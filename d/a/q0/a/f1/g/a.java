package d.a.q0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.g.b;
import d.a.q0.a.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47787d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, a> f47788e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f47789a;

    /* renamed from: b  reason: collision with root package name */
    public final b f47790b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47791c;

    /* renamed from: d.a.q0.a.f1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0753a implements d.a.q0.a.v2.e1.b<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47792e;

        public C0753a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47792e = aVar;
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && a.f47787d) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && a.f47787d) {
                c();
            }
        }

        public final synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    a("SwanLaunch", "\n\n\n");
                    a("SwanLaunch", ">>>>>> SWAN Launch Log For " + this.f47792e.f47791c);
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : this.f47792e.f47789a.entrySet()) {
                        sb.append(String.format("%s[%s] ", entry.getKey(), entry.getValue()));
                    }
                    for (b.C0754b c0754b : this.f47792e.f47790b.i()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (String str : c0754b.f47799b) {
                            sb2.append(str);
                            sb2.append(" ");
                        }
                        for (String str2 : c0754b.f47798a) {
                            String h2 = this.f47792e.f47790b.h();
                            a(TextUtils.isEmpty(c0754b.f47800c) ? h2 : c0754b.f47800c, String.format(Locale.getDefault(), "[%s]> %s%s>>> %s", h2, sb, sb2, str2));
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040961011, "Ld/a/q0/a/f1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040961011, "Ld/a/q0/a/f1/g/a;");
                return;
            }
        }
        f47787d = k.f49133a;
        f47788e = new HashMap();
    }

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47789a = new HashMap();
        b bVar = new b();
        bVar.g("SwanLaunch");
        bVar.l(c());
        this.f47790b = bVar;
        this.f47791c = str;
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            a aVar = f47788e.get(str);
            if (aVar == null) {
                a aVar2 = new a(str);
                f47788e.put(str, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final d.a.q0.a.v2.e1.b<b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0753a(this) : (d.a.q0.a.v2.e1.b) invokeV.objValue;
    }

    public b.C0754b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47790b.d() : (b.C0754b) invokeV.objValue;
    }

    public b.C0754b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f47790b.e(str) : (b.C0754b) invokeL.objValue;
    }

    public b.C0754b g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this.f47790b.f(str, str2) : (b.C0754b) invokeLL.objValue;
    }

    public synchronized a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                this.f47790b.j();
            }
            return this;
        }
        return (a) invokeV.objValue;
    }
}
