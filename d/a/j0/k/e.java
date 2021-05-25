package d.a.j0.k;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f40461b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f40462c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static long f40463d = 120;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f40464a;

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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a2 > 3 ? 3 : a2, f40462c, f40463d, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.f40464a = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new d());
    }

    public static e c() {
        synchronized (e.class) {
            if (f40461b == null) {
                f40461b = new e();
            }
        }
        return f40461b;
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable unused) {
            return 2;
        }
    }

    public void b(d.a.j0.k.a aVar) {
        try {
            this.f40464a.execute(aVar);
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
    }
}
