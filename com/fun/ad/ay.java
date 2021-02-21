package com.fun.ad;

import com.qq.e.ads.nativ.express2.AdEventListener;
/* loaded from: classes6.dex */
public class ay implements AdEventListener {
    public final /* synthetic */ av pPV;

    public ay(av avVar) {
        this.pPV = avVar;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        m.a("GDTNativeExpressAd2 onADClosed");
        av avVar = this.pPV;
        ah ahVar = avVar.pPN;
        if (ahVar != null) {
            ((aa) ahVar).a(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pPV;
        ah ahVar = avVar.pPN;
        if (ahVar != null) {
            ((aa) ahVar).c(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pPV;
        ah ahVar = avVar.pPN;
        if (ahVar != null) {
            ((aa) ahVar).d(avVar.f7754a.f7762a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        this.pPV.f7755b = false;
        m.a("GDTNativeExpressAd2 onRenderFail");
        av avVar = this.pPV;
        ak akVar = avVar.pPM;
        if (akVar != null) {
            ((x) akVar).a(avVar.f7754a.f7762a, 0, "Custom error message: render fail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        m.a("GDTNativeExpressAd2 onRenderSuccess");
        av avVar = this.pPV;
        avVar.f7755b = false;
        ak akVar = avVar.pPM;
        if (akVar != null) {
            ((x) akVar).b(avVar.f7754a.f7762a);
        }
    }
}
