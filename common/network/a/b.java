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
    private static OkHttpClient nus;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        d dIK = d.dIK();
        if (dIK == null) {
            throw new IllegalStateException("HTTPDNS没有初始化，乱了乱了！");
        }
        nus = builder.protocols(Util.immutableList(Protocol.HTTP_1_1)).connectionPool(new ConnectionPool(20, 1L, TimeUnit.MINUTES)).dispatcher(new Dispatcher(Executors.newFixedThreadPool(4, new ThreadFactory() { // from class: common.network.a.b.1
            private AtomicInteger nut = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, String.format("OkHttpDispatcher-%s", Integer.valueOf(this.nut.getAndIncrement())));
            }
        }))).dns(dIK).build();
    }

    public static void a(Interceptor interceptor) {
        nus = newBuilder().addInterceptor(interceptor).build();
    }

    public static OkHttpClient.Builder newBuilder() {
        return nus.newBuilder();
    }

    public static OkHttpClient getOkHttpClient() {
        return nus;
    }
}
