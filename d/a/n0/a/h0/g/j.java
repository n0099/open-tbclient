package d.a.n0.a.h0.g;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.h0.g.g;
/* loaded from: classes7.dex */
public class j extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout C0;
    public RelativeLayout D0;

    public j() {
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

    public static j I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new j() : (j) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View B0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(d.a.n0.a.g.swan_app_settings_layout, viewGroup, false);
            Q1(inflate);
            H2(inflate);
            if (P1()) {
                inflate = S1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    public final void H2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(d.a.n0.a.f.message_item);
            this.C0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(d.a.n0.a.f.authority_item);
            this.D0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d.B0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            g J1 = J1();
            if (J1 == null) {
                d.a.n0.a.z1.b.f.e.f(q(), d.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = J1.i("navigateTo");
            i2.n(g.f44708g, g.f44710i);
            i2.k("authority", null).a();
            d.a.n0.a.j1.a.o("permission");
        }
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            R1(view);
            l2(-1);
            t2(-16777216);
            n2(J(d.a.n0.a.h.swan_app_menu_setting));
            p2(true);
            z2(false);
        }
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.h0.g.d
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view.getId() == d.a.n0.a.f.message_item) {
                d.a.n0.a.c1.a.k0().a();
            } else if (view.getId() == d.a.n0.a.f.authority_item) {
                J2();
            }
        }
    }
}
