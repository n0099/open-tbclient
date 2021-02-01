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
    public final /* synthetic */ FunAdInteractionListener pPa;
    public final /* synthetic */ au.a pPb;
    public final /* synthetic */ p pPc;

    public am(p pVar, FunAdInteractionListener funAdInteractionListener, String str, au.a aVar) {
        this.pPc = pVar;
        this.pPa = funAdInteractionListener;
        this.f7753b = str;
        this.pPb = aVar;
    }

    public void a(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdClicked，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClicked(this.pPc.pOK.f7760a);
        }
        bg bgVar = this.pPc.pOL;
        String str2 = this.f7753b;
        au.a aVar = this.pPb;
        if (bgVar != null) {
            bd bdVar = bgVar.f7770a.get(bgVar.a(str2, aVar.f7762a));
            FunRippedAd eAp = bdVar != null ? bdVar.eAp() : null;
            if (eAp != null) {
                ((d.a) d.pOz).a(this.f7753b, this.pPb.f7763b, str, eAp.appPackageName, eAp.appLinkUrl);
                return;
            } else {
                ((d.a) d.pOz).a(this.f7753b, this.pPb.f7763b, str, (String) null, (String) null);
                return;
            }
        }
        throw null;
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdDismiss，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7753b, this.pPb.f7763b, str);
    }

    public void b(String str, View view, int i) {
        m.a("FunAdLoader 穿山甲广告 onAdShow，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdShow(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).d(this.f7753b, this.pPb.f7763b, str);
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告 onAdClose，广告ID：" + str);
        FunAdInteractionListener funAdInteractionListener = this.pPa;
        if (funAdInteractionListener != null) {
            funAdInteractionListener.onAdClose(this.pPc.pOK.f7760a);
        }
        ((d.a) d.pOz).a(this.f7753b, this.pPb.f7763b, str);
    }
}
