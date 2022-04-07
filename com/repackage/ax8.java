package com.repackage;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class ax8 {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public static final js8 b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755841296, "Lcom/repackage/ax8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755841296, "Lcom/repackage/ax8;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        b = new js8("camera_last_api", 0, "camera_last_api_stamp");
        c = "Lenovo K520".equals(Build.MODEL);
    }
}
