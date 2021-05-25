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
    public static volatile f f67766c;

    /* renamed from: a  reason: collision with root package name */
    public c f67767a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67768b;

    /* loaded from: classes7.dex */
    public static class b implements c {

        /* renamed from: e  reason: collision with root package name */
        public Handler f67769e;

        public b() {
            this.f67769e = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f67769e.post(runnable);
        }
    }

    /* loaded from: classes7.dex */
    public interface c extends Executor {
    }

    public f() {
        this(Executors.newSingleThreadExecutor(), Executors.newScheduledThreadPool(5), new b());
    }

    public static f a() {
        if (f67766c == null) {
            synchronized (f.class) {
                if (f67766c == null) {
                    f67766c = new f();
                }
            }
        }
        return f67766c;
    }

    public c b() {
        return this.f67767a;
    }

    public ScheduledExecutorService c() {
        return this.f67768b;
    }

    public f(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, c cVar) {
        this.f67768b = scheduledExecutorService;
        this.f67767a = cVar;
    }
}
