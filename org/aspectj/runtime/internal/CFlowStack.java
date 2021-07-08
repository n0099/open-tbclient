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
import java.util.Stack;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.runtime.CFlow;
import org.aspectj.runtime.internal.cflowstack.ThreadStack;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
/* loaded from: classes9.dex */
public class CFlowStack {
    public static /* synthetic */ Interceptable $ic;
    public static ThreadStackFactory tsFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadStack stackProxy;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1630479901, "Lorg/aspectj/runtime/internal/CFlowStack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1630479901, "Lorg/aspectj/runtime/internal/CFlowStack;");
                return;
            }
        }
        selectFactoryForVMVersion();
    }

    public CFlowStack() {
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
        this.stackProxy = tsFactory.getNewThreadStack();
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

    private Stack getThreadStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.stackProxy.getThreadStack() : (Stack) invokeV.objValue;
    }

    public static String getThreadStackFactoryClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? tsFactory.getClass().getName() : (String) invokeV.objValue;
    }

    public static void selectFactoryForVMVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
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

    public Object get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            CFlow peekCFlow = peekCFlow();
            if (peekCFlow == null) {
                return null;
            }
            return peekCFlow.get(i2);
        }
        return invokeI.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !getThreadStack().isEmpty() : invokeV.booleanValue;
    }

    public Object peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Stack threadStack = getThreadStack();
            if (!threadStack.isEmpty()) {
                return threadStack.peek();
            }
            throw new NoAspectBoundException();
        }
        return invokeV.objValue;
    }

    public CFlow peekCFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Stack threadStack = getThreadStack();
            if (threadStack.isEmpty()) {
                return null;
            }
            return (CFlow) threadStack.peek();
        }
        return (CFlow) invokeV.objValue;
    }

    public Object peekInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CFlow peekCFlow = peekCFlow();
            if (peekCFlow != null) {
                return peekCFlow.getAspect();
            }
            throw new NoAspectBoundException();
        }
        return invokeV.objValue;
    }

    public CFlow peekTopCFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Stack threadStack = getThreadStack();
            if (threadStack.isEmpty()) {
                return null;
            }
            return (CFlow) threadStack.elementAt(0);
        }
        return (CFlow) invokeV.objValue;
    }

    public void pop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Stack threadStack = getThreadStack();
            threadStack.pop();
            if (threadStack.isEmpty()) {
                this.stackProxy.removeThreadStack();
            }
        }
    }

    public void push(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            getThreadStack().push(obj);
        }
    }

    public void pushInstance(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            getThreadStack().push(new CFlow(obj));
        }
    }

    public void push(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr) == null) {
            getThreadStack().push(new CFlowPlusState(objArr));
        }
    }
}
