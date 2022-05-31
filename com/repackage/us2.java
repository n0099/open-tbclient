package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class us2 implements ts2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile us2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ss2 a;
    public volatile st2 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755250467, "Lcom/repackage/us2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755250467, "Lcom/repackage/us2;");
                return;
            }
        }
        c = rf1.a;
    }

    public us2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k();
    }

    public static us2 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (us2.class) {
                    if (d == null) {
                        d = new us2();
                    }
                }
            }
            return d;
        }
        return (us2) invokeV.objValue;
    }

    @Override // com.repackage.ts2
    public void b(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && m()) {
            if (c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.a.b(j);
            this.b.b(j);
        }
    }

    @Override // com.repackage.ts2
    public void c(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && m()) {
            if (c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.a.c(j);
            this.b.c(j);
            o(j);
        }
    }

    public ss2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (ss2) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.a == null) {
                this.a = new qs2();
            }
            if (this.b == null) {
                this.b = new ut2();
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (c) {
                return true;
            }
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return false;
            }
            String appId = a0.getAppId();
            return (TextUtils.isEmpty(appId) || jr1.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l() : invokeV.booleanValue;
    }

    public st2 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (st2) invokeV.objValue;
    }

    public final void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            db3.i.update((cb3<Long>) Long.valueOf(j));
        }
    }
}
