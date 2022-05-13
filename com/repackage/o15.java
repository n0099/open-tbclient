package com.repackage;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w35;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class o15 implements w35 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, Integer> a;
    public static final ArrayList<Integer> b;
    public static final HashMap<String, Integer> c;
    public static final HashMap<String, String> d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755492546, "Lcom/repackage/o15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755492546, "Lcom/repackage/o15;");
                return;
            }
        }
        a = new HashMap<>(200);
        b = new ArrayList<>(180);
        c = new HashMap<>(180);
        d = new HashMap<>(180);
    }

    public o15() {
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

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                Class.forName("com.repackage.l15");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("com.repackage.z36");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            try {
                Class.forName("com.repackage.a46");
            } catch (Throwable th3) {
                BdLog.e(th3);
            }
        }
    }

    @Override // com.repackage.w35
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f();
            return b.size();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.w35
    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            f();
            return d.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.w35
    public w35.a c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return null;
        }
        return (w35.a) invokeLL.objValue;
    }

    @Override // com.repackage.w35
    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            f();
            Integer num = a.get(str);
            if ("video_icon".equals(str)) {
                return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
            }
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.w35
    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            f();
            Integer num = c.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && d.isEmpty()) {
            g();
        }
    }
}
