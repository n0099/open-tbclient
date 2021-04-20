package d.b.h0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f50482b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f50483a = new SparseArray<>();

    public static b b() {
        if (f50482b == null) {
            synchronized (b.class) {
                if (f50482b == null) {
                    f50482b = new b();
                }
            }
        }
        return f50482b;
    }

    public View a(Context context, int i) {
        if (this.f50483a.get(i) != null) {
            return this.f50483a.get(i).a(context);
        }
        return null;
    }

    public void c(int i, d dVar) {
        this.f50483a.put(i, dVar);
    }
}
