package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes15.dex */
public class CameraConfig {
    long pRO;

    private static native void nativeDestroyCameraConfig(long j);

    private native String nativeGetCameraId(long j, long j2);

    private native int nativeGetFacingDirection(long j, long j2);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr);

    private native void nativeGetTextureDimensions(long j, long j2, int[] iArr);

    /* loaded from: classes15.dex */
    public enum FacingDirection {
        BACK(0),
        FRONT(1);
        
        final int nativeCode;

        FacingDirection(int i) {
            this.nativeCode = i;
        }

        static FacingDirection forNumber(int i) {
            FacingDirection[] values;
            for (FacingDirection facingDirection : values()) {
                if (facingDirection.nativeCode == i) {
                    return facingDirection;
                }
            }
            throw new FatalException(new StringBuilder(62).append("Unexpected value for native FacingDirection, value=").append(i).toString());
        }
    }

    protected void finalize() throws Throwable {
        if (this.pRO != 0) {
            nativeDestroyCameraConfig(this.pRO);
            this.pRO = 0L;
        }
        super.finalize();
    }
}
