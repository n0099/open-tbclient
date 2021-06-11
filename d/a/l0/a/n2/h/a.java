package d.a.l0.a.n2.h;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f47500f;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f47501e = Thread.getDefaultUncaughtExceptionHandler();

    @UiThread
    public static void a() {
        if (f47500f != null) {
            return;
        }
        f47500f = new a();
        Thread.setDefaultUncaughtExceptionHandler(f47500f);
    }

    public static void c() {
        if (f47500f == null) {
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        a aVar = f47500f;
        if (defaultUncaughtExceptionHandler == aVar) {
            Thread.setDefaultUncaughtExceptionHandler(aVar.f47501e);
            f47500f = null;
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
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f47501e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
