package com.fun.ad;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import java.util.List;
/* loaded from: classes15.dex */
public class n extends bt {

    /* loaded from: classes15.dex */
    public class a implements TTAdNative.FeedAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJNative onError code: " + i + ", message: " + str);
            n nVar = n.this;
            nVar.f8065b = false;
            ba baVar = nVar.pJV;
            if (baVar != null) {
                ((aj) baVar).a(nVar.f8064a.f8060a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            m.a("CSJNative onFeedAdLoad");
            n.this.f8065b = false;
            if (list != null && !list.isEmpty()) {
                n.this.pKr = list.get(0);
                m.a("CSJNative onFeedAdLoad imageMode: " + n.this.pKr.getImageMode());
                n nVar = n.this;
                ba baVar = nVar.pJV;
                if (baVar != null) {
                    ((aj) baVar).b(nVar.f8064a.f8060a);
                }
                AdRipper.ripCSJ(n.this.pKr);
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
        AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f8064a.f8060a).setSupportDeepLink(true);
        au.a aVar = this.f8064a;
        this.pJX.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.c, aVar.d).setAdCount(1).build(), new a());
        ba baVar = this.pJV;
        if (baVar != null) {
            ((aj) baVar).a(this.f8064a.f8060a);
        }
    }
}
