package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40043a;

    /* renamed from: b  reason: collision with root package name */
    public y0 f40044b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f40045c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40043a = str;
        y0 y0Var = new y0(applicationContext, str);
        this.f40044b = y0Var;
        y0Var.f40402h = new e(this);
    }

    public void destroy() {
        y0 y0Var = this.f40044b;
        y0Var.f40399e = false;
        y0Var.f40397c = false;
        y0Var.f40398d = false;
        n1 n1Var = y0Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f40043a;
    }

    public boolean isReady() {
        y0 y0Var = this.f40044b;
        return y0Var.a() || y0Var.e();
    }

    public void load() {
        y0 y0Var = this.f40044b;
        if (y0Var.b() && y0Var.f40400f.isEffective() && !y0Var.f40400f.isShown()) {
            y0Var.a(y0Var.f40400f);
            return;
        }
        if (y0Var.i == null) {
            y0Var.i = new n1(y0Var.f40396b, y0Var.f40395a, F.INTERSTITIAL);
        }
        y0Var.i.f40279g = new v0(y0Var);
        y0Var.i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f40045c = pBInterstitialListener;
    }

    public void show() {
        Info info;
        y0 y0Var = this.f40044b;
        if (!G.g(y0Var.f40396b)) {
            PBInterstitialListener pBInterstitialListener = y0Var.f40402h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (V1.l(y0Var.f40396b) != 1 || (info = y0Var.f40400f) == null || TextUtils.isEmpty(info.getLoad()) || TextUtils.isEmpty(V1.m(y0Var.f40396b)) || !y0Var.f40400f.getPid().equals(V1.m(y0Var.f40396b))) {
            if (y0Var.c()) {
                if (y0Var.a() && y0Var.b()) {
                    y0Var.f40397c = false;
                    B2.a().a(B2.a(y0Var.f40400f.getTraceid(), y0Var.f40400f.getId(), y0Var.f40400f.getPid()), y0Var.f40401g);
                    y0Var.f();
                }
            } else if (y0Var.d() && y0Var.e() && y0Var.b()) {
                y0Var.f40398d = false;
                y0Var.f();
            }
        } else {
            Context context = y0Var.f40396b;
            String load = y0Var.f40400f.getLoad();
            try {
                if (!TextUtils.isEmpty(load)) {
                    Uri parse = Uri.parse(load);
                    if (!R1.a(context, parse, null)) {
                        a2.a(context, parse);
                    }
                }
            } catch (Exception unused) {
            }
            a1.a(y0Var.f40396b).b(new b1(y0Var.f40400f)).a();
            if (y0Var.f40400f != null) {
                V1.a(y0Var.f40396b, y0Var.f40400f.getId() + ":" + System.currentTimeMillis(), false);
            }
            G.a(y0Var.f40400f);
        }
    }
}
