package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
/* loaded from: classes8.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f897a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56377516, "Lcom/xiaomi/push/co;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56377516, "Lcom/xiaomi/push/co;");
                return;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f897a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hn a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            hn hnVar = new hn();
            hnVar.d("category_push_stat");
            hnVar.a("push_sdk_stat_channel");
            hnVar.a(1L);
            hnVar.b(str);
            hnVar.a(true);
            hnVar.b(System.currentTimeMillis());
            hnVar.g(bx.a(context).m1153a());
            hnVar.e("com.xiaomi.xmsf");
            hnVar.f("");
            hnVar.c("push_stat");
            return hnVar;
        }
        return (hn) invokeLL.objValue;
    }
}
