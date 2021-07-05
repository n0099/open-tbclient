package d.a.q0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.n.h.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49531a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f49532b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f49533c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f49534d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1735501812, "Ld/a/q0/a/n0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1735501812, "Ld/a/q0/a/n0/h/b;");
                return;
            }
        }
        f49531a = k.f49133a;
        f49532b = new HashMap();
        f49533c = new Object();
        f49534d = c.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f49534d) {
            if (f49531a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (f49533c) {
                f49532b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f49534d) {
                return Collections.emptySet();
            }
            synchronized (f49533c) {
                strArr = (String[]) f49532b.keySet().toArray(new String[0]);
            }
            return d.a.q0.a.v2.z0.a.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f49534d && !TextUtils.isEmpty(str)) {
                synchronized (f49533c) {
                    containsKey = f49532b.containsKey(str);
                }
                if (f49531a) {
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
        if ((interceptable == null || interceptable.invokeL(65540, null, str) == null) && f49534d) {
            if (f49531a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f49533c) {
                Integer num = f49532b.get(str);
                if (num == null) {
                    f49532b.put(str, 1);
                } else {
                    f49532b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(d.a.q0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, fVar) == null) && f49534d && fVar != null) {
            for (d.a.q0.n.h.e eVar : fVar.h()) {
                if (eVar instanceof d.a.q0.n.h.f) {
                    d(eVar.f53938g);
                } else if (eVar instanceof g) {
                    d(((g) eVar).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f49534d) {
            if (f49531a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f49533c) {
                Integer num = f49532b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        f49532b.remove(str);
                    } else {
                        f49532b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
