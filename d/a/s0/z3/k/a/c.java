package d.a.s0.z3.k.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f70008a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.s0.u3.i.a f70009b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f70010c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-250960269, "Ld/a/s0/z3/k/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-250960269, "Ld/a/s0/z3/k/a/c;");
                return;
            }
        }
        f70008a = TimeUnit.DAYS.toMillis(5L);
        f70009b = new d.a.s0.u3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f70010c = "Lenovo K520".equals(Build.MODEL);
    }
}
