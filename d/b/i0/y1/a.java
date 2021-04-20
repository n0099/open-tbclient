package d.b.i0.y1;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f64016b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f64017a;

    /* renamed from: d.b.i0.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1715a implements FileFilter {
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
        this.f64017a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static a b() {
        if (f64016b == null) {
            synchronized (a.class) {
                if (f64016b == null) {
                    f64016b = new a();
                }
            }
        }
        return f64016b;
    }

    public void a(Runnable runnable) {
        this.f64017a.execute(runnable);
    }

    public final int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1715a()).length;
        } catch (Exception unused) {
            return 1;
        }
    }
}
