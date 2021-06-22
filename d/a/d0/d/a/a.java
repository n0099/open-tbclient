package d.a.d0.d.a;

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
    public static final boolean f43465a = d.a.d0.a.a.a.f43372a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f43466b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f43467c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f43468d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f43469e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f43470f;

    /* renamed from: d.a.d0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0581a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f43471a;

        /* renamed from: b  reason: collision with root package name */
        public String f43472b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0581a threadFactoryC0581a) {
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
                if (bVarArr[0] == null || bVarArr[0].f43471a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f43472b) ? bVarArr[0].f43472b : "noname";
                Thread.currentThread().setName(str);
                if (a.f43465a) {
                    Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                }
                bVarArr[0].f43471a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0581a threadFactoryC0581a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f43466b = availableProcessors;
        f43467c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f43468d = Math.max(2, f43466b - 1);
        f43469e = new ThreadFactoryC0581a();
        f43470f = new LinkedBlockingQueue();
        if (f43465a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f43467c + " max size: " + f43468d);
        }
        int i2 = f43468d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f43470f, f43469e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f43471a = runnable;
        bVar.f43472b = str;
        new c(null).execute(bVar);
    }
}
