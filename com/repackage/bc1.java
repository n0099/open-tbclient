package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bc1<T> implements dc1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public ac1<T> b;
    public ac1<T> c;

    public bc1() {
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

    public static bc1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new bc1() : (bc1) invokeV.objValue;
    }

    @Override // com.repackage.dc1
    public void a(ac1<T> ac1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ac1Var) == null) {
            this.b = ac1Var;
            this.a = null;
        }
    }

    @Override // com.repackage.dc1
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t != null) {
                return t;
            }
            ac1<T> ac1Var = this.b;
            if (ac1Var != null) {
                T t2 = ac1Var.get();
                this.a = t2;
                return t2;
            }
            ac1<T> ac1Var2 = this.c;
            if (ac1Var2 != null) {
                return ac1Var2.get();
            }
            return null;
        }
        return (T) invokeV.objValue;
    }
}
