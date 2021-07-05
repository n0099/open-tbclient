package d.a.r0.z0;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i2, boolean z) {
        InterceptResult invokeCommon;
        int width;
        int height;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = i2;
            if (z) {
                width = bitmap.getWidth() / 2;
                height = bitmap.getHeight() / 4;
            } else {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
            }
            if (width == 0 || height == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
            if (i3 < 1) {
                return null;
            }
            int i4 = width * height;
            int[] iArr2 = new int[i4];
            createBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i5 = width - 1;
            int i6 = height - 1;
            int i7 = i3 + i3 + 1;
            int[] iArr3 = new int[i4];
            int[] iArr4 = new int[i4];
            int[] iArr5 = new int[i4];
            int[] iArr6 = new int[Math.max(width, height)];
            int i8 = (i7 + 1) >> 1;
            int i9 = i8 * i8;
            int i10 = i9 * 256;
            int[] iArr7 = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr7[i11] = i11 / i9;
            }
            int[][] iArr8 = (int[][]) Array.newInstance(int.class, i7, 3);
            int i12 = i3 + 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < height) {
                Bitmap bitmap2 = createBitmap;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = -i3;
                int i25 = 0;
                while (i24 <= i3) {
                    int i26 = height;
                    int i27 = i6;
                    int i28 = iArr2[i14 + Math.min(i5, Math.max(i24, 0))];
                    int[] iArr9 = iArr8[i24 + i3];
                    iArr9[0] = (i28 & 16711680) >> 16;
                    iArr9[1] = (i28 & 65280) >> 8;
                    iArr9[2] = i28 & 255;
                    int abs = i12 - Math.abs(i24);
                    i25 += iArr9[0] * abs;
                    i16 += iArr9[1] * abs;
                    i17 += iArr9[2] * abs;
                    if (i24 > 0) {
                        i21 += iArr9[0];
                        i22 += iArr9[1];
                        i23 += iArr9[2];
                    } else {
                        i18 += iArr9[0];
                        i19 += iArr9[1];
                        i20 += iArr9[2];
                    }
                    i24++;
                    height = i26;
                    i6 = i27;
                }
                int i29 = height;
                int i30 = i6;
                int i31 = i3;
                int i32 = i25;
                int i33 = 0;
                while (i33 < width) {
                    iArr3[i14] = iArr7[i32];
                    iArr4[i14] = iArr7[i16];
                    iArr5[i14] = iArr7[i17];
                    int i34 = i32 - i18;
                    int i35 = i16 - i19;
                    int i36 = i17 - i20;
                    int[] iArr10 = iArr8[((i31 - i3) + i7) % i7];
                    int i37 = i18 - iArr10[0];
                    int i38 = i19 - iArr10[1];
                    int i39 = i20 - iArr10[2];
                    if (i13 == 0) {
                        iArr = iArr7;
                        iArr6[i33] = Math.min(i33 + i3 + 1, i5);
                    } else {
                        iArr = iArr7;
                    }
                    int i40 = iArr2[i15 + iArr6[i33]];
                    iArr10[0] = (i40 & 16711680) >> 16;
                    iArr10[1] = (i40 & 65280) >> 8;
                    iArr10[2] = i40 & 255;
                    int i41 = i21 + iArr10[0];
                    int i42 = i22 + iArr10[1];
                    int i43 = i23 + iArr10[2];
                    i32 = i34 + i41;
                    i16 = i35 + i42;
                    i17 = i36 + i43;
                    i31 = (i31 + 1) % i7;
                    int[] iArr11 = iArr8[i31 % i7];
                    i18 = i37 + iArr11[0];
                    i19 = i38 + iArr11[1];
                    i20 = i39 + iArr11[2];
                    i21 = i41 - iArr11[0];
                    i22 = i42 - iArr11[1];
                    i23 = i43 - iArr11[2];
                    i14++;
                    i33++;
                    iArr7 = iArr;
                }
                i15 += width;
                i13++;
                createBitmap = bitmap2;
                height = i29;
                i6 = i30;
            }
            int i44 = height;
            int i45 = i6;
            int[] iArr12 = iArr7;
            Bitmap bitmap3 = createBitmap;
            int i46 = 0;
            while (i46 < width) {
                int i47 = -i3;
                int i48 = i7;
                int[] iArr13 = iArr6;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                int i55 = 0;
                int i56 = i47;
                int i57 = i47 * width;
                int i58 = 0;
                int i59 = 0;
                while (i56 <= i3) {
                    int i60 = width;
                    int max = Math.max(0, i57) + i46;
                    int[] iArr14 = iArr8[i56 + i3];
                    iArr14[0] = iArr3[max];
                    iArr14[1] = iArr4[max];
                    iArr14[2] = iArr5[max];
                    int abs2 = i12 - Math.abs(i56);
                    i58 += iArr3[max] * abs2;
                    i59 += iArr4[max] * abs2;
                    i49 += iArr5[max] * abs2;
                    if (i56 > 0) {
                        i53 += iArr14[0];
                        i54 += iArr14[1];
                        i55 += iArr14[2];
                    } else {
                        i50 += iArr14[0];
                        i51 += iArr14[1];
                        i52 += iArr14[2];
                    }
                    int i61 = i45;
                    if (i56 < i61) {
                        i57 += i60;
                    }
                    i56++;
                    i45 = i61;
                    width = i60;
                }
                int i62 = width;
                int i63 = i45;
                int i64 = i3;
                int i65 = i46;
                int i66 = i44;
                int i67 = 0;
                while (i67 < i66) {
                    iArr2[i65] = (iArr2[i65] & (-16777216)) | (iArr12[i58] << 16) | (iArr12[i59] << 8) | iArr12[i49];
                    int i68 = i58 - i50;
                    int i69 = i59 - i51;
                    int i70 = i49 - i52;
                    int[] iArr15 = iArr8[((i64 - i3) + i48) % i48];
                    int i71 = i50 - iArr15[0];
                    int i72 = i51 - iArr15[1];
                    int i73 = i52 - iArr15[2];
                    if (i46 == 0) {
                        iArr13[i67] = Math.min(i67 + i12, i63) * i62;
                    }
                    int i74 = iArr13[i67] + i46;
                    iArr15[0] = iArr3[i74];
                    iArr15[1] = iArr4[i74];
                    iArr15[2] = iArr5[i74];
                    int i75 = i53 + iArr15[0];
                    int i76 = i54 + iArr15[1];
                    int i77 = i55 + iArr15[2];
                    i58 = i68 + i75;
                    i59 = i69 + i76;
                    i49 = i70 + i77;
                    i64 = (i64 + 1) % i48;
                    int[] iArr16 = iArr8[i64];
                    i50 = i71 + iArr16[0];
                    i51 = i72 + iArr16[1];
                    i52 = i73 + iArr16[2];
                    i53 = i75 - iArr16[0];
                    i54 = i76 - iArr16[1];
                    i55 = i77 - iArr16[2];
                    i65 += i62;
                    i67++;
                    i3 = i2;
                }
                i46++;
                i3 = i2;
                i45 = i63;
                i44 = i66;
                iArr6 = iArr13;
                i7 = i48;
                width = i62;
            }
            int i78 = width;
            bitmap3.setPixels(iArr2, 0, i78, 0, 0, i78, i44);
            return bitmap3;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
