package com.ksad.download.b;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e2) {
            if (e2 instanceof IOException) {
                throw e2;
            }
            throw new IOException(e2);
        }
    }
}
