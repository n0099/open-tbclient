package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jh4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jh4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final ih4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public jh4(Context context) {
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
        ih4<String> ih4Var = new ih4<>();
        this.a = ih4Var;
        if (context == null) {
            return;
        }
        ih4Var.a(new mh4(context));
        this.a.a(new oh4(context));
        this.a.a(new nh4(context));
        this.a.a(new qh4(context));
        this.a.a(new kh4(context));
        this.a.a(new ph4(context));
    }

    public static jh4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (jh4.class) {
                    if (c == null) {
                        c = new jh4(context);
                    }
                }
            }
            return c;
        }
        return (jh4) invokeL.objValue;
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
