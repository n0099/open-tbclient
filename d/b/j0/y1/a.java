package d.b.j0.y1;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f64437b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64438a;

    /* renamed from: d.b.j0.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1738a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public a() {
        int c2 = c();
        c2 = c2 <= 0 ? 1 : c2;
        int i = c2 > 4 ? 4 : c2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64438a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static a b() {
        if (f64437b == null) {
            synchronized (a.class) {
                if (f64437b == null) {
                    f64437b = new a();
                }
            }
        }
        return f64437b;
    }

    public void a(Runnable runnable) {
        this.f64438a.execute(runnable);
    }

    public final int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1738a()).length;
        } catch (Exception unused) {
            return 1;
        }
    }
}
