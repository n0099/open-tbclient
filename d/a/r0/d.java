package d.a.r0;

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
    public static final boolean f67354i;
    public static volatile d j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67355a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67356b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f67357c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.r0.g f67358d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.c f67359e;

    /* renamed from: f  reason: collision with root package name */
    public int f67360f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67361g;

    /* renamed from: h  reason: collision with root package name */
    public w f67362h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67363e;

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
            this.f67363e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67363e.f67359e == null) {
                return;
            }
            this.f67363e.f67359e.L();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67364e;

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
            this.f67364e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67364e.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.f67364e.f67359e.L();
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
        public final /* synthetic */ d f67365e;

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
            this.f67365e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67365e.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67365e.f67359e.m();
            }
        }
    }

    /* renamed from: d.a.r0.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1910d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f67366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f67368g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f67369h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f67370i;
        public final /* synthetic */ d j;

        public RunnableC1910d(d dVar, JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
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
            this.f67366e = jSONObject;
            this.f67367f = str;
            this.f67368g = z;
            this.f67369h = oVar;
            this.f67370i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.j.f67359e.H(this.f67366e, this.f67367f, this.f67368g, this.f67369h, this.f67370i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67371e;

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
            this.f67371e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67371e.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67371e.f67359e.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67372e;

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
            this.f67372e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67372e.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67372e.f67359e.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f67373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67374f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67375g;

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
            this.f67375g = dVar;
            this.f67373e = z;
            this.f67374f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67375g.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    }
                } else if (this.f67373e) {
                    this.f67375g.f67359e.K(this.f67374f);
                } else {
                    this.f67375g.f67359e.J(this.f67374f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public x f67376e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67377f;

        /* renamed from: g  reason: collision with root package name */
        public t f67378g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f67379h;

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
            this.f67379h = dVar;
            this.f67376e = xVar;
            this.f67377f = z;
            this.f67378g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67379h.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67379h.f67359e.F(this.f67376e, this.f67377f, this.f67378g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67383e;

        /* renamed from: f  reason: collision with root package name */
        public int f67384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67385g;

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
            this.f67385g = dVar;
            this.f67383e = str;
            this.f67384f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67385g.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67385g.f67359e.h(this.f67383e, this.f67384f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67388e;

        /* renamed from: f  reason: collision with root package name */
        public int f67389f;

        /* renamed from: g  reason: collision with root package name */
        public long f67390g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f67391h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f67392i;

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
            this.f67392i = dVar;
            this.f67388e = str;
            this.f67389f = i2;
            this.f67390g = System.currentTimeMillis();
            this.f67391h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67392i.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67392i.f67359e.l(this.f67388e, this.f67389f, this.f67390g, this.f67391h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67393e;

        /* renamed from: f  reason: collision with root package name */
        public int f67394f;

        /* renamed from: g  reason: collision with root package name */
        public String f67395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f67396h;

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
            this.f67396h = dVar;
            this.f67393e = str;
            this.f67394f = i2;
            this.f67395g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f67396h.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67396h.f67359e.G(this.f67393e, this.f67394f, this.f67395g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67397e;

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
            this.f67397e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f67397e.f67358d = d.a.r0.g.m();
                this.f67397e.f67359e = new d.a.r0.c(this.f67397e.f67355a);
                this.f67397e.f67359e.C();
            }
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458396317, "Ld/a/r0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-458396317, "Ld/a/r0/d;");
                return;
            }
        }
        f67354i = AppConfig.isDebug();
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
        this.f67361g = false;
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f67360f;
        dVar.f67360f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d.a.p0.c3.t.a() : (s) invokeV.objValue;
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
            this.f67356b.execute(new f(this));
        }
    }

    public void B(x xVar, boolean z, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{xVar, Boolean.valueOf(z), tVar}) == null) {
            this.f67356b.execute(new h(this, xVar, z, tVar));
        }
    }

    public void C(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) {
            this.f67356b.execute(new m(this, str, i2, str2));
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f67361g) {
            return;
        }
        this.f67361g = true;
        this.f67356b.execute(new b(this));
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
            if (f67354i) {
                Log.d("UBCBehaviorProcessor", "uploadData:" + str);
                Log.d("UBCDEBUG", jSONObject.toString());
            }
            boolean z2 = true;
            s o = o();
            if (o != null && !o.a()) {
                z2 = false;
            }
            if (z2) {
                this.f67357c.execute(new RunnableC1910d(this, jSONObject, str, z, oVar, uVar));
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
            this.f67356b.execute(new g(this, z, str));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f67356b.execute(new a(this));
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
                    if (this.f67358d != null && this.f67358d.w(str)) {
                        kVar.a(true);
                    }
                    this.f67356b.execute(kVar);
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
                    if (this.f67358d != null && this.f67358d.w(str)) {
                        kVar.a(true);
                    }
                    this.f67356b.execute(kVar);
                }
            }
            return m2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i2) == null) {
            this.f67356b.execute(new j(this, str, i2));
        }
    }

    public Flow m(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f67360f, i2);
            d.a.r0.g gVar = this.f67358d;
            if (gVar != null && !gVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                d.a.r0.g gVar2 = this.f67358d;
                if (gVar2 != null && gVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.r0.g gVar3 = this.f67358d;
                if (gVar3 != null && gVar3.v(str)) {
                    flow.setValid(false);
                    return flow;
                }
                d.a.r0.g gVar4 = this.f67358d;
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
            this.f67356b.execute(new l(this, str, i2, jSONArray));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f67356b.execute(new c(this));
        }
    }

    public String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            d.a.r0.c cVar = this.f67359e;
            return cVar != null ? cVar.p(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, context) == null) && this.f67355a == null && context != null) {
            if (context instanceof Application) {
                this.f67355a = context;
            } else {
                this.f67355a = context.getApplicationContext();
            }
            this.f67360f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f67356b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new n(this, null));
            this.f67357c = Executors.newSingleThreadExecutor();
            this.f67362h = (w) ServiceManager.getService(w.f67466a);
        }
    }

    public void t(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048594, this, str, str2, str3, i2) == null) {
            i iVar = new i(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                iVar.d(str3);
            }
            this.f67356b.execute(iVar);
        }
    }

    public void u(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, str, str2, i2) == null) {
            this.f67356b.execute(new i(this, str, str2, i2));
        }
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, str, jSONObject, i2) == null) {
            this.f67356b.execute(new i(this, str, jSONObject, i2));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f67356b.execute(new e(this));
        }
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f67356b.execute(new i(this, str, str2, i2, str3, i3));
        }
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f67356b.execute(new i(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void z(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, runnable, j2) == null) {
            this.f67356b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public o f67380e;

        /* renamed from: f  reason: collision with root package name */
        public String f67381f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67382g;

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
            this.f67382g = dVar;
            this.f67380e = new o(str, str2, i2);
            this.f67381f = str;
        }

        public final boolean a(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                    if (this.f67382g.f67358d == null || this.f67382g.f67358d.g(str, i2)) {
                        if (this.f67382g.f67358d == null || !this.f67382g.f67358d.v(str)) {
                            if (this.f67382g.f67358d == null || !this.f67382g.f67358d.h(str)) {
                                return this.f67382g.f67358d == null || !this.f67382g.f67358d.d(str);
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (oVar = this.f67380e) == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f67380e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f67380e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    this.f67382g.f67362h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            this.f67382g.f67362h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (oVar = this.f67380e) == null) {
                return;
            }
            oVar.n(z);
        }

        public void d(String str) {
            o oVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (oVar = this.f67380e) == null) {
                return;
            }
            oVar.p(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f67382g.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (this.f67382g.f67362h != null && this.f67382g.f67358d != null && this.f67382g.f67358d.b(this.f67381f) == 1) {
                    b();
                }
                if (this.f67380e.e() == -1) {
                    if (!a(this.f67380e.g(), this.f67380e.i())) {
                        return;
                    }
                    if (this.f67382g.f67358d != null && this.f67382g.f67358d.w(this.f67380e.g())) {
                        c(true);
                    }
                }
                this.f67380e.o();
                String g2 = this.f67380e.g();
                if (TextUtils.isEmpty(g2)) {
                    return;
                }
                if (this.f67382g.f67358d != null) {
                    String i2 = this.f67382g.f67358d.i(g2);
                    if (!TextUtils.isEmpty(i2)) {
                        this.f67380e.m(i2);
                    }
                }
                if (this.f67382g.f67362h != null && this.f67382g.f67358d != null && this.f67382g.f67358d.b(this.f67381f) == 2) {
                    b();
                }
                if (this.f67380e.e() == -1 && TextUtils.equals(g2, "1876")) {
                    this.f67382g.f67359e.y(this.f67380e);
                } else if ((this.f67380e.i() & 8) != 0) {
                    this.f67382g.f67359e.x(this.f67380e);
                } else if (this.f67380e == null || this.f67382g.f67358d == null || !this.f67382g.f67358d.f(g2)) {
                    this.f67382g.f67359e.w(this.f67380e);
                } else {
                    this.f67382g.f67359e.Q(this.f67380e);
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
            this.f67382g = dVar;
            this.f67380e = new o(str, jSONObject, i2);
            this.f67381f = str;
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
            this.f67382g = dVar;
            this.f67380e = new o(str, str2, i2, str3, i3);
            this.f67381f = str;
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
            this.f67382g = dVar;
            this.f67380e = new o(str, str2, i2, str3, j, i3);
            this.f67381f = str;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f67386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f67387f;

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
            this.f67387f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f67386e = qVar;
            qVar.m(flow.getStartTime());
            this.f67386e.w("1");
            d.i(dVar);
        }

        public void a(boolean z) {
            q qVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (qVar = this.f67386e) == null) {
                return;
            }
            qVar.p(z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f67387f.f67359e == null) {
                    if (d.f67354i) {
                        Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.f67386e.r();
                if (!TextUtils.isEmpty(this.f67387f.f67358d.i(this.f67386e.g()))) {
                    this.f67386e.n(this.f67387f.f67358d.i(this.f67386e.g()));
                }
                this.f67387f.f67359e.D(this.f67386e);
                QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, this.f67387f.f67360f);
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
            this.f67387f = dVar;
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f67386e = qVar;
            qVar.m(flow.getStartTime());
            this.f67386e.w("1");
            d.i(dVar);
        }
    }
}
