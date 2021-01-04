package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class aa implements ah {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8041b;
    public final /* synthetic */ FunAdInteractionListener pHN;
    public final /* synthetic */ au.a pHO;
    public final /* synthetic */ p pHP;

    public aa(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pHP = pVar;
        this.pHN = funAdInteractionListener;
        this.f8041b = str;
        this.pHO = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告 onADClosed，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).a(this.f8041b, this.pHO.f8060b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告 onADExposure，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).d(this.f8041b, this.pHO.f8060b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 优量汇广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pHP.pHx.f8057a);
        }
        aq aqVar = this.pHP.pHA;
        String str2 = this.f8041b;
        au.a aVar = this.pHO;
        if (aqVar != null) {
            an anVar = aqVar.f8053a.get(aqVar.a(str2, aVar.f8059a));
            FunRippedAd eBl = anVar != null ? anVar.eBl() : null;
            if (eBl != null) {
                ((d.a) d.pHm).a(this.f8041b, this.pHO.f8060b, str, eBl.appPackageName, eBl.appLinkUrl);
                return;
            } else {
                ((d.a) d.pHm).a(this.f8041b, this.pHO.f8060b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void d(String str) {
        m.a("FunAdLoader 优量汇广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).d(this.f8041b, this.pHO.f8060b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告 onADError，广告ID：" + str + "，code：" + i + "，message：" + str2);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).e(this.f8041b, this.pHO.f8060b, str, i, str2);
    }
}
