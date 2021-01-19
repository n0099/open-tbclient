package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.i.a.a;
import com.bytedance.sdk.openadsdk.i.a.c;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f7190a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7191b;
    private final o c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final Map<String, d> e = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1016b {
        void a();

        void a(c cVar);

        void a(String str, byte[] bArr);

        void b(c cVar);
    }

    public b(o oVar) {
        this.c = oVar;
    }

    public void a(String str, InterfaceC1016b interfaceC1016b, int i, int i2, boolean z) {
        f7191b = z;
        a(str, interfaceC1016b, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC1016b interfaceC1016b, final int i, final int i2, final ImageView.ScaleType scaleType) {
        if (interfaceC1016b != null) {
            this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC1016b != null) {
                        interfaceC1016b.a();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC1016b, i, i2, scaleType);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC1016b interfaceC1016b, int i, int i2, ImageView.ScaleType scaleType) {
        final a.C1015a a2;
        u.f("splashLoadAd", " GiftLoader doTask requestUrl " + str);
        String a3 = com.bytedance.sdk.openadsdk.i.a.a.a().a(str, i, i2, scaleType);
        u.f("splashLoadAd", " GiftLoader doTask cacheKey " + a3);
        if (f7191b) {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().b(a3);
        } else {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a3);
        }
        if (a2 != null && a2.f7189a != null) {
            final c cVar = new c(a2.f7189a, interfaceC1016b, a3, str);
            this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (interfaceC1016b != null) {
                        u.f("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                        b.f7190a = 1;
                        interfaceC1016b.a(str, a2.f7189a);
                    }
                    if (interfaceC1016b != null) {
                        interfaceC1016b.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.e.get(a3);
        if (dVar != null) {
            dVar.a(interfaceC1016b);
            return;
        }
        u.f("splashLoadAd", " GiftLoader doTask 缓存不存在 网络请求图片 requestUrl " + str);
        com.bytedance.sdk.openadsdk.i.a.c a4 = a(str, i, i2, scaleType, a3);
        d dVar2 = new d(a4, interfaceC1016b);
        this.c.j(a4);
        this.e.put(a3, dVar2);
    }

    private com.bytedance.sdk.openadsdk.i.a.c a(final String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new com.bytedance.sdk.openadsdk.i.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.i.a.b.4
            @Override // com.bytedance.sdk.openadsdk.i.a.c.a
            public void a(String str3, byte[] bArr) {
                d dVar = (d) b.this.e.get(str2);
                if (dVar != null) {
                    for (InterfaceC1016b interfaceC1016b : dVar.c) {
                        if (interfaceC1016b != null) {
                            b.f7190a = 2;
                            interfaceC1016b.a(str3, bArr);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(p<byte[]> pVar) {
                d dVar = (d) b.this.e.remove(str2);
                if (dVar != null) {
                    dVar.f7203b = pVar;
                    dVar.e = pVar.f6045a;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(p<byte[]> pVar) {
                d dVar = (d) b.this.e.remove(str2);
                if (dVar != null) {
                    dVar.f7203b = pVar;
                    dVar.d = pVar.pla;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar != null) {
            boolean a2 = dVar.a();
            if (dVar.c != null) {
                for (InterfaceC1016b interfaceC1016b : dVar.c) {
                    if (interfaceC1016b != null) {
                        if (a2) {
                            interfaceC1016b.a(new c(dVar.e, interfaceC1016b, str, str2));
                        } else {
                            interfaceC1016b.b(new c(dVar.d, interfaceC1016b, str, str2));
                        }
                    }
                }
                dVar.c.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        com.bytedance.sdk.openadsdk.i.a.c f7202a;

        /* renamed from: b  reason: collision with root package name */
        p f7203b;
        List<InterfaceC1016b> c = new CopyOnWriteArrayList();
        VAdError d;
        byte[] e;

        public d(com.bytedance.sdk.openadsdk.i.a.c cVar, InterfaceC1016b interfaceC1016b) {
            this.f7202a = cVar;
            a(interfaceC1016b);
        }

        void a(InterfaceC1016b interfaceC1016b) {
            if (interfaceC1016b != null) {
                this.c.add(interfaceC1016b);
            }
        }

        boolean a() {
            return this.d == null && this.e != null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f7200a;

        /* renamed from: b  reason: collision with root package name */
        private final InterfaceC1016b f7201b;
        private final String c;
        private final String d;
        private final VAdError e;

        public c(byte[] bArr, InterfaceC1016b interfaceC1016b, String str, String str2) {
            this.f7200a = bArr;
            this.f7201b = interfaceC1016b;
            this.c = str;
            this.d = str2;
            this.e = null;
        }

        public c(VAdError vAdError, InterfaceC1016b interfaceC1016b, String str, String str2) {
            this.e = vAdError;
            this.f7201b = interfaceC1016b;
            this.c = str;
            this.d = str2;
            this.f7200a = null;
        }
    }

    public static a a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements InterfaceC1016b {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1016b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1016b
        public void a(String str, byte[] bArr) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1016b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1016b
        public void b(c cVar) {
        }
    }
}
