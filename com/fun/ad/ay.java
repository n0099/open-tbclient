package com.fun.ad;

import com.qq.e.ads.nativ.express2.AdEventListener;
/* loaded from: classes15.dex */
public class ay implements AdEventListener {
    public final /* synthetic */ av pJQ;

    public ay(av avVar) {
        this.pJQ = avVar;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        m.a("GDTNativeExpressAd2 onADClosed");
        av avVar = this.pJQ;
        ah ahVar = avVar.pJI;
        if (ahVar != null) {
            ((aa) ahVar).a(avVar.f8052a.f8060a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pJQ;
        ah ahVar = avVar.pJI;
        if (ahVar != null) {
            ((aa) ahVar).c(avVar.f8052a.f8060a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        m.a("GDTNativeExpressAd2 onClick");
        av avVar = this.pJQ;
        ah ahVar = avVar.pJI;
        if (ahVar != null) {
            ((aa) ahVar).d(avVar.f8052a.f8060a);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        this.pJQ.f8053b = false;
        m.a("GDTNativeExpressAd2 onRenderFail");
        av avVar = this.pJQ;
        ak akVar = avVar.pJH;
        if (akVar != null) {
            ((x) akVar).a(avVar.f8052a.f8060a, 0, "Custom error message: render fail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        m.a("GDTNativeExpressAd2 onRenderSuccess");
        av avVar = this.pJQ;
        avVar.f8053b = false;
        ak akVar = avVar.pJH;
        if (akVar != null) {
            ((x) akVar).b(avVar.f8052a.f8060a);
        }
    }
}
