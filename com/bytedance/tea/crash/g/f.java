package com.bytedance.tea.crash.g;

import java.io.Closeable;
/* loaded from: classes4.dex */
public final class f {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }
}
