package com.fun.ad;

import android.view.View;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public class am implements ax {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7751b;
    public final /* synthetic */ FunAdInteractionListener pEU;
    public final /* synthetic */ au.a pEV;
    public final /* synthetic */ p pEW;

    public am(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pEW = pVar;
        this.pEU = funAdInteractionListener;
        this.f7751b = str;
        this.pEV = aVar;
    }

    public void a(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pEW.pEE.f7758a);
        }
        bg bgVar = this.pEW.pEF;
        String str2 = this.f7751b;
        au.a aVar = this.pEV;
        if (bgVar != null) {
            bd bdVar = bgVar.f7768a.get(bgVar.a(str2, aVar.f7760a));
            FunRippedAd exX = bdVar != null ? bdVar.exX() : null;
            if (exX != null) {
                ((d.a) d.pEt).a(this.f7751b, this.pEV.f7761b, str, exX.appPackageName, exX.appLinkUrl);
                return;
            } else {
                ((d.a) d.pEt).a(this.f7751b, this.pEV.f7761b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).a(this.f7751b, this.pEV.f7761b, str);
    }

    public void b(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).d(this.f7751b, this.pEV.f7761b, str);
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pEU;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pEW.pEE.f7758a);
        }
        ((d.a) d.pEt).a(this.f7751b, this.pEV.f7761b, str);
    }
}
