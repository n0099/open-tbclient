package d.a.m0.a.v2;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class y0 {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f49290a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f49291b = null;

    public synchronized boolean a(Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        z = runnable == null;
        if (!z) {
            this.f49290a.offer(runnable);
        }
        z2 = this.f49291b == null && !this.f49290a.isEmpty();
        if (z2) {
            while (!this.f49290a.isEmpty()) {
                Runnable poll = this.f49290a.poll();
                this.f49291b = poll;
                if (poll != null) {
                    poll.run();
                }
                this.f49291b = null;
            }
        }
        return (z || !z2) ? false : false;
    }
}
