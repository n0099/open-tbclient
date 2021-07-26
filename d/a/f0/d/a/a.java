package d.a.f0.d.a;

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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42807a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42808b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42809c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f42810d;

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadFactory f42811e;

    /* renamed from: f  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f42812f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.f0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class ThreadFactoryC0599a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ThreadFactoryC0599a() {
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

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f42813a;

        /* renamed from: b  reason: collision with root package name */
        public String f42814b;

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

        public /* synthetic */ b(ThreadFactoryC0599a threadFactoryC0599a) {
            this();
        }
    }

    /* loaded from: classes7.dex */
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
                    if (bVarArr[0] == null || bVarArr[0].f42813a == null) {
                        return null;
                    }
                    String str = !TextUtils.isEmpty(bVarArr[0].f42814b) ? bVarArr[0].f42814b : "noname";
                    Thread.currentThread().setName(str);
                    if (a.f42807a) {
                        Log.d(AsyncTaskAssistant.TAG, "start to run task " + str);
                    }
                    bVarArr[0].f42813a.run();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return invokeL.objValue;
        }

        public /* synthetic */ c(ThreadFactoryC0599a threadFactoryC0599a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-672101837, "Ld/a/f0/d/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-672101837, "Ld/a/f0/d/a/a;");
                return;
            }
        }
        f42807a = d.a.f0.a.a.a.f42711a;
        new Handler(Looper.getMainLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42808b = availableProcessors;
        f42809c = Math.max(2, Math.min(availableProcessors - 1, 4));
        f42810d = Math.max(2, f42808b - 1);
        f42811e = new ThreadFactoryC0599a();
        f42812f = new LinkedBlockingQueue();
        if (f42807a) {
            Log.d(AsyncTaskAssistant.TAG, "core pool size: " + f42809c + " max size: " + f42810d);
        }
        int i2 = f42810d;
        new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, f42812f, f42811e).allowCoreThreadTimeOut(true);
    }

    public static void b(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, runnable, str) == null) {
            b bVar = new b(null);
            bVar.f42813a = runnable;
            bVar.f42814b = str;
            new c(null).execute(bVar);
        }
    }
}
