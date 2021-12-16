package com.kwad.sdk.design.provider;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ServiceProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ServiceProviderDelegate {
        public static final /* synthetic */ ServiceProviderDelegate[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceProviderDelegate INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Class<?>, Object> mProviders;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1295036342, "Lcom/kwad/sdk/design/provider/ServiceProvider$ServiceProviderDelegate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1295036342, "Lcom/kwad/sdk/design/provider/ServiceProvider$ServiceProviderDelegate;");
                    return;
                }
            }
            ServiceProviderDelegate serviceProviderDelegate = new ServiceProviderDelegate("INSTANCE", 0);
            INSTANCE = serviceProviderDelegate;
            $VALUES = new ServiceProviderDelegate[]{serviceProviderDelegate};
        }

        public ServiceProviderDelegate(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mProviders = new HashMap();
        }

        public static ServiceProviderDelegate valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ServiceProviderDelegate) Enum.valueOf(ServiceProviderDelegate.class, str) : (ServiceProviderDelegate) invokeL.objValue;
        }

        public static ServiceProviderDelegate[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ServiceProviderDelegate[]) $VALUES.clone() : (ServiceProviderDelegate[]) invokeV.objValue;
        }

        public <T> T get(Class<T> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? (T) this.mProviders.get(cls) : (T) invokeL.objValue;
        }

        public void put(Class<?> cls, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, obj) == null) {
                this.mProviders.put(cls, obj);
            }
        }
    }

    public static <T> T a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cls)) == null) ? (T) ServiceProviderDelegate.INSTANCE.get(cls) : (T) invokeL.objValue;
    }

    public static void a(Class<?> cls, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cls, obj) == null) {
            ServiceProviderDelegate.INSTANCE.put(cls, obj);
        }
    }
}
