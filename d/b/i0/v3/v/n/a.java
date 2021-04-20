package d.b.i0.v3.v.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f63584a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f63585b;

    public a(Bitmap bitmap) {
        this.f63585b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f63585b, this.f63584a, null);
    }

    public Matrix b() {
        return this.f63584a;
    }

    public Bitmap c() {
        return this.f63585b;
    }

    public int d() {
        Bitmap bitmap = this.f63585b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f63585b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
