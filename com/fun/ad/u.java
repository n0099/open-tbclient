package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes15.dex */
public class u implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8137b;
    public final /* synthetic */ FunAdInteractionListener pJv;
    public final /* synthetic */ au.a pJw;
    public final /* synthetic */ p pJx;

    public u(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pJx = pVar;
        this.pJv = funAdInteractionListener;
        this.f8137b = str;
        this.pJw = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8137b, this.pJw.f8061b, str, (String) null, (String) null);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8137b, this.pJw.f8061b, str);
    }

    public void c(String str) {
        m.a("FunAdLoader 巨赢互联广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).d(this.f8137b, this.pJw.f8061b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告 onAdError，广告ID：" + str + ", errorCode: " + i + ", errorMessage: " + str2);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdError(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).e(this.f8137b, this.pJw.f8061b, str, i, str2);
    }
}
