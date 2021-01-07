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
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7751a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f7752b;
    private final Executor c;
    private final com.bytedance.sdk.openadsdk.preload.geckox.k.a d;
    private final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a e;
    private final com.bytedance.sdk.openadsdk.preload.geckox.i.b f;
    private final List<String> g;
    private final List<String> h;
    private final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a i;
    private final Long j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final File p;
    private final boolean q;

    private b(a aVar) {
        this.f7751a = aVar.d;
        if (this.f7751a == null) {
            throw new IllegalArgumentException("context == null");
        }
        this.g = aVar.f7756b;
        this.h = aVar.c;
        this.d = aVar.g;
        this.i = aVar.j;
        this.j = aVar.k;
        if (TextUtils.isEmpty(aVar.l)) {
            this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f7751a);
        } else {
            this.k = aVar.l;
        }
        this.l = aVar.m;
        this.n = aVar.p;
        this.o = aVar.q;
        if (aVar.o == null) {
            this.p = new File(this.f7751a.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.p = aVar.o;
        }
        this.m = aVar.n;
        if (TextUtils.isEmpty(this.m)) {
            throw new IllegalArgumentException("host == null");
        }
        if (this.g == null || this.g.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (this.j == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(this.l)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        if (aVar.e == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-update-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.f7752b = threadPoolExecutor;
        } else {
            this.f7752b = aVar.e;
        }
        if (aVar.f == null) {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-check-update-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            this.c = threadPoolExecutor2;
        } else {
            this.c = aVar.f;
        }
        if (aVar.f7755a == null) {
            this.f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
        } else {
            this.f = aVar.f7755a;
        }
        this.e = aVar.h;
        this.q = aVar.i;
    }

    public Context a() {
        return this.f7751a;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        return this.i;
    }

    public boolean c() {
        return this.q;
    }

    public List<String> d() {
        return this.h;
    }

    public List<String> e() {
        return this.g;
    }

    public Executor f() {
        return this.f7752b;
    }

    public Executor g() {
        return this.c;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        return this.f;
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
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        return this.e;
    }

    public String q() {
        return this.l;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private com.bytedance.sdk.openadsdk.preload.geckox.i.b f7755a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f7756b;
        private List<String> c;
        private Context d;
        private Executor e;
        private Executor f;
        private com.bytedance.sdk.openadsdk.preload.geckox.k.a g;
        private com.bytedance.sdk.openadsdk.preload.geckox.statistic.a h;
        private boolean i = true;
        private com.bytedance.sdk.openadsdk.preload.geckox.a.a.a j;
        private Long k;
        private String l;
        private String m;
        private String n;
        private File o;
        private String p;
        private String q;

        public a(Context context) {
            this.d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.c = Arrays.asList(strArr);
            }
            return this;
        }

        public a b(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.f7756b = Arrays.asList(strArr);
            }
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            this.h = aVar;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
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

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a c(String str) {
            this.n = str;
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
}
