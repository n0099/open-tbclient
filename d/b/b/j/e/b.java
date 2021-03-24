package d.b.b.j.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f42361e = null;

    public abstract View a();

    public final View b() {
        if (this.f42361e == null) {
            this.f42361e = a();
        }
        return this.f42361e;
    }

    public abstract void c();
}
