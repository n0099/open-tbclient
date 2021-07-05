package ms.bd.c;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.JProtect;
@Keep
@JProtect
/* loaded from: classes10.dex */
public class w1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f76114a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context != null) {
                try {
                    new DisplayMetrics();
                    f76114a = context.getResources().getDisplayMetrics().densityDpi;
                } catch (Throwable unused) {
                }
            }
            return "" + f76114a;
        }
        return (String) invokeL.objValue;
    }
}
