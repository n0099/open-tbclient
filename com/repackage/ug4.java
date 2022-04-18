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
public class ug4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ug4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final tg4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public ug4(Context context) {
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
        tg4<String> tg4Var = new tg4<>();
        this.a = tg4Var;
        if (context == null) {
            return;
        }
        tg4Var.a(new xg4(context));
        this.a.a(new zg4(context));
        this.a.a(new yg4(context));
        this.a.a(new bh4(context));
        this.a.a(new vg4(context));
        this.a.a(new ah4(context));
    }

    public static ug4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (ug4.class) {
                    if (c == null) {
                        c = new ug4(context);
                    }
                }
            }
            return c;
        }
        return (ug4) invokeL.objValue;
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
