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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f30035a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30036b;

    /* renamed from: c  reason: collision with root package name */
    public final n f30037c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f30038d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f30039e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f30040f;

    /* renamed from: g  reason: collision with root package name */
    public long f30041g;

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0319b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0319b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0319b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0319b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0319b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0319b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0319b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f30063a;

        /* renamed from: b  reason: collision with root package name */
        public o f30064b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0319b> f30065c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f30066d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f30067e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0319b interfaceC0319b) {
            this.f30063a = cVar;
            a(interfaceC0319b);
        }

        public void a(InterfaceC0319b interfaceC0319b) {
            if (interfaceC0319b != null) {
                this.f30065c.add(interfaceC0319b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f30066d == null && (dVar = this.f30067e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f30037c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0319b interfaceC0319b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0318a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i2, i3, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f30036b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0318a c0318a = a2;
        if (c0318a != null && (bArr = c0318a.f30034a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0319b, a3, str);
            this.f30038d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0319b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f30035a = 1;
                        b.this.a(true);
                        interfaceC0319b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0318a.f30034a));
                    }
                    InterfaceC0319b interfaceC0319b2 = interfaceC0319b;
                    if (interfaceC0319b2 != null) {
                        interfaceC0319b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f30039e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0319b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i2, i3, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0319b);
        c();
        this.f30037c.a(a4);
        this.f30039e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f30040f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f30041g = currentTimeMillis;
            r rVar2 = this.f30040f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f30040f.n(this.f30041g);
        }
    }

    public void a(String str, InterfaceC0319b interfaceC0319b, int i2, int i3, boolean z) {
        f30036b = z;
        a(str, interfaceC0319b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f30058a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0319b f30059b;

        /* renamed from: c  reason: collision with root package name */
        public final String f30060c;

        /* renamed from: d  reason: collision with root package name */
        public final String f30061d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f30062e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0319b interfaceC0319b, String str, String str2) {
            this.f30058a = dVar;
            this.f30059b = interfaceC0319b;
            this.f30060c = str;
            this.f30061d = str2;
            this.f30062e = null;
        }

        public c(VAdError vAdError, InterfaceC0319b interfaceC0319b, String str, String str2) {
            this.f30062e = vAdError;
            this.f30059b = interfaceC0319b;
            this.f30060c = str;
            this.f30061d = str2;
            this.f30058a = null;
        }
    }

    public void a(final String str, final InterfaceC0319b interfaceC0319b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0319b != null) {
            this.f30038d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0319b interfaceC0319b2 = interfaceC0319b;
                    if (interfaceC0319b2 != null) {
                        interfaceC0319b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0319b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f30040f;
        if (rVar != null && rVar.z()) {
            this.f30040f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f30039e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0319b interfaceC0319b : dVar2.f30065c) {
                        if (interfaceC0319b != null) {
                            b.f30035a = 2;
                            interfaceC0319b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f30039e.remove(str2);
                if (dVar != null) {
                    dVar.f30064b = oVar;
                    dVar.f30066d = oVar.f65082c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f30039e.remove(str2);
                if (dVar != null) {
                    dVar.f30064b = oVar;
                    dVar.f30067e = oVar.f65080a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f30040f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0319b> list = dVar.f30065c;
        if (list != null) {
            for (InterfaceC0319b interfaceC0319b : list) {
                if (interfaceC0319b != null) {
                    if (a2) {
                        interfaceC0319b.a(new c(dVar.f30067e, interfaceC0319b, str, str2));
                    } else {
                        interfaceC0319b.b(new c(dVar.f30066d, interfaceC0319b, str, str2));
                    }
                    interfaceC0319b.b();
                }
            }
            dVar.f30065c.clear();
        }
    }

    public r b() {
        return this.f30040f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f30040f = rVar;
    }
}
