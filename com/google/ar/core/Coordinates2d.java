package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes10.dex */
public enum Coordinates2d {
    TEXTURE_TEXELS(0),
    TEXTURE_NORMALIZED(1),
    IMAGE_PIXELS(2),
    IMAGE_NORMALIZED(3),
    OPENGL_NORMALIZED_DEVICE_COORDINATES(6),
    VIEW(7),
    VIEW_NORMALIZED(8);
    
    public final int nativeCode;

    Coordinates2d(int i) {
        this.nativeCode = i;
    }

    public static Coordinates2d forNumber(int i) {
        Coordinates2d[] values;
        for (Coordinates2d coordinates2d : values()) {
            if (coordinates2d.nativeCode == i) {
                return coordinates2d;
            }
        }
        StringBuilder sb = new StringBuilder(60);
        sb.append("Unexpected value for native Coordinates2d, value=");
        sb.append(i);
        throw new FatalException(sb.toString());
    }
}
