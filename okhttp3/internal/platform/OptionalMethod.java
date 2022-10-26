package okhttp3.internal.platform;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class OptionalMethod<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String methodName;
    public final Class[] methodParams;
    public final Class<?> returnType;

    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, str, clsArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.returnType = cls;
        this.methodName = str;
        this.methodParams = clsArr;
    }

    private Method getMethod(Class<?> cls) {
        InterceptResult invokeL;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            String str = this.methodName;
            if (str == null) {
                return null;
            }
            Method publicMethod = getPublicMethod(cls, str, this.methodParams);
            if (publicMethod != null && (cls2 = this.returnType) != null && !cls2.isAssignableFrom(publicMethod.getReturnType())) {
                return null;
            }
            return publicMethod;
        }
        return (Method) invokeL.objValue;
    }

    public boolean isSupported(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            if (getMethod(t.getClass()) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                try {
                    if ((method.getModifiers() & 1) == 0) {
                        return null;
                    }
                } catch (NoSuchMethodException unused) {
                }
                return method;
            } catch (NoSuchMethodException unused2) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public Object invoke(T t, Object... objArr) throws InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, objArr)) == null) {
            Method method = getMethod(t.getClass());
            if (method != null) {
                try {
                    return method.invoke(t, objArr);
                } catch (IllegalAccessException e) {
                    AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + method);
                    assertionError.initCause(e);
                    throw assertionError;
                }
            }
            throw new AssertionError("Method " + this.methodName + " not supported for object " + t);
        }
        return invokeLL.objValue;
    }

    public Object invokeOptional(T t, Object... objArr) throws InvocationTargetException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, objArr)) == null) {
            Method method = getMethod(t.getClass());
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(t, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public Object invokeOptionalWithoutCheckedException(T t, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, objArr)) == null) {
            try {
                return invokeOptional(t, objArr);
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                AssertionError assertionError = new AssertionError("Unexpected exception");
                assertionError.initCause(targetException);
                throw assertionError;
            }
        }
        return invokeLL.objValue;
    }

    public Object invokeWithoutCheckedException(T t, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t, objArr)) == null) {
            try {
                return invoke(t, objArr);
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                AssertionError assertionError = new AssertionError("Unexpected exception");
                assertionError.initCause(targetException);
                throw assertionError;
            }
        }
        return invokeLL.objValue;
    }
}
