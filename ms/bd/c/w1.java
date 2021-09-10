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
/* loaded from: classes2.dex */
public class w1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f79342a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context != null) {
                try {
                    new DisplayMetrics();
                    f79342a = context.getResources().getDisplayMetrics().densityDpi;
                } catch (Throwable unused) {
                }
            }
            return "" + f79342a;
        }
        return (String) invokeL.objValue;
    }
}
