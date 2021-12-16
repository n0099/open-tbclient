package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public class KsDialogFragment extends KsFragment implements IDialogFragmentLifecycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DelegateDialogFragment mBase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @KsAdSdkDynamicApi
    @Keep
    public KsDialogFragment() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Fragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ResDialogFragment resDialogFragment = new ResDialogFragment(this);
        this.mBase = resDialogFragment;
        setBase(resDialogFragment);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Keep
    public KsDialogFragment(DelegateDialogFragment delegateDialogFragment) {
        super(delegateDialogFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {delegateDialogFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Fragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBase = delegateDialogFragment;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBase.dismiss();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dismissAllowingStateLoss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mBase.dismissAllowingStateLoss();
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public Dialog getDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBase.getDialog() : (Dialog) invokeV.objValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean getShowsDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBase.getShowsDialog() : invokeV.booleanValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBase.getTheme() : invokeV.intValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isCancelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBase.isCancelable() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dialogInterface) == null) {
            this.mBase.superOnCancel(dialogInterface);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) ? this.mBase.superOnCreateDialog(bundle) : (Dialog) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.IDialogFragmentLifecycle
    @KsAdSdkDynamicApi
    @Keep
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface) == null) {
            this.mBase.superOnDismiss(dialogInterface);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mBase.setCancelable(z);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setShowsDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mBase.setShowsDialog(z);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setStyle(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            this.mBase.setStyle(i2, i3);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public void setupDialog(Dialog dialog, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, dialog, i2) == null) {
            this.mBase.setupDialog(dialog, i2);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public int show(KsFragmentTransaction ksFragmentTransaction, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, ksFragmentTransaction, str)) == null) ? this.mBase.show(ksFragmentTransaction.getBase(), str) : invokeLL.intValue;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void show(KsFragmentManager ksFragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, ksFragmentManager, str) == null) {
            this.mBase.show(ksFragmentManager.getBase(), str);
        }
    }
}
