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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f30177a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f30178b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f30179c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.k.a f30180d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f30181e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.i.b f30182f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f30183g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f30184h;

    /* renamed from: i  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f30185i;
    public final Long j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final File p;
    public final boolean q;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.i.b f30188a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f30189b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f30190c;

        /* renamed from: d  reason: collision with root package name */
        public Context f30191d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f30192e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f30193f;

        /* renamed from: g  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.k.a f30194g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f30195h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f30196i = true;
        public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a j;
        public Long k;
        public String l;
        public String m;
        public String n;
        public File o;
        public String p;
        public String q;

        public a(Context context) {
            this.f30191d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f30190c = Arrays.asList(strArr);
            }
            return this;
        }

        public a b(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f30189b = Arrays.asList(strArr);
            }
            return this;
        }

        public a c(String str) {
            this.n = str;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            this.f30195h = aVar;
            return this;
        }

        public a b(Executor executor) {
            this.f30193f = executor;
            return this;
        }

        public a a(boolean z) {
            this.f30196i = z;
            return this;
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a a(Executor executor) {
            this.f30192e = executor;
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
        return this.f30177a;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        return this.f30185i;
    }

    public boolean c() {
        return this.q;
    }

    public List<String> d() {
        return this.f30184h;
    }

    public List<String> e() {
        return this.f30183g;
    }

    public Executor f() {
        return this.f30178b;
    }

    public Executor g() {
        return this.f30179c;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        return this.f30182f;
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
        return this.f30180d;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        return this.f30181e;
    }

    public String q() {
        return this.l;
    }

    public b(a aVar) {
        Context context = aVar.f30191d;
        this.f30177a = context;
        if (context != null) {
            this.f30183g = aVar.f30189b;
            this.f30184h = aVar.f30190c;
            this.f30180d = aVar.f30194g;
            this.f30185i = aVar.j;
            this.j = aVar.k;
            if (!TextUtils.isEmpty(aVar.l)) {
                this.k = aVar.l;
            } else {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f30177a);
            }
            this.l = aVar.m;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o != null) {
                this.p = aVar.o;
            } else {
                this.p = new File(this.f30177a.getFilesDir(), "gecko_offline_res_x");
            }
            String str = aVar.n;
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.f30183g;
                if (list != null && !list.isEmpty()) {
                    if (this.j != null) {
                        if (!TextUtils.isEmpty(this.l)) {
                            if (aVar.f30192e != null) {
                                this.f30178b = aVar.f30192e;
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
                                this.f30178b = threadPoolExecutor;
                            }
                            if (aVar.f30193f != null) {
                                this.f30179c = aVar.f30193f;
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
                                this.f30179c = threadPoolExecutor2;
                            }
                            if (aVar.f30188a != null) {
                                this.f30182f = aVar.f30188a;
                            } else {
                                this.f30182f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                            }
                            this.f30181e = aVar.f30195h;
                            this.q = aVar.f30196i;
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
