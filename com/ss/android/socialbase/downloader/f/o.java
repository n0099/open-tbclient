package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(@NonNull List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            int size = list.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = list.get(i2);
                if (iVar.c() > j) {
                    break;
                }
                if (iVar.e() > j) {
                    j = iVar.e();
                }
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static long b(@NonNull List<i> list) {
        InterceptResult invokeL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            long j3 = 0;
            loop0: while (true) {
                j = -1;
                j2 = -1;
                for (i iVar : list) {
                    if (j == -1) {
                        if (iVar.a() > 0) {
                            j = iVar.c();
                            j2 = iVar.d();
                        }
                    } else if (iVar.c() <= j2) {
                        if (iVar.d() > j2) {
                            j2 = iVar.d();
                        }
                    } else {
                        j3 += j2 - j;
                        if (iVar.a() > 0) {
                            j = iVar.c();
                            j2 = iVar.d();
                        }
                    }
                }
            }
            return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
        }
        return invokeL.longValue;
    }
}
