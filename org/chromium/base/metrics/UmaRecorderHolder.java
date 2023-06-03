package org.chromium.base.metrics;

import androidx.annotation.VisibleForTesting;
/* loaded from: classes2.dex */
public class UmaRecorderHolder {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static CachingUmaRecorder sRecorder = new CachingUmaRecorder();
    public static boolean sAllowNativeUmaRecorder = true;

    @VisibleForTesting
    @Deprecated
    public static void setDisabledForTests(boolean z) {
    }

    public static UmaRecorder get() {
        return sRecorder;
    }

    public static void onLibraryLoaded() {
        sRecorder.setDelegate(new NativeUmaRecorder());
    }

    public static void setAllowNativeUmaRecorder(boolean z) {
        sAllowNativeUmaRecorder = z;
    }

    public static void setNonNativeDelegate(UmaRecorder umaRecorder) {
        sRecorder.setDelegate(umaRecorder);
    }
}
