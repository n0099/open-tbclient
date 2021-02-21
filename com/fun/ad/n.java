package com.fun.ad;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import java.util.List;
/* loaded from: classes6.dex */
public class n extends bt {

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.FeedAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJNative onError code: " + i + ", message: " + str);
            n nVar = n.this;
            nVar.f7767b = false;
            ba baVar = nVar.pQa;
            if (baVar != null) {
                ((aj) baVar).a(nVar.f7766a.f7762a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            m.a("CSJNative onFeedAdLoad");
            n.this.f7767b = false;
            if (list != null && !list.isEmpty()) {
                n.this.pQw = list.get(0);
                m.a("CSJNative onFeedAdLoad imageMode: " + n.this.pQw.getImageMode());
                n nVar = n.this;
                ba baVar = nVar.pQa;
                if (baVar != null) {
                    ((aj) baVar).b(nVar.f7766a.f7762a);
                }
                AdRipper.ripCSJ(n.this.pQw);
                return;
            }
            m.a("CSJNative onFeedAdLoad error: adList is null or empty");
        }
    }

    public n(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.bt
    public void c() {
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true);
        au.a aVar = this.f7766a;
        this.pQc.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).setAdCount(1).build(), new a());
        ba baVar = this.pQa;
        if (baVar != null) {
            ((aj) baVar).a(this.f7766a.f7762a);
        }
    }
}
