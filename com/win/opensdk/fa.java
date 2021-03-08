package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
import com.win.opensdk.poseidon.PoseidonH5Activity;
/* loaded from: classes14.dex */
public class fa implements ab {

    /* renamed from: a */
    public String f8166a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long j;
    public Handler k = new eo(this);
    public Info qlN;
    public bg qlO;
    public dq qlQ;
    public PBInterstitialListener qmx;

    public fa(Context context, String str) {
        this.b = context;
        this.f8166a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.er.a(java.lang.Object):void] */
    public static /* synthetic */ void a(fa faVar, Info info) {
        faVar.d(info);
    }

    @Override // com.win.opensdk.ab
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.qlN.getId() + this.f8166a)) {
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1122984843) {
                if (hashCode != -1122893139) {
                    if (hashCode == 109719091 && str2.equals("is_click")) {
                        c = 0;
                    }
                } else if (str2.equals("is_display")) {
                    c = 2;
                }
            } else if (str2.equals("is_dismiss")) {
                c = 1;
            }
            if (c == 0) {
                this.qmx.onClicked();
            } else if (c == 1) {
                this.qmx.onInterstitialDismissed();
            } else if (c != 2) {
            } else {
                this.qmx.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.c && !this.e && b() && !this.qlN.isShown() && this.qlN.isEffective();
    }

    public final boolean b() {
        return this.qlN != null;
    }

    public final boolean c() {
        return b() && this.qlN.getType() == 21;
    }

    public final void d(Info info) {
        boolean z = true;
        this.e = false;
        this.qlN = info;
        this.j = System.currentTimeMillis();
        if (b() && this.qlN.getType() == 21) {
            if (!a()) {
                this.qlO = new bg(this.b);
                this.qlO.qlb = new eu(this);
                this.qlO.a(this.qlN.getLoad(), this.qlN);
                this.k.sendEmptyMessageDelayed(11, this.qlN.getWt() * 1000);
                return;
            }
            this.qmx.onLoaded();
            return;
        }
        if (!b() || this.qlN.getType() != 22) {
            z = false;
        }
        if (z) {
            if (!e()) {
                r.eIZ().a(this.b, j.a(this.qlN.getTraceid(), this.qlN.getId(), this.qlN.getPid()), K0.INTERSTITIAL, this.qlN.getLoad(), new ex(this));
                this.k.sendEmptyMessageDelayed(11, this.qlN.getWt() * 1000);
                return;
            }
            this.qmx.onLoaded();
            return;
        }
        this.qmx.onFail(PBError.PID_TYPE_ERROR);
    }

    public final boolean d() {
        return b() && this.qlN.getType() == 22;
    }

    public final boolean e() {
        return this.d && !this.e && b() && !this.qlN.isShown() && this.qlN.isEffective();
    }

    public final void f() {
        this.qlN.setShown(true);
        q.eIY().a(j.a(this.qlN.getTraceid(), this.qlN.getId(), this.f8166a), this.qlN);
        if (this.qlN.getPid().equals(bp.m(this.b))) {
            PoseidonH5Activity.a(this.b, this.qlN, this.f8166a);
        } else {
            H5Activity.a(this.b, this.qlN, this.f8166a);
        }
        ae.a(this.qlN.getId() + this.f8166a, this);
    }
}
