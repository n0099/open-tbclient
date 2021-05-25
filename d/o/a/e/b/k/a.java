package d.o.a.e.b.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class a implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public final String f67324e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f67325f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f67326g;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f67325f.incrementAndGet();
        Thread thread = new Thread(runnable, this.f67324e + "-" + incrementAndGet);
        if (!this.f67326g) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public a(String str, boolean z) {
        this.f67325f = new AtomicInteger();
        this.f67324e = str;
        this.f67326g = z;
    }
}
