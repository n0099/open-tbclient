package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public interface Interceptor {

    /* loaded from: classes3.dex */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i2, TimeUnit timeUnit);

        Chain withReadTimeout(int i2, TimeUnit timeUnit);

        Chain withWriteTimeout(int i2, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}
