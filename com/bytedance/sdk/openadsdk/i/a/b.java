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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f29448a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29449b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29450c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29451d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29452e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29453f;

    /* renamed from: g  reason: collision with root package name */
    public long f29454g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0322b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0322b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0322b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0322b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0322b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0322b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0322b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29476a;

        /* renamed from: b  reason: collision with root package name */
        public o f29477b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0322b> f29478c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29479d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29480e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0322b interfaceC0322b) {
            this.f29476a = cVar;
            a(interfaceC0322b);
        }

        public void a(InterfaceC0322b interfaceC0322b) {
            if (interfaceC0322b != null) {
                this.f29478c.add(interfaceC0322b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29479d == null && (dVar = this.f29480e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29450c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0322b interfaceC0322b, int i, int i2, ImageView.ScaleType scaleType) {
        a.C0321a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29449b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0321a c0321a = a2;
        if (c0321a != null && (bArr = c0321a.f29447a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0322b, a3, str);
            this.f29451d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0322b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29448a = 1;
                        b.this.a(true);
                        interfaceC0322b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0321a.f29447a));
                    }
                    InterfaceC0322b interfaceC0322b2 = interfaceC0322b;
                    if (interfaceC0322b2 != null) {
                        interfaceC0322b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29452e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0322b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i, i2, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0322b);
        c();
        this.f29450c.a(a4);
        this.f29452e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29453f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29454g = currentTimeMillis;
            r rVar2 = this.f29453f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29453f.n(this.f29454g);
        }
    }

    public void a(String str, InterfaceC0322b interfaceC0322b, int i, int i2, boolean z) {
        f29449b = z;
        a(str, interfaceC0322b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29471a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0322b f29472b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29473c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29474d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29475e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0322b interfaceC0322b, String str, String str2) {
            this.f29471a = dVar;
            this.f29472b = interfaceC0322b;
            this.f29473c = str;
            this.f29474d = str2;
            this.f29475e = null;
        }

        public c(VAdError vAdError, InterfaceC0322b interfaceC0322b, String str, String str2) {
            this.f29475e = vAdError;
            this.f29472b = interfaceC0322b;
            this.f29473c = str;
            this.f29474d = str2;
            this.f29471a = null;
        }
    }

    public void a(final String str, final InterfaceC0322b interfaceC0322b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC0322b != null) {
            this.f29451d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0322b interfaceC0322b2 = interfaceC0322b;
                    if (interfaceC0322b2 != null) {
                        interfaceC0322b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0322b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29453f;
        if (rVar != null && rVar.z()) {
            this.f29453f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29452e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0322b interfaceC0322b : dVar2.f29478c) {
                        if (interfaceC0322b != null) {
                            b.f29448a = 2;
                            interfaceC0322b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29452e.remove(str2);
                if (dVar != null) {
                    dVar.f29477b = oVar;
                    dVar.f29479d = oVar.f65741c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29452e.remove(str2);
                if (dVar != null) {
                    dVar.f29477b = oVar;
                    dVar.f29480e = oVar.f65739a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29453f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0322b> list = dVar.f29478c;
        if (list != null) {
            for (InterfaceC0322b interfaceC0322b : list) {
                if (interfaceC0322b != null) {
                    if (a2) {
                        interfaceC0322b.a(new c(dVar.f29480e, interfaceC0322b, str, str2));
                    } else {
                        interfaceC0322b.b(new c(dVar.f29479d, interfaceC0322b, str, str2));
                    }
                    interfaceC0322b.b();
                }
            }
            dVar.f29478c.clear();
        }
    }

    public r b() {
        return this.f29453f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29453f = rVar;
    }
}
