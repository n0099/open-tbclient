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
/* loaded from: classes5.dex */
public class am3 implements gk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public am3() {
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

    @Override // com.repackage.gk2
    public void a(f13 f13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f13Var) == null) {
            wl3.b().a(f13Var);
            wl3.a().a(f13Var);
        }
    }

    @Override // com.repackage.gk2
    public Map<String, Object> b(@NonNull jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jo1Var)) == null) {
            Map<String, Object> b = wl3.b().b(jo1Var);
            Map<String, Object> b2 = wl3.a().b(jo1Var);
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

    @Override // com.repackage.gk2
    public Map<String, Object> c(@NonNull jo1 jo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jo1Var)) == null) {
            Map<String, Object> c = wl3.b().c(jo1Var);
            Map<String, Object> c2 = wl3.a().c(jo1Var);
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

    @Override // com.repackage.gk2
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }
}
