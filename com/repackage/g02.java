package com.repackage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
/* loaded from: classes6.dex */
public class g02 extends a02 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout F0;
    public RelativeLayout G0;

    public g02() {
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

    public static g02 U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new g02() : (g02) invokeV.objValue;
    }

    @Override // com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            U1(view2);
            s2(-1);
            B2(-16777216);
            u2(H(R.string.obfuscated_res_0x7f0f1244));
            w2(true);
            I2(false);
        }
    }

    public final void T2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091414);
            this.F0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (bk2.y0().d() || !oe3.G()) {
                this.F0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902dd);
            this.G0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (a02.E0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            d02 L1 = L1();
            if (L1 == null) {
                m03.f(getContext(), R.string.obfuscated_res_0x7f0f019e).G();
                return;
            }
            d02.b i = L1.i("navigateTo");
            i.n(d02.g, d02.i);
            i.k("authority", null).a();
            kq2.o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    @Override // com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.a02
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091414) {
                bk2.t0().a();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0902dd) {
                V2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View y0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07bc, viewGroup, false);
            T1(inflate);
            T2(inflate);
            if (S1()) {
                inflate = V1(inflate);
            }
            return C1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
