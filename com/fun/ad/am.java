package com.fun.ad;

import android.view.View;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class am implements ax {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8051b;
    public final /* synthetic */ FunAdInteractionListener pJv;
    public final /* synthetic */ au.a pJw;
    public final /* synthetic */ p pJx;

    public am(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pJx = pVar;
        this.pJv = funAdInteractionListener;
        this.f8051b = str;
        this.pJw = aVar;
    }

    public void a(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pJx.pJf.f8058a);
        }
        bg bgVar = this.pJx.pJg;
        String str2 = this.f8051b;
        au.a aVar = this.pJw;
        if (bgVar != null) {
            bd bdVar = bgVar.f8068a.get(bgVar.a(str2, aVar.f8060a));
            FunRippedAd eBP = bdVar != null ? bdVar.eBP() : null;
            if (eBP != null) {
                ((d.a) d.pIU).a(this.f8051b, this.pJw.f8061b, str, eBP.appPackageName, eBP.appLinkUrl);
                return;
            } else {
                ((d.a) d.pIU).a(this.f8051b, this.pJw.f8061b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8051b, this.pJw.f8061b, str);
    }

    public void b(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).d(this.f8051b, this.pJw.f8061b, str);
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pJv;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pJx.pJf.f8058a);
        }
        ((d.a) d.pIU).a(this.f8051b, this.pJw.f8061b, str);
    }
}
