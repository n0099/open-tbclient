package d.a.a.q.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class h extends d.a.a.w.a<PointF> {
    @Nullable
    public Path k;

    public h(d.a.a.d dVar, d.a.a.w.a<PointF> aVar) {
        super(dVar, aVar.f41450b, aVar.f41451c, aVar.f41452d, aVar.f41453e, aVar.f41454f);
        T t;
        T t2 = this.f41451c;
        boolean z = (t2 == 0 || (t = this.f41450b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f41451c;
        if (t3 == 0 || z) {
            return;
        }
        this.k = d.a.a.v.f.d((PointF) this.f41450b, (PointF) t3, aVar.i, aVar.j);
    }

    @Nullable
    public Path e() {
        return this.k;
    }
}
