package org.apache.commons.logging.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
@Deprecated
/* loaded from: classes5.dex */
public class LogFactoryImpl extends LogFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    public static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    public transient /* synthetic */ FieldHolder $fh;
    public Hashtable attributes;
    public Hashtable instances;
    public Constructor logConstructor;
    public Class[] logConstructorSignature;
    public Method logMethod;
    public Class[] logMethodSignature;

    public LogFactoryImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.logConstructorSignature = null;
        this.logMethodSignature = null;
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader getClassLoader(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ClassLoader) invokeL.objValue;
    }

    public static ClassLoader getContextClassLoader() throws LogConfigurationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (ClassLoader) invokeV.objValue;
    }

    public static boolean isDiagnosticsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.objValue;
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String[]) invokeV.objValue;
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class cls) throws LogConfigurationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    @Deprecated
    public String getLogClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public Constructor getLogConstructor() throws LogConfigurationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Constructor) invokeV.objValue;
    }

    @Deprecated
    public boolean isJdk13LumberjackAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isJdk14Available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isLog4JAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public void logDiagnostic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public Log newInstance(String str) throws LogConfigurationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) throws LogConfigurationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }
}
