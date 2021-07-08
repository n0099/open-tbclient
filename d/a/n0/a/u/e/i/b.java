package d.a.n0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c1.d.d;
import d.a.n0.a.e0.d;
import d.a.n0.a.k;
import d.a.n0.a.s1.e;
import d.a.n0.a.s1.f;
import d.a.n0.a.u.e.i.a;
import d.a.n0.a.v2.q0;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f47651b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f47652a;

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f47653a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47654b;

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
            this.f47654b = bVar;
            this.f47653a = cVar;
        }

        @Override // d.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f47654b.c(this.f47653a);
            }
        }

        @Override // d.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                d.b("GetLocationHelper", str);
                this.f47654b.f47652a.f(this.f47653a, str);
            }
        }
    }

    /* renamed from: d.a.n0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0921b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f47655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f47656b;

        public C0921b(b bVar, a.c cVar) {
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
            this.f47656b = bVar;
            this.f47655a = cVar;
        }

        @Override // d.a.n0.a.c1.d.d.a
        public void a(d.a.n0.a.c2.f.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f47656b.f47652a.g(this.f47655a, bVar);
            }
        }

        @Override // d.a.n0.a.c1.d.d.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f47656b.f47652a.b(this.f47655a, i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, d.a.n0.a.c2.f.k0.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231529287, "Ld/a/n0/a/u/e/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231529287, "Ld/a/n0/a/u/e/i/b;");
                return;
            }
        }
        boolean z = k.f45831a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f47651b == null) {
                synchronized (b.class) {
                    if (f47651b == null) {
                        f47651b = new b();
                    }
                }
            }
            return f47651b;
        }
        return (b) invokeV.objValue;
    }

    public final void c(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.f47648a, "gcj02")) {
                str = TextUtils.equals(cVar.f47648a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
            }
            d.a.n0.a.c1.a.E().b(str, false, cVar.f47649b, new C0921b(this, cVar));
        }
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.f47652a = cVar2;
            if (q0.L()) {
                c(cVar);
            } else if (z) {
                this.f47652a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                a aVar = new a(this, cVar);
                e.f(d.a.n0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
            }
        }
    }
}
