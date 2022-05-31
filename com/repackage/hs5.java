package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.AlaPersonCenterFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hs5 extends y35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterFragment c;

    public hs5() {
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
        this.c = new AlaPersonCenterFragment();
        b().a = this.c;
    }

    @Override // com.repackage.y35
    public z35 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z35 z35Var = new z35();
            z35Var.e = 5;
            z35Var.b = R.string.obfuscated_res_0x7f0f021f;
            z35Var.i = z35.k;
            return z35Var;
        }
        return (z35) invokeV.objValue;
    }

    @Override // com.repackage.y35
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ea, (ViewGroup) null);
            this.b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.repackage.y35
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(ec6 ec6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ec6Var) == null) && ec6Var != null && ec6Var.h(5)) {
            ec6Var.a(this);
        }
    }

    public void h(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaPersonCenterFragment = this.c) == null) {
            return;
        }
        alaPersonCenterFragment.E0(str);
    }

    public void i(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (alaPersonCenterFragment = this.c) == null) {
            return;
        }
        alaPersonCenterFragment.F0(str);
    }

    public void j(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (alaPersonCenterFragment = this.c) == null) {
            return;
        }
        alaPersonCenterFragment.G0(str);
    }

    public void k(String str) {
        AlaPersonCenterFragment alaPersonCenterFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (alaPersonCenterFragment = this.c) == null) {
            return;
        }
        alaPersonCenterFragment.H0(str);
    }
}
