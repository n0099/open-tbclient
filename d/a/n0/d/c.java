package d.a.n0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f53046b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<e> f53047a = new SparseArray<>();

    public static c b() {
        if (f53046b == null) {
            synchronized (c.class) {
                if (f53046b == null) {
                    f53046b = new c();
                }
            }
        }
        return f53046b;
    }

    public View a(Context context, int i2) {
        if (this.f53047a.get(i2) != null) {
            return this.f53047a.get(i2).a(context);
        }
        return null;
    }

    public void c(int i2, e eVar) {
        this.f53047a.put(i2, eVar);
    }
}
