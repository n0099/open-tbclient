package d.a.q0.a.e2.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47608f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i<ResultDataT> f47609a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.a.q0.a.v2.e1.b<i<ResultDataT>>> f47610b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f47611c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47613e;

    /* loaded from: classes8.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f47614g;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47614g = cVar;
        }

        @Override // d.a.q0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f47614g.l()) {
                    return true;
                }
                d.j("initialPrepare failed", Boolean.TRUE);
                throw new OAuthException(10001);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f47615g;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47615g = cVar;
        }

        @Override // d.a.q0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f47615g.k()) {
                    return true;
                }
                d.j("finalPrepare failed", Boolean.TRUE);
                if (c.f47608f) {
                    throw new OAuthException(10001);
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: d.a.q0.a.e2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0737c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f47616e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f47617f;

        public RunnableC0737c(c cVar, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47617f = cVar;
            this.f47616e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.q0.a.v2.e1.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f47616e) == null) {
                return;
            }
            bVar.onCallback(this.f47617f.f47609a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1899954643, "Ld/a/q0/a/e2/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1899954643, "Ld/a/q0/a/e2/c/c;");
                return;
            }
        }
        f47608f = k.f49133a;
    }

    public c() {
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
        this.f47609a = new i<>();
        this.f47610b = new HashSet();
        this.f47611c = new LinkedList<>();
        this.f47612d = false;
        this.f47613e = false;
    }

    @NonNull
    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TaskState.INIT == f()) {
                t(TaskState.CALLING);
                o();
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public final synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                j();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b bVar = new b(this);
            bVar.h(this);
            bVar.g();
            this.f47613e = true;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(null);
        }
    }

    public void e(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            if (exc instanceof OAuthException) {
                this.f47609a.f47672c = (OAuthException) exc;
            } else if (exc != null) {
                d.s("OAuthTask#finish", exc.getMessage());
                this.f47609a.f47672c = new OAuthException(exc, 10001);
            }
            if (!this.f47609a.c() && f47608f && exc != null) {
                exc.printStackTrace();
            }
            t(TaskState.FINISHED);
            d.j(toString(), Boolean.FALSE);
            h();
            this.f47610b.clear();
        }
    }

    public TaskState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f47609a.f47671b : (TaskState) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a aVar = new a(this);
            aVar.h(this);
            aVar.g();
            this.f47612d = true;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (d.a.q0.a.v2.e1.b<i<ResultDataT>> bVar : this.f47610b) {
                d.k(new RunnableC0737c(this, bVar));
            }
        }
    }

    public c i(@NonNull e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar)) == null) {
            eVar.h(this);
            this.f47611c.offer(eVar);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public abstract void j();

    public abstract boolean k();

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            if (eVar.c()) {
                o();
            } else {
                e(eVar.b());
            }
        }
    }

    public abstract ResultDataT n(JSONObject jSONObject) throws JSONException;

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!TaskState.CALLING.equals(f())) {
                if (f47608f) {
                    d.j("IllegalState on prepare", Boolean.FALSE);
                }
            } else if (!this.f47612d) {
                g();
            } else if (!this.f47611c.isEmpty()) {
                this.f47611c.poll().g();
            } else if (!this.f47613e) {
                c();
            } else {
                b();
            }
        }
    }

    public c<ResultDataT> p(d.a.q0.a.v2.e1.b<i<ResultDataT>> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bVar)) == null) {
            if (this.f47609a.f47671b.isCallbackAvailable()) {
                this.f47610b.add(bVar);
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f47609a.f47671b = TaskState.INIT;
            this.f47612d = false;
            this.f47613e = false;
        }
    }

    public c<ResultDataT> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this : (c) invokeL.objValue;
    }

    public void s(ResultDataT resultdatat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, resultdatat) == null) {
            this.f47609a.f47670a = resultdatat;
        }
    }

    public final void t(TaskState taskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, taskState) == null) {
            this.f47609a.f47671b = taskState;
        }
    }
}
