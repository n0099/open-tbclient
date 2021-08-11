package com.yy.hiidostatis.provider;

import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class GlobalProvider {
    public static final /* synthetic */ GlobalProvider[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final GlobalProvider instance;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentMap<Class, Provider> classProvider;
    public ConcurrentMap<String, Provider> nameProvider;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110442748, "Lcom/yy/hiidostatis/provider/GlobalProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(110442748, "Lcom/yy/hiidostatis/provider/GlobalProvider;");
                return;
            }
        }
        GlobalProvider globalProvider = new GlobalProvider(Transition.MATCH_INSTANCE_STR, 0);
        instance = globalProvider;
        $VALUES = new GlobalProvider[]{globalProvider};
    }

    public GlobalProvider(String str, int i2) {
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
        this.classProvider = new ConcurrentHashMap();
        this.nameProvider = new ConcurrentHashMap();
    }

    public static GlobalProvider valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GlobalProvider) Enum.valueOf(GlobalProvider.class, str) : (GlobalProvider) invokeL.objValue;
    }

    public static GlobalProvider[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GlobalProvider[]) $VALUES.clone() : (GlobalProvider[]) invokeV.objValue;
    }

    public <T> T get(Class cls, MessageConfig messageConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, messageConfig)) == null) {
            Provider provider = this.classProvider.get(cls);
            if (provider != null) {
                return (T) provider.generate(messageConfig);
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public void registerProvider(Class cls, Provider provider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, provider) == null) {
            this.classProvider.put(cls, provider);
        }
    }

    public void registerProvider(String str, Provider provider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, provider) == null) {
            this.nameProvider.put(str, provider);
        }
    }

    public <T> T get(String str, MessageConfig messageConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, messageConfig)) == null) {
            Provider provider = this.nameProvider.get(str);
            if (provider != null) {
                return (T) provider.generate(messageConfig);
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }
}
