package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
/* loaded from: classes2.dex */
public class PassSMSAuthProxyActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public static WalletApiExtListener.ThirdPartyLoginListener callback;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean PageStarted;

    public PassSMSAuthProxyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.PageStarted = false;
    }

    public static void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, activity, thirdPartyLoginListener) == null) {
            callback = thirdPartyLoginListener;
            activity.startActivity(new Intent(activity, PassSMSAuthProxyActivity.class));
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            window.setGravity(51);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            callback = null;
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (!this.PageStarted) {
                this.PageStarted = true;
                BaiduWalletDelegate.getInstance().openH5Module(this, SdkInitResponse.getInstance().getPassAuthUrl(this), false);
                return;
            }
            WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = callback;
            if (thirdPartyLoginListener != null) {
                thirdPartyLoginListener.onCallSuccess(0, null);
            }
            callback = null;
            finish();
        }
    }
}
