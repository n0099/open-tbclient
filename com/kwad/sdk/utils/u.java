package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static <T> List<List<T>> a(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, list, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                return arrayList;
            }
            if (i2 <= 0) {
                i2 = list.size();
            }
            int i3 = 0;
            while (i3 < list.size()) {
                int i4 = i3 + i2;
                arrayList.add(list.subList(i3, i4 > list.size() ? list.size() : i4));
                i3 = i4;
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }
}
