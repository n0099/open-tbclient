package d.a.m.a;

import android.view.Choreographer;
/* loaded from: classes.dex */
public final class e implements Runnable {
    public e(b bVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Choreographer.getInstance().removeFrameCallback(b.j);
            com.baidu.crabsdk.c.a.b("stop FrameMonitor !!");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
