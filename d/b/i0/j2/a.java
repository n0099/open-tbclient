package d.b.i0.j2;

import android.view.View;
/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f57530e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f57530e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f57530e.getTag()).startPlay();
    }
}
