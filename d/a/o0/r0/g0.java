package d.a.o0.r0;

import android.text.TextUtils;
import android.util.SparseArray;
/* loaded from: classes4.dex */
public class g0 {

    /* renamed from: b  reason: collision with root package name */
    public static g0 f62399b = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<String> f62400a = new SparseArray<>();

    public static g0 a() {
        return f62399b;
    }

    public boolean b(int i2) {
        if (i2 > 100) {
            i2 = 100;
        }
        return !TextUtils.isEmpty(this.f62400a.get(i2));
    }

    public void c(int i2) {
        this.f62400a.put(i2, "1");
    }
}
