package com.tencent.mm.sdk.b;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.TimeZone;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeZone GMT;
    public static final long[] q;
    public static final char[] r;
    public static final String[] s;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(153101861, "Lcom/tencent/mm/sdk/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(153101861, "Lcom/tencent/mm/sdk/b/c;");
                return;
            }
        }
        q = new long[]{300, 200, 300, 200};
        GMT = TimeZone.getTimeZone("GMT");
        r = new char[]{Typography.less, Typography.greater, '\"', ExtendedMessageFormat.QUOTE, Typography.amp};
        s = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;"};
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str == null || str.length() <= 0 : invokeL.booleanValue;
    }
}
