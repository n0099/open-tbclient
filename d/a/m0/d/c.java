package d.a.m0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f49265b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<e> f49266a = new SparseArray<>();

    public static c b() {
        if (f49265b == null) {
            synchronized (c.class) {
                if (f49265b == null) {
                    f49265b = new c();
                }
            }
        }
        return f49265b;
    }

    public View a(Context context, int i2) {
        if (this.f49266a.get(i2) != null) {
            return this.f49266a.get(i2).a(context);
        }
        return null;
    }

    public void c(int i2, e eVar) {
        this.f49266a.put(i2, eVar);
    }
}
