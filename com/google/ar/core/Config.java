package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class Config {

    /* renamed from: a  reason: collision with root package name */
    public long f30936a = 0;

    /* loaded from: classes6.dex */
    public enum AugmentedFaceMode {
        DISABLED(0),
        MESH3D(2);
        
        public final int nativeCode;

        AugmentedFaceMode(int i2) {
            this.nativeCode = i2;
        }

        public static AugmentedFaceMode forNumber(int i2) {
            AugmentedFaceMode[] values;
            for (AugmentedFaceMode augmentedFaceMode : values()) {
                if (augmentedFaceMode.nativeCode == i2) {
                    return augmentedFaceMode;
                }
            }
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected value for native AugmentedFaceMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum CloudAnchorMode {
        DISABLED(0),
        ENABLED(1);
        
        public final int nativeCode;

        CloudAnchorMode(int i2) {
            this.nativeCode = i2;
        }

        public static CloudAnchorMode forNumber(int i2) {
            CloudAnchorMode[] values;
            for (CloudAnchorMode cloudAnchorMode : values()) {
                if (cloudAnchorMode.nativeCode == i2) {
                    return cloudAnchorMode;
                }
            }
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected value for native AnchorHostingMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum FocusMode {
        FIXED(0),
        AUTO(1);
        
        public final int nativeCode;

        FocusMode(int i2) {
            this.nativeCode = i2;
        }

        public static FocusMode forNumber(int i2) {
            FocusMode[] values;
            for (FocusMode focusMode : values()) {
                if (focusMode.nativeCode == i2) {
                    return focusMode;
                }
            }
            StringBuilder sb = new StringBuilder(56);
            sb.append("Unexpected value for native FocusMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum LightEstimationMode {
        DISABLED(0),
        AMBIENT_INTENSITY(1);
        
        public final int nativeCode;

        LightEstimationMode(int i2) {
            this.nativeCode = i2;
        }

        public static LightEstimationMode forNumber(int i2) {
            LightEstimationMode[] values;
            for (LightEstimationMode lightEstimationMode : values()) {
                if (lightEstimationMode.nativeCode == i2) {
                    return lightEstimationMode;
                }
            }
            StringBuilder sb = new StringBuilder(66);
            sb.append("Unexpected value for native LightEstimationMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum PlaneFindingMode {
        DISABLED(0),
        HORIZONTAL(1),
        VERTICAL(2),
        HORIZONTAL_AND_VERTICAL(3);
        
        public final int nativeCode;

        PlaneFindingMode(int i2) {
            this.nativeCode = i2;
        }

        public static PlaneFindingMode forNumber(int i2) {
            PlaneFindingMode[] values;
            for (PlaneFindingMode planeFindingMode : values()) {
                if (planeFindingMode.nativeCode == i2) {
                    return planeFindingMode;
                }
            }
            StringBuilder sb = new StringBuilder(63);
            sb.append("Unexpected value for native PlaneFindingMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    public enum UpdateMode {
        BLOCKING(0),
        LATEST_CAMERA_IMAGE(1);
        
        public final int nativeCode;

        UpdateMode(int i2) {
            this.nativeCode = i2;
        }

        public static UpdateMode forNumber(int i2) {
            UpdateMode[] values;
            for (UpdateMode updateMode : values()) {
                if (updateMode.nativeCode == i2) {
                    return updateMode;
                }
            }
            StringBuilder sb = new StringBuilder(57);
            sb.append("Unexpected value for native UpdateMode, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    public static native long nativeCreate(long j);

    public static native void nativeDestroy(long j);

    private native int nativeGetAugmentedFaceMode(long j, long j2);

    private native long nativeGetAugmentedImageDatabase(long j, long j2);

    private native int nativeGetCloudAnchorMode(long j, long j2);

    private native int nativeGetFocusMode(long j, long j2);

    private native int nativeGetLightEstimationMode(long j, long j2);

    private native int nativeGetPlaneFindingMode(long j, long j2);

    private native int nativeGetUpdateMode(long j, long j2);

    private native void nativeSetAugmentedFaceMode(long j, long j2, int i2);

    private native void nativeSetAugmentedImageDatabase(long j, long j2, long j3);

    private native void nativeSetCloudAnchorMode(long j, long j2, int i2);

    private native void nativeSetFocusMode(long j, long j2, int i2);

    private native void nativeSetLightEstimationMode(long j, long j2, int i2);

    private native void nativeSetPlaneFindingMode(long j, long j2, int i2);

    private native void nativeSetUpdateMode(long j, long j2, int i2);

    public void finalize() {
        long j = this.f30936a;
        if (j != 0) {
            nativeDestroy(j);
        }
        super.finalize();
    }
}
