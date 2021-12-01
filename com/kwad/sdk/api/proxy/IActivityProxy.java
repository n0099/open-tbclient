package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes2.dex */
public abstract class IActivityProxy implements IComponentProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;

    public IActivityProxy() {
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

    @KsAdSdkDynamicApi
    @Keep
    public <T extends View> T findViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (T) this.mActivity.findViewById(i2) : (T) invokeI.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mActivity.finish();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mActivity : (Activity) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivity.getIntent() : (Intent) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public Window getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActivity.getWindow() : (Window) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onApplyThemeResource(Resources.Theme theme, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{theme, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Activity activity = this.mActivity;
            if (activity instanceof BaseProxyActivity) {
                ((BaseProxyActivity) activity).superOnBackPressed();
            } else if (activity instanceof BaseProxyFragmentActivity) {
                ((BaseProxyFragmentActivity) activity).superOnBackPressed();
            } else {
                throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
            }
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, charSequence) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, keyEvent)) == null) {
            Activity activity = this.mActivity;
            if (activity instanceof BaseProxyActivity) {
                return ((BaseProxyActivity) activity).superOnKeyDown(i2, keyEvent);
            }
            if (activity instanceof BaseProxyFragmentActivity) {
                return ((BaseProxyFragmentActivity) activity).superOnKeyDown(i2, keyEvent);
            }
            throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        }
        return invokeIL.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, keyEvent)) == null) {
            Activity activity = this.mActivity;
            if (activity instanceof BaseProxyActivity) {
                return ((BaseProxyActivity) activity).superOnKeyLongPress(i2, keyEvent);
            }
            if (activity instanceof BaseProxyFragmentActivity) {
                return ((BaseProxyFragmentActivity) activity).superOnKeyLongPress(i2, keyEvent);
            }
            throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        }
        return invokeIL.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            Activity activity = this.mActivity;
            if (activity instanceof BaseProxyActivity) {
                return ((BaseProxyActivity) activity).superOnKeyUp(i2, keyEvent);
            }
            if (activity instanceof BaseProxyFragmentActivity) {
                return ((BaseProxyFragmentActivity) activity).superOnKeyUp(i2, keyEvent);
            }
            throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        }
        return invokeIL.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPrePause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onTitleChanged(CharSequence charSequence, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048608, this, charSequence, i2) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onUserLeaveHint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) {
            this.mActivity.overridePendingTransition(i2, i3);
        }
    }

    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, activity) == null) {
            this.mActivity = activity;
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.mActivity.setContentView(i2);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            this.mActivity.setContentView(view);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, view, layoutParams) == null) {
            this.mActivity.setContentView(view, layoutParams);
        }
    }
}
