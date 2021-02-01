package com.fun.ad;

import com.qq.e.ads.nativ.express2.AdEventListener;
/* loaded from: classes6.dex */
public class ay implements AdEventListener {
    public final /* synthetic */ av pPv;

    public ay(av avVar) {
        this.pPv = avVar;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        m.a("GDTNativeExpressAd2 onADClosed");
        av avVar = this.pPv;
        ah ahVar = avVar.pPn;
        if (ahVar != null) {
            ((aa) ahVar).a(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pPv;
        ah ahVar = avVar.pPn;
        if (ahVar != null) {
            ((aa) ahVar).c(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pPv;
        ah ahVar = avVar.pPn;
        if (ahVar != null) {
            ((aa) ahVar).d(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        this.pPv.f7755b = false;
        m.a("GDTNativeExpressAd2 onRenderFail");
        av avVar = this.pPv;
        ak akVar = avVar.pPm;
        if (akVar != null) {
            ((x) akVar).a(avVar.f7754a.f7762a, 0, "Custom error message: render fail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        m.a("GDTNativeExpressAd2 onRenderSuccess");
        av avVar = this.pPv;
        avVar.f7755b = false;
        ak akVar = avVar.pPm;
        if (akVar != null) {
            ((x) akVar).b(avVar.f7754a.f7762a);
        }
    }
}
