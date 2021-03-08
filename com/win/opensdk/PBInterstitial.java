package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class PBInterstitial {

    /* renamed from: a  reason: collision with root package name */
    public String f8101a;
    public fa b;
    public PBInterstitialListener c;

    public PBInterstitial(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f8101a = str;
        this.b = new fa(applicationContext, str);
        this.b.qmx = new cl(this);
    }

    public void destroy() {
        fa faVar = this.b;
        faVar.e = false;
        faVar.c = false;
        faVar.d = false;
        dq dqVar = faVar.qlQ;
        if (dqVar != null) {
            dqVar.a();
        }
    }

    public String getPid() {
        return this.f8101a;
    }

    public boolean isReady() {
        fa faVar = this.b;
        return faVar.a() || faVar.e();
    }

    public void load() {
        fa faVar = this.b;
        if (!faVar.b() || !faVar.qlN.isEffective() || faVar.qlN.isShown()) {
            if (faVar.qlQ == null) {
                faVar.qlQ = new dq(faVar.b, faVar.f8166a, F.INTERSTITIAL);
            }
            faVar.qlQ.qlS = new er(faVar);
            faVar.qlQ.b();
            return;
        }
        faVar.d(faVar.qlN);
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.c = pBInterstitialListener;
    }

    public void show() {
        Info info;
        fa faVar = this.b;
        if (!v.g(faVar.b)) {
            PBInterstitialListener pBInterstitialListener = faVar.qmx;
            if (pBInterstitialListener != null) {
                pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (bp.l(faVar.b) == 1 && (info = faVar.qlN) != null && !TextUtils.isEmpty(info.getLoad()) && !TextUtils.isEmpty(bp.m(faVar.b)) && faVar.qlN.getPid().equals(bp.m(faVar.b))) {
            Context context = faVar.b;
            String load = faVar.qlN.getLoad();
            try {
                if (!TextUtils.isEmpty(load)) {
                    Uri parse = Uri.parse(load);
                    if (!bf.a(context, parse, null)) {
                        cb.i(context, parse);
                    }
                }
            } catch (Exception e) {
            }
            ca.iT(faVar.b).a(new cd(faVar.qlN)).a();
            if (faVar.qlN != null) {
                bp.a(faVar.b, faVar.qlN.getId() + ":" + System.currentTimeMillis(), false);
            }
            v.d(faVar.qlN);
        } else if (faVar.c()) {
            if (!faVar.a() || !faVar.b()) {
                return;
            }
            faVar.c = false;
            j.eIX().a(j.a(faVar.qlN.getTraceid(), faVar.qlN.getId(), faVar.qlN.getPid()), faVar.qlO);
            faVar.f();
        } else if (!faVar.d() || !faVar.e() || !faVar.b()) {
        } else {
            faVar.d = false;
            faVar.f();
        }
    }
}
