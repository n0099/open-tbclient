package d.a.c.j.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f39233e = null;

    public abstract View a();

    public final View b() {
        if (this.f39233e == null) {
            this.f39233e = a();
        }
        return this.f39233e;
    }

    public abstract void c();
}
