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
public final class iu9 {
    public static /* synthetic */ Interceptable $ic;
    public static SoftReference<iu9> d;
    public transient /* synthetic */ FieldHolder $fh;
    public ju9 a;
    public String b;
    public Context c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755605820, "Lcom/repackage/iu9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755605820, "Lcom/repackage/iu9;");
        }
    }

    public iu9(Context context, String str) {
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
        nu9.b();
        this.a = new ju9(context, str);
        this.b = str;
        this.c = context;
    }

    public static iu9 b(Context context, String str) {
        InterceptResult invokeLL;
        iu9 iu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && str != null) {
                SoftReference<iu9> softReference = d;
                iu9 iu9Var2 = softReference == null ? null : softReference.get();
                if (iu9Var2 == null || !str.equals(iu9Var2.b)) {
                    synchronized (iu9.class) {
                        iu9Var = new iu9(context, str);
                        d = new SoftReference<>(iu9Var);
                    }
                    return iu9Var;
                }
                return iu9Var2;
            }
            throw new IllegalArgumentException("YYOpenSDK createInstance failed, Make sure context or appid is not null!");
        }
        return (iu9) invokeLL.objValue;
    }

    public final void a(Activity activity, gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, gu9Var) == null) {
            this.a.c(activity, TbEnum.SystemMessage.EVENT_ID_GROUP_ACTIVITYS_IN_CHAT, gu9Var);
        }
    }

    public final void c(int i, int i2, Intent intent, gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, gu9Var}) == null) {
            this.a.d(i, i2, intent, gu9Var);
        }
    }
}
