package d.a.a.s.c;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class h extends d.a.a.y.a<PointF> {
    @Nullable
    public Path o;
    public final d.a.a.y.a<PointF> p;

    public h(d.a.a.d dVar, d.a.a.y.a<PointF> aVar) {
        super(dVar, aVar.f41801b, aVar.f41802c, aVar.f41803d, aVar.f41804e, aVar.f41805f);
        this.p = aVar;
        i();
    }

    public void i() {
        T t;
        T t2 = this.f41802c;
        boolean z = (t2 == 0 || (t = this.f41801b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f41802c;
        if (t3 == 0 || z) {
            return;
        }
        d.a.a.y.a<PointF> aVar = this.p;
        this.o = d.a.a.x.h.d((PointF) this.f41801b, (PointF) t3, aVar.m, aVar.n);
    }

    @Nullable
    public Path j() {
        return this.o;
    }
}
