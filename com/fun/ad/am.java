package com.fun.ad;

import android.view.View;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public class am implements ax {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8050b;
    public final /* synthetic */ FunAdInteractionListener pHN;
    public final /* synthetic */ au.a pHO;
    public final /* synthetic */ p pHP;

    public am(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pHP = pVar;
        this.pHN = funAdInteractionListener;
        this.f8050b = str;
        this.pHO = aVar;
    }

    public void a(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pHP.pHx.f8057a);
        }
        bg bgVar = this.pHP.pHy;
        String str2 = this.f8050b;
        au.a aVar = this.pHO;
        if (bgVar != null) {
            bd bdVar = bgVar.f8067a.get(bgVar.a(str2, aVar.f8059a));
            FunRippedAd eBl = bdVar != null ? bdVar.eBl() : null;
            if (eBl != null) {
                ((d.a) d.pHm).a(this.f8050b, this.pHO.f8060b, str, eBl.appPackageName, eBl.appLinkUrl);
                return;
            } else {
                ((d.a) d.pHm).a(this.f8050b, this.pHO.f8060b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).a(this.f8050b, this.pHO.f8060b, str);
    }

    public void b(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).d(this.f8050b, this.pHO.f8060b, str);
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pHN;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pHP.pHx.f8057a);
        }
        ((d.a) d.pHm).a(this.f8050b, this.pHO.f8060b, str);
    }
}
