package d.o.a.e.b.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class a implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public final String f67281e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f67282f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f67283g;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.f67282f.incrementAndGet();
        Thread thread = new Thread(runnable, this.f67281e + "-" + incrementAndGet);
        if (!this.f67283g) {
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
        this.f67282f = new AtomicInteger();
        this.f67281e = str;
        this.f67283g = z;
    }
}
