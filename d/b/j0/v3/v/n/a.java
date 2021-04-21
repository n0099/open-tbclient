package d.b.j0.v3.v.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f64005a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f64006b;

    public a(Bitmap bitmap) {
        this.f64006b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f64006b, this.f64005a, null);
    }

    public Matrix b() {
        return this.f64005a;
    }

    public Bitmap c() {
        return this.f64006b;
    }

    public int d() {
        Bitmap bitmap = this.f64006b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f64006b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
