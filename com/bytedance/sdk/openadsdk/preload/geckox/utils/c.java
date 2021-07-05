package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, th) == null) {
            if (!e.a()) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "throwIfDebug:", th);
            } else {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "throwIfDebug:", th);
                throw new RuntimeException(th);
            }
        }
    }
}
