package i.a.a.c.c;

import d.r.b.a.a.f.d.d;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public int f68739a;

    /* renamed from: b  reason: collision with root package name */
    public int f68740b = 0;

    public a(int i2) {
        this.f68739a = i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i2;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        while (!proceed.isSuccessful() && (i2 = this.f68740b) < this.f68739a) {
            this.f68740b = i2 + 1;
            proceed = chain.proceed(request);
            d.g("RetryInterceptor", "RetryInterceptor maxRetry=%s, retryCount=%s", Integer.valueOf(this.f68739a), Integer.valueOf(this.f68740b));
        }
        return proceed;
    }
}
