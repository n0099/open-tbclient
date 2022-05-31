package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class z84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b94 a(String str, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            Response executeSync = j64.g().getRequest().requestFrom(6).requestSubFrom(i).url(str).build().executeSync();
            if (executeSync == null) {
                return null;
            }
            return new x84(executeSync);
        }
        return (b94) invokeLI.objValue;
    }
}
