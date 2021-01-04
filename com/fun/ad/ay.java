package com.fun.ad;

import com.qq.e.ads.nativ.express2.AdEventListener;
/* loaded from: classes15.dex */
public class ay implements AdEventListener {
    public final /* synthetic */ av pIi;

    public ay(av avVar) {
        this.pIi = avVar;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        m.a("GDTNativeExpressAd2 onADClosed");
        av avVar = this.pIi;
        ah ahVar = avVar.pIa;
        if (ahVar != null) {
            ((aa) ahVar).a(avVar.f8051a.f8059a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pIi;
        ah ahVar = avVar.pIa;
        if (ahVar != null) {
            ((aa) ahVar).c(avVar.f8051a.f8059a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pIi;
        ah ahVar = avVar.pIa;
        if (ahVar != null) {
            ((aa) ahVar).d(avVar.f8051a.f8059a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        this.pIi.f8052b = false;
        m.a("GDTNativeExpressAd2 onRenderFail");
        av avVar = this.pIi;
        ak akVar = avVar.pHZ;
        if (akVar != null) {
            ((x) akVar).a(avVar.f8051a.f8059a, 0, "Custom error message: render fail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        m.a("GDTNativeExpressAd2 onRenderSuccess");
        av avVar = this.pIi;
        avVar.f8052b = false;
        ak akVar = avVar.pHZ;
        if (akVar != null) {
            ((x) akVar).b(avVar.f8051a.f8059a);
        }
    }
}
