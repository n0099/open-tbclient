package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        h03 M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str) || (M = h03.M()) == null) {
            return;
        }
        if (t14.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = t14.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            p74.h(new kb4(M.b, M.k0(), a2, 1), new x14(M.b, M.k0(), t14.b().c(str, 2), aVar));
        }
    }
}
