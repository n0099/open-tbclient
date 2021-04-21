package d.b.j0.j2;

import android.view.View;
/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f57951e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f57951e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f57951e.getTag()).startPlay();
    }
}
