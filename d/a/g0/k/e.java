package d.a.g0.k;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f40955b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f40956c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static long f40957d = 120;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f40958a;

    /* loaded from: classes2.dex */
    public class a implements FileFilter {
        public a(e eVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public e() {
        int a2 = (a() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a2 > 3 ? 3 : a2, f40956c, f40957d, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.f40958a = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new d());
    }

    public static e c() {
        synchronized (e.class) {
            if (f40955b == null) {
                f40955b = new e();
            }
        }
        return f40955b;
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }

    public void b(d.a.g0.k.a aVar) {
        try {
            this.f40958a.execute(aVar);
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
    }
}
