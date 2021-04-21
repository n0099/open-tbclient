package d.a.a.u.i;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.y.a<V>> f41763a;

    public n(V v) {
        this(Collections.singletonList(new d.a.a.y.a(v)));
    }

    @Override // d.a.a.u.i.m
    public List<d.a.a.y.a<V>> b() {
        return this.f41763a;
    }

    @Override // d.a.a.u.i.m
    public boolean c() {
        return this.f41763a.isEmpty() || (this.f41763a.size() == 1 && this.f41763a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f41763a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f41763a.toArray()));
        }
        return sb.toString();
    }

    public n(List<d.a.a.y.a<V>> list) {
        this.f41763a = list;
    }
}
