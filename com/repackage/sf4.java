package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sf4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sf4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final rf4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public sf4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        rf4<String> rf4Var = new rf4<>();
        this.a = rf4Var;
        if (context == null) {
            return;
        }
        rf4Var.a(new vf4(context));
        this.a.a(new xf4(context));
        this.a.a(new wf4(context));
        this.a.a(new zf4(context));
        this.a.a(new tf4(context));
        this.a.a(new yf4(context));
    }

    public static sf4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (sf4.class) {
                    if (c == null) {
                        c = new sf4(context);
                    }
                }
            }
            return c;
        }
        return (sf4) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.b)) {
                        String b = this.a.b();
                        this.b = b;
                        this.a.d(b);
                    }
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
