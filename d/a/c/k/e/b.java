package d.a.c.k.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f42914e = null;

    public abstract View a();

    public final View b() {
        if (this.f42914e == null) {
            this.f42914e = a();
        }
        return this.f42914e;
    }

    public abstract void c();
}
