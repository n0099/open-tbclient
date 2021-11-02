package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bitmap, i2, i3)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f2 = i2 / width;
            float f3 = i3 / height;
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f3);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception unused) {
                return bitmap;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
