package com.kwad.sdk.api.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes10.dex */
public class KsFragmentActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsFragmentManager mFragmentManager;

    public KsFragmentActivity() {
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

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final FragmentManager getSupportFragmentManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    @Keep
    public final KsFragmentManager getSupportFragmentManager2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mFragmentManager == null) {
                this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
            }
            return this.mFragmentManager;
        }
        return (KsFragmentManager) invokeV.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void onAttachFragment(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fragment) == null) {
            super.onAttachFragment(fragment);
            if (fragment instanceof IDelegateFragment) {
                onAttachFragment(((IDelegateFragment) fragment).getBase());
            }
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onAttachFragment(KsFragment ksFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ksFragment) == null) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, fragment, intent, i2) == null) {
            super.startActivityFromFragment(fragment, intent, i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048582, this, fragment, intent, i2, bundle) == null) {
            super.startActivityFromFragment(fragment, intent, i2, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public void supportFinishAfterTransition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.supportFinishAfterTransition();
        }
    }
}
