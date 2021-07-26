package d.a.q0.n1.m;

import android.net.Uri;
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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.p0.c.d> f61150a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.n1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1565b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f61151a;

        /* renamed from: b  reason: collision with root package name */
        public String f61152b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, String> f61153c;

        public C1565b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61151a = false;
            Uri parse = Uri.parse(str);
            this.f61151a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.f61152b = parse.getAuthority() + parse.getPath();
                this.f61153c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.f61153c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.f61152b = "";
            this.f61153c = new HashMap<>();
        }

        public static C1565b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new C1565b(str) : (C1565b) invokeL.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61152b : (String) invokeV.objValue;
        }

        public HashMap<String, String> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61153c : (HashMap) invokeV.objValue;
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str) && e()) {
                    for (String str2 : this.f61153c.keySet()) {
                        if (str.equals(str2)) {
                            return this.f61153c.get(str2);
                        }
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61151a : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f61154a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(572115517, "Ld/a/q0/n1/m/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(572115517, "Ld/a/q0/n1/m/b$c;");
                    return;
                }
            }
            f61154a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f61154a : (b) invokeV.objValue;
    }

    public void b(d.a.p0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            c(aVar.c(), aVar);
        }
    }

    public void c(String str, d.a.p0.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            this.f61150a.put(str, dVar);
        }
    }

    public void d(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str) == null) || str == null) {
            return;
        }
        C1565b a2 = C1565b.a(str);
        d.a.p0.c.d dVar = this.f61150a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        dVar.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, d.a.d.a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, obj, str, hashMap, eVar) == null) || str == null) {
            return;
        }
        C1565b a2 = C1565b.a(str);
        d.a.p0.c.d dVar = this.f61150a.get(a2.b());
        if (dVar == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        dVar.a(obj, a2.c(), str, eVar);
    }

    public b() {
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
        this.f61150a = new HashMap<>();
    }
}
