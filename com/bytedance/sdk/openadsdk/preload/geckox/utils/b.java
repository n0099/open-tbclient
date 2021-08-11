package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.database.Cursor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Closeable closeable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, closeable)) == null) {
            if (closeable == null) {
                return true;
            }
            try {
                closeable.close();
                return true;
            } catch (IOException e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "close:", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cursor)) == null) {
            if (cursor == null) {
                return true;
            }
            try {
                cursor.close();
                return true;
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "close:", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
