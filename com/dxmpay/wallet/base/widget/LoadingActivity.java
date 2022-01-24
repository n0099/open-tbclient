package com.dxmpay.wallet.base.widget;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class LoadingActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_LOGIN_LOADING = 512;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimationDrawable mAnimationDrawable;

    public LoadingActivity() {
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

    public static synchronized void exitLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (LoadingActivity.class) {
                BaseActivity.clearTasksWithFlag(512);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_layout_loading"));
            AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            this.mAnimationDrawable = animationDrawable;
            animationDrawable.stop();
            this.mAnimationDrawable.start();
            setImmersiveActivityMargeinTop();
        }
    }

    private void setFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mFlag |= 512;
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public boolean isSlidingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getOpenLoginToken())) {
                finish();
                return;
            }
            StatisticManager.onEventWithValues("DXMLoadingShow", Arrays.asList(String.valueOf(hashCode()), "onCreate"));
            setFlag();
            initView();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            AnimationDrawable animationDrawable = this.mAnimationDrawable;
            if (animationDrawable == null || !animationDrawable.isRunning()) {
                return;
            }
            this.mAnimationDrawable.stop();
        }
    }

    public void setImmersiveActivityMargeinTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 19 || getActivity() == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(getActivity(), "welcome_page"));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
    }
}
