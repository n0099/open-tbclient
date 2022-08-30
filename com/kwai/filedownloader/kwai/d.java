package com.kwai.filedownloader.kwai;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.kwai.filedownloader.e.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, map, bVar, list)) == null) {
            int responseCode = bVar.getResponseCode();
            String p = bVar.p(Headers.LOCATION);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (cb(responseCode)) {
                if (p == null) {
                    throw new IllegalAccessException(f.h("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.V()));
                }
                if (com.kwai.filedownloader.e.d.awL) {
                    com.kwai.filedownloader.e.d.e(d.class, "redirect to %s with %d, %s", p, Integer.valueOf(responseCode), arrayList);
                }
                bVar.W();
                bVar = b(map, p);
                arrayList.add(p);
                bVar.execute();
                responseCode = bVar.getResponseCode();
                p = bVar.p(Headers.LOCATION);
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException(f.h("redirect too many times! %s", arrayList));
                }
            }
            if (list != null) {
                list.addAll(arrayList);
            }
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static b b(Map<String, List<String>> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, str)) == null) {
            b et = com.kwai.filedownloader.download.b.Dp().et(str);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    for (String str2 : value) {
                        et.addHeader(key, str2);
                    }
                }
            }
            return et;
        }
        return (b) invokeLL.objValue;
    }

    public static boolean cb(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308 : invokeI.booleanValue;
    }
}
