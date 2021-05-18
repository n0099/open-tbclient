package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class q0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f37167a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37168b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37169c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37170d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37171e;

    /* renamed from: f  reason: collision with root package name */
    public Info f37172f;

    /* renamed from: g  reason: collision with root package name */
    public K f37173g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f37174h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f37175i;
    public long j;
    public Handler k = new n0(this);

    public q0(Context context, String str) {
        this.f37168b = context;
        this.f37167a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f37171e = false;
        this.f37172f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f37172f.getType() == 21) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f37174h.onLoaded();
                return;
            }
            K k = new K(this.f37168b);
            this.f37173g = k;
            k.f36920a = new p0(this);
            this.f37173g.a(this.f37172f.getLoad(), this.f37172f);
            this.k.sendEmptyMessageDelayed(11, this.f37172f.getWt() * 1000);
            return;
        }
        this.f37174h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f37172f.getId() + this.f37167a)) {
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
                this.f37174h.onClicked();
            } else if (c2 == 1) {
                this.f37174h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f37174h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f37169c && !this.f37171e && b() && !this.f37172f.isShown() && this.f37172f.isEffective();
    }

    public final boolean b() {
        return this.f37172f != null;
    }

    public final boolean c() {
        return b() && this.f37172f.getType() == 21;
    }
}
