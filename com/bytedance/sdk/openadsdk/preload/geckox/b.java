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
    public final Context f30095a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f30096b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f30097c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.k.a f30098d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f30099e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.i.b f30100f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f30101g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f30102h;

    /* renamed from: i  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f30103i;
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
        public com.bytedance.sdk.openadsdk.preload.geckox.i.b f30106a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f30107b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f30108c;

        /* renamed from: d  reason: collision with root package name */
        public Context f30109d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f30110e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f30111f;

        /* renamed from: g  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.k.a f30112g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f30113h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f30114i = true;
        public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a j;
        public Long k;
        public String l;
        public String m;
        public String n;
        public File o;
        public String p;
        public String q;

        public a(Context context) {
            this.f30109d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f30108c = Arrays.asList(strArr);
            }
            return this;
        }

        public a b(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f30107b = Arrays.asList(strArr);
            }
            return this;
        }

        public a c(String str) {
            this.n = str;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            this.f30113h = aVar;
            return this;
        }

        public a b(Executor executor) {
            this.f30111f = executor;
            return this;
        }

        public a a(boolean z) {
            this.f30114i = z;
            return this;
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a a(Executor executor) {
            this.f30110e = executor;
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
        return this.f30095a;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        return this.f30103i;
    }

    public boolean c() {
        return this.q;
    }

    public List<String> d() {
        return this.f30102h;
    }

    public List<String> e() {
        return this.f30101g;
    }

    public Executor f() {
        return this.f30096b;
    }

    public Executor g() {
        return this.f30097c;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        return this.f30100f;
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
        return this.f30098d;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        return this.f30099e;
    }

    public String q() {
        return this.l;
    }

    public b(a aVar) {
        Context context = aVar.f30109d;
        this.f30095a = context;
        if (context != null) {
            this.f30101g = aVar.f30107b;
            this.f30102h = aVar.f30108c;
            this.f30098d = aVar.f30112g;
            this.f30103i = aVar.j;
            this.j = aVar.k;
            if (!TextUtils.isEmpty(aVar.l)) {
                this.k = aVar.l;
            } else {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f30095a);
            }
            this.l = aVar.m;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o != null) {
                this.p = aVar.o;
            } else {
                this.p = new File(this.f30095a.getFilesDir(), "gecko_offline_res_x");
            }
            String str = aVar.n;
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.f30101g;
                if (list != null && !list.isEmpty()) {
                    if (this.j != null) {
                        if (!TextUtils.isEmpty(this.l)) {
                            if (aVar.f30110e != null) {
                                this.f30096b = aVar.f30110e;
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
                                this.f30096b = threadPoolExecutor;
                            }
                            if (aVar.f30111f != null) {
                                this.f30097c = aVar.f30111f;
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
                                this.f30097c = threadPoolExecutor2;
                            }
                            if (aVar.f30106a != null) {
                                this.f30100f = aVar.f30106a;
                            } else {
                                this.f30100f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                            }
                            this.f30099e = aVar.f30113h;
                            this.q = aVar.f30114i;
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
