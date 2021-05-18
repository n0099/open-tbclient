package d.a.i0.a.n2.h;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43650f;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f43651e = Thread.getDefaultUncaughtExceptionHandler();

    @UiThread
    public static void a() {
        if (f43650f != null) {
            return;
        }
        f43650f = new a();
        Thread.setDefaultUncaughtExceptionHandler(f43650f);
    }

    public static void c() {
        if (f43650f == null) {
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        a aVar = f43650f;
        if (defaultUncaughtExceptionHandler == aVar) {
            Thread.setDefaultUncaughtExceptionHandler(aVar.f43651e);
            f43650f = null;
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
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f43651e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
