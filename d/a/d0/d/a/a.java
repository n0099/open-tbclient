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
    public static final boolean f43362a = d.a.d0.a.a.a.f43269a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f43363b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f43364c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f43365d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f43366e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f43367f;

    /* renamed from: d.a.d0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0578a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f43368a;

        /* renamed from: b  reason: collision with root package name */
        public String f43369b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0578a threadFactoryC0578a) {
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
                if (bVarArr[0] == null || bVarArr[0].f43368a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f43369b) ? bVarArr[0].f43369b : "noname";
                Thread.currentThread().setName(str);
                if (a.f43362a) {
                    Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                }
                bVarArr[0].f43368a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0578a threadFactoryC0578a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f43363b = availableProcessors;
        f43364c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f43365d = Math.max(2, f43363b - 1);
        f43366e = new ThreadFactoryC0578a();
        f43367f = new LinkedBlockingQueue();
        if (f43362a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f43364c + " max size: " + f43365d);
        }
        int i2 = f43365d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f43367f, f43366e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f43368a = runnable;
        bVar.f43369b = str;
        new c(null).execute(bVar);
    }
}
