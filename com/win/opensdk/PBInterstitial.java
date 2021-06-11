package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40576a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f40577b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f40578c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40576a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f40577b = q0Var;
        q0Var.f40782h = new e(this);
    }

    public void destroy() {
        q0 q0Var = this.f40577b;
        q0Var.f40779e = false;
        q0Var.f40777c = false;
        q0Var.f40778d = false;
        K0 k0 = q0Var.f40783i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f40576a;
    }

    public boolean isReady() {
        q0 q0Var = this.f40577b;
        if (!q0Var.a()) {
            if (!(q0Var.f40778d && !q0Var.f40779e && q0Var.b() && !q0Var.f40780f.isShown() && q0Var.f40780f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        q0 q0Var = this.f40577b;
        if (q0Var.b() && q0Var.f40780f.isEffective() && !q0Var.f40780f.isShown()) {
            q0Var.a(q0Var.f40780f);
            return;
        }
        if (q0Var.f40783i == null) {
            q0Var.f40783i = new K0(q0Var.f40776b, q0Var.f40775a, y.INTERSTITIAL);
        }
        q0Var.f40783i.f40539g = new o0(q0Var);
        q0Var.f40783i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f40578c = pBInterstitialListener;
    }

    public void show() {
        q0 q0Var = this.f40577b;
        if (!z.e(q0Var.f40776b)) {
            PBInterstitialListener pBInterstitialListener = q0Var.f40782h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
            q0Var.f40777c = false;
            W1.a().a(W1.a(q0Var.f40780f.getTraceid(), q0Var.f40780f.getId(), q0Var.f40780f.getPid()), q0Var.f40781g);
            q0Var.f40780f.setShown(true);
            x.a().a(W1.a(q0Var.f40780f.getTraceid(), q0Var.f40780f.getId(), q0Var.f40775a), q0Var.f40780f);
            H5Activity.a(q0Var.f40776b, q0Var.f40780f, q0Var.f40775a);
            f1.a(q0Var.f40780f.getId() + q0Var.f40775a, q0Var);
        }
    }
}
