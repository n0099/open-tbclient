package d.b.i0.o2.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f57301a = new EnumMap(DecodeHintType.class);

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.PDF_417);
        f57301a.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        f57301a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        f57301a.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    public static Bitmap a(String str) {
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

    public static String b(Bitmap bitmap) {
        RGBLuminanceSource rGBLuminanceSource;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            rGBLuminanceSource = new RGBLuminanceSource(width, height, iArr);
        } catch (Exception e2) {
            e = e2;
            rGBLuminanceSource = null;
        }
        try {
            return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), f57301a).getText();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (rGBLuminanceSource != null) {
                try {
                    return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), f57301a).getText();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    public static String c(String str) {
        return b(a(str));
    }
}
