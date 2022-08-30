package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class MimeTypeMapWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, String> sExtensionToMimeTypeMap;
    public static final MimeTypeMap sMimeTypeMap;
    public static final Map<String, String> sMimeTypeToExtensionMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(176508278, "Lcom/facebook/common/media/MimeTypeMapWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(176508278, "Lcom/facebook/common/media/MimeTypeMapWrapper;");
                return;
            }
        }
        sMimeTypeMap = MimeTypeMap.getSingleton();
        sMimeTypeToExtensionMap = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
        sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");
    }

    public MimeTypeMapWrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getExtensionFromMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = sMimeTypeToExtensionMap.get(str);
            return str2 != null ? str2 : sMimeTypeMap.getExtensionFromMimeType(str);
        }
        return (String) invokeL.objValue;
    }

    public static String getMimeTypeFromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String str2 = sExtensionToMimeTypeMap.get(str);
            return str2 != null ? str2 : sMimeTypeMap.getMimeTypeFromExtension(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? sExtensionToMimeTypeMap.containsKey(str) || sMimeTypeMap.hasExtension(str) : invokeL.booleanValue;
    }

    public static boolean hasMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? sMimeTypeToExtensionMap.containsKey(str) || sMimeTypeMap.hasMimeType(str) : invokeL.booleanValue;
    }
}
