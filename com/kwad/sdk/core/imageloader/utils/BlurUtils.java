package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import java.lang.reflect.Array;
/* loaded from: classes4.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i2, boolean z) {
        Bitmap bitmap2;
        int i3;
        int i4;
        int[] iArr;
        int[] iArr2;
        int i5 = i2;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i5 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i6 = width * height;
        int[] iArr3 = new int[i6];
        copy.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i7 = width - 1;
        int i8 = height - 1;
        int i9 = i5 + i5 + 1;
        int[] iArr4 = new int[i6];
        int[] iArr5 = new int[i6];
        int[] iArr6 = new int[i6];
        int[] iArr7 = new int[Math.max(width, height)];
        int i10 = (i9 + 1) >> 1;
        int i11 = i10 * i10;
        int i12 = i11 * 256;
        int[] iArr8 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr8[i13] = i13 / i11;
        }
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, i9, 3);
        int i14 = i5 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            bitmap2 = copy;
            if (i15 >= height) {
                break;
            }
            int i18 = height;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = -i5;
            int i28 = 0;
            while (true) {
                i4 = i8;
                iArr = iArr7;
                if (i27 > i5) {
                    break;
                }
                int i29 = iArr3[i16 + Math.min(i7, Math.max(i27, 0))];
                int[] iArr10 = iArr9[i27 + i5];
                iArr10[0] = (i29 & 16711680) >> 16;
                iArr10[1] = (i29 & 65280) >> 8;
                iArr10[2] = i29 & 255;
                int abs = i14 - Math.abs(i27);
                i28 += iArr10[0] * abs;
                i19 += iArr10[1] * abs;
                i20 += iArr10[2] * abs;
                if (i27 > 0) {
                    i24 += iArr10[0];
                    i25 += iArr10[1];
                    i26 += iArr10[2];
                } else {
                    i21 += iArr10[0];
                    i22 += iArr10[1];
                    i23 += iArr10[2];
                }
                i27++;
                i8 = i4;
                iArr7 = iArr;
            }
            int i30 = i5;
            int i31 = i28;
            int i32 = 0;
            while (i32 < width) {
                iArr4[i16] = iArr8[i31];
                iArr5[i16] = iArr8[i19];
                iArr6[i16] = iArr8[i20];
                int i33 = i31 - i21;
                int i34 = i19 - i22;
                int i35 = i20 - i23;
                int[] iArr11 = iArr9[((i30 - i5) + i9) % i9];
                int i36 = i21 - iArr11[0];
                int i37 = i22 - iArr11[1];
                int i38 = i23 - iArr11[2];
                if (i15 == 0) {
                    iArr2 = iArr8;
                    iArr[i32] = Math.min(i32 + i5 + 1, i7);
                } else {
                    iArr2 = iArr8;
                }
                int i39 = iArr3[i17 + iArr[i32]];
                iArr11[0] = (i39 & 16711680) >> 16;
                iArr11[1] = (i39 & 65280) >> 8;
                iArr11[2] = i39 & 255;
                int i40 = i24 + iArr11[0];
                int i41 = i25 + iArr11[1];
                int i42 = i26 + iArr11[2];
                i31 = i33 + i40;
                i19 = i34 + i41;
                i20 = i35 + i42;
                i30 = (i30 + 1) % i9;
                int[] iArr12 = iArr9[i30 % i9];
                i21 = i36 + iArr12[0];
                i22 = i37 + iArr12[1];
                i23 = i38 + iArr12[2];
                i24 = i40 - iArr12[0];
                i25 = i41 - iArr12[1];
                i26 = i42 - iArr12[2];
                i16++;
                i32++;
                iArr8 = iArr2;
            }
            i17 += width;
            i15++;
            copy = bitmap2;
            height = i18;
            i8 = i4;
            iArr7 = iArr;
        }
        int i43 = i8;
        int[] iArr13 = iArr7;
        int i44 = height;
        int[] iArr14 = iArr8;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i5;
            int i47 = i9;
            int[] iArr15 = iArr3;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (true) {
                i3 = width;
                if (i55 > i5) {
                    break;
                }
                int max = Math.max(0, i56) + i45;
                int[] iArr16 = iArr9[i55 + i5];
                iArr16[0] = iArr4[max];
                iArr16[1] = iArr5[max];
                iArr16[2] = iArr6[max];
                int abs2 = i14 - Math.abs(i55);
                i57 += iArr4[max] * abs2;
                i58 += iArr5[max] * abs2;
                i48 += iArr6[max] * abs2;
                if (i55 > 0) {
                    i52 += iArr16[0];
                    i53 += iArr16[1];
                    i54 += iArr16[2];
                } else {
                    i49 += iArr16[0];
                    i50 += iArr16[1];
                    i51 += iArr16[2];
                }
                int i59 = i43;
                if (i55 < i59) {
                    i56 += i3;
                }
                i55++;
                i43 = i59;
                width = i3;
            }
            int i60 = i43;
            int i61 = i5;
            int i62 = i45;
            int i63 = i58;
            int i64 = i44;
            int i65 = i57;
            int i66 = 0;
            while (i66 < i64) {
                iArr15[i62] = (iArr15[i62] & (-16777216)) | (iArr14[i65] << 16) | (iArr14[i63] << 8) | iArr14[i48];
                int i67 = i65 - i49;
                int i68 = i63 - i50;
                int i69 = i48 - i51;
                int[] iArr17 = iArr9[((i61 - i5) + i47) % i47];
                int i70 = i49 - iArr17[0];
                int i71 = i50 - iArr17[1];
                int i72 = i51 - iArr17[2];
                if (i45 == 0) {
                    iArr13[i66] = Math.min(i66 + i14, i60) * i3;
                }
                int i73 = iArr13[i66] + i45;
                iArr17[0] = iArr4[i73];
                iArr17[1] = iArr5[i73];
                iArr17[2] = iArr6[i73];
                int i74 = i52 + iArr17[0];
                int i75 = i53 + iArr17[1];
                int i76 = i54 + iArr17[2];
                i65 = i67 + i74;
                i63 = i68 + i75;
                i48 = i69 + i76;
                i61 = (i61 + 1) % i47;
                int[] iArr18 = iArr9[i61];
                i49 = i70 + iArr18[0];
                i50 = i71 + iArr18[1];
                i51 = i72 + iArr18[2];
                i52 = i74 - iArr18[0];
                i53 = i75 - iArr18[1];
                i54 = i76 - iArr18[2];
                i62 += i3;
                i66++;
                i5 = i2;
            }
            i45++;
            i5 = i2;
            i43 = i60;
            i44 = i64;
            i9 = i47;
            iArr3 = iArr15;
            width = i3;
        }
        int i77 = width;
        bitmap2.setPixels(iArr3, 0, i77, 0, 0, i77, i44);
        return bitmap2;
    }
}
