package d.a.n0.a.t1.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.a1.e;
import d.a.n0.a.k;
import d.a.n0.a.v2.l0;
import d.a.n0.n.h.h;
import d.a.n0.t.d;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47416a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1888119104, "Ld/a/n0/a/t1/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1888119104, "Ld/a/n0/a/t1/e/a;");
                return;
            }
        }
        f47416a = k.f45831a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = e.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                h hVar = new h();
                hVar.f50636g = str;
                hVar.f50638i = -1L;
                d.a.n0.n.g.a.h().f(hVar);
            }
        }
        e.C0629e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = e.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<h> j = d.a.n0.a.t1.b.a.j(str);
        for (String str2 : list) {
            long j2 = -1;
            try {
                j2 = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                if (f47416a) {
                    d.a.n0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
            }
            if (!c(j2, j)) {
                d.K(e.t(str, str2));
                d.a.n0.a.t1.d.a.a("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        h hVar = null;
        if (j != null) {
            if (j.size() == 1) {
                hVar = j.get(0);
            } else if (j.size() >= 2) {
                hVar = j.get(1);
            }
        }
        if (hVar != null) {
            d.a.n0.n.g.a.h().f(hVar);
        }
    }

    public static boolean c(long j, List<h> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i2 = 0; i2 < min; i2++) {
                    h hVar = list.get(i2);
                    if (hVar != null && (j == hVar.f50638i || j == l0.c(hVar.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
