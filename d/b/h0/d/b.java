package d.b.h0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f50089b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<d> f50090a = new SparseArray<>();

    public static b b() {
        if (f50089b == null) {
            synchronized (b.class) {
                if (f50089b == null) {
                    f50089b = new b();
                }
            }
        }
        return f50089b;
    }

    public View a(Context context, int i) {
        if (this.f50090a.get(i) != null) {
            return this.f50090a.get(i).a(context);
        }
        return null;
    }

    public void c(int i, d dVar) {
        this.f50090a.put(i, dVar);
    }
}
