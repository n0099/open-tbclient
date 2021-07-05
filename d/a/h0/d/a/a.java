package d.a.h0.d.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45655a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f45656b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f45657c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f45658d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f45659e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f45660f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.h0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class ThreadFactoryC0641a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ThreadFactoryC0641a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) ? new Thread(runnable) : (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f45661a;

        /* renamed from: b  reason: collision with root package name */
        public String f45662b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(ThreadFactoryC0641a threadFactoryC0641a) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends AsyncTask<b, Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Object doInBackground(b... bVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
                Process.setThreadPriority(10);
                try {
                    if (bVarArr[0] == null || bVarArr[0].f45661a == null) {
                        return null;
                    }
                    String str = !TextUtils.isEmpty(bVarArr[0].f45662b) ? bVarArr[0].f45662b : "noname";
                    Thread.currentThread().setName(str);
                    if (a.f45655a) {
                        Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                    }
                    bVarArr[0].f45661a.run();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return invokeL.objValue;
        }

        public /* synthetic */ c(ThreadFactoryC0641a threadFactoryC0641a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(7956533, "Ld/a/h0/d/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(7956533, "Ld/a/h0/d/a/a;");
                return;
            }
        }
        f45655a = d.a.h0.a.a.a.f45559a;
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f45656b = availableProcessors;
        f45657c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f45658d = Math.max(2, f45656b - 1);
        f45659e = new ThreadFactoryC0641a();
        f45660f = new LinkedBlockingQueue();
        if (f45655a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f45657c + " max size: " + f45658d);
        }
        int i2 = f45658d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f45660f, f45659e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, runnable, str) == null) {
            b bVar = new b(null);
            bVar.f45661a = runnable;
            bVar.f45662b = str;
            new c(null).execute(bVar);
        }
    }
}
