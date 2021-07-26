package d.a.x0.e;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f69086a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f69087b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f69088c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1402120330, "Ld/a/x0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1402120330, "Ld/a/x0/e/a;");
                return;
            }
        }
        f69086a = new AtomicBoolean(false);
        f69087b = new HashMap<>();
        f69088c = new HashMap<>();
    }

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (f69088c.containsKey(Integer.valueOf(i2))) {
                return f69088c.get(Integer.valueOf(i2)).longValue();
            }
            return Long.MAX_VALUE;
        }
        return invokeI.longValue;
    }

    public static SharedPreferences b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getSharedPreferences("CONFIG_RUNTIME", 0) : (SharedPreferences) invokeL.objValue;
    }

    public static synchronized void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (a.class) {
                if (!f69086a.get()) {
                    SharedPreferences b2 = b(context);
                    Iterator<Integer> it = b.f69089a.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        HashMap<Integer, Long> hashMap = f69088c;
                        Integer valueOf = Integer.valueOf(intValue);
                        hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                        HashMap<Integer, Boolean> hashMap2 = f69087b;
                        Integer valueOf2 = Integer.valueOf(intValue);
                        hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                    }
                    f69088c.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Long.MAX_VALUE);
                    f69087b.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Boolean.TRUE);
                    f69086a.set(true);
                }
            }
        }
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (f69087b.containsKey(Integer.valueOf(i2))) {
                return f69087b.get(Integer.valueOf(i2)).booleanValue();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
