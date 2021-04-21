package d.b.j0.q0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f59640b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f59641a = new SparseArray<>();

    public static g0 a() {
        return f59640b;
    }

    public boolean b(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.f59641a.get(i));
    }

    public void c(int i) {
        this.f59641a.put(i, "1");
    }
}
