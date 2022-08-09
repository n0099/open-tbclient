package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.BaseSsoHandler;
/* loaded from: classes8.dex */
public class SsoHandler extends BaseSsoHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_REQUEST_CODE = "com.sina.weibo.intent.extra.REQUEST_CODE";
    public static final int REQUEST_CODE_GET_USER_INFO = 32974;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SsoHandler(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void fillExtraIntent(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, intent, i) == null) {
            super.fillExtraIntent(intent, i);
            if (i == 32974) {
                intent.putExtra("com.sina.weibo.intent.extra.REQUEST_CODE", i);
            }
        }
    }

    @Override // com.sina.weibo.sdk.auth.BaseSsoHandler
    public void resetIntentFillData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.resetIntentFillData();
        }
    }
}
