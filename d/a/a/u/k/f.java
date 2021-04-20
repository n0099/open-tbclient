package d.a.a.u.k;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.k;
import d.a.a.s.c.p;
/* loaded from: classes.dex */
public class f extends a {
    public final Path A;
    public final Layer B;
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> C;
    public final RectF x;
    public final Paint y;
    public final float[] z;

    public f(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        this.x = new RectF();
        this.y = new d.a.a.s.a();
        this.z = new float[8];
        this.A = new Path();
        this.B = layer;
        this.y.setAlpha(0);
        this.y.setStyle(Paint.Style.FILL);
        this.y.setColor(layer.m());
    }

    @Override // d.a.a.u.k.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == k.C) {
            if (cVar == null) {
                this.C = null;
            } else {
                this.C = new p(cVar);
            }
        }
    }

    @Override // d.a.a.u.k.a, d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        this.x.set(0.0f, 0.0f, this.B.o(), this.B.n());
        this.m.mapRect(this.x);
        rectF.set(this.x);
    }

    @Override // d.a.a.u.k.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.B.m());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        this.y.setAlpha(intValue);
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.C;
        if (aVar != null) {
            this.y.setColorFilter(aVar.h());
        }
        if (intValue > 0) {
            float[] fArr = this.z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.B.o();
            float[] fArr2 = this.z;
            fArr2[3] = 0.0f;
            fArr2[4] = this.B.o();
            this.z[5] = this.B.n();
            float[] fArr3 = this.z;
            fArr3[6] = 0.0f;
            fArr3[7] = this.B.n();
            matrix.mapPoints(this.z);
            this.A.reset();
            Path path = this.A;
            float[] fArr4 = this.z;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.A;
            float[] fArr5 = this.z;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.A;
            float[] fArr6 = this.z;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.A;
            float[] fArr7 = this.z;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.A;
            float[] fArr8 = this.z;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.A.close();
            canvas.drawPath(this.A, this.y);
        }
    }
}
