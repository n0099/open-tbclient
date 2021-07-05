package d.a.q0.a.h0.l;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.l0.g;
import d.a.q0.a.l0.j;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48150d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.a f48151a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.y.a f48152b;

    /* renamed from: c  reason: collision with root package name */
    public j f48153c;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a.l0.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f48154a;

        /* renamed from: b  reason: collision with root package name */
        public String f48155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f48156c;

        public a(@NonNull d dVar, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48156c = dVar;
            this.f48154a = str;
            this.f48155b = str2;
            if (d.f48150d) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // d.a.q0.a.l0.n.b
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48155b : (String) invokeV.objValue;
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (d.f48150d) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.f48154a);
                }
                return d.a.q0.a.h0.d.a.a("appframe", this.f48154a);
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        public void c(d.a.q0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                if (this.f48156c.f48153c != null) {
                    this.f48156c.f48153c.a(aVar);
                }
                aVar.y0();
            }
        }

        @Override // d.a.q0.a.l0.n.a, d.a.q0.a.l0.n.b
        public void d(d.a.q0.a.l0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                this.f48156c.f48152b.b(aVar, d.a.q0.a.c1.a.b());
            }
        }

        @Override // d.a.q0.a.l0.n.b
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48154a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705566248, "Ld/a/q0/a/h0/l/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705566248, "Ld/a/q0/a/h0/l/d;");
                return;
            }
        }
        f48150d = k.f49133a;
    }

    public d(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48152b = new d.a.q0.a.y.a();
        this.f48151a = d.a.q0.a.l0.f.c(e(), new a(this, str, str2), d.a.q0.a.r1.l.e.m() ? new f() : null);
    }

    public void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.f48152b.a(activity);
        }
    }

    public g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g.b bVar = new g.b();
            bVar.c(1);
            bVar.b(d.a.q0.a.h0.l.g.e.b());
            return bVar.a();
        }
        return (g) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f48151a.k0();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48151a.f49229g : (String) invokeV.objValue;
    }

    public d.a.q0.a.l0.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48151a : (d.a.q0.a.l0.a) invokeV.objValue;
    }

    public void i(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSCacheCallback) == null) {
            this.f48151a.B0(jSCacheCallback);
        }
    }

    public void j(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, codeCacheSetting) == null) {
            this.f48151a.C0(codeCacheSetting);
        }
    }

    public void k(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jVar) == null) {
            this.f48153c = jVar;
        }
    }
}
