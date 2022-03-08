package org.chromium.support_lib_boundary.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
@SuppressLint({"BanTargetApiAnnotation"})
/* loaded from: classes9.dex */
public class BoundaryInterfaceReflectionUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @TargetApi(19)
    /* loaded from: classes9.dex */
    public static class InvocationHandlerWithDelegateGetter implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mDelegate;

        public InvocationHandlerWithDelegateGetter(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDelegate = obj;
        }

        public Object getDelegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDelegate : invokeV.objValue;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, method, objArr)) == null) {
                try {
                    return BoundaryInterfaceReflectionUtil.dupeMethod(method, this.mDelegate.getClass().getClassLoader()).invoke(this.mDelegate, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getTargetException();
                } catch (ReflectiveOperationException e3) {
                    throw new RuntimeException("Reflection failed for method " + method, e3);
                }
            }
            return invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1413741229, "Lorg/chromium/support_lib_boundary/util/BoundaryInterfaceReflectionUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1413741229, "Lorg/chromium/support_lib_boundary/util/BoundaryInterfaceReflectionUtil;");
        }
    }

    public BoundaryInterfaceReflectionUtil() {
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

    public static <T> T castToSuppLibClass(Class<T> cls, InvocationHandler invocationHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, invocationHandler)) == null) ? cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler)) : (T) invokeLL.objValue;
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, collection, str)) == null) {
            if (!collection.contains(str)) {
                if (isDebuggable()) {
                    if (collection.contains(str + Features.DEV_SUFFIX)) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @TargetApi(19)
    public static InvocationHandler createInvocationHandlerFor(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? new InvocationHandlerWithDelegateGetter(obj) : (InvocationHandler) invokeL.objValue;
    }

    @TargetApi(19)
    public static InvocationHandler[] createInvocationHandlersForArray(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, objArr)) == null) {
            if (objArr == null) {
                return null;
            }
            int length = objArr.length;
            InvocationHandler[] invocationHandlerArr = new InvocationHandler[length];
            for (int i2 = 0; i2 < length; i2++) {
                invocationHandlerArr[i2] = createInvocationHandlerFor(objArr[i2]);
            }
            return invocationHandlerArr;
        }
        return (InvocationHandler[]) invokeL.objValue;
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, method, classLoader)) == null) ? Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes()) : (Method) invokeLL.objValue;
    }

    public static Object getDelegateFromInvocationHandler(InvocationHandler invocationHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, invocationHandler)) == null) ? ((InvocationHandlerWithDelegateGetter) invocationHandler).getDelegate() : invokeL.objValue;
    }

    public static boolean instanceOfInOwnClassLoader(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, obj, str)) == null) {
            try {
                return Class.forName(str, false, obj.getClass().getClassLoader()).isInstance(obj);
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isDebuggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE) : invokeV.booleanValue;
    }

    public static boolean containsFeature(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, str)) == null) ? containsFeature(Arrays.asList(strArr), str) : invokeLL.booleanValue;
    }
}
