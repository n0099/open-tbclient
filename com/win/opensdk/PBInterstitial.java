package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40679a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f40680b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f40681c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40679a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f40680b = q0Var;
        q0Var.f40885h = new e(this);
    }

    public void destroy() {
        q0 q0Var = this.f40680b;
        q0Var.f40882e = false;
        q0Var.f40880c = false;
        q0Var.f40881d = false;
        K0 k0 = q0Var.f40886i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f40679a;
    }

    public boolean isReady() {
        q0 q0Var = this.f40680b;
        if (!q0Var.a()) {
            if (!(q0Var.f40881d && !q0Var.f40882e && q0Var.b() && !q0Var.f40883f.isShown() && q0Var.f40883f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        q0 q0Var = this.f40680b;
        if (q0Var.b() && q0Var.f40883f.isEffective() && !q0Var.f40883f.isShown()) {
            q0Var.a(q0Var.f40883f);
            return;
        }
        if (q0Var.f40886i == null) {
            q0Var.f40886i = new K0(q0Var.f40879b, q0Var.f40878a, y.INTERSTITIAL);
        }
        q0Var.f40886i.f40642g = new o0(q0Var);
        q0Var.f40886i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f40681c = pBInterstitialListener;
    }

    public void show() {
        q0 q0Var = this.f40680b;
        if (!z.e(q0Var.f40879b)) {
            PBInterstitialListener pBInterstitialListener = q0Var.f40885h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
            q0Var.f40880c = false;
            W1.a().a(W1.a(q0Var.f40883f.getTraceid(), q0Var.f40883f.getId(), q0Var.f40883f.getPid()), q0Var.f40884g);
            q0Var.f40883f.setShown(true);
            x.a().a(W1.a(q0Var.f40883f.getTraceid(), q0Var.f40883f.getId(), q0Var.f40878a), q0Var.f40883f);
            H5Activity.a(q0Var.f40879b, q0Var.f40883f, q0Var.f40878a);
            f1.a(q0Var.f40883f.getId() + q0Var.f40878a, q0Var);
        }
    }
}
