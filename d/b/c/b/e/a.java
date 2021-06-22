package d.b.c.b.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import d.b.c.b.b.d;
/* loaded from: classes6.dex */
public class a implements d.j {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f69660a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69661b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69662c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView.ScaleType f69663d;

    public a(int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        this.f69660a = config;
        this.f69661b = i2;
        this.f69662c = i3;
        this.f69663d = scaleType;
    }

    @VisibleForTesting
    public static int a(int i2, int i3, int i4, int i5) {
        double min = Math.min(i2 / i4, i3 / i5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    public static int b(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        } else if (i2 == 0) {
            return (int) (i4 * (i3 / i5));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d2 = i5 / i4;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = i3;
                return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
            }
            double d4 = i3;
            return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
        }
    }

    @Override // d.b.c.b.b.d.j
    public Bitmap a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f69661b == 0 && this.f69662c == 0) {
            options.inPreferredConfig = this.f69660a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int b2 = b(this.f69661b, this.f69662c, i2, i3, this.f69663d);
        int b3 = b(this.f69662c, this.f69661b, i3, i2, this.f69663d);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a(i2, i3, b2, b3);
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
