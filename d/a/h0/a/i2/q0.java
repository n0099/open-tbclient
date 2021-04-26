package d.a.h0.a.i2;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f42791a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f42792b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42793c = false;

    public synchronized boolean a() {
        boolean d2;
        d2 = d();
        this.f42793c = true;
        return d2;
    }

    public synchronized void b() {
        this.f42793c = false;
        c();
    }

    public final synchronized boolean c() {
        boolean d2;
        d2 = d();
        if (d2) {
            while (!this.f42791a.isEmpty()) {
                Runnable poll = this.f42791a.poll();
                this.f42792b = poll;
                if (poll != null) {
                    poll.run();
                }
            }
            this.f42792b = null;
        }
        return d2;
    }

    public final boolean d() {
        return !this.f42793c && this.f42792b == null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
        if (c() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean e(Runnable runnable) {
        boolean z;
        z = true;
        boolean z2 = runnable == null;
        if (!z2) {
            try {
                this.f42791a.offer(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
        }
        z = false;
        return z;
    }
}
