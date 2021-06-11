package d.a.n0.r0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f62274b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f62275a = new SparseArray<>();

    public static g0 a() {
        return f62274b;
    }

    public boolean b(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        return !TextUtils.isEmpty(this.f62275a.get(i2));
    }

    public void c(int i2) {
        this.f62275a.put(i2, "1");
    }
}
