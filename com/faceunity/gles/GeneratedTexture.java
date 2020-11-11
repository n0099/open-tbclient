package com.faceunity.gles;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.nio.ByteBuffer;
/* loaded from: classes23.dex */
public class GeneratedTexture {
    private static final int[] pbk = {-16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, MotionEventCompat.ACTION_POINTER_INDEX_MASK, -2147483393, ViewCompat.MEASURED_STATE_MASK, InputDeviceCompat.SOURCE_ANY, -65281, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
    private static final ByteBuffer pbl = esd();
    private static final ByteBuffer pbm = ese();

    /* loaded from: classes23.dex */
    public enum Image {
        COARSE,
        FINE
    }

    private static ByteBuffer esd() {
        byte[] bArr = new byte[16384];
        for (int i = 0; i < bArr.length; i += 4) {
            int i2 = pbk[((((i / 4) / 64) / 16) * 4) + (((i / 4) % 64) / 16)];
            if (i == 0) {
                i2 = -1;
            } else if (i == bArr.length - 4) {
                i2 = -1;
            }
            int i3 = i2 & 255;
            int i4 = (i2 >> 24) & 255;
            float f = i4 / 255.0f;
            bArr[i] = (byte) (i3 * f);
            bArr[i + 1] = (byte) (((i2 >> 8) & 255) * f);
            bArr[i + 2] = (byte) (((i2 >> 16) & 255) * f);
            bArr[i + 3] = (byte) i4;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }

    private static ByteBuffer ese() {
        byte[] bArr = new byte[16384];
        a(bArr, 0, 0, 32, 32, -16776961, SupportMenu.CATEGORY_MASK, 1);
        a(bArr, 32, 32, 64, 64, -16776961, -16711936, 2);
        a(bArr, 0, 32, 32, 64, SupportMenu.CATEGORY_MASK, -16711936, 4);
        a(bArr, 32, 0, 64, 32, -1, ViewCompat.MEASURED_STATE_MASK, 8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        while (i2 < i4) {
            int i8 = i2 * 64 * 4;
            for (int i9 = i; i9 < i3; i9++) {
                int i10 = i8 + (i9 * 4);
                int i11 = ((i2 & i7) ^ (i9 & i7)) == 0 ? i5 : i6;
                int i12 = i11 & 255;
                int i13 = (i11 >> 24) & 255;
                float f = i13 / 255.0f;
                bArr[i10] = (byte) (i12 * f);
                bArr[i10 + 1] = (byte) (((i11 >> 8) & 255) * f);
                bArr[i10 + 2] = (byte) (((i11 >> 16) & 255) * f);
                bArr[i10 + 3] = (byte) i13;
            }
            i2++;
        }
    }
}
