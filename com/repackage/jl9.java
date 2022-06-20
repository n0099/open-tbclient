package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class jl9 {
    public static /* synthetic */ Interceptable $ic;
    public static jl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public jl9() {
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

    public static jl9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (jl9.class) {
                    if (a == null) {
                        a = new jl9();
                    }
                }
            }
            return a;
        }
        return (jl9) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (((r6 / 60) / 60) >= r10.a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (context == null) {
                throw new RuntimeException("Error:Context is not allowed to be null");
            }
            context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                in9.v(context, str);
            }
            pn9.b(new gl9(this, context));
            try {
                pn9.b(new hn9(context));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            uo9 c = uo9.c(context);
            long B = in9.B(c.a);
            boolean z = true;
            if (B > 0) {
                try {
                    long time = (new Date().getTime() - B) / 1000;
                    if (time < 0) {
                        c.f();
                    }
                    z = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (z) {
                c.b = System.currentTimeMillis();
                pn9.b(new ro9(c));
            }
            sl9.E(context);
            tm9.a(context);
        }
    }
}
