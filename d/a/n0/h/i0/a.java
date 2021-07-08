package d.a.n0.h.i0;

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
import d.a.n0.a.a2.e;
import d.a.n0.a.k;
import d.a.n0.h.c0.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50024b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f50025c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.h.c0.a.a f50026a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1670009933, "Ld/a/n0/h/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1670009933, "Ld/a/n0/h/i0/a;");
                return;
            }
        }
        f50024b = k.f45831a;
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
            if (f50025c == null) {
                synchronized (a.class) {
                    if (f50025c == null) {
                        f50025c = new a();
                    }
                }
            }
            return f50025c;
        }
        return (a) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        d.a.n0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (aVar = this.f50026a) == null || (cVar = aVar.f49885d) == null || (hashMap = cVar.f49895a) == null) {
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
        d.a.n0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C1086a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str) && (aVar = this.f50026a) != null && (bVar = aVar.f49884c) != null && (list = bVar.f49893a) != null) {
                for (a.C1086a c1086a : list) {
                    if (TextUtils.equals(c1086a.f49889a, str) || TextUtils.equals(c1086a.f49890b, str)) {
                        if (i2 != 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        return c1086a.f49890b;
                                    }
                                    return c1086a.f49892d;
                                }
                                return c1086a.f49891c;
                            }
                            return c1086a.f49890b;
                        }
                        return c1086a.f49889a;
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
            d.a.n0.h.c0.a.a aVar = this.f50026a;
            if (aVar != null && (bVar = aVar.f49884c) != null && (hashMap = bVar.f49894b) != null && hashMap.containsKey(c2)) {
                if (f50024b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.f50026a.f49884c.f49894b.get(c2).booleanValue();
            }
            if (f50024b) {
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
            boolean m = d.a.n0.n.g.a.h().m(V, Z, c2);
            if (m) {
                f(c2, true);
            }
            return m;
        }
        return invokeL.booleanValue;
    }

    public void e(d.a.n0.h.c0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f50026a = aVar;
        }
    }

    public void f(String str, boolean z) {
        d.a.n0.h.c0.a.a aVar;
        a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (aVar = this.f50026a) == null || (bVar = aVar.f49884c) == null || bVar.f49894b == null) {
            return;
        }
        if (f50024b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f50026a.f49884c.f49894b.put(str, Boolean.valueOf(z));
    }
}
