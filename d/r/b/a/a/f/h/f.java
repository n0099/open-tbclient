package d.r.b.a.a.f.h;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static volatile f f67037c;

    /* renamed from: a  reason: collision with root package name */
    public c f67038a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67039b;

    /* loaded from: classes7.dex */
    public static class b implements c {

        /* renamed from: e  reason: collision with root package name */
        public Handler f67040e;

        public b() {
            this.f67040e = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f67040e.post(runnable);
        }
    }

    /* loaded from: classes7.dex */
    public interface c extends Executor {
    }

    public f() {
        this(Executors.newSingleThreadExecutor(), Executors.newScheduledThreadPool(5), new b());
    }

    public static f a() {
        if (f67037c == null) {
            synchronized (f.class) {
                if (f67037c == null) {
                    f67037c = new f();
                }
            }
        }
        return f67037c;
    }

    public c b() {
        return this.f67038a;
    }

    public ScheduledExecutorService c() {
        return this.f67039b;
    }

    public f(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, c cVar) {
        this.f67039b = scheduledExecutorService;
        this.f67038a = cVar;
    }
}
