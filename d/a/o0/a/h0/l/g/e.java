package d.a.o0.a.h0.l.g;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45390a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f45391b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(455529841, "Ld/a/o0/a/h0/l/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(455529841, "Ld/a/o0/a/h0/l/g/e;");
                return;
            }
        }
        f45390a = d.a.o0.a.k.f46335a;
        f45391b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str != null && str.startsWith("master") : invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = "master";
            if (d.a.o0.a.h0.o.e.a.f()) {
                int andIncrement = f45391b.getAndIncrement();
                if (andIncrement >= 1) {
                    str = "master" + andIncrement;
                }
                if (f45390a) {
                    Log.i("MasterIdGenerator", "next master id - " + str);
                }
                return str;
            }
            return "master";
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int andSet = f45391b.getAndSet(0);
            if (f45390a) {
                Log.i("MasterIdGenerator", "last master id - " + andSet);
            }
            return andSet;
        }
        return invokeV.intValue;
    }
}
