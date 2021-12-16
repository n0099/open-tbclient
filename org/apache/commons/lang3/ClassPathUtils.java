package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ClassPathUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ClassPathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String toFullyQualifiedName(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, str)) == null) {
            Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
            Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
            return toFullyQualifiedName(cls.getPackage(), str);
        }
        return (String) invokeLL.objValue;
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, str)) == null) {
            Validate.notNull(cls, "Parameter '%s' must not be null!", "context");
            Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
            return toFullyQualifiedPath(cls.getPackage(), str);
        }
        return (String) invokeLL.objValue;
    }

    public static String toFullyQualifiedName(Package r4, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, r4, str)) == null) {
            Validate.notNull(r4, "Parameter '%s' must not be null!", "context");
            Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
            return r4.getName() + "." + str;
        }
        return (String) invokeLL.objValue;
    }

    public static String toFullyQualifiedPath(Package r4, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, r4, str)) == null) {
            Validate.notNull(r4, "Parameter '%s' must not be null!", "context");
            Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
            return r4.getName().replace('.', '/') + "/" + str;
        }
        return (String) invokeLL.objValue;
    }
}
