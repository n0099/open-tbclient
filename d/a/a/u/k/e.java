package d.a.a.u.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.u.j.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class e extends a {
    public final d.a.a.s.b.d x;

    public e(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        d.a.a.s.b.d dVar = new d.a.a.s.b.d(fVar, this, new j("__container", layer.l(), false));
        this.x = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // d.a.a.u.k.a
    public void D(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        this.x.d(dVar, i, list, dVar2);
    }

    @Override // d.a.a.u.k.a, d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        this.x.e(rectF, this.m, z);
    }

    @Override // d.a.a.u.k.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.x.g(canvas, matrix, i);
    }
}
