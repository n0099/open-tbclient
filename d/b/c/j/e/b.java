package d.b.c.j.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f42859e = null;

    public abstract View a();

    public final View b() {
        if (this.f42859e == null) {
            this.f42859e = a();
        }
        return this.f42859e;
    }

    public abstract void c();
}
