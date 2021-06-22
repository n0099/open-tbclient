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
    public static volatile int f29394a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29395b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29396c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29397d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29398e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29399f;

    /* renamed from: g  reason: collision with root package name */
    public long f29400g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0312b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0312b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0312b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0312b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0312b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0312b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0312b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29422a;

        /* renamed from: b  reason: collision with root package name */
        public o f29423b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0312b> f29424c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29425d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29426e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0312b interfaceC0312b) {
            this.f29422a = cVar;
            a(interfaceC0312b);
        }

        public void a(InterfaceC0312b interfaceC0312b) {
            if (interfaceC0312b != null) {
                this.f29424c.add(interfaceC0312b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29425d == null && (dVar = this.f29426e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29396c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0312b interfaceC0312b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0311a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i2, i3, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29395b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0311a c0311a = a2;
        if (c0311a != null && (bArr = c0311a.f29393a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0312b, a3, str);
            this.f29397d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0312b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29394a = 1;
                        b.this.a(true);
                        interfaceC0312b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0311a.f29393a));
                    }
                    InterfaceC0312b interfaceC0312b2 = interfaceC0312b;
                    if (interfaceC0312b2 != null) {
                        interfaceC0312b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29398e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0312b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i2, i3, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0312b);
        c();
        this.f29396c.a(a4);
        this.f29398e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29399f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29400g = currentTimeMillis;
            r rVar2 = this.f29399f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29399f.n(this.f29400g);
        }
    }

    public void a(String str, InterfaceC0312b interfaceC0312b, int i2, int i3, boolean z) {
        f29395b = z;
        a(str, interfaceC0312b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29417a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0312b f29418b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29419c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29420d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29421e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0312b interfaceC0312b, String str, String str2) {
            this.f29417a = dVar;
            this.f29418b = interfaceC0312b;
            this.f29419c = str;
            this.f29420d = str2;
            this.f29421e = null;
        }

        public c(VAdError vAdError, InterfaceC0312b interfaceC0312b, String str, String str2) {
            this.f29421e = vAdError;
            this.f29418b = interfaceC0312b;
            this.f29419c = str;
            this.f29420d = str2;
            this.f29417a = null;
        }
    }

    public void a(final String str, final InterfaceC0312b interfaceC0312b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0312b != null) {
            this.f29397d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0312b interfaceC0312b2 = interfaceC0312b;
                    if (interfaceC0312b2 != null) {
                        interfaceC0312b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0312b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29399f;
        if (rVar != null && rVar.z()) {
            this.f29399f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29398e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0312b interfaceC0312b : dVar2.f29424c) {
                        if (interfaceC0312b != null) {
                            b.f29394a = 2;
                            interfaceC0312b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29398e.remove(str2);
                if (dVar != null) {
                    dVar.f29423b = oVar;
                    dVar.f29425d = oVar.f69646c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29398e.remove(str2);
                if (dVar != null) {
                    dVar.f29423b = oVar;
                    dVar.f29426e = oVar.f69644a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29399f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0312b> list = dVar.f29424c;
        if (list != null) {
            for (InterfaceC0312b interfaceC0312b : list) {
                if (interfaceC0312b != null) {
                    if (a2) {
                        interfaceC0312b.a(new c(dVar.f29426e, interfaceC0312b, str, str2));
                    } else {
                        interfaceC0312b.b(new c(dVar.f29425d, interfaceC0312b, str, str2));
                    }
                    interfaceC0312b.b();
                }
            }
            dVar.f29424c.clear();
        }
    }

    public r b() {
        return this.f29399f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29399f = rVar;
    }
}
