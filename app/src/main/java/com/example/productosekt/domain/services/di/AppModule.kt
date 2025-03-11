package com.example.productosekt.domain.services.di

import com.example.productosekt.domain.repository.ProductsEktRepository
import com.example.productosekt.domain.repository.ProductsEktRepositoryImpl
import com.example.productosekt.domain.services.ProductsEktAPI
import com.example.productosekt.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun providesProductsEktAPI(retrofit: Retrofit) : ProductsEktAPI {
        return retrofit.create(ProductsEktAPI::class.java)
    }

    @Singleton
    @Provides
    fun providerProductsEktRepository(api: ProductsEktAPI, @IoDispatcher dispatcher: CoroutineDispatcher): ProductsEktRepository{
        return ProductsEktRepositoryImpl(api= api, dispatcher= dispatcher)
    }

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher