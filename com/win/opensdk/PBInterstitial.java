package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f36968a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f36969b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f36970c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f36968a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f36969b = q0Var;
        q0Var.f37174h = new e(this);
    }

    public void destroy() {
        q0 q0Var = this.f36969b;
        q0Var.f37171e = false;
        q0Var.f37169c = false;
        q0Var.f37170d = false;
        K0 k0 = q0Var.f37175i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f36968a;
    }

    public boolean isReady() {
        q0 q0Var = this.f36969b;
        if (!q0Var.a()) {
            if (!(q0Var.f37170d && !q0Var.f37171e && q0Var.b() && !q0Var.f37172f.isShown() && q0Var.f37172f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        q0 q0Var = this.f36969b;
        if (q0Var.b() && q0Var.f37172f.isEffective() && !q0Var.f37172f.isShown()) {
            q0Var.a(q0Var.f37172f);
            return;
        }
        if (q0Var.f37175i == null) {
            q0Var.f37175i = new K0(q0Var.f37168b, q0Var.f37167a, y.INTERSTITIAL);
        }
        q0Var.f37175i.f36931g = new o0(q0Var);
        q0Var.f37175i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f36970c = pBInterstitialListener;
    }

    public void show() {
        q0 q0Var = this.f36969b;
        if (!z.d(q0Var.f37168b)) {
            PBInterstitialListener pBInterstitialListener = q0Var.f37174h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
            q0Var.f37169c = false;
            W1.a().a(W1.a(q0Var.f37172f.getTraceid(), q0Var.f37172f.getId(), q0Var.f37172f.getPid()), q0Var.f37173g);
            q0Var.f37172f.setShown(true);
            x.a().a(W1.a(q0Var.f37172f.getTraceid(), q0Var.f37172f.getId(), q0Var.f37167a), q0Var.f37172f);
            H5Activity.a(q0Var.f37168b, q0Var.f37172f, q0Var.f37167a);
            f1.a(q0Var.f37172f.getId() + q0Var.f37167a, q0Var);
        }
    }
}
