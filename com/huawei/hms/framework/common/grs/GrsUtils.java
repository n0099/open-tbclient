package com.huawei.hms.framework.common.grs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.StringUtils;
import java.util.Locale;
/* loaded from: classes8.dex */
public class GrsUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GRS_KEY_INDEX = 1;
    public static final int GRS_PATH_INDEX = 2;
    public static final String GRS_SCHEMA = "grs://";
    public static final int GRS_SERVICE_INDEX = 0;
    public static final int MAX_GRS_SPLIT = 3;
    public static final String SEPARATOR = "/";
    public transient /* synthetic */ FieldHolder $fh;

    public GrsUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String fixResult(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, strArr, str)) == null) {
            if (strArr.length > 2) {
                if (str.endsWith("/")) {
                    return str + strArr[2];
                }
                return str + "/" + strArr[2];
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isGRSSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && str.startsWith(GRS_SCHEMA)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String[] parseParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.endsWith("/")) {
                str = StringUtils.substring(str, str.indexOf(GRS_SCHEMA), str.length() - 1);
            }
            return parseGRSSchema(str);
        }
        return (String[]) invokeL.objValue;
    }

    public static String[] parseGRSSchema(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split("/", 3);
            return split.length == 1 ? new String[]{split[0], "ROOT"} : split;
        }
        return (String[]) invokeL.objValue;
    }
}
