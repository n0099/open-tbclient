package d.a.o0.w3.u.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f66925a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f66926b;

    public a(Bitmap bitmap) {
        this.f66926b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f66926b, this.f66925a, null);
    }

    public Matrix b() {
        return this.f66925a;
    }

    public Bitmap c() {
        return this.f66926b;
    }

    public int d() {
        Bitmap bitmap = this.f66926b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f66926b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
