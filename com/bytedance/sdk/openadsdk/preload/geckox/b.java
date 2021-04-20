package com.bytedance.sdk.openadsdk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f29897a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f29898b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f29899c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.k.a f29900d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f29901e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.i.b f29902f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f29903g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f29904h;
    public final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a i;
    public final Long j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final File p;
    public final boolean q;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.i.b f29907a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f29908b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f29909c;

        /* renamed from: d  reason: collision with root package name */
        public Context f29910d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f29911e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f29912f;

        /* renamed from: g  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.k.a f29913g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f29914h;
        public boolean i = true;
        public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a j;
        public Long k;
        public String l;
        public String m;
        public String n;
        public File o;
        public String p;
        public String q;

        public a(Context context) {
            this.f29910d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f29909c = Arrays.asList(strArr);
            }
            return this;
        }

        public a b(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f29908b = Arrays.asList(strArr);
            }
            return this;
        }

        public a c(String str) {
            this.n = str;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            this.f29914h = aVar;
            return this;
        }

        public a b(Executor executor) {
            this.f29912f = executor;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a a(Executor executor) {
            this.f29911e = executor;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.a aVar) {
            this.j = aVar;
            return this;
        }

        public a a(long j) {
            this.k = Long.valueOf(j);
            return this;
        }

        public a a(String str) {
            this.l = str;
            return this;
        }

        public a a(File file) {
            this.o = file;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public Context a() {
        return this.f29897a;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        return this.i;
    }

    public boolean c() {
        return this.q;
    }

    public List<String> d() {
        return this.f29904h;
    }

    public List<String> e() {
        return this.f29903g;
    }

    public Executor f() {
        return this.f29898b;
    }

    public Executor g() {
        return this.f29899c;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        return this.f29902f;
    }

    public String i() {
        return this.m;
    }

    public long j() {
        return this.j.longValue();
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.n;
    }

    public File m() {
        return this.p;
    }

    public String n() {
        return this.k;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.k.a o() {
        return this.f29900d;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        return this.f29901e;
    }

    public String q() {
        return this.l;
    }

    public b(a aVar) {
        Context context = aVar.f29910d;
        this.f29897a = context;
        if (context != null) {
            this.f29903g = aVar.f29908b;
            this.f29904h = aVar.f29909c;
            this.f29900d = aVar.f29913g;
            this.i = aVar.j;
            this.j = aVar.k;
            if (!TextUtils.isEmpty(aVar.l)) {
                this.k = aVar.l;
            } else {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f29897a);
            }
            this.l = aVar.m;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o != null) {
                this.p = aVar.o;
            } else {
                this.p = new File(this.f29897a.getFilesDir(), "gecko_offline_res_x");
            }
            String str = aVar.n;
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.f29903g;
                if (list != null && !list.isEmpty()) {
                    if (this.j != null) {
                        if (!TextUtils.isEmpty(this.l)) {
                            if (aVar.f29911e != null) {
                                this.f29898b = aVar.f29911e;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.1
                                    @Override // java.util.concurrent.ThreadFactory
                                    public Thread newThread(Runnable runnable) {
                                        Thread thread = new Thread(runnable);
                                        thread.setName("tt_pangle_thread_gecko_update");
                                        thread.setPriority(3);
                                        return thread;
                                    }
                                });
                                threadPoolExecutor.allowCoreThreadTimeOut(true);
                                this.f29898b = threadPoolExecutor;
                            }
                            if (aVar.f29912f != null) {
                                this.f29899c = aVar.f29912f;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.2
                                    @Override // java.util.concurrent.ThreadFactory
                                    public Thread newThread(Runnable runnable) {
                                        Thread thread = new Thread(runnable);
                                        thread.setName("tt_pangle_thread_gecko_check_update");
                                        thread.setPriority(3);
                                        return thread;
                                    }
                                });
                                threadPoolExecutor2.allowCoreThreadTimeOut(true);
                                this.f29899c = threadPoolExecutor2;
                            }
                            if (aVar.f29907a != null) {
                                this.f29902f = aVar.f29907a;
                            } else {
                                this.f29902f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                            }
                            this.f29901e = aVar.f29914h;
                            this.q = aVar.i;
                            return;
                        }
                        throw new IllegalArgumentException("deviceId key empty");
                    }
                    throw new IllegalArgumentException("appId == null");
                }
                throw new IllegalArgumentException("access key empty");
            }
            throw new IllegalArgumentException("host == null");
        }
        throw new IllegalArgumentException("context == null");
    }
}
