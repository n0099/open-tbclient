package d.a.i0.a.v2;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f45332a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f45333b = null;

    public synchronized boolean a(Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        z = runnable == null;
        if (!z) {
            this.f45332a.offer(runnable);
        }
        z2 = this.f45333b == null && !this.f45332a.isEmpty();
        if (z2) {
            while (!this.f45332a.isEmpty()) {
                Runnable poll = this.f45332a.poll();
                this.f45333b = poll;
                if (poll != null) {
                    poll.run();
                }
                this.f45333b = null;
            }
        }
        return (z || !z2) ? false : false;
    }
}
