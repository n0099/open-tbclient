package common.network.a;

import android.support.annotation.NonNull;
import common.network.b.d;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
/* loaded from: classes.dex */
public class b {
    private static OkHttpClient ntK;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        d dHB = d.dHB();
        if (dHB == null) {
            throw new IllegalStateException("HTTPDNS没有初始化，乱了乱了！");
        }
        ntK = builder.protocols(Util.immutableList(Protocol.HTTP_1_1)).connectionPool(new ConnectionPool(20, 1L, TimeUnit.MINUTES)).dispatcher(new Dispatcher(Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: common.network.a.b.1
            private AtomicInteger ntL = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, String.format("OkHttpDispatcher-%s", Integer.valueOf(this.ntL.getAndIncrement())));
            }
        }))).dns(dHB).build();
    }

    public static void a(Interceptor interceptor) {
        ntK = newBuilder().addInterceptor(interceptor).build();
    }

    public static OkHttpClient.Builder newBuilder() {
        return ntK.newBuilder();
    }

    public static OkHttpClient getOkHttpClient() {
        return ntK;
    }
}
