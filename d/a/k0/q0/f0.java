package d.a.k0.q0;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class f0 extends SparseArray<p0> {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f58413e = null;

    public void a(int i2, p0 p0Var) {
        if (i2 > 100) {
            i2 = 100;
        }
        put(i2, p0Var);
    }

    public void b() {
        for (int i2 = 0; i2 < size(); i2++) {
            p0 valueAt = valueAt(i2);
            if (valueAt != null) {
                valueAt.p(null);
                valueAt.e();
            }
        }
    }

    public p0 c(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        return get(i2);
    }

    public void d() {
        for (int i2 = 0; i2 < size(); i2++) {
            p0 valueAt = valueAt(i2);
            if (valueAt != null) {
                valueAt.init();
            }
        }
    }

    public void e(t0 t0Var) {
        for (int i2 = 0; i2 < size(); i2++) {
            p0 valueAt = valueAt(i2);
            if (valueAt != null) {
                valueAt.p(t0Var);
            }
        }
    }
}
