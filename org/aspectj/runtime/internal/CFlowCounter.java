package org.aspectj.runtime.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.runtime.internal.cflowstack.ThreadCounter;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
/* loaded from: classes9.dex */
public class CFlowCounter {
    public static /* synthetic */ Interceptable $ic;
    public static ThreadStackFactory tsFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadCounter flowHeightHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1848430249, "Lorg/aspectj/runtime/internal/CFlowCounter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1848430249, "Lorg/aspectj/runtime/internal/CFlowCounter;");
                return;
            }
        }
        selectFactoryForVMVersion();
    }

    public CFlowCounter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.flowHeightHandler = tsFactory.getNewThreadCounter();
    }

    public static String getSystemPropertyWithoutSecurityException(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                return System.getProperty(str, str2);
            } catch (SecurityException unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static ThreadStackFactory getThreadLocalStackFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new ThreadStackFactoryImpl() : (ThreadStackFactory) invokeV.objValue;
    }

    public static ThreadStackFactory getThreadLocalStackFactoryFor11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new ThreadStackFactoryImpl11() : (ThreadStackFactory) invokeV.objValue;
    }

    public static String getThreadStackFactoryClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? tsFactory.getClass().getName() : (String) invokeV.objValue;
    }

    public static void selectFactoryForVMVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            String systemPropertyWithoutSecurityException = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
            boolean z = false;
            if (!systemPropertyWithoutSecurityException.equals("unspecified") ? systemPropertyWithoutSecurityException.equals("yes") || systemPropertyWithoutSecurityException.equals("true") : System.getProperty("java.class.version", XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT).compareTo("46.0") >= 0) {
                z = true;
            }
            if (z) {
                tsFactory = getThreadLocalStackFactory();
            } else {
                tsFactory = getThreadLocalStackFactoryFor11();
            }
        }
    }

    public void dec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.flowHeightHandler.dec();
            if (this.flowHeightHandler.isNotZero()) {
                return;
            }
            this.flowHeightHandler.removeThreadCounter();
        }
    }

    public void inc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.flowHeightHandler.inc();
        }
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flowHeightHandler.isNotZero() : invokeV.booleanValue;
    }
}
