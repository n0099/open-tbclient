package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable th) {
        Class<?> cls = th.getClass();
        while (!Intrinsics.areEqual(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable th) {
        throw th;
    }
}
