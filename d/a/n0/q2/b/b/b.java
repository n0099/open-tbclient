package d.a.n0.q2.b.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<EncodeHintType, Object> f62036a;

    static {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        f62036a = enumMap;
        enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) "utf-8");
        f62036a.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        f62036a.put(EncodeHintType.MARGIN, 0);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        float f2 = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f2, f2, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap b(String str, int i2) {
        return c(str, i2, -16777216, -1, null);
    }

    public static Bitmap c(String str, int i2, int i3, int i4, Bitmap bitmap) {
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i2, i2, f62036a);
            int[] iArr = new int[i2 * i2];
            for (int i5 = 0; i5 < i2; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    if (encode.get(i6, i5)) {
                        iArr[(i5 * i2) + i6] = i3;
                    } else {
                        iArr[(i5 * i2) + i6] = i4;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            return a(createBitmap, bitmap);
        } catch (Exception unused) {
            return null;
        }
    }
}
