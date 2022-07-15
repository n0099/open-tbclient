package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bt5 extends p55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaFrsLiveFragment c;

    public bt5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AlaFrsLiveFragment alaFrsLiveFragment = new AlaFrsLiveFragment();
        this.c = alaFrsLiveFragment;
        alaFrsLiveFragment.H1(z);
        b().a = this.c;
    }

    @Override // com.repackage.p55
    public q55 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q55 q55Var = new q55();
            q55Var.e = 2;
            q55Var.b = R.string.obfuscated_res_0x7f0f0221;
            q55Var.i = q55.k;
            return q55Var;
        }
        return (q55) invokeV.objValue;
    }

    @Override // com.repackage.p55
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e6, (ViewGroup) null);
            this.b = fragmentTabIndicator;
            fragmentTabIndicator.setTextSize(2.0f);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.repackage.p55
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (alaFrsLiveFragment = this.c) == null) {
            return;
        }
        alaFrsLiveFragment.D1(str);
    }

    public void h(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaFrsLiveFragment = this.c) == null) {
            return;
        }
        alaFrsLiveFragment.E1(str);
    }

    public void i(String str) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (alaFrsLiveFragment = this.c) == null) {
            return;
        }
        alaFrsLiveFragment.F1(str);
    }

    public void j(int i) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (alaFrsLiveFragment = this.c) == null) {
            return;
        }
        alaFrsLiveFragment.G1(i);
    }

    public void k(boolean z) {
        AlaFrsLiveFragment alaFrsLiveFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (alaFrsLiveFragment = this.c) == null) {
            return;
        }
        alaFrsLiveFragment.I1(z);
    }
}
