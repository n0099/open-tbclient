package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes10.dex */
public class CameraConfig {
    public long a = 0;

    public static native void nativeDestroyCameraConfig(long j);

    private native String nativeGetCameraId(long j, long j2);

    private native int nativeGetFacingDirection(long j, long j2);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr);

    private native void nativeGetTextureDimensions(long j, long j2, int[] iArr);

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroyCameraConfig(j);
            this.a = 0L;
        }
        super.finalize();
    }

    /* loaded from: classes10.dex */
    public enum FacingDirection {
        BACK(0),
        FRONT(1);
        
        public final int nativeCode;

        FacingDirection(int i) {
            this.nativeCode = i;
        }

        public static FacingDirection forNumber(int i) {
            FacingDirection[] values;
            for (FacingDirection facingDirection : values()) {
                if (facingDirection.nativeCode == i) {
                    return facingDirection;
                }
            }
            StringBuilder sb = new StringBuilder(62);
            sb.append("Unexpected value for native FacingDirection, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }
}
