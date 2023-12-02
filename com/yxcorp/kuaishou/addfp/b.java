package com.yxcorp.kuaishou.addfp;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final KWEGIDDFP a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-866986989, "Lcom/yxcorp/kuaishou/addfp/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-866986989, "Lcom/yxcorp/kuaishou/addfp/b;");
                return;
            }
        }
        a = new KWEGIDDFP(null);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.yxcorp.kuaishou.addfp.KWEGIDDFP.instance():com.yxcorp.kuaishou.addfp.KWEGIDDFP] */
    public static /* synthetic */ KWEGIDDFP a() {
        return a;
    }
}
