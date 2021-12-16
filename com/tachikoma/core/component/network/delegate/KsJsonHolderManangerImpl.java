package com.tachikoma.core.component.network.delegate;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.e.a;
import com.kwad.sdk.e.b;
import com.kwad.sdk.e.e;
import com.kwad.sdk.e.kwai.d;
import com.kwad.sdk.e.kwai.f;
import com.tachikoma.core.component.imageview.TKCDNUrlInner;
import com.tachikoma.core.component.network.TKErrorInner;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class KsJsonHolderManangerImpl implements b {
    public static /* synthetic */ Interceptable $ic;
    public static KsJsonHolderManangerImpl mInstance;
    public static Map<Class<? extends a>, e> sMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-287780719, "Lcom/tachikoma/core/component/network/delegate/KsJsonHolderManangerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-287780719, "Lcom/tachikoma/core/component/network/delegate/KsJsonHolderManangerImpl;");
                return;
            }
        }
        HashMap hashMap = new HashMap(3);
        sMap = hashMap;
        hashMap.put(TKCDNUrlInner.class, new d());
        sMap.put(TKErrorInner.class, new f());
        sMap.put(TKBaseResponseInner.class, new com.kwad.sdk.e.kwai.b());
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
