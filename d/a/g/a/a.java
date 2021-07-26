package d.a.g.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                int i2 = 0;
                while (i2 < length) {
                    sb.append(Array.get(obj, i2));
                    sb.append(',');
                    sb.append(' ');
                    i2++;
                }
                if (i2 > 0) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(']');
                return sb.toString();
            }
            throw new InvalidParameterException("Not a primitive array: " + obj.getClass());
        }
        return (String) invokeL.objValue;
    }
}
