package com.fun.ad;

import android.view.View;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public class am implements ax {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7753b;
    public final /* synthetic */ FunAdInteractionListener pPA;
    public final /* synthetic */ au.a pPB;
    public final /* synthetic */ p pPC;

    public am(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPC = pVar;
        this.pPA = funAdInteractionListener;
        this.f7753b = str;
        this.pPB = aVar;
    }

    public void a(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPC.pPk.f7760a);
        }
        bg bgVar = this.pPC.pPl;
        String str2 = this.f7753b;
        au.a aVar = this.pPB;
        if (bgVar != null) {
            bd bdVar = bgVar.f7770a.get(bgVar.a(str2, aVar.f7762a));
            FunRippedAd eAx = bdVar != null ? bdVar.eAx() : null;
            if (eAx != null) {
                ((d.a) d.pOZ).a(this.f7753b, this.pPB.f7763b, str, eAx.appPackageName, eAx.appLinkUrl);
                return;
            } else {
                ((d.a) d.pOZ).a(this.f7753b, this.pPB.f7763b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).a(this.f7753b, this.pPB.f7763b, str);
    }

    public void b(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).d(this.f7753b, this.pPB.f7763b, str);
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPA;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPC.pPk.f7760a);
        }
        ((d.a) d.pOZ).a(this.f7753b, this.pPB.f7763b, str);
    }
}
