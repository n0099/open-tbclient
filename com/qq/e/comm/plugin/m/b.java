package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.MediaEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.m.i;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements NativeExpressADData2, ADEventListener, com.qq.e.comm.plugin.a.d.a, com.qq.e.comm.plugin.nativeadunified.b {

    /* renamed from: a  reason: collision with root package name */
    public String f12184a;

    /* renamed from: b  reason: collision with root package name */
    public String f12185b;
    int c;
    VideoOption2 d;
    public k f;
    protected boolean g;
    private Context h;
    private c i;
    private ADListener j;
    private Handler l;
    private int m;
    private i n;
    private com.qq.e.comm.plugin.w.b o;
    private com.qq.e.comm.plugin.ad.g p;
    private boolean q;
    private b.c r;
    private String t;
    private com.qq.e.comm.plugin.aa.a.b u;
    private boolean v;
    private String w;
    private g x;
    protected com.qq.e.comm.plugin.y.c e = new com.qq.e.comm.plugin.y.c();
    private com.qq.e.comm.plugin.y.d k = new com.qq.e.comm.plugin.y.d();
    private b.d s = b.d.NOT_DOWNLOAD;

    /* renamed from: com.qq.e.comm.plugin.m.b$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.n == null) {
                i.a aVar = new i.a() { // from class: com.qq.e.comm.plugin.m.b.1.1
                    @Override // com.qq.e.comm.plugin.m.i.a
                    public void a(int i) {
                        b.this.a(104, new Object[0]);
                        b.this.b(i);
                    }

                    @Override // com.qq.e.comm.plugin.m.i.a
                    public void a(k kVar) {
                        b.this.f = kVar;
                        b.this.f.a(new j() { // from class: com.qq.e.comm.plugin.m.b.1.1.1
                            @Override // com.qq.e.comm.plugin.m.j
                            public void a() {
                                b.this.a((View) null);
                            }

                            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                            @Override // com.qq.e.comm.plugin.m.j
                            public void a(int i, int... iArr) {
                                switch (i) {
                                    case 201:
                                    case 203:
                                        break;
                                    case 202:
                                        b.this.s();
                                        b.this.a(i, new Object[0]);
                                        return;
                                    case 204:
                                    case 205:
                                    case 206:
                                    case 207:
                                        b.this.a();
                                        break;
                                    case 208:
                                        b.this.a(false);
                                        return;
                                    default:
                                        return;
                                }
                                b.this.a(i, new Object[0]);
                            }

                            @Override // com.qq.e.comm.plugin.m.j
                            public void a(String str) {
                                b.this.a(str);
                            }

                            @Override // com.qq.e.comm.plugin.m.j
                            public void b() {
                                b.this.a(105, new Object[0]);
                            }
                        });
                        b.this.a(103, new Object[0]);
                        if (b.this.o()) {
                            b.this.p();
                        }
                        b.this.b(101);
                    }
                };
                b.this.n = b.this.a(b.this.h, b.this.i, b.this.d, aVar, b.this.e);
            }
            b.this.n.b();
            b.this.b(104);
        }
    }

    public b(Context context, String str, String str2, JSONObject jSONObject, int i, int i2, int i3, VideoOption2 videoOption2) {
        this.h = context;
        this.f12184a = str2;
        this.f12185b = com.qq.e.comm.plugin.util.a.a(str, this.f12184a, o.b());
        this.i = a(str, this.f12184a, this.f12185b, jSONObject, i2, i3, videoOption2);
        this.w = b.class.getSimpleName() + this.i.m();
        this.c = i;
        this.d = videoOption2;
        this.e.a(this.f12184a);
        this.e.b(this.i.m());
        this.e.c(this.i.H());
        this.k.a("posId", str2);
        this.k.a("appid", str);
        this.o = new com.qq.e.comm.plugin.w.b(this.f12185b, com.qq.e.comm.plugin.ad.e.EXPRESS2, this.f12184a);
        this.l = new Handler(Looper.getMainLooper());
        this.p = new com.qq.e.comm.plugin.ad.g();
        if (this.i.ah()) {
            q();
            if (o()) {
                a(301, (String) null);
            } else {
                if (GDTADManager.getInstance().getSM().getInteger("Express2_Preload_Video", 1) == 1) {
                    r();
                }
            }
        }
        if (this.i.v()) {
            com.qq.e.comm.plugin.a.l.a().a(this.i.z().d(), this);
        }
        com.qq.e.comm.plugin.ab.j.e().a(this.i.o(), (j.a) null);
        l();
        this.x = new g(this.h, this, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        return this.s == b.d.COMPLETE && !TextUtils.isEmpty(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f != null) {
            this.f.a(this.t);
        }
        if (this.q) {
            return;
        }
        a(201, new Object[0]);
        this.q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        File d = ah.d(this.i.G());
        if (d == null || !d.exists()) {
            return;
        }
        this.s = b.d.COMPLETE;
        this.t = d.getAbsolutePath();
    }

    private void r() {
        if (this.i.ah()) {
            if (o()) {
                p();
            } else if (this.u == null) {
                this.u = new b.a().b(this.i.G()).a(ah.a(this.i.G())).a(ah.f()).a();
                com.qq.e.comm.plugin.aa.a.a.a().a(this.u, this.i.G(), new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.m.b.4
                    @Override // com.qq.e.comm.plugin.j.a
                    public void a() {
                        b.this.s = b.d.START;
                        if (b.this.f != null) {
                            b.this.f.p();
                        }
                        ai.a(b.this.w, "Video download onStarted: ");
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void a(long j, long j2, int i) {
                        if (b.this.r != null) {
                            b.this.r.a(i);
                        }
                        if (b.this.f != null) {
                            b.this.f.a(j, j2, i);
                        }
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void a(long j, boolean z) {
                        b.this.m = (int) (j >> 10);
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void a(com.qq.e.comm.plugin.j.c cVar) {
                        b.this.s = b.d.FAILED;
                        if (b.this.r != null) {
                            b.this.r.b();
                        }
                        b.this.a(207, new Object[0]);
                        b.this.v = true;
                        if (b.this.f != null) {
                            b.this.f.a((String) null);
                        }
                        b.this.a();
                        ai.a(b.this.w, "Video download onFailed e: " + cVar.b());
                        b.this.a(302, b.this.i.G());
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void a(File file, long j) {
                        if (b.this.r != null) {
                            b.this.r.a();
                        }
                        b.this.q();
                        if (b.this.o()) {
                            b.this.p();
                        }
                        ba.a(j, b.this.m, b.this.i.r(), b.this.e);
                        ai.a(b.this.w, "Video download onCompleted: ");
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void b() {
                        b.this.s = b.d.PAUSE;
                    }

                    @Override // com.qq.e.comm.plugin.j.a
                    public void c() {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        aa.a(this.i.y());
    }

    protected c a(String str, String str2, String str3, JSONObject jSONObject, int i, int i2, VideoOption2 videoOption2) {
        c cVar = new c(str, str2, str3, com.qq.e.comm.plugin.ad.e.EXPRESS2, jSONObject, i, i2, videoOption2);
        cVar.c(cVar.v() && cVar.ah() && com.qq.e.comm.plugin.l.b.a(cVar.Z()));
        return cVar;
    }

    @NonNull
    protected e a(Context context, c cVar, VideoOption2 videoOption2, i.a aVar, com.qq.e.comm.plugin.y.c cVar2) {
        return new e(context, cVar, videoOption2, aVar, cVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        int i;
        int i2;
        int i3;
        String q = this.i.q();
        final String t = this.i.t();
        int i4 = 2;
        int g = this.i.g();
        if (this.f != null) {
            i4 = this.f.k();
            r4 = i4 == 0 ? this.f.n() : 0;
            if (this.f.o() > 0) {
                g = this.f.o();
            }
            i2 = this.f.m();
            i = this.f.l();
            i3 = this.f.j();
        } else {
            i = 1;
            i2 = 1;
            i3 = 1;
        }
        com.qq.e.comm.plugin.w.d.a(i2, i3, i, i4, r4, g, q, this.o, new d.b() { // from class: com.qq.e.comm.plugin.m.b.3
            @Override // com.qq.e.comm.plugin.w.d.b
            public void a() {
                if (StringUtil.isEmpty(t)) {
                    return;
                }
                af.a(t);
            }

            @Override // com.qq.e.comm.plugin.w.d.b
            public void a(int i5, Exception exc) {
            }
        });
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(int i) {
        if (this.f != null) {
            this.f.a(i);
        }
    }

    protected void a(int i, String str) {
        h.a(i, this.e, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final int i, final Object... objArr) {
        if (this.j != null) {
            this.l.post(new Runnable() { // from class: com.qq.e.comm.plugin.m.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.j != null) {
                        b.this.j.onADEvent(new ADEvent(i, objArr));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final View view) {
        if (this.g) {
            return;
        }
        if (this.f == null && view == null) {
            return;
        }
        if (view == null) {
            view = this.f.q();
        }
        this.g = true;
        com.qq.e.comm.plugin.ad.a.a().a(view);
        a(102, new Object[0]);
        view.post(new Runnable() { // from class: com.qq.e.comm.plugin.m.b.2
            @Override // java.lang.Runnable
            public void run() {
                String q = b.this.i.q();
                if (b.this.i.ah()) {
                    q = com.qq.e.comm.plugin.w.i.a(q);
                }
                final String t = b.this.i.t();
                com.qq.e.comm.plugin.w.i.a(b.this.p.a(view, b.this.i.ah() ? 1 : 2, b.this.i.x(), null), com.qq.e.comm.plugin.ad.a.a().b(view), b.this.i, b.this.o, q, new d.b() { // from class: com.qq.e.comm.plugin.m.b.2.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        if (com.qq.e.comm.plugin.util.m.a(t)) {
                            return;
                        }
                        af.a(t);
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i, Exception exc) {
                    }
                });
            }
        });
        this.i.V();
        this.i.W();
        m();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(View view, int i, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        a(str4, i);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(View view, String str, boolean z) {
        this.x.a(view, str);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.a aVar) {
        if (this.f != null) {
            this.f.a(aVar);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.EnumC1199b enumC1199b) {
        if (this.f != null) {
            this.f.a(enumC1199b);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.c cVar) {
        this.r = cVar;
    }

    protected void a(String str) {
        this.x.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i) {
        a(str, i, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i, int i2) {
        if (this.f != null) {
            d.a a2 = com.qq.e.comm.plugin.w.i.a(this.i);
            d.e eVar = new d.e(this.f12185b, com.qq.e.comm.plugin.ad.e.EXPRESS2, this.f12184a);
            d.b a3 = d.a(i, i2, this.i, this.f.q(), str, this.c);
            a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f.q());
            com.qq.e.comm.plugin.w.a.d.a(this.f.q(), a2, eVar, a3);
        }
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(String str, int i, int i2, long j) {
        ai.a(this.w, "onAPKStatusUpdate: pkgName:" + str + ",status:" + i + ",progress:" + i2 + ",totalSize:" + j);
        com.qq.e.comm.plugin.ad.j z = this.i.z();
        if (z != null) {
            z.a(i2);
            z.c(i);
        }
        if (this.f != null) {
            this.f.a(str, i, i2, j);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(boolean z) {
        r();
    }

    protected void b(int i) {
        h.b(i, this.e);
    }

    public boolean b() {
        return this.v;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.qq.e.comm.plugin.nativeadunified.b
    /* renamed from: c */
    public c n() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        h.c(i, this.e);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public boolean d() {
        if (this.f != null) {
            return this.f.w();
        }
        return true;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        if (this.n != null) {
            this.n.c();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public com.qq.e.comm.plugin.ad.g e() {
        return this.p;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void e_() {
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public b.d f() {
        return this.s;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        if (this.f != null) {
            return this.f.q();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.i.J();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.i.g();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public b.EnumC1199b h() {
        if (this.f != null) {
            return this.f.r();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public int i() {
        if (this.f != null) {
            return this.f.s();
        }
        return 0;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.i.ah();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void j() {
        if (this.f != null) {
            this.f.t();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void k() {
        if (this.f == null || this != com.qq.e.comm.plugin.nativeadunified.c.a()) {
            return;
        }
        this.f.v();
        com.qq.e.comm.plugin.nativeadunified.c.g();
    }

    protected void l() {
        h.a(this.i.ah(), this.e);
    }

    protected void m() {
        h.b(this.e);
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        if (this.h != null && com.qq.e.comm.plugin.ad.e.EXPRESS2 == this.i.C()) {
            z.a().a(this.f12184a);
        }
        this.l.post(new AnonymousClass1());
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.j = aDListener;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
    }
}
