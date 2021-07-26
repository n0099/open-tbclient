package d.a.o0.h.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.h.m0.c;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50543a;

    /* renamed from: b  reason: collision with root package name */
    public static long f50544b;

    /* renamed from: c  reason: collision with root package name */
    public static String f50545c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355461903, "Ld/a/o0/h/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355461903, "Ld/a/o0/h/j/a;");
                return;
            }
        }
        f50543a = k.f46335a;
        f50544b = 86400000L;
        f50545c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            e i2 = e.i();
            d.a.o0.a.y.b.a aVar = null;
            if (jsObject == null || i2 == null || !b(i2)) {
                bVar = null;
            } else {
                if (f50543a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
                String C = G.C("swanGameId");
                if (TextUtils.isEmpty(C)) {
                    bVar = null;
                } else {
                    d.a.o0.a.k2.g.b a2 = h.a();
                    if (!c(Long.valueOf(a2.getLong(C + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(C + "_Duration", 0L);
                    }
                    bVar = new b();
                    bVar.duration = a2.getLong(C + "_Duration", 0L);
                }
                aVar = G;
            }
            c.a(aVar, true, bVar);
        }
    }

    public static boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            String string = h.a().getString(f50545c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (e.V().contains(jSONArray.optString(i2))) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (f50543a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    public static void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || e.i() == null || TextUtils.isEmpty(e.V())) {
            return;
        }
        String V = e.V();
        d.a.o0.a.k2.g.b a2 = h.a();
        long j3 = a2.getLong(V + "_LastPause", 0L);
        long j4 = a2.getLong(V + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(V + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(V + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(V + "_Duration", j2 % f50544b);
        }
        a2.putLong(V + "_LastPause", System.currentTimeMillis());
    }
}
