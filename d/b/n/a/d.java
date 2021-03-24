package d.b.n.a;

import android.view.Choreographer;
/* loaded from: classes2.dex */
public final class d implements Runnable {
    public d(b bVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().postFrameCallback(b.j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
