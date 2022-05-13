package com.repackage;

import android.telephony.PhoneStateListener;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ip2 extends PhoneStateListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755610842, "Lcom/repackage/ip2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755610842, "Lcom/repackage/ip2;");
                return;
            }
        }
        a = eh1.a;
    }

    public ip2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            super.onCallStateChanged(i, str);
            if (i == 0) {
                kp2.k().o();
                if (a) {
                    Log.i("PhoneStateListener", "挂断");
                }
            } else if (i == 1) {
                kp2.k().n();
                if (a) {
                    Log.i("PhoneStateListener", "响铃:" + str);
                }
            } else if (i != 2) {
                if (a) {
                    Log.e("PhoneStateListener", "invalid state");
                }
            } else {
                kp2.k().n();
                if (a) {
                    Log.i("PhoneStateListener", "接听");
                }
            }
        }
    }
}
