package d.c.c.b.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import d.c.c.b.b.d;
/* loaded from: classes5.dex */
public class a implements d.j {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f66600a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66601b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66602c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView.ScaleType f66603d;

    public a(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config) {
        this.f66600a = config;
        this.f66601b = i;
        this.f66602c = i2;
        this.f66603d = scaleType;
    }

    @VisibleForTesting
    public static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(i / i3, i2 / i4);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    public static int b(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else if (i == 0) {
            return (int) (i3 * (i2 / i4));
        } else if (i2 == 0) {
            return i;
        } else {
            double d2 = i4 / i3;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = i2;
                return ((double) i) * d2 < d3 ? (int) (d3 / d2) : i;
            }
            double d4 = i2;
            return ((double) i) * d2 > d4 ? (int) (d4 / d2) : i;
        }
    }

    @Override // d.c.c.b.b.d.j
    public Bitmap a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f66601b == 0 && this.f66602c == 0) {
            options.inPreferredConfig = this.f66600a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int b2 = b(this.f66601b, this.f66602c, i, i2, this.f66603d);
        int b3 = b(this.f66602c, this.f66601b, i2, i, this.f66603d);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(i, i2, b2, b3);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray != null) {
            if (decodeByteArray.getWidth() > b2 || decodeByteArray.getHeight() > b3) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, b2, b3, true);
                decodeByteArray.recycle();
                return createScaledBitmap;
            }
            return decodeByteArray;
        }
        return decodeByteArray;
    }
}
