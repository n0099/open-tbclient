package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class f8 {
    public static /* synthetic */ Interceptable $ic;
    public static f8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public j8 a;
    public e7 b;

    public f8() {
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

    public static f8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                c = new f8();
            }
            return c;
        }
        return (f8) invokeV.objValue;
    }

    public void b(Object[] objArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, objArr, i, i2) == null) {
            if (this.b == null) {
                this.b = new e7();
            }
            this.b.c(objArr, i, i2);
        }
    }

    public <T> void c(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tArr, comparator, i, i2) == null) {
            if (this.a == null) {
                this.a = new j8();
            }
            this.a.c(tArr, comparator, i, i2);
        }
    }
}
