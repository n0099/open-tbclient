package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.Preconditions;
/* loaded from: classes9.dex */
public class ErrorDialogFragment extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DialogInterface.OnCancelListener myCancelLister;
    public Dialog myDialog;

    public ErrorDialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.myDialog = null;
        this.myCancelLister = null;
    }

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dialog)) == null) {
            return newInstance(dialog, null);
        }
        return (ErrorDialogFragment) invokeL.objValue;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (onCancelListener = this.myCancelLister) != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            if (this.myDialog == null) {
                setShowsDialog(false);
            }
            return this.myDialog;
        }
        return (Dialog) invokeL.objValue;
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dialog, onCancelListener)) == null) {
            Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            errorDialogFragment.myDialog = dialog;
            dialog.setOnCancelListener(null);
            errorDialogFragment.myDialog.setOnDismissListener(null);
            if (onCancelListener != null) {
                errorDialogFragment.myCancelLister = onCancelListener;
            }
            return errorDialogFragment;
        }
        return (ErrorDialogFragment) invokeLL.objValue;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fragmentManager, str) == null) {
            Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
            super.show(fragmentManager, str);
        }
    }
}
