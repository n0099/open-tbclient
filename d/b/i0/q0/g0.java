package d.b.i0.q0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f59219b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f59220a = new SparseArray<>();

    public static g0 a() {
        return f59219b;
    }

    public boolean b(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.f59220a.get(i));
    }

    public void c(int i) {
        this.f59220a.put(i, "1");
    }
}
