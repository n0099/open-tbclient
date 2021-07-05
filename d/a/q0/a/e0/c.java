package d.a.q0.a.e0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47284a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, d.a.q0.a.p.e.a> f47285b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(114164355, "Ld/a/q0/a/e0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(114164355, "Ld/a/q0/a/e0/c;");
                return;
            }
        }
        f47284a = k.f49133a;
        f47285b = new HashMap(2);
    }

    public static d.a.q0.a.p.e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f47284a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            d.k(true);
            return g.N().X().a(AppRuntime.getAppContext());
        }
        return (d.a.q0.a.p.e.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized d.a.q0.a.p.e.a b() {
        InterceptResult invokeV;
        String str;
        d.a.q0.a.p.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c.class) {
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                if (Q != null && !TextUtils.isEmpty(Q.getAppId())) {
                    str = Q.getAppId();
                    String a2 = d.a.q0.a.v.a.a(str);
                    aVar = f47285b.get(a2);
                    if (aVar == null) {
                        e();
                        aVar = a();
                        f47285b.put(a2, aVar);
                        if (f47284a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (f47284a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = d.a.q0.a.v.a.a(str);
                aVar = f47285b.get(a22);
                if (aVar == null) {
                }
                if (f47284a) {
                }
            }
            return aVar;
        }
        return (d.a.q0.a.p.e.a) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q != null && !TextUtils.isEmpty(Q.f46683f)) {
                return b.b(d.a.q0.a.v.a.a(Q.f46683f));
            }
            if (f47284a) {
                Log.w("ConsoleCache", "swanApp is null or appId is empty");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65540, null) == null) && c()) {
            b();
        }
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (c.class) {
                if (f47285b.size() > 0) {
                    for (String str : f47285b.keySet()) {
                        d.a.q0.a.p.e.a aVar = f47285b.get(str);
                        if (aVar != null) {
                            aVar.E();
                        }
                    }
                    f47285b.clear();
                }
            }
        }
    }
}
