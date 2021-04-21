package d.b.c.j.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f43099e = null;

    public abstract View a();

    public final View b() {
        if (this.f43099e == null) {
            this.f43099e = a();
        }
        return this.f43099e;
    }

    public abstract void c();
}
