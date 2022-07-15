package com.repackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bo1 extends vz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends s12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bo1 c;

        public a(bo1 bo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bo1Var;
        }

        @Override // com.repackage.s12, com.repackage.v12
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.b(str) : invokeL.booleanValue;
        }
    }

    public bo1() {
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

    @Override // com.repackage.vz1, com.repackage.nz1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            om1 om1Var = this.G0;
            if (om1Var != null && om1Var.canGoBack()) {
                this.G0.goBack();
                return true;
            }
            co1.a().b(1);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.vz1, com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.U1(view2);
            this.l0.setRightZoneVisibility(true);
        }
    }

    @Override // com.repackage.vz1
    public v12 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (v12) invokeV.objValue;
    }

    @Override // com.repackage.vz1
    public void a3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (activity = getActivity()) != null && this.m0 == null) {
            this.m0 = new m64(activity, this.l0, g3(), oj2.K(), new qf3());
            new xp2(this.m0, this).z();
        }
    }

    @Override // com.repackage.vz1, com.repackage.nz1
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d2() ? 18 : 12 : invokeV.intValue;
    }

    @Override // com.repackage.vz1
    public qm1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b72.U().f0().g(getContext()) : (qm1) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.repackage.om1] */
    @Override // com.repackage.vz1, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00db, viewGroup, false);
            U1(inflate);
            qm1 l = l();
            this.F0 = l;
            l.b0(Z2());
            this.G0 = this.F0.t();
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901a6);
            this.F0.k(frameLayout, this.G0.covertToView());
            W2(frameLayout);
            return T1() ? W1(inflate) : inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
