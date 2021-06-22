package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class Anchor {

    /* renamed from: a  reason: collision with root package name */
    public long f30926a = 0;

    /* loaded from: classes6.dex */
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

        CloudAnchorState(int i2) {
            this.nativeCode = i2;
        }

        public static CloudAnchorState forNumber(int i2) {
            CloudAnchorState[] values;
            for (CloudAnchorState cloudAnchorState : values()) {
                if (cloudAnchorState.nativeCode == i2) {
                    return cloudAnchorState;
                }
            }
            StringBuilder sb = new StringBuilder(63);
            sb.append("Unexpected value for native CloudAnchorState, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }

        public final boolean isError() {
            return this.nativeCode < 0;
        }
    }

    private native void nativeDetach(long j, long j2);

    private native String nativeGetCloudAnchorId(long j, long j2);

    private native int nativeGetCloudAnchorState(long j, long j2);

    private native d.g.b.a.a nativeGetPose(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    public static native void nativeReleaseAnchor(long j);

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == Anchor.class && ((Anchor) obj).f30926a == this.f30926a;
    }

    public void finalize() {
        long j = this.f30926a;
        if (j != 0) {
            nativeReleaseAnchor(j);
        }
        super.finalize();
    }

    public int hashCode() {
        return Long.valueOf(this.f30926a).hashCode();
    }
}
