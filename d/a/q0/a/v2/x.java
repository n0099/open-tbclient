package d.a.q0.a.v2;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51433a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924445, "Ld/a/q0/a/v2/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924445, "Ld/a/q0/a/v2/x;");
                return;
            }
        }
        f51433a = d.a.q0.a.k.f49133a;
    }

    public static void a(Context context, IBinder iBinder) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, iBinder) == null) || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        try {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        } catch (Exception e2) {
            if (f51433a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Context context, boolean z) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(z ? 2 : 0, 2);
    }
}
