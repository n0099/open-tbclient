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
/* loaded from: classes8.dex */
public final class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f68799a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68800b;
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
        f68799a = new AtomicBoolean(false);
        f68800b = "";
    }

    public static String a(SharedPreferences sharedPreferences) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sharedPreferences)) == null) {
            if (f68799a.compareAndSet(false, true)) {
                String string = sharedPreferences.getString("cdid", "");
                f68800b = string;
                if (TextUtils.isEmpty(string)) {
                    f68800b = UUID.randomUUID().toString();
                    sharedPreferences.edit().putString("cdid", f68800b).apply();
                }
            }
            return f68800b;
        }
        return (String) invokeL.objValue;
    }
}
