package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ta8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<DecodeHintType, Object> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755297370, "Lcom/repackage/ta8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755297370, "Lcom/repackage/ta8;");
                return;
            }
        }
        a = new EnumMap(DecodeHintType.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.PDF_417);
        a.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        a.put(DecodeHintType.CHARACTER_SET, IMAudioTransRequest.CHARSET);
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outHeight / 800;
                if (i2 > 0) {
                    i = i2;
                }
                options.inSampleSize = i;
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(str, options);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String b(Bitmap bitmap) {
        InterceptResult invokeL;
        RGBLuminanceSource rGBLuminanceSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int[] iArr = new int[width * height];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                rGBLuminanceSource = new RGBLuminanceSource(width, height, iArr);
            } catch (Exception e) {
                e = e;
                rGBLuminanceSource = null;
            }
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), a).getText();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (rGBLuminanceSource != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? b(a(str)) : (String) invokeL.objValue;
    }
}
