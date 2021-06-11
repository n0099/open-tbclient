package d.a.m0.d;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f52939b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<e> f52940a = new SparseArray<>();

    public static c b() {
        if (f52939b == null) {
            synchronized (c.class) {
                if (f52939b == null) {
                    f52939b = new c();
                }
            }
        }
        return f52939b;
    }

    public View a(Context context, int i2) {
        if (this.f52940a.get(i2) != null) {
            return this.f52940a.get(i2).a(context);
        }
        return null;
    }

    public void c(int i2, e eVar) {
        this.f52940a.put(i2, eVar);
    }
}
