package d.a.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, c> f45681a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (d.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (f45681a == null) {
                    f45681a = new HashMap<>();
                }
                if (f45681a.get(str) != null) {
                    return f45681a.get(str);
                }
                c cVar = new c(str);
                f45681a.put(str, cVar);
                return cVar;
            }
        }
        return (c) invokeLL.objValue;
    }
}
