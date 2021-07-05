package d.b.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f71696a;

    /* renamed from: b  reason: collision with root package name */
    public static String f71697b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413434725, "Ld/b/a/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413434725, "Ld/b/a/l0;");
                return;
            }
        }
        f71696a = new AtomicBoolean(false);
        f71697b = "";
    }

    public static String a(SharedPreferences sharedPreferences) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sharedPreferences)) == null) {
            if (f71696a.compareAndSet(false, true)) {
                String string = sharedPreferences.getString("cdid", "");
                f71697b = string;
                if (TextUtils.isEmpty(string)) {
                    f71697b = UUID.randomUUID().toString();
                    sharedPreferences.edit().putString("cdid", f71697b).apply();
                }
            }
            return f71697b;
        }
        return (String) invokeL.objValue;
    }
}
