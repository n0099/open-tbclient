package d.a.b0.d.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39367a = d.a.b0.a.a.a.f39286a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39368b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39369c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f39370d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f39371e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f39372f;

    /* renamed from: d.a.b0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0506a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f39373a;

        /* renamed from: b  reason: collision with root package name */
        public String f39374b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0506a threadFactoryC0506a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends AsyncTask<b, Object, Object> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Object doInBackground(b... bVarArr) {
            Process.setThreadPriority(10);
            try {
                if (bVarArr[0] == null || bVarArr[0].f39373a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f39374b) ? bVarArr[0].f39374b : "noname";
                Thread.currentThread().setName(str);
                if (a.f39367a) {
                    Log.d("AsyncTaskAssistant", "start to run task " + str);
                }
                bVarArr[0].f39373a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0506a threadFactoryC0506a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39368b = availableProcessors;
        f39369c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f39370d = Math.max(2, f39368b - 1);
        f39371e = new ThreadFactoryC0506a();
        f39372f = new LinkedBlockingQueue();
        if (f39367a) {
            Log.d("AsyncTaskAssistant", "core pool size: " + f39369c + " max size: " + f39370d);
        }
        int i2 = f39370d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f39372f, f39371e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f39373a = runnable;
        bVar.f39374b = str;
        new c(null).execute(bVar);
    }
}
