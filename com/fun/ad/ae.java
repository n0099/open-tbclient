package com.fun.ad;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.fun.ad.au;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes15.dex */
public class ae extends ab {
    public ae(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ab
    public AdSlot eBo() {
        return new AdSlot.Builder().setCodeId(this.f8063a.f8059a).setSupportDeepLink(true).setImageAcceptedSize(1080, WBConstants.SDK_NEW_PAY_VERSION).setExpressViewAcceptedSize(360.0f, 640.0f).build();
    }
}
