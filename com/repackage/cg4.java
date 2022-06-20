package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cg4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final bg4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public cg4(Context context) {
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
        bg4<String> bg4Var = new bg4<>();
        this.a = bg4Var;
        if (context == null) {
            return;
        }
        bg4Var.a(new fg4(context));
        this.a.a(new hg4(context));
        this.a.a(new gg4(context));
        this.a.a(new jg4(context));
        this.a.a(new dg4(context));
        this.a.a(new ig4(context));
    }

    public static cg4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (cg4.class) {
                    if (c == null) {
                        c = new cg4(context);
                    }
                }
            }
            return c;
        }
        return (cg4) invokeL.objValue;
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
