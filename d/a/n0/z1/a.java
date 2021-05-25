package d.a.n0.z1;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f63600b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f63601a;

    /* renamed from: d.a.n0.z1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1755a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public a() {
        int c2 = c();
        c2 = c2 <= 0 ? 1 : c2;
        int i2 = c2 > 4 ? 4 : c2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f63601a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static a b() {
        if (f63600b == null) {
            synchronized (a.class) {
                if (f63600b == null) {
                    f63600b = new a();
                }
            }
        }
        return f63600b;
    }

    public void a(Runnable runnable) {
        this.f63601a.execute(runnable);
    }

    public final int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1755a()).length;
        } catch (Exception unused) {
            return 1;
        }
    }
}
