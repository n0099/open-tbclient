package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes6.dex */
public class WbShareResultActivity extends BaseActivity {
    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        LogUtil.i("Share", "startShareResultActivity");
        try {
            intent = getIntent();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (intent.getIntExtra(WBConstants.SHARE_START_FLAG, -1) == 0) {
            finish();
            return;
        }
        if (WBConstants.ACTIVITY_REQ_SDK.equals(intent.getAction())) {
            intent.setClass(this, WbShareTransActivity.class);
        } else {
            intent.setClass(this, WbShareToStoryActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
