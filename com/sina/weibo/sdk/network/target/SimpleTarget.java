package com.sina.weibo.sdk.network.target;

import com.sina.weibo.sdk.network.base.WbResponse;
/* loaded from: classes6.dex */
public abstract class SimpleTarget extends BaseTarget {
    @Override // com.sina.weibo.sdk.network.target.Target
    public final void onRequestSuccess(Object obj) {
        onSuccess(String.valueOf(obj));
    }

    public abstract void onSuccess(String str);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.sina.weibo.sdk.network.target.Target
    public String transResponse(WbResponse wbResponse) throws Exception {
        return wbResponse.body().string();
    }
}
