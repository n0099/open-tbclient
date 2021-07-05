package d.a.q0.f.i.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("?code2=");
            a aVar = new a();
            sb2.append(aVar.a(sb.toString() + "b" + System.currentTimeMillis() + "=1"));
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("&b" + System.currentTimeMillis());
            sb4.append("=");
            sb4.append("1");
            return sb3 + sb4.toString();
        }
        return (String) invokeLL.objValue;
    }
}
