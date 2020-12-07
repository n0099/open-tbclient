package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes17.dex */
public class Anchor {
    private final Session psW = null;
    long psX = 0;

    private native void nativeDetach(long j, long j2);

    private native String nativeGetCloudAnchorId(long j, long j2);

    private native int nativeGetCloudAnchorState(long j, long j2);

    private native h nativeGetPose(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    private static native void nativeReleaseAnchor(long j);

    /* loaded from: classes17.dex */
    public enum CloudAnchorState {
        NONE(0),
        TASK_IN_PROGRESS(1),
        SUCCESS(2),
        ERROR_INTERNAL(-1),
        ERROR_NOT_AUTHORIZED(-2),
        ERROR_SERVICE_UNAVAILABLE(-3),
        ERROR_RESOURCE_EXHAUSTED(-4),
        ERROR_HOSTING_DATASET_PROCESSING_FAILED(-5),
        ERROR_CLOUD_ID_NOT_FOUND(-6),
        ERROR_RESOLVING_LOCALIZATION_NO_MATCH(-7),
        ERROR_RESOLVING_SDK_VERSION_TOO_OLD(-8),
        ERROR_RESOLVING_SDK_VERSION_TOO_NEW(-9);
        
        final int nativeCode;

        CloudAnchorState(int i) {
            this.nativeCode = i;
        }

        public final boolean isError() {
            return this.nativeCode < 0;
        }

        public static CloudAnchorState forNumber(int i) {
            CloudAnchorState[] values;
            for (CloudAnchorState cloudAnchorState : values()) {
                if (cloudAnchorState.nativeCode == i) {
                    return cloudAnchorState;
                }
            }
            throw new FatalException(new StringBuilder(63).append("Unexpected value for native CloudAnchorState, value=").append(i).toString());
        }
    }

    protected Anchor() {
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((Anchor) obj).psX == this.psX;
    }

    public int hashCode() {
        return Long.valueOf(this.psX).hashCode();
    }

    protected void finalize() throws Throwable {
        if (this.psX != 0) {
            nativeReleaseAnchor(this.psX);
        }
        super.finalize();
    }
}
