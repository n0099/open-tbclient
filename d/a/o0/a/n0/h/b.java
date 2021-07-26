package d.a.o0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import d.a.o0.n.h.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46733a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f46734b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f46735c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f46736d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477336374, "Ld/a/o0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1477336374, "Ld/a/o0/a/n0/h/b;");
                return;
            }
        }
        f46733a = k.f46335a;
        f46734b = new HashMap();
        f46735c = new Object();
        f46736d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f46736d) {
            if (f46733a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f46735c) {
                f46734b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f46736d) {
                return Collections.emptySet();
            }
            synchronized (f46735c) {
                strArr = (String[]) f46734b.keySet().toArray(new String[0]);
            }
            return d.a.o0.a.v2.z0.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f46736d && !TextUtils.isEmpty(str)) {
                synchronized (f46735c) {
                    containsKey = f46734b.containsKey(str);
                }
                if (f46733a) {
                    Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
                }
                return containsKey;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && f46736d) {
            if (f46733a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f46735c) {
                Integer num = f46734b.get(str);
                if (num == null) {
                    f46734b.put(str, 1);
                } else {
                    f46734b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(d.a.o0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, fVar) == null) && f46736d && fVar != null) {
            for (d.a.o0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof d.a.o0.n.h.f) {
                    d(eVar.f51140g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f46736d) {
            if (f46733a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f46735c) {
                Integer num = f46734b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f46734b.remove(str);
                    } else {
                        f46734b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
