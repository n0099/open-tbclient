package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes7.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean waitingForDismissAllowingStateLoss;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDialogFragment$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BottomSheetDialogFragment this$0;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048576, this, view2, f) == null) {
            }
        }

        public BottomSheetDismissCallback(BottomSheetDialogFragment bottomSheetDialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bottomSheetDialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bottomSheetDialogFragment;
        }

        public /* synthetic */ BottomSheetDismissCallback(BottomSheetDialogFragment bottomSheetDialogFragment, AnonymousClass1 anonymousClass1) {
            this(bottomSheetDialogFragment);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) && i == 5) {
                this.this$0.dismissAfterAnimation();
            }
        }
    }

    public BottomSheetDialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.waitingForDismissAllowingStateLoss) {
                super.dismissAllowingStateLoss();
            } else {
                super.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    private boolean tryDismissWithAnimation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            Dialog dialog = getDialog();
            if (dialog instanceof BottomSheetDialog) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
                BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
                if (behavior.isHideable() && bottomSheetDialog.getDismissWithAnimation()) {
                    dismissWithAnimation(behavior, z);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            return new BottomSheetDialog(getContext(), getTheme());
        }
        return (Dialog) invokeL.objValue;
    }

    private void dismissWithAnimation(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, bottomSheetBehavior, z) == null) {
            this.waitingForDismissAllowingStateLoss = z;
            if (bottomSheetBehavior.getState() == 5) {
                dismissAfterAnimation();
                return;
            }
            if (getDialog() instanceof BottomSheetDialog) {
                ((BottomSheetDialog) getDialog()).removeDefaultCallback();
            }
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetDismissCallback(this, null));
            bottomSheetBehavior.setState(5);
        }
    }
}
