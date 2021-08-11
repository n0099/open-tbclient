package com.yy.hiidostatis.provider;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class MessageConfigFactory {
    public static /* synthetic */ Interceptable $ic;
    public static ConcurrentHashMap<String, MessageConfig> caches;
    public static MessageConfig mainConfig;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-853878033, "Lcom/yy/hiidostatis/provider/MessageConfigFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-853878033, "Lcom/yy/hiidostatis/provider/MessageConfigFactory;");
                return;
            }
        }
        caches = new ConcurrentHashMap<>();
        mainConfig = null;
    }

    public MessageConfigFactory() {
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

    public static MessageConfig generate(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            MessageConfig messageConfig = caches.get(str);
            if (messageConfig != null) {
                return messageConfig;
            }
            synchronized (MessageConfigFactory.class) {
                MessageConfig messageConfig2 = caches.get(str);
                if (messageConfig2 != null) {
                    return messageConfig2;
                }
                MessageConfig messageConfig3 = new MessageConfig(context, str, false);
                caches.put(str, messageConfig3);
                return messageConfig3;
            }
        }
        return (MessageConfig) invokeLL.objValue;
    }

    public static MessageConfig generateMainConfig(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            MessageConfig messageConfig = mainConfig;
            if (messageConfig != null) {
                return messageConfig;
            }
            synchronized (MessageConfigFactory.class) {
                if (mainConfig != null) {
                    return mainConfig;
                }
                MessageConfig messageConfig2 = new MessageConfig(context, str, true);
                mainConfig = messageConfig2;
                caches.put(str, messageConfig2);
                return mainConfig;
            }
        }
        return (MessageConfig) invokeLL.objValue;
    }

    public static MessageConfig getMainConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? mainConfig : (MessageConfig) invokeV.objValue;
    }
}
