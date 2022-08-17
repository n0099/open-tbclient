package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class ce {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Type[] a;
    public Type b;
    public Class<?> c;

    public ce(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.a = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType.getRawType();
            this.b = rawType;
            Type[] typeArr = this.a;
            if (typeArr == null || typeArr.length <= 0) {
                return;
            }
            try {
                this.c = (Class) rawType;
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            this.c = (Class) type;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Class<?> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (Class) invokeV.objValue;
    }

    public Type[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (Type[]) invokeV.objValue;
    }
}
