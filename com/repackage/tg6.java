package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tg6 implements bi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iq6 a;

    public tg6() {
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

    @Override // com.repackage.bi6
    public wp6 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.R3()) {
                return null;
            }
            return new wp6(frsFragment, noPressedRelativeLayout);
        }
        return (wp6) invokeLL.objValue;
    }

    @Override // com.repackage.bi6
    public ai6 b(FrsFragment frsFragment, tn tnVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, tnVar, z)) == null) ? new mh6(frsFragment, tnVar, z) : (ai6) invokeLLZ.objValue;
    }

    @Override // com.repackage.bi6
    public ci6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new vg6() : (ci6) invokeV.objValue;
    }

    @Override // com.repackage.bi6
    public di6 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new up6(frsFragment, noPressedRelativeLayout) : (di6) invokeLL.objValue;
    }

    @Override // com.repackage.bi6
    public iq6 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            ug6 ug6Var = new ug6(frsFragment, null, null, i);
            this.a = ug6Var;
            ug6Var.R(frsFragment.q3());
            return this.a;
        }
        return (iq6) invokeLLI.objValue;
    }
}
