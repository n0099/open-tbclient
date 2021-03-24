package d.b.i0.p0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f57519b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f57520a = new SparseArray<>();

    public static g0 a() {
        return f57519b;
    }

    public boolean b(int i) {
        if (i > 100) {
            i = 100;
        }
        return !TextUtils.isEmpty(this.f57520a.get(i));
    }

    public void c(int i) {
        this.f57520a.put(i, "1");
    }
}
