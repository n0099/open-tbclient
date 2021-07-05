package d.a.u0;

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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f70580i;
    public static volatile d j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f70581a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f70582b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f70583c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.u0.g f70584d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.u0.c f70585e;

    /* renamed from: f  reason: collision with root package name */
    public int f70586f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70587g;

    /* renamed from: h  reason: collision with root package name */
    public w f70588h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70589e;

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
            this.f70589e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f70589e.f70585e == null) {
                return;
            }
            this.f70589e.f70585e.L();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70590e;

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
            this.f70590e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70590e.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f70590e.f70585e.L();
                long currentTimeMillis = System.currentTimeMillis();
                h0.e().putLong("ubc_last_upload_all_time", currentTimeMillis);
                h0.e().putLong("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70591e;

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
            this.f70591e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70591e.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70591e.f70585e.m();
            }
        }
    }

    /* renamed from: d.a.u0.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1952d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f70592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f70594g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f70595h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f70596i;
        public final /* synthetic */ d j;

        public RunnableC1952d(d dVar, JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
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
            this.f70592e = jSONObject;
            this.f70593f = str;
            this.f70594g = z;
            this.f70595h = oVar;
            this.f70596i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.j.f70585e.H(this.f70592e, this.f70593f, this.f70594g, this.f70595h, this.f70596i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70597e;

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
            this.f70597e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70597e.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70597e.f70585e.t();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70598e;

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
            this.f70598e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70598e.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70598e.f70585e.A();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f70599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f70600f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f70601g;

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
            this.f70601g = dVar;
            this.f70599e = z;
            this.f70600f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70601g.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (this.f70599e) {
                    this.f70601g.f70585e.K(this.f70600f);
                } else {
                    this.f70601g.f70585e.J(this.f70600f);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public x f70602e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70603f;

        /* renamed from: g  reason: collision with root package name */
        public t f70604g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f70605h;

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
            this.f70605h = dVar;
            this.f70602e = xVar;
            this.f70603f = z;
            this.f70604g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70605h.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70605h.f70585e.F(this.f70602e, this.f70603f, this.f70604g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70609e;

        /* renamed from: f  reason: collision with root package name */
        public int f70610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f70611g;

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
            this.f70611g = dVar;
            this.f70609e = str;
            this.f70610f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70611g.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70611g.f70585e.h(this.f70609e, this.f70610f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70614e;

        /* renamed from: f  reason: collision with root package name */
        public int f70615f;

        /* renamed from: g  reason: collision with root package name */
        public long f70616g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f70617h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f70618i;

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
            this.f70618i = dVar;
            this.f70614e = str;
            this.f70615f = i2;
            this.f70616g = System.currentTimeMillis();
            this.f70617h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70618i.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70618i.f70585e.l(this.f70614e, this.f70615f, this.f70616g, this.f70617h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f70619e;

        /* renamed from: f  reason: collision with root package name */
        public int f70620f;

        /* renamed from: g  reason: collision with root package name */
        public String f70621g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f70622h;

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
            this.f70622h = dVar;
            this.f70619e = str;
            this.f70620f = i2;
            this.f70621g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f70622h.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70622h.f70585e.G(this.f70619e, this.f70620f, this.f70621g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f70623e;

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
            this.f70623e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f70623e.f70584d = d.a.u0.g.m();
                this.f70623e.f70585e = new d.a.u0.c(this.f70623e.f70581a);
                this.f70623e.f70585e.C();
            }
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-455625754, "Ld/a/u0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-455625754, "Ld/a/u0/d;");
                return;
            }
        }
        f70580i = AppConfig.isDebug();
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
        this.f70587g = false;
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f70586f;
        dVar.f70586f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.a.s0.c3.t.a() : (s) invokeV.objValue;
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
            this.f70582b.execute(new f(this));
        }
    }

    public void B(x xVar, boolean z, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{xVar, Boolean.valueOf(z), tVar}) == null) {
            this.f70582b.execute(new h(this, xVar, z, tVar));
        }
    }

    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) {
            this.f70582b.execute(new m(this, str, i2, str2));
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f70587g) {
            return;
        }
        this.f70587g = true;
        this.f70582b.execute(new b(this));
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
            if (f70580i) {
                Log.d("UBCBehaviorProcessor", "uploadData:" + str);
                Log.d("UBCDEBUG", jSONObject.toString());
            }
            boolean z2 = true;
            s o = o();
            if (o != null && !o.a()) {
                z2 = false;
            }
            if (z2) {
                this.f70583c.execute(new RunnableC1952d(this, jSONObject, str, z, oVar, uVar));
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
            this.f70582b.execute(new g(this, z, str));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f70582b.execute(new a(this));
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
                    if (this.f70584d != null && this.f70584d.w(str)) {
                        kVar.a(true);
                    }
                    this.f70582b.execute(kVar);
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
                    if (this.f70584d != null && this.f70584d.w(str)) {
                        kVar.a(true);
                    }
                    this.f70582b.execute(kVar);
                }
            }
            return m2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            this.f70582b.execute(new j(this, str, i2));
        }
    }

    public Flow m(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f70586f, i2);
            d.a.u0.g gVar = this.f70584d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                d.a.u0.g gVar2 = this.f70584d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.u0.g gVar3 = this.f70584d;
                if (gVar3 != null && gVar3.v(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.u0.g gVar4 = this.f70584d;
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
            this.f70582b.execute(new l(this, str, i2, jSONArray));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f70582b.execute(new c(this));
        }
    }

    public String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            d.a.u0.c cVar = this.f70585e;
            return cVar != null ? cVar.p(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, context) == null) && this.f70581a == null && context != null) {
            if (context instanceof Application) {
                this.f70581a = context;
            } else {
                this.f70581a = context.getApplicationContext();
            }
            this.f70586f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f70582b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new n(this, null));
            this.f70583c = Executors.newSingleThreadExecutor();
            this.f70588h = (w) ServiceManager.getService(w.f70692a);
        }
    }

    public void t(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048594, this, str, str2, str3, i2) == null) {
            i iVar = new i(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                iVar.d(str3);
            }
            this.f70582b.execute(iVar);
        }
    }

    public void u(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, str, str2, i2) == null) {
            this.f70582b.execute(new i(this, str, str2, i2));
        }
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, str, jSONObject, i2) == null) {
            this.f70582b.execute(new i(this, str, jSONObject, i2));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f70582b.execute(new e(this));
        }
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f70582b.execute(new i(this, str, str2, i2, str3, i3));
        }
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f70582b.execute(new i(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void z(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, runnable, j2) == null) {
            this.f70582b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public o f70606e;

        /* renamed from: f  reason: collision with root package name */
        public String f70607f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f70608g;

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
            this.f70608g = dVar;
            this.f70606e = new o(str, str2, i2);
            this.f70607f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f70608g.f70584d == null || this.f70608g.f70584d.g(str, i2)) {
                        if (this.f70608g.f70584d == null || !this.f70608g.f70584d.v(str)) {
                            if (this.f70608g.f70584d == null || !this.f70608g.f70584d.h(str)) {
                                return this.f70608g.f70584d == null || !this.f70608g.f70584d.d(str);
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (oVar = this.f70606e) == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f70606e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f70606e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    this.f70608g.f70588h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            this.f70608g.f70588h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (oVar = this.f70606e) == null) {
                return;
            }
            oVar.n(z);
        }

        public void d(String str) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (oVar = this.f70606e) == null) {
                return;
            }
            oVar.p(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f70608g.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (this.f70608g.f70588h != null && this.f70608g.f70584d != null && this.f70608g.f70584d.b(this.f70607f) == 1) {
                    b();
                }
                if (this.f70606e.e() == -1) {
                    if (!a(this.f70606e.g(), this.f70606e.i())) {
                        return;
                    }
                    if (this.f70608g.f70584d != null && this.f70608g.f70584d.w(this.f70606e.g())) {
                        c(true);
                    }
                }
                this.f70606e.o();
                String g2 = this.f70606e.g();
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                if (this.f70608g.f70584d != null) {
                    String i2 = this.f70608g.f70584d.i(g2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f70606e.m(i2);
                    }
                }
                if (this.f70608g.f70588h != null && this.f70608g.f70584d != null && this.f70608g.f70584d.b(this.f70607f) == 2) {
                    b();
                }
                if (this.f70606e.e() == -1 && TextUtils.equals(g2, "1876")) {
                    this.f70608g.f70585e.y(this.f70606e);
                } else if ((this.f70606e.i() & 8) != 0) {
                    this.f70608g.f70585e.x(this.f70606e);
                } else if (this.f70606e == null || this.f70608g.f70584d == null || !this.f70608g.f70584d.f(g2)) {
                    this.f70608g.f70585e.w(this.f70606e);
                } else {
                    this.f70608g.f70585e.Q(this.f70606e);
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
            this.f70608g = dVar;
            this.f70606e = new o(str, jSONObject, i2);
            this.f70607f = str;
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
            this.f70608g = dVar;
            this.f70606e = new o(str, str2, i2, str3, i3);
            this.f70607f = str;
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
            this.f70608g = dVar;
            this.f70606e = new o(str, str2, i2, str3, j, i3);
            this.f70607f = str;
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f70612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f70613f;

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
            this.f70613f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f70612e = qVar;
            qVar.m(flow.getStartTime());
            this.f70612e.w("1");
            d.i(dVar);
        }

        public void a(boolean z) {
            q qVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (qVar = this.f70612e) == null) {
                return;
            }
            qVar.p(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f70613f.f70585e == null) {
                    if (d.f70580i) {
                        Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f70612e.r();
                if (!TextUtils.isEmpty(this.f70613f.f70584d.i(this.f70612e.g()))) {
                    this.f70612e.n(this.f70613f.f70584d.i(this.f70612e.g()));
                }
                this.f70613f.f70585e.D(this.f70612e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f70613f.f70586f);
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
            this.f70613f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f70612e = qVar;
            qVar.m(flow.getStartTime());
            this.f70612e.w("1");
            d.i(dVar);
        }
    }
}
