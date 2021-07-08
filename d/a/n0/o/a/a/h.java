package d.a.n0.o.a.a;

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
/* loaded from: classes7.dex */
public class h extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k0;
    public int l0;
    public boolean m0;
    public boolean n0;
    public int o0;
    public Dialog p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;

    public h() {
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
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = true;
        this.n0 = true;
        this.o0 = -1;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.D0();
            Dialog dialog = this.p0;
            if (dialog != null) {
                this.q0 = true;
                dialog.dismiss();
                this.p0 = null;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E0();
            if (this.s0 || this.r0) {
                return;
            }
            this.r0 = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0(Bundle bundle) {
        Bundle onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.M0(bundle);
            Dialog dialog = this.p0;
            if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
            int i2 = this.k0;
            if (i2 != 0) {
                bundle.putInt(DialogFragment.SAVED_STYLE, i2);
            }
            int i3 = this.l0;
            if (i3 != 0) {
                bundle.putInt(DialogFragment.SAVED_THEME, i3);
            }
            boolean z = this.m0;
            if (!z) {
                bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
            }
            boolean z2 = this.n0;
            if (!z2) {
                bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
            }
            int i4 = this.o0;
            if (i4 != -1) {
                bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i4);
            }
        }
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o1(false);
        }
    }

    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.r0) {
            return;
        }
        this.r0 = true;
        this.s0 = false;
        Dialog dialog = this.p0;
        if (dialog != null) {
            dialog.dismiss();
            this.p0 = null;
        }
        this.q0 = true;
        if (this.o0 >= 0) {
            u().e(this.o0, 1);
            this.o0 = -1;
            return;
        }
        n a2 = u().a();
        a2.g(this);
        if (z) {
            a2.e();
        } else {
            a2.d();
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dialogInterface) == null) {
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.n0 = this.B == 0;
            if (bundle != null) {
                this.k0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
                this.l0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
                this.m0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
                this.n0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.n0);
                this.o0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) || this.q0) {
            return;
        }
        o1(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            Dialog dialog = this.p0;
            if (dialog != null) {
                this.q0 = false;
                dialog.show();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            Dialog dialog = this.p0;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    public Dialog p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p0 : (Dialog) invokeV.objValue;
    }

    @StyleRes
    public int q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l0 : invokeV.intValue;
    }

    @NonNull
    public Dialog r1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundle)) == null) ? new Dialog(h(), q1()) : (Dialog) invokeL.objValue;
    }

    public void s1(Dialog dialog, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, dialog, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            dialog.requestWindowFeature(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.t0(bundle);
            if (this.n0) {
                View b0 = b0();
                if (b0 != null) {
                    if (b0.getParent() == null) {
                        this.p0.setContentView(b0);
                    } else {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
                this.p0.setOwnerActivity(h());
                this.p0.setCancelable(this.m0);
                this.p0.setOnCancelListener(this);
                this.p0.setOnDismissListener(this);
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                this.p0.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void t1(l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, lVar, str) == null) {
            this.r0 = false;
            this.s0 = true;
            n a2 = lVar.a();
            a2.c(this, str);
            a2.d();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater v(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bundle)) == null) {
            if (!this.n0) {
                return super.v(bundle);
            }
            Dialog r1 = r1(bundle);
            this.p0 = r1;
            if (r1 != null) {
                s1(r1, this.k0);
                return (LayoutInflater) this.p0.getContext().getSystemService("layout_inflater");
            }
            return (LayoutInflater) this.x.h().getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            super.w0(activity);
            if (this.s0) {
                return;
            }
            this.r0 = false;
        }
    }
}
