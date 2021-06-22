package d.a.k0.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class d implements ThreadFactory {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicInteger f44276h = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f44277e;

    /* renamed from: f  reason: collision with root package name */
    public String f44278f;

    /* renamed from: g  reason: collision with root package name */
    public int f44279g;

    public d() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f44278f + this.f44277e.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i2 = this.f44279g;
        if (i2 != 5) {
            thread.setPriority(i2);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public d(int i2) {
        this.f44277e = new AtomicInteger(1);
        this.f44278f = "sso-" + f44276h.getAndIncrement() + "-thread-";
        this.f44279g = i2;
    }
}
