package org.apache.commons.logging;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
@Deprecated
/* loaded from: classes8.dex */
public abstract class LogFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
    public static final String PRIORITY_KEY = "priority";
    public static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    public static final String TCCL_KEY = "use_tccl";
    public static Hashtable factories;
    public static LogFactory nullClassLoaderFactory;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class cls) throws LogConfigurationException;

    public abstract Log getInstance(String str) throws LogConfigurationException;

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    public LogFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader directGetContextClassLoader() throws LogConfigurationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ClassLoader) invokeV.objValue;
    }

    public static ClassLoader getContextClassLoader() throws LogConfigurationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ClassLoader) invokeV.objValue;
    }

    public static LogFactory getFactory() throws LogConfigurationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (LogFactory) invokeV.objValue;
    }

    public static boolean isDiagnosticsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public static void releaseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static Object createFactory(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, classLoader)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.objValue;
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, classLoader)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (LogFactory) invokeLL.objValue;
    }

    public static ClassLoader getClassLoader(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ClassLoader) invokeL.objValue;
    }

    public static Log getLog(Class cls) throws LogConfigurationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    public static final void logRawDiagnostic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static String objectId(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeL.objValue;
    }

    public static void release(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, classLoader) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static Log getLog(String str) throws LogConfigurationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader, ClassLoader classLoader2) throws LogConfigurationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, classLoader, classLoader2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (LogFactory) invokeLLL.objValue;
    }
}
