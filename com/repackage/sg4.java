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
public class sg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sg4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final rg4<String> a;
    public String b;

    @SuppressLint({"BDThrowableCheck"})
    public sg4(Context context) {
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
        rg4<String> rg4Var = new rg4<>();
        this.a = rg4Var;
        if (context == null) {
            return;
        }
        rg4Var.a(new vg4(context));
        this.a.a(new xg4(context));
        this.a.a(new wg4(context));
        this.a.a(new zg4(context));
        this.a.a(new tg4(context));
        this.a.a(new yg4(context));
    }

    public static sg4 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (sg4.class) {
                    if (c == null) {
                        c = new sg4(context);
                    }
                }
            }
            return c;
        }
        return (sg4) invokeL.objValue;
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
