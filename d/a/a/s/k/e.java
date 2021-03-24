package d.a.a.s.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.s.j.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a {
    public final d.a.a.q.a.c w;

    public e(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        d.a.a.q.a.c cVar = new d.a.a.q.a.c(fVar, this, new j("__container", layer.l()));
        this.w = cVar;
        cVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // d.a.a.s.k.a, d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        super.c(rectF, matrix);
        this.w.c(rectF, this.m);
    }

    @Override // d.a.a.s.k.a
    public void m(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.w.g(canvas, matrix, i);
    }

    @Override // d.a.a.s.k.a
    public void v(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        this.w.e(eVar, i, list, eVar2);
    }
}
