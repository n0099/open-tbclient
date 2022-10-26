package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class J1 {
    public static /* synthetic */ Interceptable $ic;
    public static J1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public J1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static J1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (J1.class) {
                    if (a == null) {
                        a = new J1();
                    }
                }
            }
            return a;
        }
        return (J1) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (((r6 / 60) / 60) >= r10.a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (context != null) {
                context.getApplicationContext();
                if (!TextUtils.isEmpty(str)) {
                    Z1.e(context, str);
                }
                b2.a(new I1(this, context));
                try {
                    b2.a(new Z0(context));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                k1 a2 = k1.a(context);
                long i = Z1.i(a2.a);
                boolean z = true;
                if (i > 0) {
                    try {
                        long time = (new Date().getTime() - i) / 1000;
                        if (time < 0) {
                            a2.b();
                        }
                        z = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    a2.b = System.currentTimeMillis();
                    b2.a(new j1(a2));
                }
                M.d(context);
                U1.a(context);
                return;
            }
            throw new RuntimeException("Error:Context is not allowed to be null");
        }
    }
}
