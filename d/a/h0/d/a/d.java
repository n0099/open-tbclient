package d.a.h0.d.a;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f45665a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f45666b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f45667c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(7956626, "Ld/a/h0/d/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(7956626, "Ld/a/h0/d/a/d;");
                return;
            }
        }
        int max = Math.max(200, d.a.h0.a.b.a.f45561a.get().t());
        f45665a = max;
        f45666b = max;
        f45667c = max;
        Log.e("HttpRequestConstan", "static initializer: " + f45665a + " " + f45666b);
    }
}
