package org.apache.commons.logging;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.util.Hashtable;
@Deprecated
/* loaded from: classes5.dex */
public class LogSource {
    public static /* synthetic */ Interceptable $ic;
    public static boolean jdk14IsAvailable;
    public static boolean log4jIsAvailable;
    public static Constructor logImplctor;
    public static Hashtable logs;
    public transient /* synthetic */ FieldHolder $fh;

    public LogSource() {
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
        throw new RuntimeException("Stub!");
    }

    public static Log getInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    public static String[] getLogNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String[]) invokeV.objValue;
    }

    public static Log makeNewLogInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    public static void setLogImplementation(String str) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static Log getInstance(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Log) invokeL.objValue;
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cls) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
