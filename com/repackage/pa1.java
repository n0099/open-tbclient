package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class pa1<T> implements ra1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public na1<List<T>> b;
    public na1<List<T>> c;

    public pa1() {
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

    public static pa1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new pa1() : (pa1) invokeV.objValue;
    }

    @Override // com.repackage.ra1
    public void a(na1<List<T>> na1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, na1Var) == null) {
            this.b = na1Var;
            this.a = null;
        }
    }

    @Override // com.repackage.ra1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            na1<List<T>> na1Var = this.b;
            if (na1Var != null) {
                List<T> list2 = na1Var.get();
                this.a = list2;
                return list2;
            }
            na1<List<T>> na1Var2 = this.c;
            if (na1Var2 != null) {
                return na1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
