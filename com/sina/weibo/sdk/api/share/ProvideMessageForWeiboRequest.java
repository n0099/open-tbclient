package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager;
/* loaded from: classes3.dex */
public class ProvideMessageForWeiboRequest extends BaseRequest {
    public ProvideMessageForWeiboRequest() {
    }

    public ProvideMessageForWeiboRequest(Bundle bundle) {
        fromBundle(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.BaseRequest
    public final boolean check(Context context, WeiboAppManager.WeiboInfo weiboInfo, VersionCheckHandler versionCheckHandler) {
        return true;
    }
}
