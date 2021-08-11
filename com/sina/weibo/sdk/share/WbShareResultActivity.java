package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes10.dex */
public class WbShareResultActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WbShareResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
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
}
