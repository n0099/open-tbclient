package d.a.n0.k2;

import android.view.View;
/* loaded from: classes5.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f56813e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f56813e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f56813e.getTag()).startPlay();
    }
}
