package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class bx {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n";
    public static String b = "Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334585153, "Lcom/kuaishou/weapon/p0/bx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334585153, "Lcom/kuaishou/weapon/p0/bx;");
                return;
            }
        }
        a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
        b = c.b(b, 2);
    }

    public bx() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(d(context))) {
                str = "0";
            } else {
                str = "1";
            }
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                return "0" + str;
            }
            String str2 = "1" + str;
            b(context, c);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context.getApplicationContext())) {
                    return;
                }
                Settings.System.putString(context.getContentResolver(), a, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            df.a(context).d(str);
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String c = c(context);
            String d = d(context);
            if (!TextUtils.isEmpty(c) && TextUtils.equals(c, d)) {
                return c;
            }
            if (!TextUtils.isEmpty(c)) {
                b(context, c);
                return c;
            } else if (!TextUtils.isEmpty(d)) {
                a(context, d);
                return d;
            } else {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                return ApiReplaceUtil.getString(context.getContentResolver(), a);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return df.a(context).e();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
