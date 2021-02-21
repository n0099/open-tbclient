package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes6.dex */
public class u implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7839b;
    public final /* synthetic */ FunAdInteractionListener pPA;
    public final /* synthetic */ au.a pPB;
    public final /* synthetic */ p pPC;

    public u(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPC = pVar;
        this.pPA = funAdInteractionListener;
        this.f7839b = str;
        this.pPB = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).a(this.f7839b, this.pPB.f7763b, str, (String) null, (String) null);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).a(this.f7839b, this.pPB.f7763b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).d(this.f7839b, this.pPB.f7763b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告 onAdError，广告ID：" + str + ", errorCode: " + i + ", errorMessage: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).e(this.f7839b, this.pPB.f7763b, str, i, str2);
    }
}
