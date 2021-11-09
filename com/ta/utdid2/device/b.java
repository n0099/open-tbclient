package com.ta.utdid2.device;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ta.utdid2.a.a.g;
import java.util.zip.Adler32;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f69784a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f69785d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(61108061, "Lcom/ta/utdid2/device/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(61108061, "Lcom/ta/utdid2/device/b;");
                return;
            }
        }
        f69785d = new Object();
    }

    public static long a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar != null) {
                String format = String.format("%s%s%s%s%s", aVar.f(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.e());
                if (g.m63a(format)) {
                    return 0L;
                }
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(format.getBytes());
                return adler32.getValue();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static synchronized a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (b.class) {
                a aVar = f69784a;
                if (aVar != null) {
                    return aVar;
                }
                if (context != null) {
                    a a2 = a(context);
                    f69784a = a2;
                    return a2;
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null) {
                synchronized (f69785d) {
                    String value = c.a(context).getValue();
                    if (g.m63a(value)) {
                        return null;
                    }
                    if (value.endsWith(StringUtils.LF)) {
                        value = value.substring(0, value.length() - 1);
                    }
                    a aVar = new a();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = com.ta.utdid2.a.a.e.a(context);
                    String c2 = com.ta.utdid2.a.a.e.c(context);
                    aVar.d(a2);
                    aVar.b(a2);
                    aVar.b(currentTimeMillis);
                    aVar.c(c2);
                    aVar.e(value);
                    aVar.a(a(aVar));
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}
