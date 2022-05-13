package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        u03 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str) || (L = u03.L()) == null) {
            return;
        }
        if (g24.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = g24.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            c84.h(new xb4(L.b, L.j0(), a2, 1), new k24(L.b, L.j0(), g24.b().c(str, 2), aVar));
        }
    }
}
