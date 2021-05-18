package d.a.k0.q0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f58442b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f58443a = new SparseArray<>();

    public static g0 a() {
        return f58442b;
    }

    public boolean b(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        return !TextUtils.isEmpty(this.f58443a.get(i2));
    }

    public void c(int i2) {
        this.f58443a.put(i2, "1");
    }
}
