package f.a.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StringBuilder sb, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, sb, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    sb.append('\t');
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                try {
                    if (!"".equals(str)) {
                        StringBuilder sb = new StringBuilder();
                        int i2 = 0;
                        char c2 = 0;
                        boolean z = false;
                        int i3 = 0;
                        while (i2 < str.length()) {
                            char charAt = str.charAt(i2);
                            if (charAt == '\"') {
                                if (c2 != '\\') {
                                    z = !z;
                                }
                                sb.append(charAt);
                            } else if (charAt != ',') {
                                if (charAt != '[') {
                                    if (charAt != ']') {
                                        if (charAt != '{') {
                                            if (charAt != '}') {
                                                sb.append(charAt);
                                            }
                                        }
                                    }
                                    if (!z) {
                                        sb.append('\n');
                                        i3--;
                                        a(sb, i3);
                                    }
                                    sb.append(charAt);
                                }
                                sb.append(charAt);
                                if (!z) {
                                    sb.append('\n');
                                    i3++;
                                    a(sb, i3);
                                }
                            } else {
                                sb.append(charAt);
                                if (c2 != '\\' && !z) {
                                    sb.append('\n');
                                    a(sb, i3);
                                }
                            }
                            i2++;
                            c2 = charAt;
                        }
                        return sb.toString();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
