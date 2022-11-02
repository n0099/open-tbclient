package org.apache.http.client.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
@Deprecated
/* loaded from: classes9.dex */
public class URLEncodedUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public transient /* synthetic */ FieldHolder $fh;

    public URLEncodedUtils() {
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

    public static String format(List<? extends NameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    public static List<NameValuePair> parse(URI uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (List) invokeLL.objValue;
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpEntity)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    public static List<NameValuePair> parse(HttpEntity httpEntity) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpEntity)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (List) invokeL.objValue;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, list, scanner, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
