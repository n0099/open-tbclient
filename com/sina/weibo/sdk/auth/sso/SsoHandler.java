package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.Intent;
import com.sina.weibo.sdk.auth.BaseSsoHandler;
/* loaded from: classes7.dex */
public class SsoHandler extends BaseSsoHandler {
    private static final String EXTRA_REQUEST_CODE = "com.sina.weibo.intent.extra.REQUEST_CODE";
    private static final int REQUEST_CODE_GET_USER_INFO = 32974;

    public SsoHandler(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void fillExtraIntent(Intent intent, int i) {
        super.fillExtraIntent(intent, i);
        if (i == 32974) {
            intent.putExtra("com.sina.weibo.intent.extra.REQUEST_CODE", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void resetIntentFillData() {
        super.resetIntentFillData();
    }
}
