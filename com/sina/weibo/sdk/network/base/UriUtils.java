package com.sina.weibo.sdk.network.base;

import android.net.Uri;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class UriUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UriUtils() {
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

    public static Uri buildCompleteUri(Uri uri, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uri, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                Uri.Builder buildUpon = uri.buildUpon();
                for (String str : bundle.keySet()) {
                    buildUpon.appendQueryParameter(str, String.valueOf(bundle.get(str)));
                }
                return buildUpon.build();
            }
            return uri;
        }
        return (Uri) invokeLL.objValue;
    }

    public static String buildCompleteUri(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bundle)) == null) {
            Uri buildCompleteUri = buildCompleteUri(Uri.parse(str), bundle);
            if (buildCompleteUri != null) {
                return buildCompleteUri.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
