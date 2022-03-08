package com.kuaishou.tachikoma.api.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.app.TKBaseResponse;
import com.kuaishou.tachikoma.api.app.TKError;
import com.kwad.sdk.e.a;
import com.kwad.sdk.e.b;
import com.kwad.sdk.e.e;
import com.kwad.sdk.e.kwai.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class KsJsonHolderManangerImpl implements b {
    public static /* synthetic */ Interceptable $ic;
    public static KsJsonHolderManangerImpl mInstance;
    public static Map<Class<? extends a>, e> sMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(894149743, "Lcom/kuaishou/tachikoma/api/model/KsJsonHolderManangerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(894149743, "Lcom/kuaishou/tachikoma/api/model/KsJsonHolderManangerImpl;");
                return;
            }
        }
        HashMap hashMap = new HashMap(3);
        sMap = hashMap;
        hashMap.put(TKBaseResponse.class, new com.kwad.sdk.e.kwai.a());
        sMap.put(TKCDNUrl.class, new c());
        sMap.put(TKError.class, new com.kwad.sdk.e.kwai.e());
    }

    public KsJsonHolderManangerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static KsJsonHolderManangerImpl getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (KsJsonHolderManangerImpl.class) {
                    if (mInstance == null) {
                        mInstance = new KsJsonHolderManangerImpl();
                    }
                }
            }
            return mInstance;
        }
        return (KsJsonHolderManangerImpl) invokeV.objValue;
    }

    @Override // com.kwad.sdk.e.b
    public e getHolder(Class<? extends a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? sMap.get(cls) : (e) invokeL.objValue;
    }
}
