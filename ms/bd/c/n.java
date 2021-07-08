package ms.bd.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
    }

    /* loaded from: classes9.dex */
    public interface b {
    }

    /* loaded from: classes9.dex */
    public interface c {
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            new o().c(context, str, null, null);
        }
    }

    public static boolean b(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) ? charSequence == null || charSequence.length() == 0 : invokeL.booleanValue;
    }
}
