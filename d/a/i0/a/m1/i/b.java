package d.a.i0.a.m1.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
/* loaded from: classes3.dex */
public class b extends a {
    public b(double d2) {
        this.f43317a = d2;
    }

    @Override // d.a.i0.a.m1.i.a
    public boolean a(Bitmap bitmap, Rect rect) {
        if (a.f43316c) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
        int width = rect2.width() - 2;
        int height = rect2.height() - 2;
        int i2 = width / 3;
        int i3 = height / i2;
        int ceil = (int) Math.ceil(i3 * 3 * this.f43317a);
        int i4 = 0;
        int i5 = 0;
        while (i5 < 3) {
            int i6 = rect2.left;
            int i7 = (i5 * i2) + 1 + i6;
            int i8 = i5 == 2 ? width + 1 : ((i5 + 1) * i2) + i6;
            int i9 = i4;
            int i10 = 0;
            while (i10 < i3) {
                int i11 = rect2.top;
                int i12 = i10;
                if (e(bitmap, i7, (i10 * i2) + 1 + i11, i8, i10 == i3 + (-1) ? height + 1 : ((i10 + 1) * i2) + i11)) {
                    int i13 = i9 + 1;
                    if (i13 >= ceil) {
                        return true;
                    }
                    i9 = i13;
                }
                i10 = i12 + 1;
            }
            i5++;
            i4 = i9;
        }
        return false;
    }

    public double d(Bitmap bitmap, Rect rect) {
        if (a.f43316c) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return 0.0d;
        }
        Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
        int width = rect2.width() - 2;
        int height = rect2.height() - 2;
        int i2 = width / 3;
        int i3 = height / i2;
        int i4 = 0;
        int i5 = 0;
        while (i5 < 3) {
            int i6 = rect2.left;
            int i7 = (i5 * i2) + 1 + i6;
            int i8 = i5 == 2 ? width + 1 : ((i5 + 1) * i2) + i6;
            int i9 = i4;
            int i10 = 0;
            while (i10 < i3) {
                int i11 = rect2.top;
                int i12 = i10;
                if (e(bitmap, i7, (i10 * i2) + 1 + i11, i8, i10 == i3 + (-1) ? height + 1 : ((i10 + 1) * i2) + i11)) {
                    i9++;
                }
                i10 = i12 + 1;
            }
            i5++;
            i4 = i9;
        }
        return i4 / (i3 * 3);
    }

    public final boolean e(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        if (i2 < 0 || i4 < i2 || i3 < 0 || i5 < i3) {
            return false;
        }
        int pixel = bitmap.getPixel(i2, i3);
        while (i2 <= i4) {
            for (int i6 = i3; i6 <= i5; i6++) {
                if (pixel != bitmap.getPixel(i2, i6)) {
                    return false;
                }
            }
            i2++;
        }
        return true;
    }
}
