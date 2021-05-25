package i.a.a.c.c;

import d.r.b.a.a.f.d.d;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public int f68782a;

    /* renamed from: b  reason: collision with root package name */
    public int f68783b = 0;

    public a(int i2) {
        this.f68782a = i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i2;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        while (!proceed.isSuccessful() && (i2 = this.f68783b) < this.f68782a) {
            this.f68783b = i2 + 1;
            proceed = chain.proceed(request);
            d.g("RetryInterceptor", "RetryInterceptor maxRetry=%s, retryCount=%s", Integer.valueOf(this.f68782a), Integer.valueOf(this.f68783b));
        }
        return proceed;
    }
}
