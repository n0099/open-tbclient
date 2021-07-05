package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class c1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c1 f42548a;
    public transient /* synthetic */ FieldHolder $fh;

    public c1() {
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

    public static c1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f42548a == null) {
                synchronized (c1.class) {
                    if (f42548a == null) {
                        f42548a = new c1();
                    }
                }
            }
            return f42548a;
        }
        return (c1) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (((r6 / 60) / 60) >= r10.f42329a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L9;
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
                s1.e(context, str);
            }
            u1.a(new b1(this, context));
            D0 a2 = D0.a(context);
            long h2 = s1.h(a2.f42329a);
            boolean z = true;
            if (h2 > 0) {
                try {
                    long time = (new Date().getTime() - h2) / 1000;
                    if (time < 0) {
                        a2.b();
                    }
                    z = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                a2.f42330b = System.currentTimeMillis();
                u1.a(new C0(a2));
            }
            z.d(context);
            n1.a(context);
        }
    }
}
