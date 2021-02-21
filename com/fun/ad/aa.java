package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class aa implements ah {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7744b;
    public final /* synthetic */ FunAdInteractionListener pPA;
    public final /* synthetic */ au.a pPB;
    public final /* synthetic */ p pPC;

    public aa(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPC = pVar;
        this.pPA = funAdInteractionListener;
        this.f7744b = str;
        this.pPB = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告 onADClosed，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).a(this.f7744b, this.pPB.f7763b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告 onADExposure，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).d(this.f7744b, this.pPB.f7763b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 优量汇广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPC.pPk.f7760a);
        }
        aq aqVar = this.pPC.pPn;
        String str2 = this.f7744b;
        au.a aVar = this.pPB;
        if (aqVar != null) {
            an anVar = aqVar.f7756a.get(aqVar.a(str2, aVar.f7762a));
            FunRippedAd eAx = anVar != null ? anVar.eAx() : null;
            if (eAx != null) {
                ((d.a) d.pOZ).a(this.f7744b, this.pPB.f7763b, str, eAx.appPackageName, eAx.appLinkUrl);
                return;
            } else {
                ((d.a) d.pOZ).a(this.f7744b, this.pPB.f7763b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void d(String str) {
        m.a("FunAdLoader 优量汇广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).d(this.f7744b, this.pPB.f7763b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告 onADError，广告ID：" + str + "，code：" + i + "，message：" + str2);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).e(this.f7744b, this.pPB.f7763b, str, i, str2);
    }
}
