package org.chromium.base.metrics;

import android.os.SystemClock;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class RecordUserAction {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static long sNativeActionCallback;

    /* loaded from: classes2.dex */
    public interface Natives {
        long addActionCallbackForTesting(UserActionCallback userActionCallback);

        void removeActionCallbackForTesting(long j);
    }

    /* loaded from: classes2.dex */
    public interface UserActionCallback {
        @CalledByNative("UserActionCallback")
        void onActionRecorded(String str);
    }

    public static void removeActionCallbackForTesting() {
        RecordUserActionJni.get().removeActionCallbackForTesting(sNativeActionCallback);
        sNativeActionCallback = 0L;
    }

    public static void record(String str) {
        UmaRecorderHolder.get().recordUserAction(str, SystemClock.elapsedRealtime());
    }

    public static void setActionCallbackForTesting(UserActionCallback userActionCallback) {
        sNativeActionCallback = RecordUserActionJni.get().addActionCallbackForTesting(userActionCallback);
    }
}
