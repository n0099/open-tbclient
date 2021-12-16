package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
/* loaded from: classes2.dex */
public abstract class IterativeBoxBlurFilter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IterativeBoxBlurFilter";
    public transient /* synthetic */ FieldHolder $fh;

    public IterativeBoxBlurFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int bound(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? i2 < i3 ? i3 : i2 > i4 ? i4 : i2 : invokeIII.intValue;
    }

    public static void boxBlurBitmapInPlace(Bitmap bitmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, bitmap, i2, i3) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkArgument(bitmap.isMutable());
            Preconditions.checkArgument(((float) bitmap.getHeight()) <= 2048.0f);
            Preconditions.checkArgument(((float) bitmap.getWidth()) <= 2048.0f);
            Preconditions.checkArgument(i3 > 0 && i3 <= 25);
            Preconditions.checkArgument(i2 > 0);
            try {
                fastBoxBlur(bitmap, i2, i3);
            } catch (OutOfMemoryError e2) {
                FLog.e(TAG, String.format(null, "OOM: %d iterations on %dx%d with %d radius", Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i3)));
                throw e2;
            }
        }
    }

    public static void fastBoxBlur(Bitmap bitmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, bitmap, i2, i3) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i4 = i3 + 1;
            int i5 = i4 + i3;
            int[] iArr2 = new int[i5 * 256];
            int i6 = 1;
            while (true) {
                if (i6 > 255) {
                    break;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr2[i4] = i6;
                    i4++;
                }
                i6++;
            }
            int[] iArr3 = new int[Math.max(width, height)];
            for (int i8 = 0; i8 < i2; i8++) {
                for (int i9 = 0; i9 < height; i9++) {
                    internalHorizontalBlur(iArr, iArr3, width, i9, i5, iArr2);
                    System.arraycopy(iArr3, 0, iArr, i9 * width, width);
                }
                int i10 = 0;
                while (i10 < width) {
                    int i11 = i10;
                    internalVerticalBlur(iArr, iArr3, width, height, i10, i5, iArr2);
                    int i12 = i11;
                    for (int i13 = 0; i13 < height; i13++) {
                        iArr[i12] = iArr3[i13];
                        i12 += width;
                    }
                    i10 = i11 + 1;
                }
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }

    public static void internalHorizontalBlur(int[] iArr, int[] iArr2, int i2, int i3, int i4, int[] iArr3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{iArr, iArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr3}) == null) {
            int i5 = i2 * i3;
            int i6 = ((i3 + 1) * i2) - 1;
            int i7 = i4 >> 1;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = -i7; i12 < i2 + i7; i12++) {
                int i13 = iArr[bound(i5 + i12, i5, i6)];
                i8 += (i13 >> 16) & 255;
                i9 += (i13 >> 8) & 255;
                i10 += i13 & 255;
                i11 += i13 >>> 24;
                if (i12 >= i7) {
                    iArr2[i12 - i7] = (iArr3[i11] << 24) | (iArr3[i8] << 16) | (iArr3[i9] << 8) | iArr3[i10];
                    int i14 = iArr[bound((i12 - (i4 - 1)) + i5, i5, i6)];
                    i8 -= (i14 >> 16) & 255;
                    i9 -= (i14 >> 8) & 255;
                    i10 -= i14 & 255;
                    i11 -= i14 >>> 24;
                }
            }
        }
    }

    public static void internalVerticalBlur(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, int[] iArr3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{iArr, iArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr3}) == null) {
            int i6 = ((i3 - 1) * i2) + i4;
            int i7 = (i5 >> 1) * i2;
            int i8 = (i5 - 1) * i2;
            int i9 = i4 - i7;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i9 <= i6 + i7) {
                int i15 = iArr[bound(i9, i4, i6)];
                i10 += (i15 >> 16) & 255;
                i11 += (i15 >> 8) & 255;
                i12 += i15 & 255;
                i13 += i15 >>> 24;
                if (i9 - i7 >= i4) {
                    iArr2[i14] = (iArr3[i13] << 24) | (iArr3[i10] << 16) | (iArr3[i11] << 8) | iArr3[i12];
                    i14++;
                    int i16 = iArr[bound(i9 - i8, i4, i6)];
                    i10 -= (i16 >> 16) & 255;
                    i11 -= (i16 >> 8) & 255;
                    i12 -= i16 & 255;
                    i13 -= i16 >>> 24;
                }
                i9 += i2;
            }
        }
    }
}
