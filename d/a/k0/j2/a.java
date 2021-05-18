package d.a.k0.j2;

import android.view.View;
/* loaded from: classes5.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f56633e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f56633e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f56633e.getTag()).startPlay();
    }
}
