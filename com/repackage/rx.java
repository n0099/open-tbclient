package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class rx {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, qx> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qx a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, context)) == null) {
            synchronized (rx.class) {
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName() + "_preferences";
                }
                if (a == null) {
                    a = new HashMap<>();
                }
                if (a.get(str) != null) {
                    return a.get(str);
                }
                qx qxVar = new qx(str);
                a.put(str, qxVar);
                return qxVar;
            }
        }
        return (qx) invokeLL.objValue;
    }
}
