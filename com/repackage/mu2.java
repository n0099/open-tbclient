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
/* loaded from: classes6.dex */
public class mu2 implements lu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile mu2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ku2 a;
    public volatile kv2 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755486873, "Lcom/repackage/mu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755486873, "Lcom/repackage/mu2;");
                return;
            }
        }
        c = jh1.a;
    }

    public mu2() {
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
        i();
    }

    public static mu2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (mu2.class) {
                    if (d == null) {
                        d = new mu2();
                    }
                }
            }
            return d;
        }
        return (mu2) invokeV.objValue;
    }

    @Override // com.repackage.lu2
    public void end(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && k()) {
            if (c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.a.end(j);
            this.b.end(j);
            m(j);
        }
    }

    public ku2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ku2) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.a == null) {
                this.a = new iu2();
            }
            if (this.b == null) {
                this.b = new mv2();
            }
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c) {
                return true;
            }
            z03 b0 = z03.b0();
            if (b0 == null) {
                return false;
            }
            String appId = b0.getAppId();
            return (TextUtils.isEmpty(appId) || bt1.b(appId) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j() : invokeV.booleanValue;
    }

    public kv2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (kv2) invokeV.objValue;
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            vc3.i.update((uc3<Long>) Long.valueOf(j));
        }
    }

    @Override // com.repackage.lu2
    public void start(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && k()) {
            if (c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.a.start(j);
            this.b.start(j);
        }
    }
}
