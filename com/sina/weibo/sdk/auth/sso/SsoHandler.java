package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.Intent;
import com.sina.weibo.sdk.auth.BaseSsoHandler;
/* loaded from: classes6.dex */
public class SsoHandler extends BaseSsoHandler {
    public static final String EXTRA_REQUEST_CODE = "com.sina.weibo.intent.extra.REQUEST_CODE";
    public static final int REQUEST_CODE_GET_USER_INFO = 32974;

    public SsoHandler(Activity activity) {
        super(activity);
    }

    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void fillExtraIntent(Intent intent, int i2) {
        super.fillExtraIntent(intent, i2);
        if (i2 == 32974) {
            intent.putExtra("com.sina.weibo.intent.extra.REQUEST_CODE", i2);
        }
    }

    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void resetIntentFillData() {
        super.resetIntentFillData();
    }
}
