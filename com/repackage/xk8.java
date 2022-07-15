package com.repackage;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Set;
/* loaded from: classes7.dex */
public class xk8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static boolean b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755168596, "Lcom/repackage/xk8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755168596, "Lcom/repackage/xk8;");
        }
    }

    public static boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() || intent == null) {
                return false;
            }
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            boolean z = !AdToMainTabActivitySwitch.getIsOn() && action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER") && PermissionUtil.isAgreePrivacyPolicy() && a;
            a = false;
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            if (intent == null) {
                return false;
            }
            String action = intent.getAction();
            Set<String> categories = intent.getCategories();
            boolean z = AdToMainTabActivitySwitch.getIsOn() && b && action != null && categories != null && TextUtils.equals(action, "android.intent.action.MAIN") && categories.contains("android.intent.category.LAUNCHER");
            b = false;
            return z;
        }
        return invokeL.booleanValue;
    }
}
