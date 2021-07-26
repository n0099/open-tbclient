package d.a.o0.h.i0;

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
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import d.a.o0.h.c0.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50528b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f50529c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.h.c0.a.a f50530a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1866523438, "Ld/a/o0/h/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1866523438, "Ld/a/o0/h/i0/a;");
                return;
            }
        }
        f50528b = k.f46335a;
    }

    public a() {
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

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f50529c == null) {
                synchronized (a.class) {
                    if (f50529c == null) {
                        f50529c = new a();
                    }
                }
            }
            return f50529c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        d.a.o0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.f50530a) == null || (cVar = aVar.f50389d) == null || (hashMap = cVar.f50399a) == null) {
                return null;
            }
            return hashMap.get(c2);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i2) {
        InterceptResult invokeLI;
        d.a.o0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C1095a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f50530a) != null && (bVar = aVar.f50388c) != null && (list = bVar.f50397a) != null) {
                for (a.C1095a c1095a : list) {
                    if (TextUtils.equals(c1095a.f50393a, str) || TextUtils.equals(c1095a.f50394b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c1095a.f50394b;
                                    }
                                    return c1095a.f50396d;
                                }
                                return c1095a.f50395c;
                            }
                            return c1095a.f50394b;
                        }
                        return c1095a.f50393a;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        a.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            d.a.o0.h.c0.a.a aVar = this.f50530a;
            if (aVar != null && (bVar = aVar.f50388c) != null && (hashMap = bVar.f50398b) != null && hashMap.containsKey(c2)) {
                if (f50528b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.f50530a.f50388c.f50398b.get(c2).booleanValue();
            }
            if (f50528b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String V = e.V();
            if (e.i() == null) {
                return false;
            }
            String Z = e.i().Z();
            if (TextUtils.isEmpty(V) || TextUtils.isEmpty(Z)) {
                return false;
            }
            boolean m = d.a.o0.n.g.a.h().m(V, Z, c2);
            if (m) {
                f(c2, true);
            }
            return m;
        }
        return invokeL.booleanValue;
    }

    public void e(d.a.o0.h.c0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f50530a = aVar;
        }
    }

    public void f(String str, boolean z) {
        d.a.o0.h.c0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.f50530a) == null || (bVar = aVar.f50388c) == null || bVar.f50398b == null) {
            return;
        }
        if (f50528b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f50530a.f50388c.f50398b.put(str, Boolean.valueOf(z));
    }
}
