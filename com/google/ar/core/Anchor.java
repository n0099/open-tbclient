package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes9.dex */
public class Anchor {
    public long a = 0;

    private native void nativeDetach(long j, long j2);

    private native String nativeGetCloudAnchorId(long j, long j2);

    private native int nativeGetCloudAnchorState(long j, long j2);

    private native Pose nativeGetPose(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    public static native void nativeReleaseAnchor(long j);

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeReleaseAnchor(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.a).hashCode();
    }

    /* loaded from: classes9.dex */
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
        
        public final int nativeCode;

        CloudAnchorState(int i) {
            this.nativeCode = i;
        }

        public static CloudAnchorState forNumber(int i) {
            CloudAnchorState[] values;
            for (CloudAnchorState cloudAnchorState : values()) {
                if (cloudAnchorState.nativeCode == i) {
                    return cloudAnchorState;
                }
            }
            StringBuilder sb = new StringBuilder(63);
            sb.append("Unexpected value for native CloudAnchorState, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }

        public final boolean isError() {
            if (this.nativeCode < 0) {
                return true;
            }
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Anchor.class || ((Anchor) obj).a != this.a) {
            return false;
        }
        return true;
    }
}
