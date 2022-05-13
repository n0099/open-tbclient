package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ke4 extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h0;
    public int i0;
    public boolean j0;
    public boolean k0;
    public int l0;
    public Dialog m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;

    public ke4() {
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
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = true;
        this.k0 = true;
        this.l0 = -1;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.B0();
            Dialog dialog = this.m0;
            if (dialog != null) {
                this.n0 = true;
                dialog.dismiss();
                this.m0 = null;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C0();
            if (this.p0 || this.o0) {
                return;
            }
            this.o0 = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void K0(Bundle bundle) {
        Bundle onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.K0(bundle);
            Dialog dialog = this.m0;
            if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
                bundle.putBundle(DialogFragment.SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
            }
            int i = this.h0;
            if (i != 0) {
                bundle.putInt(DialogFragment.SAVED_STYLE, i);
            }
            int i2 = this.i0;
            if (i2 != 0) {
                bundle.putInt(DialogFragment.SAVED_THEME, i2);
            }
            boolean z = this.j0;
            if (!z) {
                bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
            }
            boolean z2 = this.k0;
            if (!z2) {
                bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
            }
            int i3 = this.l0;
            if (i3 != -1) {
                bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i3);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.L0();
            Dialog dialog = this.m0;
            if (dialog != null) {
                this.n0 = false;
                dialog.show();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.M0();
            Dialog dialog = this.m0;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n1(false);
        }
    }

    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.o0) {
            return;
        }
        this.o0 = true;
        this.p0 = false;
        Dialog dialog = this.m0;
        if (dialog != null) {
            dialog.dismiss();
            this.m0 = null;
        }
        this.n0 = true;
        if (this.l0 >= 0) {
            v().e(this.l0, 1);
            this.l0 = -1;
            return;
        }
        qe4 a = v().a();
        a.h(this);
        if (z) {
            a.f();
        } else {
            a.e();
        }
    }

    public Dialog o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m0 : (Dialog) invokeV.objValue;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface) == null) {
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, dialogInterface) == null) || this.n0) {
            return;
        }
        n1(true);
    }

    @StyleRes
    public int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i0 : invokeV.intValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q0(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.q0(bundle);
            if (this.k0) {
                View S = S();
                if (S != null) {
                    if (S.getParent() == null) {
                        this.m0.setContentView(S);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                this.m0.setOwnerActivity(getActivity());
                this.m0.setCancelable(this.j0);
                this.m0.setOnCancelListener(this);
                this.m0.setOnDismissListener(this);
                if (bundle == null || (bundle2 = bundle.getBundle(DialogFragment.SAVED_DIALOG_STATE_TAG)) == null) {
                    return;
                }
                this.m0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @NonNull
    public Dialog q1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundle)) == null) ? new Dialog(getActivity(), p1()) : (Dialog) invokeL.objValue;
    }

    public void r1(Dialog dialog, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, dialog, i) == null) {
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            dialog.requestWindowFeature(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            super.s0(activity);
            if (this.p0) {
                return;
            }
            this.o0 = false;
        }
    }

    public void s1(oe4 oe4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, oe4Var, str) == null) {
            this.o0 = false;
            this.p0 = true;
            qe4 a = oe4Var.a();
            a.c(this, str);
            a.e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.v0(bundle);
            this.k0 = this.x == 0;
            if (bundle != null) {
                this.h0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
                this.i0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
                this.j0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
                this.k0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.k0);
                this.l0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater w(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundle)) == null) {
            if (!this.k0) {
                return super.w(bundle);
            }
            Dialog q1 = q1(bundle);
            this.m0 = q1;
            if (q1 != null) {
                r1(q1, this.h0);
                return (LayoutInflater) this.m0.getContext().getSystemService("layout_inflater");
            }
            return (LayoutInflater) this.t.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeL.objValue;
    }
}
