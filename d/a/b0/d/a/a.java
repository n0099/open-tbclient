package d.a.b0.d.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38612a = d.a.b0.a.a.a.f38531a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f38613b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38614c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f38615d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f38616e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f38617f;

    /* renamed from: d.a.b0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0493a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f38618a;

        /* renamed from: b  reason: collision with root package name */
        public String f38619b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0493a threadFactoryC0493a) {
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
                if (bVarArr[0] == null || bVarArr[0].f38618a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f38619b) ? bVarArr[0].f38619b : "noname";
                Thread.currentThread().setName(str);
                if (a.f38612a) {
                    Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                }
                bVarArr[0].f38618a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0493a threadFactoryC0493a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f38613b = availableProcessors;
        f38614c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f38615d = Math.max(2, f38613b - 1);
        f38616e = new ThreadFactoryC0493a();
        f38617f = new LinkedBlockingQueue();
        if (f38612a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f38614c + " max size: " + f38615d);
        }
        int i2 = f38615d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f38617f, f38616e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f38618a = runnable;
        bVar.f38619b = str;
        new c(null).execute(bVar);
    }
}
