package d.a.s0.n1.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.c.f;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.r0.c.e> f63768a;

    /* renamed from: d.a.s0.n1.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1603a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f63769a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(830251133, "Ld/a/s0/n1/m/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(830251133, "Ld/a/s0/n1/m/a$b;");
                    return;
                }
            }
            f63769a = new a(null);
        }
    }

    public /* synthetic */ a(C1603a c1603a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f63769a : (a) invokeV.objValue;
    }

    public void b(d.a.r0.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            c(eVar.a(), eVar);
        }
    }

    public final void c(String str, d.a.r0.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar) == null) {
            this.f63768a.put(str, eVar);
        }
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.a.r0.c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, hashMap, fVar) == null) || str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f63768a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

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
        this.f63768a = new HashMap<>();
    }
}
