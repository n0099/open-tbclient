package tv.chushou.basis.http;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
@Keep
/* loaded from: classes5.dex */
public class HttpExecutor {
    public static final String TAG = "HttpLogger";
    private static OkHttpClient sClient;
    protected OkHttpClient mClient = sClient;

    @Keep
    public static OkHttpClient getOkHttpClient() {
        return sClient;
    }

    @Keep
    public static void initialize(@Nullable OkHttpClient okHttpClient) {
        OkHttpClient.Builder builder;
        if (okHttpClient != null) {
            builder = okHttpClient.newBuilder();
            builder.interceptors().clear();
            builder.networkInterceptors().clear();
        } else {
            builder = new OkHttpClient.Builder();
        }
        sClient = builder.connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
    }

    public void customOkHttpClient() {
        this.mClient = getOkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
    }
}
