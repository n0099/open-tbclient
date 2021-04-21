package d.b.b0.d.a;

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
    public static final boolean f42182a = d.b.b0.a.a.a.f42104a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42183b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42184c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f42185d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f42186e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f42187f;

    /* renamed from: d.b.b0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0567a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f42188a;

        /* renamed from: b  reason: collision with root package name */
        public String f42189b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0567a threadFactoryC0567a) {
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
                if (bVarArr[0] == null || bVarArr[0].f42188a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f42189b) ? bVarArr[0].f42189b : "noname";
                Thread.currentThread().setName(str);
                if (a.f42182a) {
                    Log.d("AsyncTaskAssistant", "start to run task " + str);
                }
                bVarArr[0].f42188a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0567a threadFactoryC0567a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42183b = availableProcessors;
        f42184c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f42185d = Math.max(2, f42183b - 1);
        f42186e = new ThreadFactoryC0567a();
        f42187f = new LinkedBlockingQueue();
        if (f42182a) {
            Log.d("AsyncTaskAssistant", "core pool size: " + f42184c + " max size: " + f42185d);
        }
        int i = f42185d;
        new ThreadPoolExecutor(i, i, 30L, TimeUnit.SECONDS, f42187f, f42186e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f42188a = runnable;
        bVar.f42189b = str;
        new c(null).execute(bVar);
    }
}
