package d.b.i0.q0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class f0 extends SparseArray<p0> {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f59193e = null;

    public void a(int i, p0 p0Var) {
        if (i > 100) {
            i = 100;
        }
        put(i, p0Var);
    }

    public void b() {
        for (int i = 0; i < size(); i++) {
            p0 valueAt = valueAt(i);
            if (valueAt != null) {
                valueAt.o(null);
                valueAt.j();
            }
        }
    }

    public p0 c(int i) {
        if (i > 100) {
            i = 100;
        }
        return get(i);
    }

    public void d() {
        for (int i = 0; i < size(); i++) {
            p0 valueAt = valueAt(i);
            if (valueAt != null) {
                valueAt.init();
            }
        }
    }

    public void e(t0 t0Var) {
        for (int i = 0; i < size(); i++) {
            p0 valueAt = valueAt(i);
            if (valueAt != null) {
                valueAt.o(t0Var);
            }
        }
    }
}
