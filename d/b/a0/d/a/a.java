package d.b.a0.d.a;

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
    public static final boolean f41893a = d.b.a0.a.a.a.f41815a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f41894b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f41895c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f41896d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f41897e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f41898f;

    /* renamed from: d.b.a0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0548a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f41899a;

        /* renamed from: b  reason: collision with root package name */
        public String f41900b;

        public b() {
        }

        public /* synthetic */ b(ThreadFactoryC0548a threadFactoryC0548a) {
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
                if (bVarArr[0] == null || bVarArr[0].f41899a == null) {
                    return null;
                }
                String str = !TextUtils.isEmpty(bVarArr[0].f41900b) ? bVarArr[0].f41900b : "noname";
                Thread.currentThread().setName(str);
                if (a.f41893a) {
                    Log.d("AsyncTaskAssistant", "start to run task " + str);
                }
                bVarArr[0].f41899a.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public /* synthetic */ c(ThreadFactoryC0548a threadFactoryC0548a) {
            this();
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f41894b = availableProcessors;
        f41895c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f41896d = Math.max(2, f41894b - 1);
        f41897e = new ThreadFactoryC0548a();
        f41898f = new LinkedBlockingQueue();
        if (f41893a) {
            Log.d("AsyncTaskAssistant", "core pool size: " + f41895c + " max size: " + f41896d);
        }
        int i = f41896d;
        new ThreadPoolExecutor(i, i, 30L, TimeUnit.SECONDS, f41898f, f41897e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        b bVar = new b(null);
        bVar.f41899a = runnable;
        bVar.f41900b = str;
        new c(null).execute(bVar);
    }
}
