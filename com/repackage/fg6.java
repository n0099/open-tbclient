package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fg6 implements nh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nq6 a;

    public fg6() {
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

    @Override // com.repackage.nh6
    public zp6 a(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsFragment, noPressedRelativeLayout)) == null) {
            if (frsFragment.Y2()) {
                return null;
            }
            return new zp6(frsFragment, noPressedRelativeLayout);
        }
        return (zp6) invokeLL.objValue;
    }

    @Override // com.repackage.nh6
    public mh6 b(FrsFragment frsFragment, xo xoVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsFragment, xoVar, z)) == null) ? new yg6(frsFragment, xoVar, z) : (mh6) invokeLLZ.objValue;
    }

    @Override // com.repackage.nh6
    public oh6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new hg6() : (oh6) invokeV.objValue;
    }

    @Override // com.repackage.nh6
    public ph6 d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, frsFragment, noPressedRelativeLayout)) == null) ? new xp6(frsFragment, noPressedRelativeLayout) : (ph6) invokeLL.objValue;
    }

    @Override // com.repackage.nh6
    public nq6 e(String str, FrsFragment frsFragment, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, frsFragment, i)) == null) {
            if (frsFragment == null) {
                return null;
            }
            gg6 gg6Var = new gg6(frsFragment, null, null, i);
            this.a = gg6Var;
            gg6Var.U(frsFragment.y2());
            return this.a;
        }
        return (nq6) invokeLLI.objValue;
    }

    public gg6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            nq6 nq6Var = this.a;
            if (nq6Var instanceof gg6) {
                return (gg6) nq6Var;
            }
            return null;
        }
        return (gg6) invokeV.objValue;
    }
}
