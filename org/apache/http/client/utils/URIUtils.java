package org.apache.http.client.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpHost;
@Deprecated
/* loaded from: classes4.dex */
public class URIUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public URIUtils() {
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

    public static URI createURI(String str, String str2, int i2, String str3, String str4, String str5) throws URISyntaxException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeCommon.objValue;
    }

    public static URI resolve(URI uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uri, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeLL.objValue;
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, uri, httpHost, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeLLZ.objValue;
    }

    public static URI resolve(URI uri, URI uri2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, uri2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeLL.objValue;
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, httpHost)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (URI) invokeLL.objValue;
    }
}
