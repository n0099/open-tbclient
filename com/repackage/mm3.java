package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes6.dex */
public class mm3 implements sk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mm3() {
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

    @Override // com.repackage.sk2
    public void a(r13 r13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r13Var) == null) {
            im3.b().a(r13Var);
            im3.a().a(r13Var);
        }
    }

    @Override // com.repackage.sk2
    public Map<String, Object> b(@NonNull vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vo1Var)) == null) {
            Map<String, Object> b = im3.b().b(vo1Var);
            Map<String, Object> b2 = im3.a().b(vo1Var);
            HashMap hashMap = new HashMap();
            if (b != null) {
                hashMap.putAll(b);
            }
            if (b2 != null) {
                hashMap.putAll(b2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public Map<String, Object> c(@NonNull vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vo1Var)) == null) {
            Map<String, Object> c = im3.b().c(vo1Var);
            Map<String, Object> c2 = im3.a().c(vo1Var);
            HashMap hashMap = new HashMap();
            if (c != null) {
                hashMap.putAll(c);
            }
            if (c2 != null) {
                hashMap.putAll(c2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.repackage.sk2
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
