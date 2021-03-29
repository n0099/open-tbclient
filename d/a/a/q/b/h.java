package d.a.a.q.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class h extends d.a.a.w.a<PointF> {
    @Nullable
    public Path k;

    public h(d.a.a.d dVar, d.a.a.w.a<PointF> aVar) {
        super(dVar, aVar.f41451b, aVar.f41452c, aVar.f41453d, aVar.f41454e, aVar.f41455f);
        T t;
        T t2 = this.f41452c;
        boolean z = (t2 == 0 || (t = this.f41451b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f41452c;
        if (t3 == 0 || z) {
            return;
        }
        this.k = d.a.a.v.f.d((PointF) this.f41451b, (PointF) t3, aVar.i, aVar.j);
    }

    @Nullable
    public Path e() {
        return this.k;
    }
}
