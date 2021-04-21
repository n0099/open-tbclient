package d.b.i0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f50818b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f50819a = new SparseArray<>();

    public static b b() {
        if (f50818b == null) {
            synchronized (b.class) {
                if (f50818b == null) {
                    f50818b = new b();
                }
            }
        }
        return f50818b;
    }

    public View a(Context context, int i) {
        if (this.f50819a.get(i) != null) {
            return this.f50819a.get(i).a(context);
        }
        return null;
    }

    public void c(int i, d dVar) {
        this.f50819a.put(i, dVar);
    }
}
