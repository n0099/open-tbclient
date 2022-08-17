package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ny6 implements ay6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public by6 a;
    public zx6 b;

    public ny6(by6 by6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {by6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = by6Var;
        this.b = new my6(this);
    }

    @Override // com.repackage.ay6
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            zx6 zx6Var = this.b;
            if (zx6Var != null) {
                return zx6Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.ay6
    public boolean b(int i, ly6 ly6Var) {
        InterceptResult invokeIL;
        by6 by6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ly6Var)) == null) {
            if (ly6Var == null || (by6Var = this.a) == null) {
                return false;
            }
            by6Var.setData(ly6Var.getDataList());
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.ay6
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            by6 by6Var = this.a;
            if (by6Var != null) {
                by6Var.b(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.ay6
    public void setData(List<on> list) {
        by6 by6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (by6Var = this.a) == null) {
            return;
        }
        by6Var.setData(list);
    }
}
