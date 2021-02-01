package com.fun.ad;

import com.qq.e.ads.nativ.express2.MediaEventListener;
/* loaded from: classes6.dex */
public class bb implements MediaEventListener {
    public bb(av avVar) {
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoCache() {
        m.a("GDTNativeExpressAd2 onVideoCache");
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoComplete() {
        m.a("GDTNativeExpressAd2 onVideoComplete");
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoError() {
        m.a("GDTNativeExpressAd2 onVideoError");
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoPause() {
        m.a("GDTNativeExpressAd2 onVideoPause");
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoResume() {
        m.a("GDTNativeExpressAd2 onVideoResume");
    }

    @Override // com.qq.e.ads.nativ.express2.MediaEventListener
    public void onVideoStart() {
        m.a("GDTNativeExpressAd2 onVideoStart");
    }
}
