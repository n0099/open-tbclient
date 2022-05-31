package com.tachikoma.core.utility;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UriUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ASSET_PREFIX = "asset://";
    public static final String BUNDLE_PREFIX = "bundle://";
    public static final String FILE_PREFIX = "file://";
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public transient /* synthetic */ FieldHolder $fh;

    public UriUtil() {
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

    public static String getMappedPath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (str == null || str.length() <= 0 || !str.startsWith(str2)) {
                return str;
            }
            return str.substring(str2 != null ? str2.length() : 0);
        }
        return (String) invokeLL.objValue;
    }

    public static String getResName(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String mappedPath = getMappedPath(str, "asset://");
            return (mappedPath == null || mappedPath.length() <= 0 || -1 == (lastIndexOf = mappedPath.lastIndexOf("."))) ? mappedPath : mappedPath.substring(0, lastIndexOf);
        }
        return (String) invokeL.objValue;
    }
}
