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
    public static volatile f f67723c;

    /* renamed from: a  reason: collision with root package name */
    public c f67724a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67725b;

    /* loaded from: classes7.dex */
    public static class b implements c {

        /* renamed from: e  reason: collision with root package name */
        public Handler f67726e;

        public b() {
            this.f67726e = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f67726e.post(runnable);
        }
    }

    /* loaded from: classes7.dex */
    public interface c extends Executor {
    }

    public f() {
        this(Executors.newSingleThreadExecutor(), Executors.newScheduledThreadPool(5), new b());
    }

    public static f a() {
        if (f67723c == null) {
            synchronized (f.class) {
                if (f67723c == null) {
                    f67723c = new f();
                }
            }
        }
        return f67723c;
    }

    public c b() {
        return this.f67724a;
    }

    public ScheduledExecutorService c() {
        return this.f67725b;
    }

    public f(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, c cVar) {
        this.f67725b = scheduledExecutorService;
        this.f67724a = cVar;
    }
}
