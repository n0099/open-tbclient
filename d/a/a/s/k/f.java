package d.a.a.s.k;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.j;
import d.a.a.q.b.p;
/* loaded from: classes.dex */
public class f extends a {
    public final Layer A;
    @Nullable
    public d.a.a.q.b.a<ColorFilter, ColorFilter> B;
    public final RectF w;
    public final Paint x;
    public final float[] y;
    public final Path z;

    public f(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        this.w = new RectF();
        this.x = new Paint();
        this.y = new float[8];
        this.z = new Path();
        this.A = layer;
        this.x.setAlpha(0);
        this.x.setStyle(Paint.Style.FILL);
        this.x.setColor(layer.m());
    }

    @Override // d.a.a.s.k.a, d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        super.c(rectF, matrix);
        this.w.set(0.0f, 0.0f, this.A.o(), this.A.n());
        this.m.mapRect(this.w);
        rectF.set(this.w);
    }

    @Override // d.a.a.s.k.a, d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        super.d(t, cVar);
        if (t == j.x) {
            if (cVar == null) {
                this.B = null;
            } else {
                this.B = new p(cVar);
            }
        }
    }

    @Override // d.a.a.s.k.a
    public void m(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.A.m());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * this.u.g().h().intValue()) / 100.0f) * 255.0f);
        this.x.setAlpha(intValue);
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.B;
        if (aVar != null) {
            this.x.setColorFilter(aVar.h());
        }
        if (intValue > 0) {
            float[] fArr = this.y;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.A.o();
            float[] fArr2 = this.y;
            fArr2[3] = 0.0f;
            fArr2[4] = this.A.o();
            this.y[5] = this.A.n();
            float[] fArr3 = this.y;
            fArr3[6] = 0.0f;
            fArr3[7] = this.A.n();
            matrix.mapPoints(this.y);
            this.z.reset();
            Path path = this.z;
            float[] fArr4 = this.y;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.z;
            float[] fArr5 = this.y;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.z;
            float[] fArr6 = this.y;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.z;
            float[] fArr7 = this.y;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.z;
            float[] fArr8 = this.y;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.z.close();
            canvas.drawPath(this.z, this.x);
        }
    }
}
