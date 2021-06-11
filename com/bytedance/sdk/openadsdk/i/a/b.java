package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.i.a.a;
import com.bytedance.sdk.openadsdk.i.a.c;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.u;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f29312a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29313b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29314c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29315d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29316e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29317f;

    /* renamed from: g  reason: collision with root package name */
    public long f29318g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0309b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0309b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29340a;

        /* renamed from: b  reason: collision with root package name */
        public o f29341b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0309b> f29342c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29343d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29344e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0309b interfaceC0309b) {
            this.f29340a = cVar;
            a(interfaceC0309b);
        }

        public void a(InterfaceC0309b interfaceC0309b) {
            if (interfaceC0309b != null) {
                this.f29342c.add(interfaceC0309b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29343d == null && (dVar = this.f29344e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29314c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0309b interfaceC0309b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0308a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i2, i3, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29313b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0308a c0308a = a2;
        if (c0308a != null && (bArr = c0308a.f29311a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0309b, a3, str);
            this.f29315d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0309b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29312a = 1;
                        b.this.a(true);
                        interfaceC0309b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0308a.f29311a));
                    }
                    InterfaceC0309b interfaceC0309b2 = interfaceC0309b;
                    if (interfaceC0309b2 != null) {
                        interfaceC0309b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29316e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0309b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i2, i3, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0309b);
        c();
        this.f29314c.a(a4);
        this.f29316e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29317f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29318g = currentTimeMillis;
            r rVar2 = this.f29317f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29317f.n(this.f29318g);
        }
    }

    public void a(String str, InterfaceC0309b interfaceC0309b, int i2, int i3, boolean z) {
        f29313b = z;
        a(str, interfaceC0309b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29335a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0309b f29336b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29337c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29338d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29339e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0309b interfaceC0309b, String str, String str2) {
            this.f29335a = dVar;
            this.f29336b = interfaceC0309b;
            this.f29337c = str;
            this.f29338d = str2;
            this.f29339e = null;
        }

        public c(VAdError vAdError, InterfaceC0309b interfaceC0309b, String str, String str2) {
            this.f29339e = vAdError;
            this.f29336b = interfaceC0309b;
            this.f29337c = str;
            this.f29338d = str2;
            this.f29335a = null;
        }
    }

    public void a(final String str, final InterfaceC0309b interfaceC0309b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0309b != null) {
            this.f29315d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0309b interfaceC0309b2 = interfaceC0309b;
                    if (interfaceC0309b2 != null) {
                        interfaceC0309b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0309b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29317f;
        if (rVar != null && rVar.z()) {
            this.f29317f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29316e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0309b interfaceC0309b : dVar2.f29342c) {
                        if (interfaceC0309b != null) {
                            b.f29312a = 2;
                            interfaceC0309b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29316e.remove(str2);
                if (dVar != null) {
                    dVar.f29341b = oVar;
                    dVar.f29343d = oVar.f69542c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29316e.remove(str2);
                if (dVar != null) {
                    dVar.f29341b = oVar;
                    dVar.f29344e = oVar.f69540a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29317f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0309b> list = dVar.f29342c;
        if (list != null) {
            for (InterfaceC0309b interfaceC0309b : list) {
                if (interfaceC0309b != null) {
                    if (a2) {
                        interfaceC0309b.a(new c(dVar.f29344e, interfaceC0309b, str, str2));
                    } else {
                        interfaceC0309b.b(new c(dVar.f29343d, interfaceC0309b, str, str2));
                    }
                    interfaceC0309b.b();
                }
            }
            dVar.f29342c.clear();
        }
    }

    public r b() {
        return this.f29317f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29317f = rVar;
    }
}
