package d.o.a.e.b.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class a implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public final String f71214e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f71215f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f71216g;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f71215f.incrementAndGet();
        Thread thread = new Thread(runnable, this.f71214e + "-" + incrementAndGet);
        if (!this.f71216g) {
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
        this.f71215f = new AtomicInteger();
        this.f71214e = str;
        this.f71216g = z;
    }
}
