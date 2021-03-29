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
    public String f40106a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40107b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40108c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40109d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40110e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40111f;

    /* renamed from: g  reason: collision with root package name */
    public S f40112g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f40113h;
    public n1 i;
    public long j;
    public Handler k = new u0(this);

    public y0(Context context, String str) {
        this.f40107b = context;
        this.f40106a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40110e = false;
        this.f40111f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40111f.getType() == 21) {
            if (a()) {
                this.f40113h.onLoaded();
                return;
            }
            S s = new S(this.f40107b);
            this.f40112g = s;
            s.f39786a = new w0(this);
            this.f40112g.a(this.f40111f.getLoad(), this.f40111f);
            this.k.sendEmptyMessageDelayed(11, this.f40111f.getWt() * 1000);
            return;
        }
        if (b() && this.f40111f.getType() == 22) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40113h.onLoaded();
                return;
            }
            E0.a().a(this.f40107b, B2.a(this.f40111f.getTraceid(), this.f40111f.getId(), this.f40111f.getPid()), K0.INTERSTITIAL, this.f40111f.getLoad(), new x0(this));
            this.k.sendEmptyMessageDelayed(11, this.f40111f.getWt() * 1000);
            return;
        }
        this.f40113h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f40111f.getId() + this.f40106a)) {
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
                this.f40113h.onClicked();
            } else if (c2 == 1) {
                this.f40113h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f40113h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f40108c && !this.f40110e && b() && !this.f40111f.isShown() && this.f40111f.isEffective();
    }

    public final boolean b() {
        return this.f40111f != null;
    }

    public final boolean c() {
        return b() && this.f40111f.getType() == 21;
    }

    public final boolean d() {
        return b() && this.f40111f.getType() == 22;
    }

    public final boolean e() {
        return this.f40109d && !this.f40110e && b() && !this.f40111f.isShown() && this.f40111f.isEffective();
    }

    public final void f() {
        this.f40111f.setShown(true);
        E.a().a(B2.a(this.f40111f.getTraceid(), this.f40111f.getId(), this.f40106a), this.f40111f);
        if (this.f40111f.getPid().equals(V1.m(this.f40107b))) {
            PoseidonH5Activity.a(this.f40107b, this.f40111f, this.f40106a);
        } else {
            H5Activity.a(this.f40107b, this.f40111f, this.f40106a);
        }
        I1.a(this.f40111f.getId() + this.f40106a, this);
    }
}
