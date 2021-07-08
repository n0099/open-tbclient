package d.a.n0.a.v1.a.b.b;

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
import d.a.n0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47902d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47903e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.n0.a.v1.a.b.c.a<d.a.n0.a.v1.a.b.a.b>> f47904a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f47905b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0944a f47906c;

    /* renamed from: d.a.n0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0944a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0944a(Looper looper) {
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

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f47907e;

        /* renamed from: f  reason: collision with root package name */
        public String f47908f;

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
            this.f47907e = new WeakReference<>(aVar);
            this.f47908f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f47907e.get()) == null) {
                return;
            }
            if (a.f47902d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f47908f);
            }
            d.a.n0.a.v1.a.b.a.b bVar = new d.a.n0.a.v1.a.b.a.b(this.f47908f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1530269664, "Ld/a/n0/a/v1/a/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1530269664, "Ld/a/n0/a/v1/a/b/b/a;");
                return;
            }
        }
        f47902d = k.f45831a;
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
        this.f47904a = new ConcurrentHashMap<>();
        this.f47905b = new ConcurrentHashMap<>();
        this.f47906c = new HandlerC0944a(Looper.getMainLooper());
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f47903e == null) {
                synchronized (a.class) {
                    if (f47903e == null) {
                        f47903e = new a();
                    }
                }
            }
            return f47903e;
        }
        return (a) invokeV.objValue;
    }

    public void c(@NonNull d.a.n0.a.v1.a.b.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            d.a.n0.a.v1.a.b.c.a<d.a.n0.a.v1.a.b.a.b> aVar = this.f47904a.get(bVar.c());
            if (aVar == null) {
                if (f47902d) {
                    Log.e("MDelegate-Observe", "notify a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (f47902d) {
                Log.d("MDelegate-Observe", "notify observer: " + b2);
            }
            aVar.onEvent(bVar);
            if (this.f47905b.containsKey(b2)) {
                if (f47902d) {
                    Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
                }
                this.f47906c.removeCallbacks(this.f47905b.get(b2));
                this.f47905b.remove(b2);
            }
            if (aVar.c()) {
                if (f47902d) {
                    Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
                }
                f(aVar);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f47902d) {
                Log.d("MDelegate-Observe", "release observable");
            }
            if (f47903e == null) {
                return;
            }
            this.f47904a.clear();
            for (Map.Entry<String, Runnable> entry : this.f47905b.entrySet()) {
                if (f47902d) {
                    Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
                }
                this.f47906c.removeCallbacks(entry.getValue());
            }
            this.f47905b.clear();
            f47903e = null;
        }
    }

    public void e(d.a.n0.a.v1.a.b.c.a<d.a.n0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar == null) {
                if (f47902d) {
                    Log.e("MDelegate-Observe", "register a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (this.f47904a.containsKey(b2)) {
                if (f47902d) {
                    Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                    return;
                }
                return;
            }
            if (f47902d) {
                Log.d("MDelegate-Observe", "register observer: " + b2);
            }
            this.f47904a.put(b2, aVar);
            long a2 = aVar.a();
            if (a2 <= 0 || !aVar.c()) {
                return;
            }
            if (f47902d) {
                Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
            }
            b bVar = new b(this, b2);
            this.f47905b.put(b2, bVar);
            this.f47906c.postDelayed(bVar, a2);
        }
    }

    public void f(d.a.n0.a.v1.a.b.c.a<d.a.n0.a.v1.a.b.a.b> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (aVar == null) {
                if (f47902d) {
                    Log.e("MDelegate-Observe", "unregister a null observer");
                    return;
                }
                return;
            }
            String b2 = aVar.b();
            if (!this.f47904a.containsKey(b2)) {
                if (f47902d) {
                    Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                    return;
                }
                return;
            }
            if (f47902d) {
                Log.d("MDelegate-Observe", "unregister observer: " + b2);
            }
            this.f47904a.remove(b2);
        }
    }
}
