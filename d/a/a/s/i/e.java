package d.a.a.s.i;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.w.a<PointF>> f41349a;

    public e() {
        this.f41349a = Collections.singletonList(new d.a.a.w.a(new PointF(0.0f, 0.0f)));
    }

    @Override // d.a.a.s.i.m
    public d.a.a.q.b.a<PointF, PointF> a() {
        if (this.f41349a.get(0).d()) {
            return new d.a.a.q.b.j(this.f41349a);
        }
        return new d.a.a.q.b.i(this.f41349a);
    }

    public e(List<d.a.a.w.a<PointF>> list) {
        this.f41349a = list;
    }
}
