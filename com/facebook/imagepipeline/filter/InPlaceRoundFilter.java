package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes9.dex */
public final class InPlaceRoundFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InPlaceRoundFilter() {
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

    public static void roundBitmapInPlace(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bitmap) == null) {
            Preconditions.checkNotNull(bitmap);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int min = Math.min(width, height) / 2;
            int i2 = width / 2;
            int i3 = height / 2;
            if (min == 0) {
                return;
            }
            Preconditions.checkArgument(min >= 1);
            Preconditions.checkArgument(width > 0 && ((float) width) <= 2048.0f);
            Preconditions.checkArgument(height > 0 && ((float) height) <= 2048.0f);
            Preconditions.checkArgument(i2 > 0 && i2 < width);
            Preconditions.checkArgument(i3 > 0 && i3 < height);
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i4 = min - 1;
            Preconditions.checkArgument(i2 - i4 >= 0 && i3 - i4 >= 0 && i2 + i4 < width && i3 + i4 < height);
            int i5 = (-min) * 2;
            int[] iArr2 = new int[width];
            int i6 = i5 + 1;
            int i7 = 0;
            int i8 = 1;
            int i9 = 1;
            while (i4 >= i7) {
                int i10 = i2 + i4;
                int i11 = i2 - i4;
                int i12 = i2 + i7;
                int i13 = min;
                int i14 = i2 - i7;
                int i15 = i3 + i4;
                int i16 = i3 - i4;
                int i17 = i2;
                int i18 = i3 + i7;
                int i19 = i3 - i7;
                Preconditions.checkArgument(i4 >= 0 && i12 < width && i14 >= 0 && i18 < height && i19 >= 0);
                int i20 = i18 * width;
                int i21 = height;
                int i22 = width * i19;
                int i23 = i3;
                int i24 = width * i15;
                int i25 = i5;
                int i26 = width * i16;
                int i27 = i8;
                System.arraycopy(iArr2, 0, iArr, i20, i11);
                System.arraycopy(iArr2, 0, iArr, i22, i11);
                System.arraycopy(iArr2, 0, iArr, i24, i14);
                System.arraycopy(iArr2, 0, iArr, i26, i14);
                int i28 = width - i10;
                System.arraycopy(iArr2, 0, iArr, i20 + i10, i28);
                System.arraycopy(iArr2, 0, iArr, i22 + i10, i28);
                int i29 = width - i12;
                System.arraycopy(iArr2, 0, iArr, i24 + i12, i29);
                System.arraycopy(iArr2, 0, iArr, i26 + i12, i29);
                if (i6 <= 0) {
                    i7++;
                    i9 += 2;
                    i6 += i9;
                }
                if (i6 > 0) {
                    i4--;
                    i8 = i27 + 2;
                    i6 += i8 + i25;
                    min = i13;
                    i5 = i25;
                } else {
                    min = i13;
                    i5 = i25;
                    i8 = i27;
                }
                i2 = i17;
                i3 = i23;
                height = i21;
            }
            int i30 = height;
            int i31 = min;
            int i32 = i3;
            for (int i33 = i32 - i31; i33 >= 0; i33--) {
                System.arraycopy(iArr2, 0, iArr, i33 * width, width);
            }
            for (int i34 = i32 + i31; i34 < i30; i34++) {
                System.arraycopy(iArr2, 0, iArr, i34 * width, width);
            }
            bitmap.setPixels(iArr, 0, width, 0, 0, width, i30);
        }
    }
}
