package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
/* loaded from: classes6.dex */
public class f91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            int i5 = 1;
            if (i3 > i2 || i4 > i) {
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (i6 / i5 >= i2 && i7 / i5 >= i) {
                    i5 *= 2;
                }
            }
            return i5;
        }
        return invokeLII.intValue;
    }

    public static Bitmap b(FileDescriptor fileDescriptor, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, fileDescriptor, i, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            int a = a(options, i, i2);
            options.inSampleSize = a;
            options.inJustDecodeBounds = false;
            if (a <= 1) {
                return BitmapFactory.decodeFileDescriptor(fileDescriptor);
            }
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        }
        return (Bitmap) invokeLII.objValue;
    }
}
