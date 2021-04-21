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
    public String f40490a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40491b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40492c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40493d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40494e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40495f;

    /* renamed from: g  reason: collision with root package name */
    public S f40496g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f40497h;
    public n1 i;
    public long j;
    public Handler k = new u0(this);

    public y0(Context context, String str) {
        this.f40491b = context;
        this.f40490a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40494e = false;
        this.f40495f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40495f.getType() == 21) {
            if (a()) {
                this.f40497h.onLoaded();
                return;
            }
            S s = new S(this.f40491b);
            this.f40496g = s;
            s.f40170a = new w0(this);
            this.f40496g.a(this.f40495f.getLoad(), this.f40495f);
            this.k.sendEmptyMessageDelayed(11, this.f40495f.getWt() * 1000);
            return;
        }
        if (b() && this.f40495f.getType() == 22) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40497h.onLoaded();
                return;
            }
            E0.a().a(this.f40491b, B2.a(this.f40495f.getTraceid(), this.f40495f.getId(), this.f40495f.getPid()), K0.INTERSTITIAL, this.f40495f.getLoad(), new x0(this));
            this.k.sendEmptyMessageDelayed(11, this.f40495f.getWt() * 1000);
            return;
        }
        this.f40497h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f40495f.getId() + this.f40490a)) {
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
                this.f40497h.onClicked();
            } else if (c2 == 1) {
                this.f40497h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f40497h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f40492c && !this.f40494e && b() && !this.f40495f.isShown() && this.f40495f.isEffective();
    }

    public final boolean b() {
        return this.f40495f != null;
    }

    public final boolean c() {
        return b() && this.f40495f.getType() == 21;
    }

    public final boolean d() {
        return b() && this.f40495f.getType() == 22;
    }

    public final boolean e() {
        return this.f40493d && !this.f40494e && b() && !this.f40495f.isShown() && this.f40495f.isEffective();
    }

    public final void f() {
        this.f40495f.setShown(true);
        E.a().a(B2.a(this.f40495f.getTraceid(), this.f40495f.getId(), this.f40490a), this.f40495f);
        if (this.f40495f.getPid().equals(V1.m(this.f40491b))) {
            PoseidonH5Activity.a(this.f40491b, this.f40495f, this.f40490a);
        } else {
            H5Activity.a(this.f40491b, this.f40495f, this.f40490a);
        }
        I1.a(this.f40495f.getId() + this.f40490a, this);
    }
}
