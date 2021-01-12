package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public class ag implements w {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7747b;
    public final /* synthetic */ FunAdInteractionListener pEU;
    public final /* synthetic */ au.a pEV;
    public final /* synthetic */ p pEW;

    public ag(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pEW = pVar;
        this.pEU = funAdInteractionListener;
        this.f7747b = str;
        this.pEV = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 快手广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pEW.pEE.f7758a);
        }
        af afVar = this.pEW.pEG;
        String str2 = this.f7747b;
        au.a aVar = this.pEV;
        if (afVar != null) {
            ac acVar = afVar.f7746a.get(afVar.a(str2, aVar.f7760a));
            FunRippedAd exX = acVar != null ? acVar.exX() : null;
            if (exX != null) {
                ((d.a) d.pEt).a(this.f7747b, this.pEV.f7761b, str, exX.appPackageName, exX.appLinkUrl);
                return;
            } else {
                ((d.a) d.pEt).a(this.f7747b, this.pEV.f7761b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 快手广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).a(this.f7747b, this.pEV.f7761b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 快手广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).d(this.f7747b, this.pEV.f7761b, str);
    }

    public void d(String str) {
        m.a("FunAdLoader 快手广告 onPageDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).a(this.f7747b, this.pEV.f7761b, str);
    }

    public void e(String str) {
        m.a("FunAdLoader 快手广告 onVideoPlayError，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).e(this.f7747b, this.pEV.f7761b, str, 0, "Custom error message: onVideoPlayError");
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 快手广告 onAdShowError，广告ID：" + str + ", code: " + i + ", message: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).e(this.f7747b, this.pEV.f7761b, str, i, str2);
    }
}
