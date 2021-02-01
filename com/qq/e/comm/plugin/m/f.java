package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.m.a;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.bd;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements d.a, c.a, k {
    private m A;
    private j f;
    private Context g;
    private a h;
    private MediaView i;
    private com.qq.e.comm.plugin.aa.b.f j;
    private com.qq.e.comm.plugin.gdtnativead.a.c k;
    private String l;
    private boolean n;
    private ax o;
    private int p;
    private b.a q;
    private com.qq.e.comm.plugin.ab.d.a r;
    private boolean s;
    private String t;
    private VideoOption2 u;
    private boolean v;
    private boolean x;
    private boolean y;

    /* renamed from: a  reason: collision with root package name */
    private int f12212a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f12213b = 1;
    private int c = 1;
    private int d = 1;
    private b.EnumC1203b e = b.EnumC1203b.INIT;
    private AtomicBoolean m = new AtomicBoolean(false);
    private int w = 0;
    private int z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, a aVar, MediaView mediaView, com.qq.e.comm.plugin.aa.b.f fVar, com.qq.e.comm.plugin.gdtnativead.a.c cVar, com.qq.e.comm.plugin.ab.d.a aVar2, String str, VideoOption2 videoOption2) {
        this.g = context;
        this.h = aVar;
        this.i = mediaView;
        this.j = fVar;
        this.k = cVar;
        this.r = aVar2;
        this.t = f.class.getSimpleName() + str;
        this.u = videoOption2;
        if (this.k != null && this.j != null) {
            this.k.a(this);
            this.j.a(this.k);
            C();
        }
        this.n = GDTADManager.getInstance().getSM().getInteger("express2CheckWindowFocus", 1) == 1;
        this.h.a(new a.InterfaceC1200a() { // from class: com.qq.e.comm.plugin.m.f.1
            @Override // com.qq.e.comm.plugin.m.a.InterfaceC1200a
            public void a() {
                f.this.c(true);
            }

            @Override // com.qq.e.comm.plugin.m.a.InterfaceC1200a
            public void a(int i) {
                if (i == 0) {
                    f.this.c(false);
                } else {
                    f.this.y();
                }
            }

            @Override // com.qq.e.comm.plugin.m.a.InterfaceC1200a
            public void b() {
                f.this.y();
            }

            @Override // com.qq.e.comm.plugin.m.a.InterfaceC1200a
            public void c() {
                f.this.y();
            }

            @Override // com.qq.e.comm.plugin.m.a.InterfaceC1200a
            public void d() {
                f.this.c(true);
            }
        });
    }

    private void A() {
        if (this.s) {
            return;
        }
        this.s = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            a("onAdExposure", jSONObject);
            ai.a(this.t, "callJsExpressShow");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean B() {
        if (this.u != null) {
            boolean z = GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI;
            switch (this.u.getAutoPlayPolicy()) {
                case WIFI:
                    return z;
                case ALWAYS:
                default:
                    return true;
                case NEVER:
                    return false;
            }
        }
        return true;
    }

    private void C() {
        if (this.u == null) {
            this.j.h();
        } else if (this.u.isAutoPlayMuted()) {
            this.j.h();
        } else {
            this.j.i();
        }
    }

    private void a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            jSONObject.put("progress", i2);
            a("onAPKStatusUpdate", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void a(String str, JSONObject jSONObject) {
        this.r.c().a(new com.qq.e.comm.plugin.ab.b.b(str, jSONObject));
    }

    private void b(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
            a("onViewableChange", jSONObject);
            ai.a(this.t, "callJsViewableChange");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.x) {
            if (this.o == null) {
                this.o = new ax(Long.MAX_VALUE, 200L) { // from class: com.qq.e.comm.plugin.m.f.2
                    @Override // com.qq.e.comm.plugin.util.ax
                    public void a() {
                    }

                    @Override // com.qq.e.comm.plugin.util.ax
                    public void a(long j) {
                        f.this.z();
                    }
                };
                this.o.b();
            } else {
                this.o.e();
            }
            if (z && this.e == b.EnumC1203b.END) {
                this.e = b.EnumC1203b.INIT;
            }
        }
    }

    private void d(boolean z) {
        this.m.set(false);
        if (this.j != null) {
            this.e = z ? b.EnumC1203b.MANUAL_PAUSE : b.EnumC1203b.AUTO_PAUSE;
            this.j.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.x) {
            if (this.o != null) {
                this.o.d();
            }
            if (this.j == null || this.j == com.qq.e.comm.plugin.nativeadunified.c.b() || !this.j.c()) {
                return;
            }
            this.j.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (B() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean z() {
        if (this.j == null || com.qq.e.comm.plugin.nativeadunified.c.b() != this.j) {
            boolean a2 = bd.a(this.g, this.h, 50, this.n);
            if (this.i != null) {
                switch (this.e) {
                    case PLAYING:
                        if (!a2) {
                            d(false);
                            break;
                        }
                        break;
                    case AUTO_PAUSE:
                        if (a2) {
                            this.d = 1;
                            a();
                            break;
                        }
                        break;
                }
            }
            if (a2) {
                A();
                if (this.f != null) {
                    this.f.a();
                }
            }
            if (this.v != a2) {
                this.v = a2;
                b(this.v ? 1 : 0);
            }
            if (this.k != null) {
                if (a2) {
                    this.k.b(false);
                } else {
                    this.k.b(true);
                }
            }
            return a2;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a() {
        this.m.set(true);
        if (TextUtils.isEmpty(this.l)) {
            if (!TextUtils.isEmpty(this.l) || this.f == null) {
                return;
            }
            this.f.a(208, new int[0]);
        } else if (this.j != null) {
            this.e = b.EnumC1203b.PLAYING;
            this.j.b();
            ai.a(this.t, "playVideo: mControllerViewListener = " + this.q);
            if (this.q != null) {
                this.q.d();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(int i) {
        this.f12212a = i;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void a(int i, Exception exc) {
        this.w = 5;
        this.c = 2;
        this.e = b.EnumC1203b.ERROR;
        if (this.f != null) {
            this.f.a(207, new int[0]);
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(long j, long j2, int i) {
        if (j >= j2 || !B()) {
            return;
        }
        this.w = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r9.equals("clickAdEvent") != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
        char c = 0;
        ai.a(this.t, str + " param: " + str2);
        switch (str.hashCode()) {
            case -1926689588:
                if (str.equals("getVideoState")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -620782193:
                break;
            case -401693945:
                if (str.equals("clickLogoEvent")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 217446186:
                if (str.equals("clickCloseEvent")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1070487396:
                if (str.equals("changeVideoMute")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (this.f != null) {
                    A();
                    this.f.a(str2);
                    return;
                }
                return;
            case 1:
                try {
                    com.qq.e.comm.plugin.c.c.a(new JSONObject(str2).optString("url"), null);
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            case 2:
                if (this.j != null) {
                    try {
                        if (new JSONObject(str2).optBoolean("mute")) {
                            this.j.h();
                        } else {
                            this.j.i();
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            case 3:
                try {
                    int optInt = new JSONObject(str2).optInt("stateType");
                    if (optInt == 2) {
                        a();
                    } else if (optInt == 3) {
                        d(true);
                    }
                    return;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
            case 4:
                try {
                    int n = n();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", this.w);
                    jSONObject.put("currentTime", n);
                    jSONObject.put("totalTime", this.p);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 0);
                    jSONObject2.put("data", jSONObject);
                    eVar.a(str3, 0, jSONObject2.toString(), 0);
                    if (this.A != null) {
                        this.A.a(n);
                        return;
                    }
                    return;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    return;
                }
            case 5:
                if (this.f != null) {
                    this.f.b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(j jVar) {
        this.f = jVar;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(m mVar) {
        this.A = mVar;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(b.a aVar) {
        this.q = aVar;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(b.EnumC1203b enumC1203b) {
        this.e = enumC1203b;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(String str) {
        this.l = str;
        if (TextUtils.isEmpty(this.l)) {
            this.c = 2;
            this.w = 5;
            return;
        }
        this.c = 0;
        if (this.j != null) {
            this.j.a(this.l);
        }
        if (this.m.get()) {
            a();
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void a(String str, int i, int i2, long j) {
        if (this.q != null) {
            this.q.a(str, i, i2, j);
        }
        a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.x = z;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void b(boolean z) {
        if (!z) {
            this.d = 0;
        }
        if (this.q != null) {
            this.q.c();
        }
        this.e = z ? b.EnumC1203b.MANUAL_PAUSE : b.EnumC1203b.PLAYING;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void b_() {
        this.c = 0;
        if (this.j != null) {
            this.p = this.j.e();
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void c_() {
        this.w = 2;
        if (this.f != null) {
            this.f.a(202, new int[0]);
        }
        ai.a(this.t, "onVideoStart: mControllerViewListener = " + this.q);
        if (this.q != null) {
            this.q.d();
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void f_() {
        this.w = 4;
        this.e = b.EnumC1203b.END;
        if (this.f != null) {
            this.f.a(206, new int[0]);
        }
        this.f12213b = 3;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g() {
        this.w = 2;
        this.f12213b = 2;
        if (this.f != null) {
            this.f.a(203, new int[0]);
        }
        if (this.q != null) {
            this.q.d();
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g_() {
        this.w = 4;
        this.e = b.EnumC1203b.END;
        if (this.f != null) {
            this.f.a(205, new int[0]);
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void h_() {
        this.w = 3;
        if (this.f != null && !this.y) {
            this.f.a(204, new int[0]);
        }
        this.y = false;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void i_() {
        if (this.q != null) {
            this.q.a();
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int j() {
        return this.f12212a;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void j_() {
        if (this.q != null) {
            this.q.b();
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int k() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int l() {
        return this.f12213b;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int m() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int n() {
        return this.j != null ? this.j.f() : this.z;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int o() {
        return this.p;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void p() {
        if (B()) {
            this.w = 1;
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public View q() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public b.EnumC1203b r() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public int s() {
        return com.qq.e.comm.plugin.ad.a.a().b(this.h);
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void t() {
        this.q = null;
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void u() {
        this.i.removeView(this.j);
        this.i.removeView(this.k);
        this.k.b(true);
        com.qq.e.comm.plugin.nativeadunified.c.a(this.k);
        com.qq.e.comm.plugin.nativeadunified.c.a(this.j);
        com.qq.e.comm.plugin.nativeadunified.c.a(n());
        if (this.j != null && !this.j.c()) {
            this.d = 0;
        }
        y();
    }

    @Override // com.qq.e.comm.plugin.m.k
    public void v() {
        this.y = true;
        bc.a(this.j);
        bc.a(this.k);
        if (this.i != null) {
            this.i.addView(this.j);
            this.i.addView(this.k);
        }
        if (this.k != null) {
            this.k.d();
        }
        this.f12212a = 1;
        if (this.j != null) {
            C();
        }
        if (this.k != null) {
            this.k.b();
        }
    }

    @Override // com.qq.e.comm.plugin.m.k
    public boolean w() {
        return Build.VERSION.SDK_INT < 11 || this.h.isHardwareAccelerated();
    }

    public void x() {
        if (this.e == b.EnumC1203b.PLAYING) {
            this.j.a();
            this.e = b.EnumC1203b.DEV_PAUSE;
        }
        if (this.i != null) {
            this.i.removeAllViews();
            this.i = null;
        }
        if (this.j != null) {
            this.z = this.j.f();
            this.j.l();
            this.j = null;
        }
        if (this.k != null) {
            this.k.i();
            this.k.removeAllViews();
            this.k = null;
        }
        if (this.o != null) {
            this.o.c();
        }
        this.r.a();
        com.qq.e.comm.plugin.ab.j.e().d();
    }
}
