package com.kwai.filedownloader.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, map, bVar, list)) == null) {
            int e2 = bVar.e();
            String a2 = bVar.a("Location");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (a(e2)) {
                if (a2 == null) {
                    throw new IllegalAccessException(f.a("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(e2), bVar.c()));
                }
                if (com.kwai.filedownloader.f.d.f74563a) {
                    com.kwai.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", a2, Integer.valueOf(e2), arrayList);
                }
                bVar.f();
                bVar = a(map, a2);
                arrayList.add(a2);
                bVar.d();
                e2 = bVar.e();
                a2 = bVar.a("Location");
                i2++;
                if (i2 >= 10) {
                    throw new IllegalAccessException(f.a("redirect too many times! %s", arrayList));
                }
            }
            if (list != null) {
                list.addAll(arrayList);
            }
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static b a(Map<String, List<String>> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, str)) == null) {
            b a2 = com.kwai.filedownloader.download.b.a().a(str);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    for (String str2 : value) {
                        a2.a(key, str2);
                    }
                }
            }
            return a2;
        }
        return (b) invokeLL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308 : invokeI.booleanValue;
    }
}
