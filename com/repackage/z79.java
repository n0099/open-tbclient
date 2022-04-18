package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes7.dex */
public class z79 {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158955, "Lcom/repackage/z79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158955, "Lcom/repackage/z79;");
                return;
            }
        }
        Charset.forName("ISO-8859-1");
        Charset.forName("US-ASCII");
        Charset.forName("UTF-16");
        Charset.forName(CharEncoding.UTF_16BE);
        Charset.forName(CharEncoding.UTF_16LE);
        a = Charset.forName("UTF-8");
    }
}
