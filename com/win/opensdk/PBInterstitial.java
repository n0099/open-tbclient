package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f37723a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f37724b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f37725c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f37723a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f37724b = q0Var;
        q0Var.f37929h = new e(this);
    }

    public void destroy() {
        q0 q0Var = this.f37724b;
        q0Var.f37926e = false;
        q0Var.f37924c = false;
        q0Var.f37925d = false;
        K0 k0 = q0Var.f37930i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f37723a;
    }

    public boolean isReady() {
        q0 q0Var = this.f37724b;
        if (!q0Var.a()) {
            if (!(q0Var.f37925d && !q0Var.f37926e && q0Var.b() && !q0Var.f37927f.isShown() && q0Var.f37927f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        q0 q0Var = this.f37724b;
        if (q0Var.b() && q0Var.f37927f.isEffective() && !q0Var.f37927f.isShown()) {
            q0Var.a(q0Var.f37927f);
            return;
        }
        if (q0Var.f37930i == null) {
            q0Var.f37930i = new K0(q0Var.f37923b, q0Var.f37922a, y.INTERSTITIAL);
        }
        q0Var.f37930i.f37686g = new o0(q0Var);
        q0Var.f37930i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f37725c = pBInterstitialListener;
    }

    public void show() {
        q0 q0Var = this.f37724b;
        if (!z.d(q0Var.f37923b)) {
            PBInterstitialListener pBInterstitialListener = q0Var.f37929h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
            q0Var.f37924c = false;
            W1.a().a(W1.a(q0Var.f37927f.getTraceid(), q0Var.f37927f.getId(), q0Var.f37927f.getPid()), q0Var.f37928g);
            q0Var.f37927f.setShown(true);
            x.a().a(W1.a(q0Var.f37927f.getTraceid(), q0Var.f37927f.getId(), q0Var.f37922a), q0Var.f37927f);
            H5Activity.a(q0Var.f37923b, q0Var.f37927f, q0Var.f37922a);
            f1.a(q0Var.f37927f.getId() + q0Var.f37922a, q0Var);
        }
    }
}
