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
import d.c.c.b.d.n;
import d.c.c.b.d.o;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f29133a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29134b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29135c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29136d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29137e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29138f;

    /* renamed from: g  reason: collision with root package name */
    public long f29139g;

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0324b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0324b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0324b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0324b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0324b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0324b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0324b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29161a;

        /* renamed from: b  reason: collision with root package name */
        public o f29162b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0324b> f29163c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29164d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29165e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0324b interfaceC0324b) {
            this.f29161a = cVar;
            a(interfaceC0324b);
        }

        public void a(InterfaceC0324b interfaceC0324b) {
            if (interfaceC0324b != null) {
                this.f29163c.add(interfaceC0324b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29164d == null && (dVar = this.f29165e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29135c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0324b interfaceC0324b, int i, int i2, ImageView.ScaleType scaleType) {
        a.C0323a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29134b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0323a c0323a = a2;
        if (c0323a != null && (bArr = c0323a.f29132a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0324b, a3, str);
            this.f29136d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0324b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29133a = 1;
                        b.this.a(true);
                        interfaceC0324b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0323a.f29132a));
                    }
                    InterfaceC0324b interfaceC0324b2 = interfaceC0324b;
                    if (interfaceC0324b2 != null) {
                        interfaceC0324b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29137e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0324b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i, i2, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0324b);
        c();
        this.f29135c.a(a4);
        this.f29137e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29138f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29139g = currentTimeMillis;
            r rVar2 = this.f29138f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29138f.n(this.f29139g);
        }
    }

    public void a(String str, InterfaceC0324b interfaceC0324b, int i, int i2, boolean z) {
        f29134b = z;
        a(str, interfaceC0324b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29156a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0324b f29157b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29158c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29159d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29160e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0324b interfaceC0324b, String str, String str2) {
            this.f29156a = dVar;
            this.f29157b = interfaceC0324b;
            this.f29158c = str;
            this.f29159d = str2;
            this.f29160e = null;
        }

        public c(VAdError vAdError, InterfaceC0324b interfaceC0324b, String str, String str2) {
            this.f29160e = vAdError;
            this.f29157b = interfaceC0324b;
            this.f29158c = str;
            this.f29159d = str2;
            this.f29156a = null;
        }
    }

    public void a(final String str, final InterfaceC0324b interfaceC0324b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC0324b != null) {
            this.f29136d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0324b interfaceC0324b2 = interfaceC0324b;
                    if (interfaceC0324b2 != null) {
                        interfaceC0324b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0324b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29138f;
        if (rVar != null && rVar.z()) {
            this.f29138f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29137e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0324b interfaceC0324b : dVar2.f29163c) {
                        if (interfaceC0324b != null) {
                            b.f29133a = 2;
                            interfaceC0324b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29137e.remove(str2);
                if (dVar != null) {
                    dVar.f29162b = oVar;
                    dVar.f29164d = oVar.f66586c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29137e.remove(str2);
                if (dVar != null) {
                    dVar.f29162b = oVar;
                    dVar.f29165e = oVar.f66584a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29138f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0324b> list = dVar.f29163c;
        if (list != null) {
            for (InterfaceC0324b interfaceC0324b : list) {
                if (interfaceC0324b != null) {
                    if (a2) {
                        interfaceC0324b.a(new c(dVar.f29165e, interfaceC0324b, str, str2));
                    } else {
                        interfaceC0324b.b(new c(dVar.f29164d, interfaceC0324b, str, str2));
                    }
                    interfaceC0324b.b();
                }
            }
            dVar.f29163c.clear();
        }
    }

    public r b() {
        return this.f29138f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29138f = rVar;
    }
}
