package com.fun.ad;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import java.util.List;
/* loaded from: classes14.dex */
public class n extends bt {

    /* loaded from: classes14.dex */
    public class a implements TTAdNative.FeedAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJNative onError code: " + i + ", message: " + str);
            n nVar = n.this;
            nVar.f7765b = false;
            ba baVar = nVar.pFu;
            if (baVar != null) {
                ((aj) baVar).a(nVar.f7764a.f7760a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            m.a("CSJNative onFeedAdLoad");
            n.this.f7765b = false;
            if (list != null && !list.isEmpty()) {
                n.this.pFQ = list.get(0);
                m.a("CSJNative onFeedAdLoad imageMode: " + n.this.pFQ.getImageMode());
                n nVar = n.this;
                ba baVar = nVar.pFu;
                if (baVar != null) {
                    ((aj) baVar).b(nVar.f7764a.f7760a);
                }
                AdRipper.ripCSJ(n.this.pFQ);
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
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f7764a.f7760a).setSupportDeepLink(true);
        au.a aVar = this.f7764a;
        this.pFw.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).setAdCount(1).build(), new a());
        ba baVar = this.pFu;
        if (baVar != null) {
            ((aj) baVar).a(this.f7764a.f7760a);
        }
    }
}
