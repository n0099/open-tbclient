package com.kwad.sdk.c.b;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49279436, "Lcom/kwad/sdk/c/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(49279436, "Lcom/kwad/sdk/c/b/c;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList(2);
        a = arrayList;
        arrayList.add("application/x-javascript");
        a.add("image/jpeg");
        a.add("image/tiff");
        a.add("text/css");
        a.add(SapiWebView.DATA_MIME_TYPE);
        a.add("image/gif");
        a.add("image/png");
        a.add(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? a.contains(str) : invokeL.booleanValue;
    }
}
