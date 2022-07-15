package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public final class go9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<go9> d;
    public transient /* synthetic */ FieldHolder $fh;
    public ho9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755671168, "Lcom/repackage/go9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755671168, "Lcom/repackage/go9;");
        }
    }

    public go9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lo9.b();
        this.a = new ho9(context, str);
        this.b = str;
        this.c = context;
    }

    public static go9 b(Context context, String str) {
        InterceptResult invokeLL;
        go9 go9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<go9> softReference = d;
                go9 go9Var2 = softReference == null ? null : softReference.get();
                if (go9Var2 == null || !str.equals(go9Var2.b)) {
                    synchronized (go9.class) {
                        go9Var = new go9(context, str);
                        d = new SoftReference<>(go9Var);
                    }
                    return go9Var;
                }
                return go9Var2;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (go9) invokeLL.objValue;
    }

    public final void a(Activity activity, eo9 eo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, eo9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, eo9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, eo9 eo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, eo9Var}) == null) {
            this.a.d(i, i2, intent, eo9Var);
        }
    }
}
