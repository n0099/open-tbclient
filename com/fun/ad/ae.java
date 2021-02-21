package com.fun.ad;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.fun.ad.au;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes6.dex */
public class ae extends ab {
    public ae(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ab
    public AdSlot eAA() {
        return new AdSlot.Builder().setCodeId(this.f7766a.f7762a).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).setExpressViewAcceptedSize(360.0f, 640.0f).build();
    }
}
