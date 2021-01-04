package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes15.dex */
public class u implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8136b;
    public final /* synthetic */ FunAdInteractionListener pHN;
    public final /* synthetic */ au.a pHO;
    public final /* synthetic */ p pHP;

    public u(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pHP = pVar;
        this.pHN = funAdInteractionListener;
        this.f8136b = str;
        this.pHO = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).a(this.f8136b, this.pHO.f8060b, str, (String) null, (String) null);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).a(this.f8136b, this.pHO.f8060b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).d(this.f8136b, this.pHO.f8060b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告 onAdError，广告ID：" + str + ", errorCode: " + i + ", errorMessage: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).e(this.f8136b, this.pHO.f8060b, str, i, str2);
    }
}
