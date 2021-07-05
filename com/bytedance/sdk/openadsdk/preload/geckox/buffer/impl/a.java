package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a(Context context, File file, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, file, Long.valueOf(j)})) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b2 = b(context, file, j);
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "buffer type:" + b2.getClass());
            return b2;
        }
        return (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) invokeCommon.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b(Context context, File file, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, file, Long.valueOf(j)})) == null) {
            if (j <= 0) {
                try {
                    return new b(file);
                } catch (Exception e2) {
                    throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e2.getMessage(), e2);
                }
            }
            try {
                return new MMapBuffer(j, file);
            } catch (Exception e3) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "mmap failed:", e3);
                try {
                    return new c(j, file);
                } catch (Exception e4) {
                    throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e4.getMessage(), e4);
                }
            }
        }
        return (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) invokeCommon.objValue;
    }
}
