package d.b.i0.u3.v.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f61846a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f61847b;

    public a(Bitmap bitmap) {
        this.f61847b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f61847b, this.f61846a, null);
    }

    public Matrix b() {
        return this.f61846a;
    }

    public Bitmap c() {
        return this.f61847b;
    }

    public int d() {
        Bitmap bitmap = this.f61847b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f61847b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
