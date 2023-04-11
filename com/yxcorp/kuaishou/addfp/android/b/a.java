package com.yxcorp.kuaishou.addfp.android.b;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.UserHandle");
                Class<?> cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getUserId", cls2);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Integer.valueOf(Process.myUid()))).intValue();
                Method declaredMethod2 = Class.forName("android.provider.Settings$" + str).getDeclaredMethod("getStringForUser", ContentResolver.class, String.class, cls2);
                declaredMethod2.setAccessible(true);
                return (String) declaredMethod2.invoke(null, context.getContentResolver(), str2, Integer.valueOf(intValue));
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
