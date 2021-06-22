package d.a.c.k.e;

import android.view.View;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public View f43017e = null;

    public abstract View a();

    public final View b() {
        if (this.f43017e == null) {
            this.f43017e = a();
        }
        return this.f43017e;
    }

    public abstract void c();
}
