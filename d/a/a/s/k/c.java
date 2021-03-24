package d.a.a.s.k;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.j;
import d.a.a.q.b.p;
/* loaded from: classes.dex */
public class c extends a {
    public final Paint w;
    public final Rect x;
    public final Rect y;
    @Nullable
    public d.a.a.q.b.a<ColorFilter, ColorFilter> z;

    public c(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        this.w = new Paint(3);
        this.x = new Rect();
        this.y = new Rect();
    }

    @Nullable
    public final Bitmap C() {
        return this.n.p(this.o.k());
    }

    @Override // d.a.a.s.k.a, d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        super.c(rectF, matrix);
        Bitmap C = C();
        if (C != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, C.getWidth()), Math.min(rectF.bottom, C.getHeight()));
            this.m.mapRect(rectF);
        }
    }

    @Override // d.a.a.s.k.a, d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        super.d(t, cVar);
        if (t == j.x) {
            if (cVar == null) {
                this.z = null;
            } else {
                this.z = new p(cVar);
            }
        }
    }

    @Override // d.a.a.s.k.a
    public void m(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap C = C();
        if (C == null || C.isRecycled()) {
            return;
        }
        float e2 = d.a.a.v.f.e();
        this.w.setAlpha(i);
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.z;
        if (aVar != null) {
            this.w.setColorFilter(aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.x.set(0, 0, C.getWidth(), C.getHeight());
        this.y.set(0, 0, (int) (C.getWidth() * e2), (int) (C.getHeight() * e2));
        canvas.drawBitmap(C, this.x, this.y, this.w);
        canvas.restore();
    }
}
