package i.a.a.c.d;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public int f72041a;

    /* renamed from: b  reason: collision with root package name */
    public int f72042b = 0;

    public a(int i2) {
        this.f72041a = i2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i2;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        while (!proceed.isSuccessful() && (i2 = this.f72042b) < this.f72041a) {
            this.f72042b = i2 + 1;
            proceed = chain.proceed(request);
            RLog.info("RetryInterceptor", "RetryInterceptor maxRetry=%s, retryCount=%s", Integer.valueOf(this.f72041a), Integer.valueOf(this.f72042b));
        }
        return proceed;
    }
}
