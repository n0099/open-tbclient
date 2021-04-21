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
    public static volatile int f29141a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29142b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29143c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29144d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29145e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29146f;

    /* renamed from: g  reason: collision with root package name */
    public long f29147g;

    /* loaded from: classes5.dex */
    public static class a implements InterfaceC0326b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0326b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0326b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0326b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0326b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0326b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0326b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29169a;

        /* renamed from: b  reason: collision with root package name */
        public o f29170b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0326b> f29171c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29172d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29173e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0326b interfaceC0326b) {
            this.f29169a = cVar;
            a(interfaceC0326b);
        }

        public void a(InterfaceC0326b interfaceC0326b) {
            if (interfaceC0326b != null) {
                this.f29171c.add(interfaceC0326b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29172d == null && (dVar = this.f29173e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29143c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0326b interfaceC0326b, int i, int i2, ImageView.ScaleType scaleType) {
        a.C0325a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29142b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0325a c0325a = a2;
        if (c0325a != null && (bArr = c0325a.f29140a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0326b, a3, str);
            this.f29144d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0326b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29141a = 1;
                        b.this.a(true);
                        interfaceC0326b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0325a.f29140a));
                    }
                    InterfaceC0326b interfaceC0326b2 = interfaceC0326b;
                    if (interfaceC0326b2 != null) {
                        interfaceC0326b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29145e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0326b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i, i2, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0326b);
        c();
        this.f29143c.a(a4);
        this.f29145e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29146f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29147g = currentTimeMillis;
            r rVar2 = this.f29146f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29146f.n(this.f29147g);
        }
    }

    public void a(String str, InterfaceC0326b interfaceC0326b, int i, int i2, boolean z) {
        f29142b = z;
        a(str, interfaceC0326b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29164a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0326b f29165b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29166c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29167d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29168e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0326b interfaceC0326b, String str, String str2) {
            this.f29164a = dVar;
            this.f29165b = interfaceC0326b;
            this.f29166c = str;
            this.f29167d = str2;
            this.f29168e = null;
        }

        public c(VAdError vAdError, InterfaceC0326b interfaceC0326b, String str, String str2) {
            this.f29168e = vAdError;
            this.f29165b = interfaceC0326b;
            this.f29166c = str;
            this.f29167d = str2;
            this.f29164a = null;
        }
    }

    public void a(final String str, final InterfaceC0326b interfaceC0326b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC0326b != null) {
            this.f29144d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0326b interfaceC0326b2 = interfaceC0326b;
                    if (interfaceC0326b2 != null) {
                        interfaceC0326b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0326b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29146f;
        if (rVar != null && rVar.z()) {
            this.f29146f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29145e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0326b interfaceC0326b : dVar2.f29171c) {
                        if (interfaceC0326b != null) {
                            b.f29141a = 2;
                            interfaceC0326b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29145e.remove(str2);
                if (dVar != null) {
                    dVar.f29170b = oVar;
                    dVar.f29172d = oVar.f66681c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29145e.remove(str2);
                if (dVar != null) {
                    dVar.f29170b = oVar;
                    dVar.f29173e = oVar.f66679a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29146f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0326b> list = dVar.f29171c;
        if (list != null) {
            for (InterfaceC0326b interfaceC0326b : list) {
                if (interfaceC0326b != null) {
                    if (a2) {
                        interfaceC0326b.a(new c(dVar.f29173e, interfaceC0326b, str, str2));
                    } else {
                        interfaceC0326b.b(new c(dVar.f29172d, interfaceC0326b, str, str2));
                    }
                    interfaceC0326b.b();
                }
            }
            dVar.f29171c.clear();
        }
    }

    public r b() {
        return this.f29146f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29146f = rVar;
    }
}
