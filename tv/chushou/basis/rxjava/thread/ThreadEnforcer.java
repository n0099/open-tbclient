package tv.chushou.basis.rxjava.thread;

import android.os.Looper;
import tv.chushou.basis.rxjava.Bus;
/* loaded from: classes5.dex */
public interface ThreadEnforcer {
    public static final ThreadEnforcer ANY = new ThreadEnforcer() { // from class: tv.chushou.basis.rxjava.thread.ThreadEnforcer.1
        @Override // tv.chushou.basis.rxjava.thread.ThreadEnforcer
        public void enforce(Bus bus) {
        }
    };
    public static final ThreadEnforcer MAIN = new ThreadEnforcer() { // from class: tv.chushou.basis.rxjava.thread.ThreadEnforcer.2
        @Override // tv.chushou.basis.rxjava.thread.ThreadEnforcer
        public void enforce(Bus bus) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("Event bus " + bus + " accessed from non-main thread " + Looper.myLooper());
            }
        }
    };

    void enforce(Bus bus);
}
