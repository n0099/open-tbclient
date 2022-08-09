package com.repackage;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uc9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDFactory";
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public yc9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755265626, "Lcom/repackage/uc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755265626, "Lcom/repackage/uc9;");
                return;
            }
        }
        c = rc9.e();
    }

    public uc9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int a = sc9.a();
        if (c) {
            String str = b;
            Log.e(str, "UnionIDFactory manufacturer:" + a);
        }
        if (a == 10001) {
            this.a = new ad9(context);
        } else if (a != 10002) {
            this.a = new bd9(context);
        } else {
            if (c) {
                Log.e(b, "UnionIDFactory XMUnionID");
            }
            this.a = new cd9(context);
        }
    }

    public yc9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (yc9) invokeV.objValue;
    }
}
