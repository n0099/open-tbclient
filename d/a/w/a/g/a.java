package d.a.w.a.g;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w.a.h.e;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f70856c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f70857d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f70858e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f70859f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f70860a;

    /* renamed from: b  reason: collision with root package name */
    public Context f70861b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1763162387, "Ld/a/w/a/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1763162387, "Ld/a/w/a/g/a;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f70857d = availableProcessors;
        f70858e = Math.max(2, Math.min(availableProcessors - 1, 4));
        f70859f = (f70857d * 2) + 1;
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70860a = null;
        this.f70861b = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f70858e, f70859f, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f70860a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Executors.newSingleThreadExecutor();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (f70856c == null) {
                synchronized (a.class) {
                    if (f70856c == null) {
                        f70856c = new a(context);
                    }
                }
            }
            return f70856c;
        }
        return (a) invokeL.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.f70860a.submit(runnable);
            } catch (Throwable th) {
                e.c("TaskManager", "Exception ", th);
            }
        }
    }
}
