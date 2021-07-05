package d.f.d.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes10.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? m.e(str) : invokeL.booleanValue;
    }

    public static String b(String str, Object... objArr) {
        InterceptResult invokeLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, objArr)) == null) {
            String valueOf = String.valueOf(str);
            int i2 = 0;
            if (objArr == null) {
                objArr = new Object[]{"(Object[])null"};
            } else {
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    objArr[i3] = c(objArr[i3]);
                }
            }
            StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
            int i4 = 0;
            while (i2 < objArr.length && (indexOf = valueOf.indexOf("%s", i4)) != -1) {
                sb.append((CharSequence) valueOf, i4, indexOf);
                sb.append(objArr[i2]);
                i4 = indexOf + 2;
                i2++;
            }
            sb.append((CharSequence) valueOf, i4, valueOf.length());
            if (i2 < objArr.length) {
                sb.append(" [");
                sb.append(objArr[i2]);
                for (int i5 = i2 + 1; i5 < objArr.length; i5++) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(objArr[i5]);
                }
                sb.append(']');
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            try {
                return String.valueOf(obj);
            } catch (Exception e2) {
                String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e2);
                return "<" + str + " threw " + e2.getClass().getName() + ">";
            }
        }
        return (String) invokeL.objValue;
    }
}
