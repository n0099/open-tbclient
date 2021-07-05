package d.a.h0.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class h extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f45649a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, e> f45650b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f45651a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-20474621, "Ld/a/h0/c/h$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-20474621, "Ld/a/h0/c/h$b;");
                    return;
                }
            }
            f45651a = new h(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577630593, "Ld/a/h0/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1577630593, "Ld/a/h0/c/h;");
                return;
            }
        }
        f45649a = new HashMap<>();
        f45650b = new HashMap<>();
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f45651a : (h) invokeV.objValue;
    }

    @Override // d.a.h0.c.e
    public boolean b(Context context, g gVar, d.a.h0.c.a aVar) {
        InterceptResult invokeLLL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, gVar, aVar)) == null) {
            String e2 = gVar.e();
            if (f45649a.get(e2) != null) {
                gVar.j(e2, f45649a.get(e2));
            }
            String g2 = gVar.g(true);
            if (TextUtils.isEmpty(g2) || (eVar = f45650b.get(g2)) == null) {
                return false;
            }
            return eVar.b(context, gVar, aVar);
        }
        return invokeLLL.booleanValue;
    }

    @Override // d.a.h0.c.e
    public boolean c(Context context, g gVar, d.a.h0.c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, gVar, aVar)) == null) {
            gVar.m = j.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, eVar) == null) || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        f45650b.put(str, eVar);
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.a(f45649a);
    }

    public h() {
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
}
