package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class CameraConfig {

    /* renamed from: a  reason: collision with root package name */
    public long f30934a = 0;

    /* loaded from: classes6.dex */
    public enum FacingDirection {
        BACK(0),
        FRONT(1);
        
        public final int nativeCode;

        FacingDirection(int i2) {
            this.nativeCode = i2;
        }

        public static FacingDirection forNumber(int i2) {
            FacingDirection[] values;
            for (FacingDirection facingDirection : values()) {
                if (facingDirection.nativeCode == i2) {
                    return facingDirection;
                }
            }
            StringBuilder sb = new StringBuilder(62);
            sb.append("Unexpected value for native FacingDirection, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    public static native void nativeDestroyCameraConfig(long j);

    private native String nativeGetCameraId(long j, long j2);

    private native int nativeGetFacingDirection(long j, long j2);

    private native void nativeGetImageDimensions(long j, long j2, int[] iArr);

    private native void nativeGetTextureDimensions(long j, long j2, int[] iArr);

    public void finalize() {
        long j = this.f30934a;
        if (j != 0) {
            nativeDestroyCameraConfig(j);
            this.f30934a = 0L;
        }
        super.finalize();
    }
}
