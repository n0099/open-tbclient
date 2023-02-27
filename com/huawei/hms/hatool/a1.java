package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class a1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a1() {
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

    public final x0 a(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i != 0) {
                str = f();
                if (!TextUtils.isEmpty(str)) {
                    return new x0(y0.b, str);
                }
            } else {
                str = "";
            }
            return new x0(y0.d, str);
        }
        return (x0) invokeI.objValue;
    }

    public x0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            String c = c();
            if (TextUtils.isEmpty(c)) {
                String a = a();
                if (TextUtils.isEmpty(a)) {
                    boolean e = e();
                    String b = b();
                    return !TextUtils.isEmpty(b) ? e ? new x0(y0.c, b) : new x0(y0.b, a(b)) : e ? a(d()) : b(d());
                }
                return new x0(y0.a, a);
            }
            return new x0(y0.b, c);
        }
        return (x0) invokeL.objValue;
    }

    public abstract String a();

    public abstract String a(String str);

    public final x0 b(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if ((i & 4) != 0) {
                str = f();
                if (!TextUtils.isEmpty(str)) {
                    return new x0(y0.b, str);
                }
            } else {
                str = "";
            }
            return new x0(y0.d, str);
        }
        return (x0) invokeI.objValue;
    }

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            l b = i.c().b();
            if (TextUtils.isEmpty(b.l())) {
                b.h(f.a());
            }
            return !TextUtils.isEmpty(b.l());
        }
        return invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l b = i.c().b();
            if (TextUtils.isEmpty(b.i())) {
                b.e(b1.c());
            }
            return b.i();
        }
        return (String) invokeV.objValue;
    }
}
