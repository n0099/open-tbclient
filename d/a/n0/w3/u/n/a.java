package d.a.n0.w3.u.n;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Matrix f66800a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f66801b;

    public a(Bitmap bitmap) {
        this.f66801b = bitmap;
    }

    public void a(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(this.f66801b, this.f66800a, null);
    }

    public Matrix b() {
        return this.f66800a;
    }

    public Bitmap c() {
        return this.f66801b;
    }

    public int d() {
        Bitmap bitmap = this.f66801b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int e() {
        Bitmap bitmap = this.f66801b;
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }
}
