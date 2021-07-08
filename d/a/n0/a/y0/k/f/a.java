package d.a.n0.a.y0.k.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.e0.d;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.k;
import d.a.n0.a.r1.h;
import d.a.n0.a.v2.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48513e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Long> f48514a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f48515b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48516c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48517d;

    /* renamed from: d.a.n0.a.y0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0987a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a f48518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f48519f;

        public RunnableC0987a(a aVar, b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48519f = aVar;
            this.f48518e = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48519f.j(this.f48518e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(270474601, "Ld/a/n0/a/y0/k/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(270474601, "Ld/a/n0/a/y0/k/f/a;");
                return;
            }
        }
        f48513e = k.f45831a;
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
        this.f48514a = new HashMap<>();
        this.f48515b = new HashMap<>();
        this.f48516c = false;
        this.f48517d = false;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48514a.clear();
            this.f48515b.clear();
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f48517d = true;
            }
        }
    }

    public synchronized boolean d(@NonNull String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                containsKey = this.f48514a.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean e(@NonNull String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                containsKey = this.f48515b.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = this.f48517d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                if (!this.f48517d) {
                    this.f48515b.put(str, str2);
                }
            }
        }
    }

    public synchronized void h(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                if (f48513e) {
                    Log.i("VideoStaticRecorder", "inline video record: action " + str);
                }
                if (!this.f48517d && !this.f48514a.containsKey(str)) {
                    this.f48514a.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public synchronized void i(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            synchronized (this) {
                if (f48513e) {
                    Log.i("VideoStaticRecorder", "inline video record: action " + str);
                }
                if (!this.f48514a.containsKey(str)) {
                    this.f48514a.put(str, Long.valueOf(j));
                }
            }
        }
    }

    public final synchronized void j(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                if (this.f48516c) {
                    return;
                }
                this.f48516c = true;
                boolean equals = TextUtils.equals("1", this.f48515b.get("autoPlay"));
                boolean equals2 = TextUtils.equals("1", this.f48515b.get("playMethod"));
                if (f48513e) {
                    Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
                }
                if (!equals && !equals2) {
                    b();
                    return;
                }
                h.r("video");
                HybridUbcFlow p = h.p("video");
                for (Map.Entry<String, Long> entry : this.f48514a.entrySet()) {
                    d.g("VideoStaticRecorder", "submit: event key: " + entry.getKey() + " value " + entry.getValue());
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
                    ubcFlowEvent.h(entry.getValue().longValue());
                    p.C(ubcFlowEvent);
                }
                for (Map.Entry<String, String> entry2 : this.f48515b.entrySet()) {
                    d.g("VideoStaticRecorder", "submit: ext key: " + entry2.getKey() + " value " + entry2.getValue());
                    p.A(entry2.getKey(), entry2.getValue());
                }
                String g2 = p.g("fmpArrived");
                if (TextUtils.isEmpty(g2)) {
                    g2 = "0";
                }
                p.A("fmpArrived", g2);
                long l = aVar.l("launch_time", 0L);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_start");
                ubcFlowEvent2.h(l);
                p.C(ubcFlowEvent2);
                p.A("launchID", aVar.V());
                p.A("scheme", aVar.W());
                p.A("appid", aVar.H());
                p.A("page", aVar.e0());
                long j = aVar.r0().getLong("click_time", 0L);
                if (j > 0) {
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("user_action");
                    ubcFlowEvent3.h(j);
                    p.C(ubcFlowEvent3);
                }
                p.x();
                b();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q.j(new RunnableC0987a(this, d.a.n0.a.a2.d.g().r().L()), "VideoStaticRecorder");
        }
    }
}
