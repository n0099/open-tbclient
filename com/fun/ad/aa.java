package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class aa implements ah {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8042b;
    public final /* synthetic */ FunAdInteractionListener pJv;
    public final /* synthetic */ au.a pJw;
    public final /* synthetic */ p pJx;

    public aa(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pJx = pVar;
        this.pJv = funAdInteractionListener;
        this.f8042b = str;
        this.pJw = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告 onADClosed，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8042b, this.pJw.f8061b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告 onADExposure，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).d(this.f8042b, this.pJw.f8061b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 优量汇广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pJx.pJf.f8058a);
        }
        aq aqVar = this.pJx.pJi;
        String str2 = this.f8042b;
        au.a aVar = this.pJw;
        if (aqVar != null) {
            an anVar = aqVar.f8054a.get(aqVar.a(str2, aVar.f8060a));
            FunRippedAd eBP = anVar != null ? anVar.eBP() : null;
            if (eBP != null) {
                ((d.a) d.pIU).a(this.f8042b, this.pJw.f8061b, str, eBP.appPackageName, eBP.appLinkUrl);
                return;
            } else {
                ((d.a) d.pIU).a(this.f8042b, this.pJw.f8061b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void d(String str) {
        m.a("FunAdLoader 优量汇广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).d(this.f8042b, this.pJw.f8061b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告 onADError，广告ID：" + str + "，code：" + i + "，message：" + str2);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).e(this.f8042b, this.pJw.f8061b, str, i, str2);
    }
}
