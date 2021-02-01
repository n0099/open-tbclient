package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class aa implements ah {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7744b;
    public final /* synthetic */ FunAdInteractionListener pPa;
    public final /* synthetic */ au.a pPb;
    public final /* synthetic */ p pPc;

    public aa(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPc = pVar;
        this.pPa = funAdInteractionListener;
        this.f7744b = str;
        this.pPb = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告 onADClosed，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7744b, this.pPb.f7763b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告 onADExposure，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).d(this.f7744b, this.pPb.f7763b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 优量汇广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPc.pOK.f7760a);
        }
        aq aqVar = this.pPc.pON;
        String str2 = this.f7744b;
        au.a aVar = this.pPb;
        if (aqVar != null) {
            an anVar = aqVar.f7756a.get(aqVar.a(str2, aVar.f7762a));
            FunRippedAd eAp = anVar != null ? anVar.eAp() : null;
            if (eAp != null) {
                ((d.a) d.pOz).a(this.f7744b, this.pPb.f7763b, str, eAp.appPackageName, eAp.appLinkUrl);
                return;
            } else {
                ((d.a) d.pOz).a(this.f7744b, this.pPb.f7763b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void d(String str) {
        m.a("FunAdLoader 优量汇广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).d(this.f7744b, this.pPb.f7763b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告 onADError，广告ID：" + str + "，code：" + i + "，message：" + str2);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).e(this.f7744b, this.pPb.f7763b, str, i, str2);
    }
}
