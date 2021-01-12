package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import java.lang.reflect.Array;
/* loaded from: classes4.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i, boolean z) {
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[width * height];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = width - 1;
        int i3 = height - 1;
        int i4 = width * height;
        int i5 = i + i + 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int[] iArr6 = new int[i7 * 256];
        for (int i8 = 0; i8 < i7 * 256; i8++) {
            iArr6[i8] = i8 / i7;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i5, 3);
        int i9 = i + 1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i10;
            if (i13 >= height) {
                break;
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = -i; i23 <= i; i23++) {
                int i24 = iArr[Math.min(i2, Math.max(i23, 0)) + i12];
                int[] iArr8 = iArr7[i23 + i];
                iArr8[0] = (16711680 & i24) >> 16;
                iArr8[1] = (65280 & i24) >> 8;
                iArr8[2] = i24 & 255;
                int abs = i9 - Math.abs(i23);
                i22 += iArr8[0] * abs;
                i21 += iArr8[1] * abs;
                i20 += abs * iArr8[2];
                if (i23 > 0) {
                    i16 += iArr8[0];
                    i15 += iArr8[1];
                    i14 += iArr8[2];
                } else {
                    i19 += iArr8[0];
                    i18 += iArr8[1];
                    i17 += iArr8[2];
                }
            }
            int i25 = i;
            for (int i26 = 0; i26 < width; i26++) {
                iArr2[i12] = iArr6[i22];
                iArr3[i12] = iArr6[i21];
                iArr4[i12] = iArr6[i20];
                int i27 = i22 - i19;
                int i28 = i21 - i18;
                int i29 = i20 - i17;
                int[] iArr9 = iArr7[((i25 - i) + i5) % i5];
                int i30 = i19 - iArr9[0];
                int i31 = i18 - iArr9[1];
                int i32 = i17 - iArr9[2];
                if (i13 == 0) {
                    iArr5[i26] = Math.min(i26 + i + 1, i2);
                }
                int i33 = iArr[iArr5[i26] + i11];
                iArr9[0] = (16711680 & i33) >> 16;
                iArr9[1] = (65280 & i33) >> 8;
                iArr9[2] = i33 & 255;
                int i34 = i16 + iArr9[0];
                int i35 = i15 + iArr9[1];
                int i36 = i14 + iArr9[2];
                i22 = i27 + i34;
                i21 = i28 + i35;
                i20 = i29 + i36;
                i25 = (i25 + 1) % i5;
                int[] iArr10 = iArr7[i25 % i5];
                i19 = i30 + iArr10[0];
                i18 = i31 + iArr10[1];
                i17 = i32 + iArr10[2];
                i16 = i34 - iArr10[0];
                i15 = i35 - iArr10[1];
                i14 = i36 - iArr10[2];
                i12++;
            }
            i10 = i13 + 1;
            i11 += width;
        }
        for (int i37 = 0; i37 < width; i37++) {
            int i38 = (-i) * width;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            for (int i48 = -i; i48 <= i; i48++) {
                int max = Math.max(0, i38) + i37;
                int[] iArr11 = iArr7[i48 + i];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i9 - Math.abs(i48);
                i47 += iArr2[max] * abs2;
                i46 += iArr3[max] * abs2;
                i45 += iArr4[max] * abs2;
                if (i48 > 0) {
                    i41 += iArr11[0];
                    i40 += iArr11[1];
                    i39 += iArr11[2];
                } else {
                    i44 += iArr11[0];
                    i43 += iArr11[1];
                    i42 += iArr11[2];
                }
                if (i48 < i3) {
                    i38 += width;
                }
            }
            int i49 = 0;
            int i50 = i39;
            int i51 = i;
            int i52 = i37;
            while (i49 < height) {
                iArr[i52] = ((-16777216) & iArr[i52]) | (iArr6[i47] << 16) | (iArr6[i46] << 8) | iArr6[i45];
                int i53 = i47 - i44;
                int i54 = i46 - i43;
                int i55 = i45 - i42;
                int[] iArr12 = iArr7[((i51 - i) + i5) % i5];
                int i56 = i44 - iArr12[0];
                int i57 = i43 - iArr12[1];
                int i58 = i42 - iArr12[2];
                if (i37 == 0) {
                    iArr5[i49] = Math.min(i49 + i9, i3) * width;
                }
                int i59 = iArr5[i49] + i37;
                iArr12[0] = iArr2[i59];
                iArr12[1] = iArr3[i59];
                iArr12[2] = iArr4[i59];
                int i60 = i41 + iArr12[0];
                int i61 = i40 + iArr12[1];
                int i62 = i50 + iArr12[2];
                i47 = i53 + i60;
                i46 = i54 + i61;
                i45 = i55 + i62;
                i51 = (i51 + 1) % i5;
                int[] iArr13 = iArr7[i51];
                i44 = i56 + iArr13[0];
                i43 = i57 + iArr13[1];
                i42 = i58 + iArr13[2];
                i41 = i60 - iArr13[0];
                int i63 = i61 - iArr13[1];
                i50 = i62 - iArr13[2];
                i52 += width;
                i49++;
                i40 = i63;
            }
        }
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        return copy;
    }
}
