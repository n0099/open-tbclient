package d.b.h0.a.i2;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<Runnable> f45473a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public Runnable f45474b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45475c = false;

    public synchronized boolean a() {
        boolean d2;
        d2 = d();
        this.f45475c = true;
        return d2;
    }

    public synchronized void b() {
        this.f45475c = false;
        c();
    }

    public final synchronized boolean c() {
        boolean d2;
        d2 = d();
        if (d2) {
            while (!this.f45473a.isEmpty()) {
                Runnable poll = this.f45473a.poll();
                this.f45474b = poll;
                if (poll != null) {
                    poll.run();
                }
            }
            this.f45474b = null;
        }
        return d2;
    }

    public final boolean d() {
        return !this.f45475c && this.f45474b == null;
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
                this.f45473a.offer(runnable);
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
