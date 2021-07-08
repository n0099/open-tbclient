package d.a.e0.d.a;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f42313a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42314b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42315c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1135352719, "Ld/a/e0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1135352719, "Ld/a/e0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, d.a.e0.a.b.a.f42209a.get().t());
        f42313a = max;
        f42314b = max;
        f42315c = max;
        Log.e("HttpRequestConstan", "static initializer: " + f42313a + " " + f42314b);
    }
}
