package d.c.c.b.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import d.c.c.b.b.d;
/* loaded from: classes5.dex */
public class a implements d.j {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f65754a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65755b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65756c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView.ScaleType f65757d;

    public a(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config) {
        this.f65754a = config;
        this.f65755b = i;
        this.f65756c = i2;
        this.f65757d = scaleType;
    }

    @VisibleForTesting
    public static int a(int i, int i2, int i3, int i4) {
        double d2 = i;
        double d3 = i3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = i2;
        double d5 = i4;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double min = Math.min(d2 / d3, d4 / d5);
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
            double d2 = i2;
            double d3 = i4;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i3;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        } else if (i2 == 0) {
            return i;
        } else {
            double d5 = i4;
            double d6 = i3;
            Double.isNaN(d5);
            Double.isNaN(d6);
            double d7 = d5 / d6;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d8 = i;
                Double.isNaN(d8);
                double d9 = i2;
                if (d8 * d7 < d9) {
                    Double.isNaN(d9);
                    return (int) (d9 / d7);
                }
                return i;
            }
            double d10 = i;
            Double.isNaN(d10);
            double d11 = i2;
            if (d10 * d7 > d11) {
                Double.isNaN(d11);
                return (int) (d11 / d7);
            }
            return i;
        }
    }

    @Override // d.c.c.b.b.d.j
    public Bitmap a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f65755b == 0 && this.f65756c == 0) {
            options.inPreferredConfig = this.f65754a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int b2 = b(this.f65755b, this.f65756c, i, i2, this.f65757d);
        int b3 = b(this.f65756c, this.f65755b, i2, i, this.f65757d);
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
