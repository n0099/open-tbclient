package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class ag implements w {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7749b;
    public final /* synthetic */ FunAdInteractionListener pPa;
    public final /* synthetic */ au.a pPb;
    public final /* synthetic */ p pPc;

    public ag(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPc = pVar;
        this.pPa = funAdInteractionListener;
        this.f7749b = str;
        this.pPb = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 快手广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPc.pOK.f7760a);
        }
        af afVar = this.pPc.pOM;
        String str2 = this.f7749b;
        au.a aVar = this.pPb;
        if (afVar != null) {
            ac acVar = afVar.f7748a.get(afVar.a(str2, aVar.f7762a));
            FunRippedAd eAp = acVar != null ? acVar.eAp() : null;
            if (eAp != null) {
                ((d.a) d.pOz).a(this.f7749b, this.pPb.f7763b, str, eAp.appPackageName, eAp.appLinkUrl);
                return;
            } else {
                ((d.a) d.pOz).a(this.f7749b, this.pPb.f7763b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 快手广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7749b, this.pPb.f7763b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 快手广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).d(this.f7749b, this.pPb.f7763b, str);
    }

    public void d(String str) {
        m.a("FunAdLoader 快手广告 onPageDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7749b, this.pPb.f7763b, str);
    }

    public void e(String str) {
        m.a("FunAdLoader 快手广告 onVideoPlayError，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).e(this.f7749b, this.pPb.f7763b, str, 0, "Custom error message: onVideoPlayError");
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 快手广告 onAdShowError，广告ID：" + str + ", code: " + i + ", message: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).e(this.f7749b, this.pPb.f7763b, str, i, str2);
    }
}
