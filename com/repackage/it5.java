package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.gamebar.AlaGameFrsLiveTabFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class it5 extends p55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaGameFrsLiveTabFragment c;

    public it5() {
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
        this.c = new AlaGameFrsLiveTabFragment();
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

    public void g(be6 be6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, be6Var) == null) && be6Var != null && be6Var.h(2)) {
            be6Var.a(this);
        }
    }

    public void h(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (alaGameFrsLiveTabFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.D1(str);
    }

    public void i(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (alaGameFrsLiveTabFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.E1(str);
    }

    public void j(String str) {
        AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (alaGameFrsLiveTabFragment = this.c) == null) {
            return;
        }
        alaGameFrsLiveTabFragment.F1(str);
    }
}
