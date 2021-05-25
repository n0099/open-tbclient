package d.a.n0.w3.u.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f63085a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f63086b;

    public a(Bitmap bitmap) {
        this.f63086b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f63086b, this.f63085a, null);
    }

    public Matrix b() {
        return this.f63085a;
    }

    public Bitmap c() {
        return this.f63086b;
    }

    public int d() {
        Bitmap bitmap = this.f63086b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f63086b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
