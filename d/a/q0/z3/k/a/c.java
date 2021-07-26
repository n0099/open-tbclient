package d.a.q0.z3.k.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f67489a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.q0.u3.h.a f67490b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f67491c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-509125707, "Ld/a/q0/z3/k/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-509125707, "Ld/a/q0/z3/k/a/c;");
                return;
            }
        }
        f67489a = TimeUnit.DAYS.toMillis(5L);
        f67490b = new d.a.q0.u3.h.a("camera_last_api", 0, "camera_last_api_stamp");
        f67491c = "Lenovo K520".equals(Build.MODEL);
    }
}
