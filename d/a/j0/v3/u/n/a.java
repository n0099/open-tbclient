package d.a.j0.v3.u.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f62252a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f62253b;

    public a(Bitmap bitmap) {
        this.f62253b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f62253b, this.f62252a, null);
    }

    public Matrix b() {
        return this.f62252a;
    }

    public Bitmap c() {
        return this.f62253b;
    }

    public int d() {
        Bitmap bitmap = this.f62253b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f62253b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
