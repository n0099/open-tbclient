package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class cc1<T> implements ec1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public ac1<List<T>> b;
    public ac1<List<T>> c;

    public cc1() {
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

    public static cc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new cc1() : (cc1) invokeV.objValue;
    }

    @Override // com.repackage.ec1
    public void a(ac1<List<T>> ac1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ac1Var) == null) {
            this.b = ac1Var;
            this.a = null;
        }
    }

    @Override // com.repackage.ec1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            ac1<List<T>> ac1Var = this.b;
            if (ac1Var != null) {
                List<T> list2 = ac1Var.get();
                this.a = list2;
                return list2;
            }
            ac1<List<T>> ac1Var2 = this.c;
            if (ac1Var2 != null) {
                return ac1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
