package i.a.a.e.n;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "Empty";
            }
            String[] split = str.split("\\?");
            return split.length > 0 ? split[0] : V8ExceptionInfo.V8_EXCEPTION_ERROR;
        }
        return (String) invokeL.objValue;
    }
}
