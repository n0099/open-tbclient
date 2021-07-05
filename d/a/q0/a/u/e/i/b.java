package d.a.q0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c1.d.d;
import d.a.q0.a.e0.d;
import d.a.q0.a.k;
import d.a.q0.a.s1.e;
import d.a.q0.a.s1.f;
import d.a.q0.a.u.e.i.a;
import d.a.q0.a.v2.q0;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f50953b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f50954a;

    /* loaded from: classes8.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f50955a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f50956b;

        public a(b bVar, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50956b = bVar;
            this.f50955a = cVar;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f50956b.c(this.f50955a);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.b("GetLocationHelper", str);
                this.f50956b.f50954a.f(this.f50955a, str);
            }
        }
    }

    /* renamed from: d.a.q0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0972b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f50957a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f50958b;

        public C0972b(b bVar, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50958b = bVar;
            this.f50957a = cVar;
        }

        @Override // d.a.q0.a.c1.d.d.a
        public void a(d.a.q0.a.c2.f.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f50958b.f50954a.g(this.f50957a, bVar);
            }
        }

        @Override // d.a.q0.a.c1.d.d.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f50958b.f50954a.b(this.f50957a, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, d.a.q0.a.c2.f.k0.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111738308, "Ld/a/q0/a/u/e/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111738308, "Ld/a/q0/a/u/e/i/b;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f50953b == null) {
                synchronized (b.class) {
                    if (f50953b == null) {
                        f50953b = new b();
                    }
                }
            }
            return f50953b;
        }
        return (b) invokeV.objValue;
    }

    public final void c(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.f50950a, "gcj02")) {
                str = TextUtils.equals(cVar.f50950a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
            }
            d.a.q0.a.c1.a.E().b(str, false, cVar.f50951b, new C0972b(this, cVar));
        }
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.f50954a = cVar2;
            if (q0.L()) {
                c(cVar);
            } else if (z) {
                this.f50954a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                a aVar = new a(this, cVar);
                e.f(d.a.q0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
            }
        }
    }
}
