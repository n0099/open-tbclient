package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes6.dex */
public class u implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7839b;
    public final /* synthetic */ FunAdInteractionListener pPa;
    public final /* synthetic */ au.a pPb;
    public final /* synthetic */ p pPc;

    public u(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPc = pVar;
        this.pPa = funAdInteractionListener;
        this.f7839b = str;
        this.pPb = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7839b, this.pPb.f7763b, str, (String) null, (String) null);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7839b, this.pPb.f7763b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).d(this.f7839b, this.pPb.f7763b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告 onAdError，广告ID：" + str + ", errorCode: " + i + ", errorMessage: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).e(this.f7839b, this.pPb.f7763b, str, i, str2);
    }
}
