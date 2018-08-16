Synchronized refreshing access token module

How to use:

1)add TokenAuthinticator class  to  your OkHttpClient client 

2)add AuthInterceptor instance  to  your OkHttpClient client 

    protected OkHttpClient provideOkHttpClient(Context context,
                                                      HttpLoggingInterceptor loggingInterceptor,
                                                      AuthInterceptor authInterceptor,
                                                      TokenAuthenticator tokenAuthenticator) {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .retryOnConnectionFailure(true)
                .authenticator(tokenAuthenticator)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .build();
    }
