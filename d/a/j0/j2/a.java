package d.a.j0.j2;

import android.view.View;
/* loaded from: classes4.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f55926e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f55926e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f55926e.getTag()).startPlay();
    }
}
