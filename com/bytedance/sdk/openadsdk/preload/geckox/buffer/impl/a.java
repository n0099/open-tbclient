package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class a {
    public static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a(Context context, File file, long j) throws IOException {
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b2 = b(context, file, j);
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "buffer type:" + b2.getClass());
        return b2;
    }

    public static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b(Context context, File file, long j) throws IOException {
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
}
