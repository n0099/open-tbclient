package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class BitmapHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapHelper() {
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

    public static int getSampleSizeAutoFitToScreen(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) == null) {
            if (i3 == 0 || i2 == 0) {
                return 1;
            }
            return Math.min(Math.max(i4 / i2, i5 / i3), Math.max(i5 / i2, i4 / i3));
        }
        return invokeIIII.intValue;
    }

    public static int getSampleSizeOfNotTooLarge(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rect)) == null) {
            double width = ((rect.width() * rect.height()) * 2.0d) / 5242880.0d;
            if (width >= 1.0d) {
                return (int) width;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static boolean makesureSizeNotTooLarge(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rect)) == null) ? (rect.width() * rect.height()) * 2 <= 5242880 : invokeL.booleanValue;
    }

    public static boolean verifyBitmap(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) ? verifyBitmap(new ByteArrayInputStream(bArr)) : invokeL.booleanValue;
    }

    public static boolean verifyBitmap(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            if (inputStream == null) {
                return false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            BitmapFactory.decodeStream(inputStream, null, options);
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return options.outHeight > 0 && options.outWidth > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean verifyBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return verifyBitmap(new FileInputStream(str));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
