package d.a.l0.a.n2.h;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43824f;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f43825e = Thread.getDefaultUncaughtExceptionHandler();

    @UiThread
    public static void a() {
        if (f43824f != null) {
            return;
        }
        f43824f = new a();
        Thread.setDefaultUncaughtExceptionHandler(f43824f);
    }

    public static void c() {
        if (f43824f == null) {
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        a aVar = f43824f;
        if (defaultUncaughtExceptionHandler == aVar) {
            Thread.setDefaultUncaughtExceptionHandler(aVar.f43825e);
            f43824f = null;
        }
    }

    public final void b() {
        b.h("memory_alert_crash", null);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        if (th instanceof OutOfMemoryError) {
            try {
                b();
            } catch (Throwable unused) {
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f43825e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
