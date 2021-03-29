package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class PBInterstitial implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f39754a;

    /* renamed from: b  reason: collision with root package name */
    public y0 f39755b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f39756c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f39754a = str;
        y0 y0Var = new y0(applicationContext, str);
        this.f39755b = y0Var;
        y0Var.f40113h = new e(this);
    }

    public void destroy() {
        y0 y0Var = this.f39755b;
        y0Var.f40110e = false;
        y0Var.f40108c = false;
        y0Var.f40109d = false;
        n1 n1Var = y0Var.i;
        if (n1Var != null) {
            n1Var.a();
        }
    }

    public String getPid() {
        return this.f39754a;
    }

    public boolean isReady() {
        y0 y0Var = this.f39755b;
        return y0Var.a() || y0Var.e();
    }

    public void load() {
        y0 y0Var = this.f39755b;
        if (y0Var.b() && y0Var.f40111f.isEffective() && !y0Var.f40111f.isShown()) {
            y0Var.a(y0Var.f40111f);
            return;
        }
        if (y0Var.i == null) {
            y0Var.i = new n1(y0Var.f40107b, y0Var.f40106a, F.INTERSTITIAL);
        }
        y0Var.i.f39990g = new v0(y0Var);
        y0Var.i.b();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.f39756c = pBInterstitialListener;
    }

    public void show() {
        Info info;
        y0 y0Var = this.f39755b;
        if (!G.g(y0Var.f40107b)) {
            PBInterstitialListener pBInterstitialListener = y0Var.f40113h;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (V1.l(y0Var.f40107b) != 1 || (info = y0Var.f40111f) == null || TextUtils.isEmpty(info.getLoad()) || TextUtils.isEmpty(V1.m(y0Var.f40107b)) || !y0Var.f40111f.getPid().equals(V1.m(y0Var.f40107b))) {
            if (y0Var.c()) {
                if (y0Var.a() && y0Var.b()) {
                    y0Var.f40108c = false;
                    B2.a().a(B2.a(y0Var.f40111f.getTraceid(), y0Var.f40111f.getId(), y0Var.f40111f.getPid()), y0Var.f40112g);
                    y0Var.f();
                }
            } else if (y0Var.d() && y0Var.e() && y0Var.b()) {
                y0Var.f40109d = false;
                y0Var.f();
            }
        } else {
            Context context = y0Var.f40107b;
            String load = y0Var.f40111f.getLoad();
            try {
                if (!TextUtils.isEmpty(load)) {
                    Uri parse = Uri.parse(load);
                    if (!R1.a(context, parse, null)) {
                        a2.a(context, parse);
                    }
                }
            } catch (Exception unused) {
            }
            a1.a(y0Var.f40107b).b(new b1(y0Var.f40111f)).a();
            if (y0Var.f40111f != null) {
                V1.a(y0Var.f40107b, y0Var.f40111f.getId() + ":" + System.currentTimeMillis(), false);
            }
            G.a(y0Var.f40111f);
        }
    }
}
