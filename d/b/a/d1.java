package d.b.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bun.miitmdid.core.JLibrary;
/* loaded from: classes8.dex */
public final class d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, context) == null) && JLibrary.context == null) {
            JLibrary.InitEntry(context);
        }
    }
}
