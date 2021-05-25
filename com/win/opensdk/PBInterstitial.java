package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f36897a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f36898b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f36899c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f36897a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f36898b = q0Var;
        q0Var.f37103h = new e(this);
    }

    public void destroy() {
        q0 q0Var = this.f36898b;
        q0Var.f37100e = false;
        q0Var.f37098c = false;
        q0Var.f37099d = false;
        K0 k0 = q0Var.f37104i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f36897a;
    }

    public boolean isReady() {
        q0 q0Var = this.f36898b;
        if (!q0Var.a()) {
            if (!(q0Var.f37099d && !q0Var.f37100e && q0Var.b() && !q0Var.f37101f.isShown() && q0Var.f37101f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        q0 q0Var = this.f36898b;
        if (q0Var.b() && q0Var.f37101f.isEffective() && !q0Var.f37101f.isShown()) {
            q0Var.a(q0Var.f37101f);
            return;
        }
        if (q0Var.f37104i == null) {
            q0Var.f37104i = new K0(q0Var.f37097b, q0Var.f37096a, y.INTERSTITIAL);
        }
        q0Var.f37104i.f36860g = new o0(q0Var);
        q0Var.f37104i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f36899c = pBInterstitialListener;
    }

    public void show() {
        q0 q0Var = this.f36898b;
        if (!z.d(q0Var.f37097b)) {
            PBInterstitialListener pBInterstitialListener = q0Var.f37103h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
            q0Var.f37098c = false;
            W1.a().a(W1.a(q0Var.f37101f.getTraceid(), q0Var.f37101f.getId(), q0Var.f37101f.getPid()), q0Var.f37102g);
            q0Var.f37101f.setShown(true);
            x.a().a(W1.a(q0Var.f37101f.getTraceid(), q0Var.f37101f.getId(), q0Var.f37096a), q0Var.f37101f);
            H5Activity.a(q0Var.f37097b, q0Var.f37101f, q0Var.f37096a);
            f1.a(q0Var.f37101f.getId() + q0Var.f37096a, q0Var);
        }
    }
}
