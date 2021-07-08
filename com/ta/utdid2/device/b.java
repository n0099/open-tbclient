package com.ta.utdid2.device;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ta.utdid2.a.a.f;
import java.util.zip.Adler32;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f38696a;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f38697d;
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
        f38697d = new Object();
    }

    public static long a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar != null) {
                String format = String.format("%s%s%s%s%s", aVar.getUtdid(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.getImei());
                if (f.isEmpty(format)) {
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
                if (f38696a != null) {
                    return f38696a;
                }
                if (context != null) {
                    a a2 = a(context);
                    f38696a = a2;
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
                synchronized (f38697d) {
                    String value = c.a(context).getValue();
                    if (f.isEmpty(value)) {
                        return null;
                    }
                    if (value.endsWith("\n")) {
                        value = value.substring(0, value.length() - 1);
                    }
                    a aVar = new a();
                    long currentTimeMillis = System.currentTimeMillis();
                    String imei = com.ta.utdid2.a.a.d.getImei(context);
                    String imsi = com.ta.utdid2.a.a.d.getImsi(context);
                    aVar.b(imei);
                    aVar.setImei(imei);
                    aVar.b(currentTimeMillis);
                    aVar.setImsi(imsi);
                    aVar.c(value);
                    aVar.a(a(aVar));
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}
