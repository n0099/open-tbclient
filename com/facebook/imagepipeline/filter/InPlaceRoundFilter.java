package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes9.dex */
public final class InPlaceRoundFilter {
    public static void roundBitmapInPlace(Bitmap bitmap) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Preconditions.checkNotNull(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height) / 2;
        int i = width / 2;
        int i2 = height / 2;
        if (min == 0) {
            return;
        }
        if (min >= 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (width > 0 && width <= 2048.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (height > 0 && height <= 2048.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (i > 0 && i < width) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        if (i2 > 0 && i2 < height) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = min - 1;
        int i4 = i + i3;
        int i5 = i2 + i3;
        int i6 = i2 - i3;
        if (i - i3 >= 0 && i6 >= 0 && i4 < width && i5 < height) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6);
        int i7 = (-min) * 2;
        int[] iArr2 = new int[width];
        int i8 = i7 + 1;
        int i9 = 0;
        int i10 = 1;
        int i11 = 1;
        while (i3 >= i9) {
            int i12 = i + i3;
            int i13 = i - i3;
            int i14 = i + i9;
            int i15 = min;
            int i16 = i - i9;
            int i17 = i2 + i3;
            int i18 = i2 - i3;
            int i19 = i;
            int i20 = i2 + i9;
            int i21 = i2 - i9;
            if (i3 >= 0 && i14 < width && i16 >= 0 && i20 < height && i21 >= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkArgument(z7);
            int i22 = i20 * width;
            int i23 = height;
            int i24 = width * i21;
            int i25 = i2;
            int i26 = width * i17;
            int i27 = i7;
            int i28 = width * i18;
            int i29 = i10;
            System.arraycopy(iArr2, 0, iArr, i22, i13);
            System.arraycopy(iArr2, 0, iArr, i24, i13);
            System.arraycopy(iArr2, 0, iArr, i26, i16);
            System.arraycopy(iArr2, 0, iArr, i28, i16);
            int i30 = width - i12;
            System.arraycopy(iArr2, 0, iArr, i22 + i12, i30);
            System.arraycopy(iArr2, 0, iArr, i24 + i12, i30);
            int i31 = width - i14;
            System.arraycopy(iArr2, 0, iArr, i26 + i14, i31);
            System.arraycopy(iArr2, 0, iArr, i28 + i14, i31);
            if (i8 <= 0) {
                i9++;
                i11 += 2;
                i8 += i11;
            }
            if (i8 > 0) {
                i3--;
                i10 = i29 + 2;
                i8 += i10 + i27;
                min = i15;
                i7 = i27;
            } else {
                min = i15;
                i7 = i27;
                i10 = i29;
            }
            i = i19;
            i2 = i25;
            height = i23;
        }
        int i32 = height;
        int i33 = min;
        int i34 = i2;
        for (int i35 = i34 - i33; i35 >= 0; i35--) {
            System.arraycopy(iArr2, 0, iArr, i35 * width, width);
        }
        for (int i36 = i34 + i33; i36 < i32; i36++) {
            System.arraycopy(iArr2, 0, iArr, i36 * width, width);
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i32);
    }
}
