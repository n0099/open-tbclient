package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
import com.win.opensdk.poseidon.PoseidonH5Activity;
/* loaded from: classes7.dex */
public class y0 implements H1 {

    /* renamed from: a  reason: collision with root package name */
    public String f40105a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40106b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40107c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40108d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40109e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40110f;

    /* renamed from: g  reason: collision with root package name */
    public S f40111g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f40112h;
    public n1 i;
    public long j;
    public Handler k = new u0(this);

    public y0(Context context, String str) {
        this.f40106b = context;
        this.f40105a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40109e = false;
        this.f40110f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40110f.getType() == 21) {
            if (a()) {
                this.f40112h.onLoaded();
                return;
            }
            S s = new S(this.f40106b);
            this.f40111g = s;
            s.f39785a = new w0(this);
            this.f40111g.a(this.f40110f.getLoad(), this.f40110f);
            this.k.sendEmptyMessageDelayed(11, this.f40110f.getWt() * 1000);
            return;
        }
        if (b() && this.f40110f.getType() == 22) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40112h.onLoaded();
                return;
            }
            E0.a().a(this.f40106b, B2.a(this.f40110f.getTraceid(), this.f40110f.getId(), this.f40110f.getPid()), K0.INTERSTITIAL, this.f40110f.getLoad(), new x0(this));
            this.k.sendEmptyMessageDelayed(11, this.f40110f.getWt() * 1000);
            return;
        }
        this.f40112h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f40110f.getId() + this.f40105a)) {
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1122984843) {
                if (hashCode != -1122893139) {
                    if (hashCode == 109719091 && str2.equals("is_click")) {
                        c2 = 0;
                    }
                } else if (str2.equals("is_display")) {
                    c2 = 2;
                }
            } else if (str2.equals("is_dismiss")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.f40112h.onClicked();
            } else if (c2 == 1) {
                this.f40112h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f40112h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f40107c && !this.f40109e && b() && !this.f40110f.isShown() && this.f40110f.isEffective();
    }

    public final boolean b() {
        return this.f40110f != null;
    }

    public final boolean c() {
        return b() && this.f40110f.getType() == 21;
    }

    public final boolean d() {
        return b() && this.f40110f.getType() == 22;
    }

    public final boolean e() {
        return this.f40108d && !this.f40109e && b() && !this.f40110f.isShown() && this.f40110f.isEffective();
    }

    public final void f() {
        this.f40110f.setShown(true);
        E.a().a(B2.a(this.f40110f.getTraceid(), this.f40110f.getId(), this.f40105a), this.f40110f);
        if (this.f40110f.getPid().equals(V1.m(this.f40106b))) {
            PoseidonH5Activity.a(this.f40106b, this.f40110f, this.f40105a);
        } else {
            H5Activity.a(this.f40106b, this.f40110f, this.f40105a);
        }
        I1.a(this.f40110f.getId() + this.f40105a, this);
    }
}
