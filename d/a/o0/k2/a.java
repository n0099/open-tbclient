package d.a.o0.k2;

import android.view.View;
/* loaded from: classes5.dex */
public class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public View f60627e;

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f60627e;
        if (view == null || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) this.f60627e.getTag()).startPlay();
    }
}
