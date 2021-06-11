package d.a.n0.k2;

import android.view.View;
/* loaded from: classes5.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f60502e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f60502e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f60502e.getTag()).startPlay();
    }
}
