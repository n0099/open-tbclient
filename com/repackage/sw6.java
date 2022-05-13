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
public class sw6 implements fw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gw6 a;
    public ew6 b;

    public sw6(gw6 gw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gw6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gw6Var;
        this.b = new rw6(this);
    }

    @Override // com.repackage.fw6
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            ew6 ew6Var = this.b;
            if (ew6Var != null) {
                return ew6Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.fw6
    public boolean b(int i, qw6 qw6Var) {
        InterceptResult invokeIL;
        gw6 gw6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qw6Var)) == null) {
            if (qw6Var == null || (gw6Var = this.a) == null) {
                return false;
            }
            gw6Var.setData(qw6Var.getDataList());
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.fw6
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            gw6 gw6Var = this.a;
            if (gw6Var != null) {
                gw6Var.b(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.repackage.fw6
    public void setData(List<ro> list) {
        gw6 gw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (gw6Var = this.a) == null) {
            return;
        }
        gw6Var.setData(list);
    }
}
