package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes10.dex */
public class E1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static E1 f76791a;
    public transient /* synthetic */ FieldHolder $fh;

    public E1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static E1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f76791a == null) {
                synchronized (E1.class) {
                    if (f76791a == null) {
                        f76791a = new E1();
                    }
                }
            }
            return f76791a;
        }
        return (E1) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (((r6 / 60) / 60) >= r10.f77024a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (context == null) {
                throw new RuntimeException("Error:Context is not allowed to be null");
            }
            context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                U1.e(context, str);
            }
            W1.a(new D1(this, context));
            f1 a2 = f1.a(context);
            long i2 = U1.i(a2.f77024a);
            boolean z = true;
            if (i2 > 0) {
                try {
                    long time = (new Date().getTime() - i2) / 1000;
                    if (time < 0) {
                        a2.b();
                    }
                    z = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                a2.f77025b = System.currentTimeMillis();
                W1.a(new e1(a2));
            }
            N.d(context);
            P1.a(context);
        }
    }
}
