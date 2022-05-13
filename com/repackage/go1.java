package com.repackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class go1 extends i02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends f22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ go1 c;

        public a(go1 go1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = go1Var;
        }

        @Override // com.repackage.f22, com.repackage.i22
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.b(str) : invokeL.booleanValue;
        }
    }

    public go1() {
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

    @Override // com.repackage.i02, com.repackage.a02
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bn1 bn1Var = this.G0;
            if (bn1Var != null && bn1Var.canGoBack()) {
                this.G0.goBack();
                return true;
            }
            f3();
            SwanAppAllianceLoginHelper.d.a(ho1.d(), ho1.a());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.i02, com.repackage.a02
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.T1(view2);
            this.l0.setRightZoneVisibility(true);
        }
    }

    @Override // com.repackage.i02
    public i22 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (i22) invokeV.objValue;
    }

    @Override // com.repackage.i02
    public void Z2() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            this.m0 = new z64(activity, this.l0, g3(), bk2.K(), new dg3());
            new kq2(this.m0, this).z();
        }
    }

    @Override // com.repackage.i02, com.repackage.a02
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f3() {
        gh1 d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || SwanAppAllianceLoginHelper.d.c() || (d = SwanAppAllianceLoginHelper.d.d()) == null) {
            return;
        }
        d.onResult(-2);
    }

    public final int g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? c2() ? 18 : 12 : invokeV.intValue;
    }

    @Override // com.repackage.i02
    public dn1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o72.U().f0().f(getContext()) : (dn1) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.repackage.bn1] */
    @Override // com.repackage.i02, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e0, viewGroup, false);
            T1(inflate);
            dn1 m = m();
            this.F0 = m;
            m.c0(Y2());
            this.G0 = this.F0.u();
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.F0.l(frameLayout, this.G0.covertToView());
            V2(frameLayout);
            return S1() ? V1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.repackage.i02, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f3();
            super.z0();
        }
    }
}
