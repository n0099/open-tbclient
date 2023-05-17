package com.vivo.push.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.ContextDelegate;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public Context b;

    public b() {
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

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
                bVar = c;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final synchronized a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    return this.a;
                }
                if (context == null) {
                    return null;
                }
                if (this.a == null) {
                    Context context2 = ContextDelegate.getContext(context.getApplicationContext());
                    this.b = context2;
                    this.a = new c(context2);
                }
                return this.a;
            }
        }
        return (a) invokeL.objValue;
    }
}
