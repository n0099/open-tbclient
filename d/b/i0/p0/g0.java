package d.b.i0.p0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f57520b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f57521a = new SparseArray<>();

    public static g0 a() {
        return f57520b;
    }

    public boolean b(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.f57521a.get(i));
    }

    public void c(int i) {
        this.f57521a.put(i, "1");
    }
}
