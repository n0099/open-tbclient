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
    public String f40395a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40396b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40397c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40398d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40399e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40400f;

    /* renamed from: g  reason: collision with root package name */
    public S f40401g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f40402h;
    public n1 i;
    public long j;
    public Handler k = new u0(this);

    public y0(Context context, String str) {
        this.f40396b = context;
        this.f40395a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40399e = false;
        this.f40400f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40400f.getType() == 21) {
            if (a()) {
                this.f40402h.onLoaded();
                return;
            }
            S s = new S(this.f40396b);
            this.f40401g = s;
            s.f40075a = new w0(this);
            this.f40401g.a(this.f40400f.getLoad(), this.f40400f);
            this.k.sendEmptyMessageDelayed(11, this.f40400f.getWt() * 1000);
            return;
        }
        if (b() && this.f40400f.getType() == 22) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40402h.onLoaded();
                return;
            }
            E0.a().a(this.f40396b, B2.a(this.f40400f.getTraceid(), this.f40400f.getId(), this.f40400f.getPid()), K0.INTERSTITIAL, this.f40400f.getLoad(), new x0(this));
            this.k.sendEmptyMessageDelayed(11, this.f40400f.getWt() * 1000);
            return;
        }
        this.f40402h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f40400f.getId() + this.f40395a)) {
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
                this.f40402h.onClicked();
            } else if (c2 == 1) {
                this.f40402h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f40402h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f40397c && !this.f40399e && b() && !this.f40400f.isShown() && this.f40400f.isEffective();
    }

    public final boolean b() {
        return this.f40400f != null;
    }

    public final boolean c() {
        return b() && this.f40400f.getType() == 21;
    }

    public final boolean d() {
        return b() && this.f40400f.getType() == 22;
    }

    public final boolean e() {
        return this.f40398d && !this.f40399e && b() && !this.f40400f.isShown() && this.f40400f.isEffective();
    }

    public final void f() {
        this.f40400f.setShown(true);
        E.a().a(B2.a(this.f40400f.getTraceid(), this.f40400f.getId(), this.f40395a), this.f40400f);
        if (this.f40400f.getPid().equals(V1.m(this.f40396b))) {
            PoseidonH5Activity.a(this.f40396b, this.f40400f, this.f40395a);
        } else {
            H5Activity.a(this.f40396b, this.f40400f, this.f40395a);
        }
        I1.a(this.f40400f.getId() + this.f40395a, this);
    }
}
