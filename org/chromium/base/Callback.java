package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;
@FunctionalInterface
/* loaded from: classes2.dex */
public interface Callback<T> {
    Runnable bind(T t);

    void onResult(T t);

    /* loaded from: classes2.dex */
    public static abstract class Helper {
        @CalledByNative("Helper")
        public static void onBooleanResultFromNative(Callback callback, boolean z) {
            callback.onResult(Boolean.valueOf(z));
        }

        @CalledByNative("Helper")
        public static void onIntResultFromNative(Callback callback, int i) {
            callback.onResult(Integer.valueOf(i));
        }

        @CalledByNative("Helper")
        public static void onObjectResultFromNative(Callback callback, Object obj) {
            callback.onResult(obj);
        }

        @CalledByNative("Helper")
        public static void runRunnable(Runnable runnable) {
            runnable.run();
        }
    }
}
