package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes14.dex */
public class Config {
    long pSD;

    private static native long nativeCreate(long j);

    private static native void nativeDestroy(long j);

    private native int nativeGetAugmentedFaceMode(long j, long j2);

    private native long nativeGetAugmentedImageDatabase(long j, long j2);

    private native int nativeGetCloudAnchorMode(long j, long j2);

    private native int nativeGetFocusMode(long j, long j2);

    private native int nativeGetLightEstimationMode(long j, long j2);

    private native int nativeGetPlaneFindingMode(long j, long j2);

    private native int nativeGetUpdateMode(long j, long j2);

    private native void nativeSetAugmentedFaceMode(long j, long j2, int i);

    private native void nativeSetAugmentedImageDatabase(long j, long j2, long j3);

    private native void nativeSetCloudAnchorMode(long j, long j2, int i);

    private native void nativeSetFocusMode(long j, long j2, int i);

    private native void nativeSetLightEstimationMode(long j, long j2, int i);

    private native void nativeSetPlaneFindingMode(long j, long j2, int i);

    private native void nativeSetUpdateMode(long j, long j2, int i);

    /* loaded from: classes14.dex */
    public enum AugmentedFaceMode {
        DISABLED(0),
        MESH3D(2);
        
        final int nativeCode;

        AugmentedFaceMode(int i) {
            this.nativeCode = i;
        }

        static AugmentedFaceMode forNumber(int i) {
            AugmentedFaceMode[] values;
            for (AugmentedFaceMode augmentedFaceMode : values()) {
                if (augmentedFaceMode.nativeCode == i) {
                    return augmentedFaceMode;
                }
            }
            throw new FatalException(new StringBuilder(64).append("Unexpected value for native AugmentedFaceMode, value=").append(i).toString());
        }
    }

    /* loaded from: classes14.dex */
    public enum CloudAnchorMode {
        DISABLED(0),
        ENABLED(1);
        
        final int nativeCode;

        CloudAnchorMode(int i) {
            this.nativeCode = i;
        }

        static CloudAnchorMode forNumber(int i) {
            CloudAnchorMode[] values;
            for (CloudAnchorMode cloudAnchorMode : values()) {
                if (cloudAnchorMode.nativeCode == i) {
                    return cloudAnchorMode;
                }
            }
            throw new FatalException(new StringBuilder(64).append("Unexpected value for native AnchorHostingMode, value=").append(i).toString());
        }
    }

    /* loaded from: classes14.dex */
    public enum FocusMode {
        FIXED(0),
        AUTO(1);
        
        final int nativeCode;

        FocusMode(int i) {
            this.nativeCode = i;
        }

        static FocusMode forNumber(int i) {
            FocusMode[] values;
            for (FocusMode focusMode : values()) {
                if (focusMode.nativeCode == i) {
                    return focusMode;
                }
            }
            throw new FatalException(new StringBuilder(56).append("Unexpected value for native FocusMode, value=").append(i).toString());
        }
    }

    /* loaded from: classes14.dex */
    public enum LightEstimationMode {
        DISABLED(0),
        AMBIENT_INTENSITY(1);
        
        final int nativeCode;

        LightEstimationMode(int i) {
            this.nativeCode = i;
        }

        static LightEstimationMode forNumber(int i) {
            LightEstimationMode[] values;
            for (LightEstimationMode lightEstimationMode : values()) {
                if (lightEstimationMode.nativeCode == i) {
                    return lightEstimationMode;
                }
            }
            throw new FatalException(new StringBuilder(66).append("Unexpected value for native LightEstimationMode, value=").append(i).toString());
        }
    }

    /* loaded from: classes14.dex */
    public enum PlaneFindingMode {
        DISABLED(0),
        HORIZONTAL(1),
        VERTICAL(2),
        HORIZONTAL_AND_VERTICAL(3);
        
        final int nativeCode;

        PlaneFindingMode(int i) {
            this.nativeCode = i;
        }

        static PlaneFindingMode forNumber(int i) {
            PlaneFindingMode[] values;
            for (PlaneFindingMode planeFindingMode : values()) {
                if (planeFindingMode.nativeCode == i) {
                    return planeFindingMode;
                }
            }
            throw new FatalException(new StringBuilder(63).append("Unexpected value for native PlaneFindingMode, value=").append(i).toString());
        }
    }

    /* loaded from: classes14.dex */
    public enum UpdateMode {
        BLOCKING(0),
        LATEST_CAMERA_IMAGE(1);
        
        final int nativeCode;

        UpdateMode(int i) {
            this.nativeCode = i;
        }

        static UpdateMode forNumber(int i) {
            UpdateMode[] values;
            for (UpdateMode updateMode : values()) {
                if (updateMode.nativeCode == i) {
                    return updateMode;
                }
            }
            throw new FatalException(new StringBuilder(57).append("Unexpected value for native UpdateMode, value=").append(i).toString());
        }
    }

    protected void finalize() throws Throwable {
        if (this.pSD != 0) {
            nativeDestroy(this.pSD);
        }
        super.finalize();
    }
}
