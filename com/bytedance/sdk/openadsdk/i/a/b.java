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
    public static volatile int f29447a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f29448b;

    /* renamed from: c  reason: collision with root package name */
    public final n f29449c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f29450d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d> f29451e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public r f29452f;

    /* renamed from: g  reason: collision with root package name */
    public long f29453g;

    /* loaded from: classes6.dex */
    public static class a implements InterfaceC0321b {
        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0321b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0321b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0321b
        public void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0321b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0321b
        public void b(c cVar) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0321b {
        void a();

        void a(c cVar);

        void a(String str, com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();

        void b(c cVar);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.c f29475a;

        /* renamed from: b  reason: collision with root package name */
        public o f29476b;

        /* renamed from: c  reason: collision with root package name */
        public List<InterfaceC0321b> f29477c = new CopyOnWriteArrayList();

        /* renamed from: d  reason: collision with root package name */
        public VAdError f29478d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.i.a.d f29479e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC0321b interfaceC0321b) {
            this.f29475a = cVar;
            a(interfaceC0321b);
        }

        public void a(InterfaceC0321b interfaceC0321b) {
            if (interfaceC0321b != null) {
                this.f29477c.add(interfaceC0321b);
            }
        }

        public boolean a() {
            com.bytedance.sdk.openadsdk.i.a.d dVar;
            return this.f29478d == null && (dVar = this.f29479e) != null && dVar.c();
        }
    }

    public b(n nVar) {
        this.f29449c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0321b interfaceC0321b, int i, int i2, ImageView.ScaleType scaleType) {
        a.C0320a a2;
        byte[] bArr;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f29448b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        final a.C0320a c0320a = a2;
        if (c0320a != null && (bArr = c0320a.f29446a) != null) {
            final c cVar = new c(new com.bytedance.sdk.openadsdk.i.a.d(bArr), interfaceC0321b, a3, str);
            this.f29450d.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC0321b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f29447a = 1;
                        b.this.a(true);
                        interfaceC0321b.a(str, new com.bytedance.sdk.openadsdk.i.a.d(c0320a.f29446a));
                    }
                    InterfaceC0321b interfaceC0321b2 = interfaceC0321b;
                    if (interfaceC0321b2 != null) {
                        interfaceC0321b2.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.f29451e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC0321b);
            return;
        }
        a(false);
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i, i2, scaleType, a3);
        d dVar2 = new d(a4, interfaceC0321b);
        c();
        this.f29449c.a(a4);
        this.f29451e.put(a3, dVar2);
    }

    private void c() {
        r rVar = this.f29452f;
        if (rVar != null && rVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f29453g = currentTimeMillis;
            r rVar2 = this.f29452f;
            rVar2.h(currentTimeMillis - rVar2.t());
            this.f29452f.n(this.f29453g);
        }
    }

    public void a(String str, InterfaceC0321b interfaceC0321b, int i, int i2, boolean z) {
        f29448b = z;
        a(str, interfaceC0321b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.i.a.d f29470a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC0321b f29471b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29472c;

        /* renamed from: d  reason: collision with root package name */
        public final String f29473d;

        /* renamed from: e  reason: collision with root package name */
        public final VAdError f29474e;

        public c(com.bytedance.sdk.openadsdk.i.a.d dVar, InterfaceC0321b interfaceC0321b, String str, String str2) {
            this.f29470a = dVar;
            this.f29471b = interfaceC0321b;
            this.f29472c = str;
            this.f29473d = str2;
            this.f29474e = null;
        }

        public c(VAdError vAdError, InterfaceC0321b interfaceC0321b, String str, String str2) {
            this.f29474e = vAdError;
            this.f29471b = interfaceC0321b;
            this.f29472c = str;
            this.f29473d = str2;
            this.f29470a = null;
        }
    }

    public void a(final String str, final InterfaceC0321b interfaceC0321b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC0321b != null) {
            this.f29450d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0321b interfaceC0321b2 = interfaceC0321b;
                    if (interfaceC0321b2 != null) {
                        interfaceC0321b2.a();
                    }
                }
            });
        }
        e.a(new g("GifLoader get") { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0321b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        r rVar = this.f29452f;
        if (rVar != null && rVar.z()) {
            this.f29452f.a(z);
        }
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.c cVar = new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                d dVar2 = (d) b.this.f29451e.get(str2);
                if (dVar2 != null) {
                    for (InterfaceC0321b interfaceC0321b : dVar2.f29477c) {
                        if (interfaceC0321b != null) {
                            b.f29447a = 2;
                            interfaceC0321b.a(str3, dVar);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void b(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29451e.remove(str2);
                if (dVar != null) {
                    dVar.f29476b = oVar;
                    dVar.f29478d = oVar.f65740c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.c.a, d.c.c.b.d.o.a
            public void a(o<com.bytedance.sdk.openadsdk.i.a.d> oVar) {
                d dVar = (d) b.this.f29451e.remove(str2);
                if (dVar != null) {
                    dVar.f29476b = oVar;
                    dVar.f29479e = oVar.f65738a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
        cVar.a(this.f29452f);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0321b> list = dVar.f29477c;
        if (list != null) {
            for (InterfaceC0321b interfaceC0321b : list) {
                if (interfaceC0321b != null) {
                    if (a2) {
                        interfaceC0321b.a(new c(dVar.f29479e, interfaceC0321b, str, str2));
                    } else {
                        interfaceC0321b.b(new c(dVar.f29478d, interfaceC0321b, str, str2));
                    }
                    interfaceC0321b.b();
                }
            }
            dVar.f29477c.clear();
        }
    }

    public r b() {
        return this.f29452f;
    }

    public static a a() {
        return new a();
    }

    public void a(r rVar) {
        this.f29452f = rVar;
    }
}
