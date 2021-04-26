package d.a.c.j.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f40324e = null;

    public abstract View a();

    public final View b() {
        if (this.f40324e == null) {
            this.f40324e = a();
        }
        return this.f40324e;
    }

    public abstract void c();
}
