package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b {
    public static boolean a(Closeable closeable) {
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

    public static boolean a(Cursor cursor) {
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
}
