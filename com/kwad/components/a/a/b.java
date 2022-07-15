package com.kwad.components.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.o;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized boolean a(Context context, com.kwad.sdk.e.kwai.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, bVar)) == null) {
            synchronized (b.class) {
                String str = bVar.c;
                File file = new File(str);
                if (o.a(file)) {
                    if (!TextUtils.isEmpty(bVar.g)) {
                        String b = com.kwad.sdk.utils.a.b(file);
                        if (b != null && b.length() > 10) {
                            b = b.substring(0, 10);
                        }
                        if (!at.a(b, bVar.g)) {
                            o.l(file);
                            return false;
                        }
                    }
                    com.kwad.components.a.b.b.a(bVar, 2);
                    try {
                        com.kwad.components.a.b.a.a(str, com.kwad.components.a.b.a.a(context, bVar.b));
                        o.l(file);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.kwad.components.a.b.b.a(bVar, 0, 2, e.getMessage());
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
