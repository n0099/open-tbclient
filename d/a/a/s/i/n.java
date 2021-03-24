package d.a.a.s.i;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.a.w.a<V>> f41363a;

    public n(V v) {
        this(Collections.singletonList(new d.a.a.w.a(v)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f41363a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f41363a.toArray()));
        }
        return sb.toString();
    }

    public n(List<d.a.a.w.a<V>> list) {
        this.f41363a = list;
    }
}
