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
    public static volatile int f29280a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29281b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29282c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29283d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29284e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29285f;

    /* renamed from: g  reason: collision with root package name */
    public long f29286g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0306b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0306b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0306b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0306b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0306b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0306b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0306b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29308a;

        /* renamed from: b  reason: collision with root package name */
        public o f29309b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0306b> f29310c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29311d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29312e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0306b interfaceC0306b) {
            this.f29308a = cVar;
            a(interfaceC0306b);
        }

        public void a(InterfaceC0306b interfaceC0306b) {
            if (interfaceC0306b != null) {
                this.f29310c.add(interfaceC0306b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29311d == null && (dVar = this.f29312e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29282c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0306b interfaceC0306b, int i2, int i3, ImageView.ScaleType scaleType) {
        a.C0305a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i2, i3, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29281b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0305a c0305a = a2;
        if (c0305a != null && (bArr = c0305a.f29279a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0306b, a3, str);
            this.f29283d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0306b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29280a = 1;
                        b.this.a(true);
                        interfaceC0306b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0305a.f29279a));
                    }
                    InterfaceC0306b interfaceC0306b2 = interfaceC0306b;
                    if (interfaceC0306b2 != null) {
                        interfaceC0306b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29284e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0306b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i2, i3, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0306b);
        c();
        this.f29282c.a(a4);
        this.f29284e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29285f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29286g = currentTimeMillis;
            r rVar2 = this.f29285f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29285f.n(this.f29286g);
        }
    }

    public void a(String str, InterfaceC0306b interfaceC0306b, int i2, int i3, boolean z) {
        f29281b = z;
        a(str, interfaceC0306b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29303a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0306b f29304b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29305c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29306d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29307e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0306b interfaceC0306b, String str, String str2) {
            this.f29303a = dVar;
            this.f29304b = interfaceC0306b;
            this.f29305c = str;
            this.f29306d = str2;
            this.f29307e = null;
        }

        public c(VAdError vAdError, InterfaceC0306b interfaceC0306b, String str, String str2) {
            this.f29307e = vAdError;
            this.f29304b = interfaceC0306b;
            this.f29305c = str;
            this.f29306d = str2;
            this.f29303a = null;
        }
    }

    public void a(final String str, final InterfaceC0306b interfaceC0306b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0306b != null) {
            this.f29283d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0306b interfaceC0306b2 = interfaceC0306b;
                    if (interfaceC0306b2 != null) {
                        interfaceC0306b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0306b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29285f;
        if (rVar != null && rVar.z()) {
            this.f29285f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29284e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0306b interfaceC0306b : dVar2.f29310c) {
                        if (interfaceC0306b != null) {
                            b.f29280a = 2;
                            interfaceC0306b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29284e.remove(str2);
                if (dVar != null) {
                    dVar.f29309b = oVar;
                    dVar.f29311d = oVar.f65768c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.b.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29284e.remove(str2);
                if (dVar != null) {
                    dVar.f29309b = oVar;
                    dVar.f29312e = oVar.f65766a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29285f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0306b> list = dVar.f29310c;
        if (list != null) {
            for (InterfaceC0306b interfaceC0306b : list) {
                if (interfaceC0306b != null) {
                    if (a2) {
                        interfaceC0306b.a(new c(dVar.f29312e, interfaceC0306b, str, str2));
                    } else {
                        interfaceC0306b.b(new c(dVar.f29311d, interfaceC0306b, str, str2));
                    }
                    interfaceC0306b.b();
                }
            }
            dVar.f29310c.clear();
        }
    }

    public r b() {
        return this.f29285f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29285f = rVar;
    }
}
