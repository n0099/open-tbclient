package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes14.dex */
public class u implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7837b;
    public final /* synthetic */ FunAdInteractionListener pEV;
    public final /* synthetic */ au.a pEW;
    public final /* synthetic */ p pEX;

    public u(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pEX = pVar;
        this.pEV = funAdInteractionListener;
        this.f7837b = str;
        this.pEW = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEV;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pEX.pEF.f7758a);
        }
        ((d.a) d.pEu).a(this.f7837b, this.pEW.f7761b, str, (String) null, (String) null);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEV;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEX.pEF.f7758a);
        }
        ((d.a) d.pEu).a(this.f7837b, this.pEW.f7761b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEV;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pEX.pEF.f7758a);
        }
        ((d.a) d.pEu).d(this.f7837b, this.pEW.f7761b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告 onAdError，广告ID：" + str + ", errorCode: " + i + ", errorMessage: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pEV;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pEX.pEF.f7758a);
        }
        ((d.a) d.pEu).e(this.f7837b, this.pEW.f7761b, str, i, str2);
    }
}
