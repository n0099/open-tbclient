package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻⁱ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0314 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f59 = "Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String f60 = "Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335416449, "Lcom/kuaishou/weapon/p0/ʻⁱ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335416449, "Lcom/kuaishou/weapon/p0/ʻⁱ;");
                return;
            }
        }
        f59 = C0446.m976("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
        f60 = C0446.m976(f60, 2);
    }

    public C0314() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m215(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = TextUtils.isEmpty(m219(context)) ? "0" : "1";
            String m217 = m217(context);
            if (TextUtils.isEmpty(m217)) {
                return "0" + str;
            }
            String str2 = "1" + str;
            m218(context, m217);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m216(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext())) {
                    Settings.System.putString(context.getContentResolver(), f59, str);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m217(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), f59);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m218(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            C0374.m389(context).m422(str);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m219(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                return C0374.m389(context).m394();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m220(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String m217 = m217(context);
            String m219 = m219(context);
            if (TextUtils.isEmpty(m217) || !TextUtils.equals(m217, m219)) {
                if (!TextUtils.isEmpty(m217)) {
                    m218(context, m217);
                    return m217;
                } else if (TextUtils.isEmpty(m219)) {
                    return "";
                } else {
                    m216(context, m219);
                    return m219;
                }
            }
            return m217;
        }
        return (String) invokeL.objValue;
    }
}
