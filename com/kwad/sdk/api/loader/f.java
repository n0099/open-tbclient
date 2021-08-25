package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f70926a = "newversion";

    /* renamed from: b  reason: collision with root package name */
    public static String f70927b = "curversion";

    /* renamed from: c  reason: collision with root package name */
    public static String f70928c = "apiversion";

    /* renamed from: d  reason: collision with root package name */
    public static String f70929d = "_enable";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1711378591, "Lcom/kwad/sdk/api/loader/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1711378591, "Lcom/kwad/sdk/api/loader/f;");
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? a(context, f70928c) : (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? q.b(context, str, "") : (String) invokeLL.objValue;
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            q.a(context, str, str2);
        }
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return false;
            }
            if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                    try {
                        int parseInt = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                        if (parseInt > 0) {
                            return true;
                        }
                        if (parseInt < 0) {
                            return false;
                        }
                    } catch (NumberFormatException unused) {
                        return false;
                    }
                }
                return split.length > split2.length;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
            a(context, f70928c, str);
        }
    }
}
