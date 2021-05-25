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
    public static final boolean f39681a = d.a.d0.a.a.a.f39588a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39682b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39683c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f39684d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f39685e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f39686f;

    /* renamed from: d.a.d0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0522a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f39687a;

        /* renamed from: b  reason: collision with root package name */
        public String f39688b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0522a threadFactoryC0522a) {
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
                if (bVarArr[0] == null || bVarArr[0].f39687a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f39688b) ? bVarArr[0].f39688b : "noname";
                Thread.currentThread().setName(str);
                if (a.f39681a) {
                    Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                }
                bVarArr[0].f39687a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0522a threadFactoryC0522a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f39682b = availableProcessors;
        f39683c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f39684d = Math.max(2, f39682b - 1);
        f39685e = new ThreadFactoryC0522a();
        f39686f = new LinkedBlockingQueue();
        if (f39681a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f39683c + " max size: " + f39684d);
        }
        int i2 = f39684d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f39686f, f39685e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f39687a = runnable;
        bVar.f39688b = str;
        new c(null).execute(bVar);
    }
}
