package com.huawei.hms.hatool;

import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 4;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return "FormalHASDK_2.2.0.313" + k1.a();
        }
        return (String) invokeV.objValue;
    }

    public void a(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 19) {
                sb.append(System.lineSeparator());
                sb.append("======================================= ");
                sb.append(System.lineSeparator());
                sb.append(a());
                sb.append("");
                sb.append(System.lineSeparator());
                str = "=======================================";
            } else {
                sb.append("====================");
                sb.append(a());
                str = "===================";
            }
            sb.append(str);
            Log.i("FormalHASDK", sb.toString());
            this.b = i;
            this.a = true;
        }
    }

    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
            if (i == 3) {
                Log.d(str, str2);
            } else if (i == 5) {
                Log.w(str, str2);
            } else if (i != 6) {
                Log.i(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public void b(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
            a(i, "FormalHASDK", str + "=> " + str2);
        }
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a && i >= this.b : invokeI.booleanValue;
    }
}
