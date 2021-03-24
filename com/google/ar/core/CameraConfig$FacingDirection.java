package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public enum CameraConfig$FacingDirection {
    BACK(0),
    FRONT(1);
    
    public final int nativeCode;

    CameraConfig$FacingDirection(int i) {
        this.nativeCode = i;
    }

    public static CameraConfig$FacingDirection forNumber(int i) {
        CameraConfig$FacingDirection[] values;
        for (CameraConfig$FacingDirection cameraConfig$FacingDirection : values()) {
            if (cameraConfig$FacingDirection.nativeCode == i) {
                return cameraConfig$FacingDirection;
            }
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append("Unexpected value for native FacingDirection, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
