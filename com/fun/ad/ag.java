package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class ag implements w {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8047b;
    public final /* synthetic */ FunAdInteractionListener pJv;
    public final /* synthetic */ au.a pJw;
    public final /* synthetic */ p pJx;

    public ag(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pJx = pVar;
        this.pJv = funAdInteractionListener;
        this.f8047b = str;
        this.pJw = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 快手广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pJx.pJf.f8058a);
        }
        af afVar = this.pJx.pJh;
        String str2 = this.f8047b;
        au.a aVar = this.pJw;
        if (afVar != null) {
            ac acVar = afVar.f8046a.get(afVar.a(str2, aVar.f8060a));
            FunRippedAd eBP = acVar != null ? acVar.eBP() : null;
            if (eBP != null) {
                ((d.a) d.pIU).a(this.f8047b, this.pJw.f8061b, str, eBP.appPackageName, eBP.appLinkUrl);
                return;
            } else {
                ((d.a) d.pIU).a(this.f8047b, this.pJw.f8061b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 快手广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8047b, this.pJw.f8061b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 快手广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).d(this.f8047b, this.pJw.f8061b, str);
    }

    public void d(String str) {
        m.a("FunAdLoader 快手广告 onPageDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8047b, this.pJw.f8061b, str);
    }

    public void e(String str) {
        m.a("FunAdLoader 快手广告 onVideoPlayError，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).e(this.f8047b, this.pJw.f8061b, str, 0, "Custom error message: onVideoPlayError");
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 快手广告 onAdShowError，广告ID：" + str + ", code: " + i + ", message: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).e(this.f8047b, this.pJw.f8061b, str, i, str2);
    }
}
