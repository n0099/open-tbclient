package d.b.g0.a.f1.h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
/* loaded from: classes2.dex */
public class b extends a {
    public b(double d2) {
        this.f44840a = d2;
    }

    @Override // d.b.g0.a.f1.h.a
    public boolean a(Bitmap bitmap, Rect rect) {
        if (a.f44839c) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
        int width = rect2.width() - 2;
        int height = rect2.height() - 2;
        int i = width / 3;
        int i2 = height / i;
        int ceil = (int) Math.ceil(i2 * 3 * this.f44840a);
        int i3 = 0;
        int i4 = 0;
        while (i4 < 3) {
            int i5 = rect2.left;
            int i6 = (i4 * i) + 1 + i5;
            int i7 = i4 == 2 ? width + 1 : ((i4 + 1) * i) + i5;
            int i8 = i3;
            int i9 = 0;
            while (i9 < i2) {
                int i10 = rect2.top;
                int i11 = i9;
                if (e(bitmap, i6, (i9 * i) + 1 + i10, i7, i9 == i2 + (-1) ? height + 1 : ((i9 + 1) * i) + i10)) {
                    int i12 = i8 + 1;
                    if (i12 >= ceil) {
                        return true;
                    }
                    i8 = i12;
                }
                i9 = i11 + 1;
            }
            i4++;
            i3 = i8;
        }
        return false;
    }

    public double d(Bitmap bitmap, Rect rect) {
        if (a.f44839c) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return 0.0d;
        }
        Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
        int width = rect2.width() - 2;
        int height = rect2.height() - 2;
        int i = width / 3;
        int i2 = height / i;
        int i3 = 0;
        int i4 = 0;
        while (i4 < 3) {
            int i5 = rect2.left;
            int i6 = (i4 * i) + 1 + i5;
            int i7 = i4 == 2 ? width + 1 : ((i4 + 1) * i) + i5;
            int i8 = i3;
            int i9 = 0;
            while (i9 < i2) {
                int i10 = rect2.top;
                int i11 = i9;
                if (e(bitmap, i6, (i9 * i) + 1 + i10, i7, i9 == i2 + (-1) ? height + 1 : ((i9 + 1) * i) + i10)) {
                    i8++;
                }
                i9 = i11 + 1;
            }
            i4++;
            i3 = i8;
        }
        return i3 / (i2 * 3);
    }

    public final boolean e(Bitmap bitmap, int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < i || i2 < 0 || i4 < i2) {
            return false;
        }
        int pixel = bitmap.getPixel(i, i2);
        while (i <= i3) {
            for (int i5 = i2; i5 <= i4; i5++) {
                if (pixel != bitmap.getPixel(i, i5)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
