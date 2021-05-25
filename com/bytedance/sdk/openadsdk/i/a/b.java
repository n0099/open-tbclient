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
    public static volatile int f29209a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29210b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29211c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29212d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29213e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29214f;

    /* renamed from: g  reason: collision with root package name */
    public long f29215g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0307b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0307b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0307b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0307b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0307b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0307b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0307b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29237a;

        /* renamed from: b  reason: collision with root package name */
        public o f29238b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0307b> f29239c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29240d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29241e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0307b interfaceC0307b) {
            this.f29237a = cVar;
            a(interfaceC0307b);
        }

        public void a(InterfaceC0307b interfaceC0307b) {
            if (interfaceC0307b != null) {
                this.f29239c.add(interfaceC0307b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29240d == null && (dVar = this.f29241e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29211c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0307b interfaceC0307b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0306a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i2, i3, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29210b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0306a c0306a = a2;
        if (c0306a != null && (bArr = c0306a.f29208a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0307b, a3, str);
            this.f29212d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0307b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29209a = 1;
                        b.this.a(true);
                        interfaceC0307b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0306a.f29208a));
                    }
                    InterfaceC0307b interfaceC0307b2 = interfaceC0307b;
                    if (interfaceC0307b2 != null) {
                        interfaceC0307b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29213e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0307b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i2, i3, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0307b);
        c();
        this.f29211c.a(a4);
        this.f29213e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29214f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29215g = currentTimeMillis;
            r rVar2 = this.f29214f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29214f.n(this.f29215g);
        }
    }

    public void a(String str, InterfaceC0307b interfaceC0307b, int i2, int i3, boolean z) {
        f29210b = z;
        a(str, interfaceC0307b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29232a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0307b f29233b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29234c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29235d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29236e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0307b interfaceC0307b, String str, String str2) {
            this.f29232a = dVar;
            this.f29233b = interfaceC0307b;
            this.f29234c = str;
            this.f29235d = str2;
            this.f29236e = null;
        }

        public c(VAdError vAdError, InterfaceC0307b interfaceC0307b, String str, String str2) {
            this.f29236e = vAdError;
            this.f29233b = interfaceC0307b;
            this.f29234c = str;
            this.f29235d = str2;
            this.f29232a = null;
        }
    }

    public void a(final String str, final InterfaceC0307b interfaceC0307b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0307b != null) {
            this.f29212d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0307b interfaceC0307b2 = interfaceC0307b;
                    if (interfaceC0307b2 != null) {
                        interfaceC0307b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0307b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29214f;
        if (rVar != null && rVar.z()) {
            this.f29214f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29213e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0307b interfaceC0307b : dVar2.f29239c) {
                        if (interfaceC0307b != null) {
                            b.f29209a = 2;
                            interfaceC0307b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29213e.remove(str2);
                if (dVar != null) {
                    dVar.f29238b = oVar;
                    dVar.f29240d = oVar.f65811c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29213e.remove(str2);
                if (dVar != null) {
                    dVar.f29238b = oVar;
                    dVar.f29241e = oVar.f65809a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29214f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0307b> list = dVar.f29239c;
        if (list != null) {
            for (InterfaceC0307b interfaceC0307b : list) {
                if (interfaceC0307b != null) {
                    if (a2) {
                        interfaceC0307b.a(new c(dVar.f29241e, interfaceC0307b, str, str2));
                    } else {
                        interfaceC0307b.b(new c(dVar.f29240d, interfaceC0307b, str, str2));
                    }
                    interfaceC0307b.b();
                }
            }
            dVar.f29239c.clear();
        }
    }

    public r b() {
        return this.f29214f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29214f = rVar;
    }
}
