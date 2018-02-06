package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes3.dex */
public abstract class BaseRequest extends Base {
    public String packageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean check(Context context, WeiboAppManager.WeiboInfo weiboInfo, VersionCheckHandler versionCheckHandler);

    @Override // com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, getType());
        bundle.putString(WBConstants.TRAN, this.transaction);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        this.transaction = bundle.getString(WBConstants.TRAN);
        this.packageName = bundle.getString(WBConstants.Base.APP_PKG);
    }
}
