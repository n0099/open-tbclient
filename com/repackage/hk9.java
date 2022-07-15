package com.repackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public final class hk9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    @GuardedBy("sLock")
    public static boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755645221, "Lcom/repackage/hk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755645221, "Lcom/repackage/hk9;");
                return;
            }
        }
        a = new Object();
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            b(context);
            return c;
        }
        return invokeL.intValue;
    }

    public static void b(Context context) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (a) {
                if (b) {
                    return;
                }
                b = true;
                try {
                    bundle = zk9.a(context).a(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
                if (bundle == null) {
                    return;
                }
                bundle.getString("com.google.app.id");
                c = bundle.getInt("com.google.android.gms.version");
            }
        }
    }
}
