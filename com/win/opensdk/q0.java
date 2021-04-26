package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class q0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f37922a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37923b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37924c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37925d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37926e;

    /* renamed from: f  reason: collision with root package name */
    public Info f37927f;

    /* renamed from: g  reason: collision with root package name */
    public K f37928g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f37929h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f37930i;
    public long j;
    public Handler k = new n0(this);

    public q0(Context context, String str) {
        this.f37923b = context;
        this.f37922a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f37926e = false;
        this.f37927f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f37927f.getType() == 21) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f37929h.onLoaded();
                return;
            }
            K k = new K(this.f37923b);
            this.f37928g = k;
            k.f37675a = new p0(this);
            this.f37928g.a(this.f37927f.getLoad(), this.f37927f);
            this.k.sendEmptyMessageDelayed(11, this.f37927f.getWt() * 1000);
            return;
        }
        this.f37929h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f37927f.getId() + this.f37922a)) {
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
                this.f37929h.onClicked();
            } else if (c2 == 1) {
                this.f37929h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f37929h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f37924c && !this.f37926e && b() && !this.f37927f.isShown() && this.f37927f.isEffective();
    }

    public final boolean b() {
        return this.f37927f != null;
    }

    public final boolean c() {
        return b() && this.f37927f.getType() == 21;
    }
}
