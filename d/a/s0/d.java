package d.a.s0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
@Autowired
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f68032i;
    public static volatile d j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68033a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f68034b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f68035c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.g f68036d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.c f68037e;

    /* renamed from: f  reason: collision with root package name */
    public int f68038f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68039g;

    /* renamed from: h  reason: collision with root package name */
    public w f68040h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68041e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68041e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f68041e.f68037e == null) {
                return;
            }
            this.f68041e.f68037e.L();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68042e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68042e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68042e.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f68042e.f68037e.L();
                long currentTimeMillis = System.currentTimeMillis();
                h0.e().putLong("ubc_last_upload_all_time", currentTimeMillis);
                h0.e().putLong("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68043e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68043e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68043e.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68043e.f68037e.m();
            }
        }
    }

    /* renamed from: d.a.s0.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1915d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f68044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68045f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f68046g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f68047h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f68048i;
        public final /* synthetic */ d j;

        public RunnableC1915d(d dVar, JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, jSONObject, str, Boolean.valueOf(z), oVar, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = dVar;
            this.f68044e = jSONObject;
            this.f68045f = str;
            this.f68046g = z;
            this.f68047h = oVar;
            this.f68048i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.j.f68037e.H(this.f68044e, this.f68045f, this.f68046g, this.f68047h, this.f68048i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68049e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68049e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68049e.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68049e.f68037e.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68050e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68050e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68050e.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68050e.f68037e.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f68051e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68052f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f68053g;

        public g(d dVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68053g = dVar;
            this.f68051e = z;
            this.f68052f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68053g.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (this.f68051e) {
                    this.f68053g.f68037e.K(this.f68052f);
                } else {
                    this.f68053g.f68037e.J(this.f68052f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public x f68054e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68055f;

        /* renamed from: g  reason: collision with root package name */
        public t f68056g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f68057h;

        public h(d dVar, x xVar, boolean z, t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, xVar, Boolean.valueOf(z), tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68057h = dVar;
            this.f68054e = xVar;
            this.f68055f = z;
            this.f68056g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68057h.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68057h.f68037e.F(this.f68054e, this.f68055f, this.f68056g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68061e;

        /* renamed from: f  reason: collision with root package name */
        public int f68062f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f68063g;

        public j(d dVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68063g = dVar;
            this.f68061e = str;
            this.f68062f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68063g.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68063g.f68037e.h(this.f68061e, this.f68062f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68066e;

        /* renamed from: f  reason: collision with root package name */
        public int f68067f;

        /* renamed from: g  reason: collision with root package name */
        public long f68068g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f68069h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f68070i;

        public l(d dVar, String str, int i2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68070i = dVar;
            this.f68066e = str;
            this.f68067f = i2;
            this.f68068g = System.currentTimeMillis();
            this.f68069h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68070i.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68070i.f68037e.l(this.f68066e, this.f68067f, this.f68068g, this.f68069h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68071e;

        /* renamed from: f  reason: collision with root package name */
        public int f68072f;

        /* renamed from: g  reason: collision with root package name */
        public String f68073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f68074h;

        public m(d dVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68074h = dVar;
            this.f68071e = str;
            this.f68072f = i2;
            this.f68073g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68074h.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68074h.f68037e.G(this.f68071e, this.f68072f, this.f68073g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68075e;

        public n(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68075e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f68075e.f68036d = d.a.s0.g.m();
                this.f68075e.f68037e = new d.a.s0.c(this.f68075e.f68033a);
                this.f68075e.f68037e.C();
            }
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457472796, "Ld/a/s0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457472796, "Ld/a/s0/d;");
                return;
            }
        }
        f68032i = AppConfig.isDebug();
    }

    public d() {
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
        this.f68039g = false;
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f68038f;
        dVar.f68038f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.a.q0.c3.t.a() : (s) invokeV.objValue;
    }

    public static d q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (j == null) {
                synchronized (d.class) {
                    if (j == null) {
                        j = new d();
                    }
                }
            }
            return j;
        }
        return (d) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68034b.execute(new f(this));
        }
    }

    public void B(x xVar, boolean z, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{xVar, Boolean.valueOf(z), tVar}) == null) {
            this.f68034b.execute(new h(this, xVar, z, tVar));
        }
    }

    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) {
            this.f68034b.execute(new m(this, str, i2, str2));
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f68039g) {
            return;
        }
        this.f68039g = true;
        this.f68034b.execute(new b(this));
    }

    public void E(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            F(jSONObject, null);
        }
    }

    public void F(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) {
            G(jSONObject, str, false, null, null);
        }
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{jSONObject, str, Boolean.valueOf(z), oVar, uVar}) == null) {
            if (f68032i) {
                Log.d("UBCBehaviorProcessor", "uploadData:" + str);
                Log.d("UBCDEBUG", jSONObject.toString());
            }
            boolean z2 = true;
            s o = o();
            if (o != null && !o.a()) {
                z2 = false;
            }
            if (z2) {
                this.f68035c.execute(new RunnableC1915d(this, jSONObject, str, z, oVar, uVar));
            }
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{jSONObject, Boolean.valueOf(z), oVar, uVar}) == null) {
            G(jSONObject, null, z, oVar, uVar);
        }
    }

    public void I(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
            this.f68034b.execute(new g(this, z, str));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f68034b.execute(new a(this));
        }
    }

    public synchronized Flow j(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, str, str2, i2)) == null) {
            synchronized (this) {
                m2 = m(str, i2);
                if (m2 != null && m2.getValid()) {
                    k kVar = new k(this, m2, str2);
                    if (this.f68036d != null && this.f68036d.w(str)) {
                        kVar.a(true);
                    }
                    this.f68034b.execute(kVar);
                }
            }
            return m2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Flow m2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, str, jSONObject, i2)) == null) {
            synchronized (this) {
                m2 = m(str, i2);
                if (m2 != null && m2.getValid()) {
                    k kVar = new k(this, m2, jSONObject);
                    if (this.f68036d != null && this.f68036d.w(str)) {
                        kVar.a(true);
                    }
                    this.f68034b.execute(kVar);
                }
            }
            return m2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            this.f68034b.execute(new j(this, str, i2));
        }
    }

    public Flow m(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f68038f, i2);
            d.a.s0.g gVar = this.f68036d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                d.a.s0.g gVar2 = this.f68036d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.s0.g gVar3 = this.f68036d;
                if (gVar3 != null && gVar3.v(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.s0.g gVar4 = this.f68036d;
                if (gVar4 != null && !gVar4.x(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, jSONArray) == null) {
            this.f68034b.execute(new l(this, str, i2, jSONArray));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f68034b.execute(new c(this));
        }
    }

    public String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            d.a.s0.c cVar = this.f68037e;
            return cVar != null ? cVar.p(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, context) == null) && this.f68033a == null && context != null) {
            if (context instanceof Application) {
                this.f68033a = context;
            } else {
                this.f68033a = context.getApplicationContext();
            }
            this.f68038f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f68034b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new n(this, null));
            this.f68035c = Executors.newSingleThreadExecutor();
            this.f68040h = (w) ServiceManager.getService(w.f68144a);
        }
    }

    public void t(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048594, this, str, str2, str3, i2) == null) {
            i iVar = new i(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                iVar.d(str3);
            }
            this.f68034b.execute(iVar);
        }
    }

    public void u(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, str, str2, i2) == null) {
            this.f68034b.execute(new i(this, str, str2, i2));
        }
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, str, jSONObject, i2) == null) {
            this.f68034b.execute(new i(this, str, jSONObject, i2));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f68034b.execute(new e(this));
        }
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f68034b.execute(new i(this, str, str2, i2, str3, i3));
        }
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f68034b.execute(new i(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void z(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, runnable, j2) == null) {
            this.f68034b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public o f68058e;

        /* renamed from: f  reason: collision with root package name */
        public String f68059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f68060g;

        public i(d dVar, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68060g = dVar;
            this.f68058e = new o(str, str2, i2);
            this.f68059f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f68060g.f68036d == null || this.f68060g.f68036d.g(str, i2)) {
                        if (this.f68060g.f68036d == null || !this.f68060g.f68036d.v(str)) {
                            if (this.f68060g.f68036d == null || !this.f68060g.f68036d.h(str)) {
                                return this.f68060g.f68036d == null || !this.f68060g.f68036d.d(str);
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLI.booleanValue;
        }

        public final void b() {
            o oVar;
            JSONObject h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (oVar = this.f68058e) == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f68058e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f68058e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    this.f68060g.f68040h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            this.f68060g.f68040h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (oVar = this.f68058e) == null) {
                return;
            }
            oVar.n(z);
        }

        public void d(String str) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (oVar = this.f68058e) == null) {
                return;
            }
            oVar.p(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f68060g.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (this.f68060g.f68040h != null && this.f68060g.f68036d != null && this.f68060g.f68036d.b(this.f68059f) == 1) {
                    b();
                }
                if (this.f68058e.e() == -1) {
                    if (!a(this.f68058e.g(), this.f68058e.i())) {
                        return;
                    }
                    if (this.f68060g.f68036d != null && this.f68060g.f68036d.w(this.f68058e.g())) {
                        c(true);
                    }
                }
                this.f68058e.o();
                String g2 = this.f68058e.g();
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                if (this.f68060g.f68036d != null) {
                    String i2 = this.f68060g.f68036d.i(g2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f68058e.m(i2);
                    }
                }
                if (this.f68060g.f68040h != null && this.f68060g.f68036d != null && this.f68060g.f68036d.b(this.f68059f) == 2) {
                    b();
                }
                if (this.f68058e.e() == -1 && TextUtils.equals(g2, "1876")) {
                    this.f68060g.f68037e.y(this.f68058e);
                } else if ((this.f68058e.i() & 8) != 0) {
                    this.f68060g.f68037e.x(this.f68058e);
                } else if (this.f68058e == null || this.f68060g.f68036d == null || !this.f68060g.f68036d.f(g2)) {
                    this.f68060g.f68037e.w(this.f68058e);
                } else {
                    this.f68060g.f68037e.Q(this.f68058e);
                }
            }
        }

        public i(d dVar, String str, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f68060g = dVar;
            this.f68058e = new o(str, jSONObject, i2);
            this.f68059f = str;
        }

        public i(d dVar, String str, String str2, int i2, String str3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f68060g = dVar;
            this.f68058e = new o(str, str2, i2, str3, i3);
            this.f68059f = str;
        }

        public i(d dVar, String str, String str2, int i2, String str3, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f68060g = dVar;
            this.f68058e = new o(str, str2, i2, str3, j, i3);
            this.f68059f = str;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f68064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f68065f;

        public k(d dVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68065f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f68064e = qVar;
            qVar.m(flow.getStartTime());
            this.f68064e.w("1");
            d.i(dVar);
        }

        public void a(boolean z) {
            q qVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (qVar = this.f68064e) == null) {
                return;
            }
            qVar.p(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f68065f.f68037e == null) {
                    if (d.f68032i) {
                        Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f68064e.r();
                if (!TextUtils.isEmpty(this.f68065f.f68036d.i(this.f68064e.g()))) {
                    this.f68064e.n(this.f68065f.f68036d.i(this.f68064e.g()));
                }
                this.f68065f.f68037e.D(this.f68064e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f68065f.f68038f);
            }
        }

        public k(d dVar, Flow flow, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, flow, jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f68065f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f68064e = qVar;
            qVar.m(flow.getStartTime());
            this.f68064e.w("1");
            d.i(dVar);
        }
    }
}
