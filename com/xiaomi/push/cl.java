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
public class cl {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: a  reason: collision with other field name */
    public static SimpleDateFormat f193a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56377609, "Lcom/xiaomi/push/cl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56377609, "Lcom/xiaomi/push/cl;");
                return;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f193a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hj a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            hj hjVar = new hj();
            hjVar.d("category_push_stat");
            hjVar.a("push_sdk_stat_channel");
            hjVar.a(1L);
            hjVar.b(str);
            hjVar.a(true);
            hjVar.b(System.currentTimeMillis());
            hjVar.g(bu.a(context).m255a());
            hjVar.e("com.xiaomi.xmsf");
            hjVar.f("");
            hjVar.c("push_stat");
            return hjVar;
        }
        return (hj) invokeLL.objValue;
    }
}
