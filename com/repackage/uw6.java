package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class uw6 implements hw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iw6 a;
    public gw6 b;

    public uw6(iw6 iw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iw6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iw6Var;
        this.b = new tw6(this);
    }

    @Override // com.repackage.hw6
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            gw6 gw6Var = this.b;
            if (gw6Var != null) {
                return gw6Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.hw6
    public boolean b(int i, sw6 sw6Var) {
        InterceptResult invokeIL;
        iw6 iw6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sw6Var)) == null) {
            if (sw6Var == null || (iw6Var = this.a) == null) {
                return false;
            }
            iw6Var.setData(sw6Var.getDataList());
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.hw6
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            iw6 iw6Var = this.a;
            if (iw6Var != null) {
                iw6Var.b(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.hw6
    public void setData(List<nn> list) {
        iw6 iw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (iw6Var = this.a) == null) {
            return;
        }
        iw6Var.setData(list);
    }
}
