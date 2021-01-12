package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public class aa implements ah {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7742b;
    public final /* synthetic */ FunAdInteractionListener pEU;
    public final /* synthetic */ au.a pEV;
    public final /* synthetic */ p pEW;

    public aa(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pEW = pVar;
        this.pEU = funAdInteractionListener;
        this.f7742b = str;
        this.pEV = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告 onADClosed，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).a(this.f7742b, this.pEV.f7761b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告 onADExposure，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).d(this.f7742b, this.pEV.f7761b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 优量汇广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pEW.pEE.f7758a);
        }
        aq aqVar = this.pEW.pEH;
        String str2 = this.f7742b;
        au.a aVar = this.pEV;
        if (aqVar != null) {
            an anVar = aqVar.f7754a.get(aqVar.a(str2, aVar.f7760a));
            FunRippedAd exX = anVar != null ? anVar.exX() : null;
            if (exX != null) {
                ((d.a) d.pEt).a(this.f7742b, this.pEV.f7761b, str, exX.appPackageName, exX.appLinkUrl);
                return;
            } else {
                ((d.a) d.pEt).a(this.f7742b, this.pEV.f7761b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void d(String str) {
        m.a("FunAdLoader 优量汇广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).d(this.f7742b, this.pEV.f7761b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告 onADError，广告ID：" + str + "，code：" + i + "，message：" + str2);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).e(this.f7742b, this.pEV.f7761b, str, i, str2);
    }
}
