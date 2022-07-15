package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class pb1<T> implements rb1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public nb1<List<T>> b;
    public nb1<List<T>> c;

    public pb1() {
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

    public static pb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new pb1() : (pb1) invokeV.objValue;
    }

    @Override // com.repackage.rb1
    public void a(nb1<List<T>> nb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nb1Var) == null) {
            this.b = nb1Var;
            this.a = null;
        }
    }

    @Override // com.repackage.rb1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            nb1<List<T>> nb1Var = this.b;
            if (nb1Var != null) {
                List<T> list2 = nb1Var.get();
                this.a = list2;
                return list2;
            }
            nb1<List<T>> nb1Var2 = this.c;
            if (nb1Var2 != null) {
                return nb1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
