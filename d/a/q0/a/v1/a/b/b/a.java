package d.a.q0.a.v1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51204d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f51205e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.q0.a.v1.a.b.c.a<d.a.q0.a.v1.a.b.a.b>> f51206a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f51207b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0995a f51208c;

    /* renamed from: d.a.q0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0995a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0995a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f51209e;

        /* renamed from: f  reason: collision with root package name */
        public String f51210f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51209e = new WeakReference<>(aVar);
            this.f51210f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f51209e.get()) == null) {
                return;
            }
            if (a.f51204d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f51210f);
            }
            d.a.q0.a.v1.a.b.a.b bVar = new d.a.q0.a.v1.a.b.a.b(this.f51210f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1233095101, "Ld/a/q0/a/v1/a/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1233095101, "Ld/a/q0/a/v1/a/b/b/a;");
                return;
            }
        }
        f51204d = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51206a = new ConcurrentHashMap<>();
        this.f51207b = new ConcurrentHashMap<>();
        this.f51208c = new HandlerC0995a(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f51205e == null) {
                synchronized (a.class) {
                    if (f51205e == null) {
                        f51205e = new a();
                    }
                }
            }
            return f51205e;
        }
        return (a) invokeV.objValue;
    }

    public void c(@NonNull d.a.q0.a.v1.a.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            d.a.q0.a.v1.a.b.c.a<d.a.q0.a.v1.a.b.a.b> aVar = this.f51206a.get(bVar.c());
            if (aVar == null) {
                if (f51204d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (f51204d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            aVar.onEvent(bVar);
            if (this.f51207b.containsKey(b2)) {
                if (f51204d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.f51208c.removeCallbacks(this.f51207b.get(b2));
                this.f51207b.remove(b2);
            }
            if (aVar.c()) {
                if (f51204d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(aVar);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f51204d) {
                Log.d("MDelegate-Observe", "release observable");
            }
            if (f51205e == null) {
                return;
            }
            this.f51206a.clear();
            for (Map.Entry<String, Runnable> entry : this.f51207b.entrySet()) {
                if (f51204d) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.f51208c.removeCallbacks(entry.getValue());
            }
            this.f51207b.clear();
            f51205e = null;
        }
    }

    public void e(d.a.q0.a.v1.a.b.c.a<d.a.q0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar == null) {
                if (f51204d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (this.f51206a.containsKey(b2)) {
                if (f51204d) {
                    Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                    return;
                }
                return;
            }
            if (f51204d) {
                Log.d("MDelegate-Observe", "register observer: " + b2);
            }
            this.f51206a.put(b2, aVar);
            long a2 = aVar.a();
            if (a2 <= 0 || !aVar.c()) {
                return;
            }
            if (f51204d) {
                Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
            }
            b bVar = new b(this, b2);
            this.f51207b.put(b2, bVar);
            this.f51208c.postDelayed(bVar, a2);
        }
    }

    public void f(d.a.q0.a.v1.a.b.c.a<d.a.q0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar == null) {
                if (f51204d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (!this.f51206a.containsKey(b2)) {
                if (f51204d) {
                    Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                    return;
                }
                return;
            }
            if (f51204d) {
                Log.d("MDelegate-Observe", "unregister observer: " + b2);
            }
            this.f51206a.remove(b2);
        }
    }
}
