package d.a.n0.a.n0.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f46282a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a<Boolean>> f46283b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a<b>> f46284c;

    /* renamed from: d  reason: collision with root package name */
    public a<Exception> f46285d;

    /* loaded from: classes7.dex */
    public static class a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Set<d.a.n0.a.v2.e1.b<T>> f46286a;

        public a() {
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
            this.f46286a = new HashSet();
        }

        public void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                for (d.a.n0.a.v2.e1.b<T> bVar : this.f46286a) {
                    bVar.onCallback(t);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f46286a.clear();
            }
        }

        public void c(d.a.n0.a.v2.e1.b<T> bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f46286a.add(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f46287a;

        /* renamed from: b  reason: collision with root package name */
        public final long f46288b;

        public b(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46287a = j;
            this.f46288b = j2;
            int i4 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46288b > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1348343090, "Ld/a/n0/a/n0/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1348343090, "Ld/a/n0/a/n0/k/d;");
                return;
            }
        }
        boolean z = k.f45831a;
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
        this.f46282a = new HashSet();
        this.f46283b = new HashMap();
        this.f46284c = new HashMap();
        this.f46285d = new a<>();
    }

    public static <T> a<T> i(Map<String, a<T>> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, map, str)) == null) {
            a<T> aVar = map.get(str);
            if (aVar == null) {
                a<T> aVar2 = new a<>();
                map.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public HashSet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new HashSet<>(this.f46282a) : (HashSet) invokeV.objValue;
    }

    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            this.f46285d.a(exc);
            this.f46285d.b();
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            a i2 = i(this.f46283b, str);
            i2.a(Boolean.valueOf(z));
            i2.b();
        }
    }

    public void d(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            if (bVar == null || bVar.a()) {
                i(this.f46284c, str).a(bVar);
            }
        }
    }

    public d e(d.a.n0.a.v2.e1.b<Exception> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            this.f46285d.c(bVar);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
            this.f46282a.addAll(Arrays.asList(strArr));
            return this;
        }
        return (d) invokeL.objValue;
    }

    public final <T> d g(Map<String, a<T>> map, String str, d.a.n0.a.v2.e1.b<T> bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, map, str, bVar)) == null) {
            f(str);
            i(map, str).c(bVar);
            return this;
        }
        return (d) invokeLLL.objValue;
    }

    public d h(String str, d.a.n0.a.v2.e1.b<Boolean> bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, bVar)) == null) {
            g(this.f46283b, str, bVar);
            return this;
        }
        return (d) invokeLL.objValue;
    }
}
