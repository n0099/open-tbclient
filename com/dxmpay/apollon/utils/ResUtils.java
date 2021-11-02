package com.dxmpay.apollon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
/* loaded from: classes11.dex */
public final class ResUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANIM = "anim";
    public transient /* synthetic */ FieldHolder $fh;

    public ResUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            if (context != null) {
                if (str != null && str.trim().length() != 0) {
                    if (str2 != null && str2.trim().length() != 0) {
                        Resources resources = context.getResources();
                        String packageName = context.getPackageName();
                        if (ChannelUtils.isSpecailPackage()) {
                            packageName = "com.baidu.wallet";
                        }
                        if (ApollonConstants.DEBUG) {
                            String str3 = "context instance is " + context;
                            String str4 = "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context;
                        }
                        return resources.getIdentifier(str2, str, packageName);
                    }
                    throw new NullPointerException("the attrNme is null or empty");
                }
                throw new NullPointerException("the type is null or empty");
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLL.intValue;
    }

    public static int anim(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? a(context, "anim", str) : invokeLL.intValue;
    }

    public static int array(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? a(context, "array", str) : invokeLL.intValue;
    }

    public static int attr(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) ? a(context, "attr", str) : invokeLL.intValue;
    }

    public static int b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, str3)) == null) {
            if (context != null) {
                if (str2 != null && str2.trim().length() != 0) {
                    if (str3 != null && str3.trim().length() != 0) {
                        Resources resources = context.getResources();
                        if (ChannelUtils.isSpecailPackage()) {
                            str = "com.baidu.wallet";
                        }
                        if (ApollonConstants.DEBUG) {
                            String str4 = "context instance is " + context;
                            String str5 = "packake name is " + str + " attrName is " + str3 + ", context instance is " + context;
                        }
                        return resources.getIdentifier(str3, str2, str);
                    }
                    throw new NullPointerException("the attrNme is null or empty");
                }
                throw new NullPointerException("the type is null or empty");
            }
            throw new NullPointerException("the context is null");
        }
        return invokeLLLL.intValue;
    }

    public static int color(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? a(context, "color", str) : invokeLL.intValue;
    }

    public static int dimen(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? a(context, "dimen", str) : invokeLL.intValue;
    }

    public static int drawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? a(context, "drawable", str) : invokeLL.intValue;
    }

    public static Animation getAnimation(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? AnimationUtils.loadAnimation(context, anim(context, str)) : (Animation) invokeLL.objValue;
    }

    public static int getColor(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(context, str));
            return context.getResources().getColor(color(context, str));
        }
        return invokeLL.intValue;
    }

    public static float getDimension(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? context.getResources().getDimension(dimen(context, str)) : invokeLL.floatValue;
    }

    public static Drawable getDrawable(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) ? context.getResources().getDrawable(drawable(context, str)) : (Drawable) invokeLL.objValue;
    }

    public static int getInteger(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? context.getResources().getInteger(integer(context, str)) : invokeLL.intValue;
    }

    public static String getString(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
            if (context != null && context.getResources() != null) {
                try {
                    return context.getResources().getString(string(context, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String[] getStringArray(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) ? context.getResources().getStringArray(array(context, str)) : (String[]) invokeLL.objValue;
    }

    public static int id(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) ? a(context, "id", str) : invokeLL.intValue;
    }

    public static int integer(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) ? a(context, "integer", str) : invokeLL.intValue;
    }

    public static int layout(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) ? a(context, "layout", str) : invokeLL.intValue;
    }

    public static int raw(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) ? a(context, "raw", str) : invokeLL.intValue;
    }

    public static int string(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) ? a(context, "string", str) : invokeLL.intValue;
    }

    public static int style(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) ? a(context, "style", str) : invokeLL.intValue;
    }

    public static int xml(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) ? a(context, "xml", str) : invokeLL.intValue;
    }

    public static int anim(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) ? b(context, str, "anim", str2) : invokeLLL.intValue;
    }
}
