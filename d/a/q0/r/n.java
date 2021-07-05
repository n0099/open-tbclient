package d.a.q0.r;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f54343h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f54344a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f54345b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f54346c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.r.d f54347d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.r.c f54348e;

    /* renamed from: f  reason: collision with root package name */
    public int f54349f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54350g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f54351e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54351e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54351e.f54348e) == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f54352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f54353f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f54354g;

        public b(n nVar, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54354g = nVar;
            this.f54352e = jSONArray;
            this.f54353f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54354g.f54348e) == null) {
                return;
            }
            cVar.u(this.f54352e, this.f54353f);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f54355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f54356f;

        public c(n nVar, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54356f = nVar;
            this.f54355e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54356f.f54348e) == null) {
                return;
            }
            cVar.w(this.f54355e);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f54357e;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54357e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54357e.f54348e) == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f54358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f54359f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f54360g;

        public e(n nVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54360g = nVar;
            this.f54358e = z;
            this.f54359f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54360g.f54348e) == null) {
                return;
            }
            if (this.f54358e) {
                cVar.y(this.f54359f);
            } else {
                cVar.x(this.f54359f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public q f54361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f54362f;

        public f(n nVar, q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54362f = nVar;
            this.f54361e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54362f.f54348e) == null) {
                return;
            }
            cVar.r(this.f54361e);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f54365e;

        /* renamed from: f  reason: collision with root package name */
        public int f54366f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ n f54367g;

        public h(n nVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54367g = nVar;
            this.f54365e = str;
            this.f54366f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54367g.f54348e) == null) {
                return;
            }
            cVar.a(this.f54365e, this.f54366f);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.q0.r.k f54368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f54369f;

        public i(n nVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54369f = nVar;
            d.a.q0.r.k kVar = new d.a.q0.r.k(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.isSampled());
            this.f54368e = kVar;
            kVar.f54338e = flow.getStartTime();
            this.f54368e.f54341h = "1";
            nVar.f54349f++;
        }

        public void a(boolean z) {
            d.a.q0.r.k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (kVar = this.f54368e) == null) {
                return;
            }
            kVar.l = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54369f.f54348e == null) {
                return;
            }
            this.f54368e.a();
            if (!TextUtils.isEmpty(this.f54369f.f54347d.d(this.f54368e.f54334a))) {
                d.a.q0.r.k kVar = this.f54368e;
                kVar.j = this.f54369f.f54347d.d(kVar.f54334a);
            }
            this.f54369f.f54348e.p(this.f54368e);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f54370e;

        /* renamed from: f  reason: collision with root package name */
        public int f54371f;

        /* renamed from: g  reason: collision with root package name */
        public long f54372g;

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f54373h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ n f54374i;

        public j(n nVar, String str, int i2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54374i = nVar;
            this.f54370e = str;
            this.f54371f = i2;
            this.f54372g = System.currentTimeMillis();
            this.f54373h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54374i.f54348e) == null) {
                return;
            }
            cVar.d(this.f54370e, this.f54371f, this.f54372g, this.f54373h);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f54375e;

        /* renamed from: f  reason: collision with root package name */
        public int f54376f;

        /* renamed from: g  reason: collision with root package name */
        public String f54377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ n f54378h;

        public k(n nVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54378h = nVar;
            this.f54375e = str;
            this.f54376f = i2;
            this.f54377g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.r.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f54378h.f54348e) == null) {
                return;
            }
            cVar.s(this.f54375e, this.f54376f, this.f54377g);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f54379e;

        public l(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54379e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f54379e.f54347d = d.a.q0.r.d.g();
                n nVar = this.f54379e;
                nVar.f54348e = new d.a.q0.r.c(nVar.f54344a);
                this.f54379e.f54348e.o();
            }
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54350g = false;
        g(d.a.q0.r.e.f());
    }

    public static n f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f54343h == null) {
                synchronized (n.class) {
                    if (f54343h == null) {
                        f54343h = new n();
                    }
                }
            }
            return f54343h;
        }
        return (n) invokeV.objValue;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i2)) == null) {
            synchronized (this) {
                d2 = d(str, i2);
                if (d2 != null && d2.getValid()) {
                    i iVar = new i(this, d2, str2);
                    if (this.f54347d != null && this.f54347d.m(str)) {
                        iVar.a(true);
                    }
                    this.f54345b.execute(iVar);
                }
            }
            return d2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f54345b.execute(new d.a.q0.p.a(i2));
        this.f54346c.execute(new d.a.q0.p.a(i2));
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f54345b.execute(new h(this, str, i2));
        }
    }

    public Flow d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f54349f, i2);
            d.a.q0.r.d dVar = this.f54347d;
            if (dVar != null && !dVar.c(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !d.a.q0.r.e.h().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                d.a.q0.r.d dVar2 = this.f54347d;
                if (dVar2 != null && dVar2.i(str) > 0) {
                    if (new Random().nextInt(100) >= this.f54347d.i(str)) {
                        flow.setSampled(true);
                        return flow;
                    }
                }
                d.a.q0.r.d dVar3 = this.f54347d;
                if (dVar3 != null && dVar3.l(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, jSONArray) == null) {
            this.f54345b.execute(new j(this, str, i2, jSONArray));
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.f54344a == null && context != null) {
            if (context instanceof Application) {
                this.f54344a = context;
            } else {
                this.f54344a = context.getApplicationContext();
            }
            int i2 = d.a.q0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.f54349f = i2;
            if (i2 > 1073741823) {
                this.f54349f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            } else {
                this.f54349f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            }
            ExecutorService h2 = h();
            this.f54345b = h2;
            h2.execute(new l(this));
            this.f54346c = Executors.newSingleThreadExecutor();
        }
    }

    public final ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (d.a.q0.r.e.h() != null && !d.a.q0.r.e.h().j()) {
                if (d.a.q0.r.e.h().d() == null) {
                    return Executors.newSingleThreadExecutor();
                }
                return d.a.q0.r.e.h().d();
            }
            return Executors.newSingleThreadExecutor();
        }
        return (ExecutorService) invokeV.objValue;
    }

    public boolean i(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) ? TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20 : invokeLI.booleanValue;
    }

    public void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, str2, i2);
        d.a.q0.r.d dVar = this.f54347d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f54345b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, str, jSONObject, i2) == null) || i(str, i2)) {
            return;
        }
        g gVar = new g(this, str, jSONObject, i2);
        d.a.q0.r.d dVar = this.f54347d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f54345b.execute(gVar);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54345b.execute(new d(this));
        }
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.f54345b.execute(new g(this, str, str2, i2, str3, i3));
        }
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.f54345b.execute(new g(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void o(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, qVar) == null) {
            this.f54345b.execute(new f(this, qVar));
        }
    }

    public void p(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, str2) == null) {
            this.f54345b.execute(new k(this, str, i2, str2));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f54350g) {
            return;
        }
        this.f54350g = true;
        this.f54345b.execute(new a(this));
    }

    public void r(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, jSONArray, str) == null) {
            r.d(jSONArray);
            this.f54346c.execute(new b(this, jSONArray, str));
        }
    }

    public void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            r.d(jSONArray);
            this.f54346c.execute(new c(this, jSONArray));
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            this.f54345b.execute(new e(this, z, str));
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.q0.r.i f54363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f54364f;

        public g(n nVar, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54364f = nVar;
            this.f54363e = new d.a.q0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.q0.r.i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (iVar = this.f54363e) == null) {
                return;
            }
            iVar.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54364f.f54348e == null) {
                return;
            }
            this.f54363e.b();
            if (!TextUtils.isEmpty(this.f54364f.f54347d.d(this.f54363e.f54324a))) {
                d.a.q0.r.i iVar = this.f54363e;
                iVar.f54332i = this.f54364f.f54347d.d(iVar.f54324a);
            }
            d.a.q0.r.i iVar2 = this.f54363e;
            if ((iVar2.f54330g & 8) != 0) {
                this.f54364f.f54348e.l(iVar2);
            } else {
                this.f54364f.f54348e.k(iVar2);
            }
        }

        public g(n nVar, String str, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f54364f = nVar;
            this.f54363e = new d.a.q0.r.i(str, jSONObject, i2);
        }

        public g(n nVar, String str, String str2, int i2, String str3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f54364f = nVar;
            this.f54363e = new d.a.q0.r.i(str, str2, i2, str3, i3);
        }

        public g(n nVar, String str, String str2, int i2, String str3, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f54364f = nVar;
            this.f54363e = new d.a.q0.r.i(str, str2, i2, str3, j, i3);
        }
    }
}
