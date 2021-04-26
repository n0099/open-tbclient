package d.a.i0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f48393b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<e> f48394a = new SparseArray<>();

    public static c b() {
        if (f48393b == null) {
            synchronized (c.class) {
                if (f48393b == null) {
                    f48393b = new c();
                }
            }
        }
        return f48393b;
    }

    public View a(Context context, int i2) {
        if (this.f48394a.get(i2) != null) {
            return this.f48394a.get(i2).a(context);
        }
        return null;
    }

    public void c(int i2, e eVar) {
        this.f48394a.put(i2, eVar);
    }
}
