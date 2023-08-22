package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes10.dex */
public abstract class ResourceLoaderUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public ResourceLoaderUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Context getmContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return a;
        }
        return (Context) invokeV.objValue;
    }

    public static int getAnimId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return a.getResources().getIdentifier(str, "anim", b);
        }
        return invokeL.intValue;
    }

    public static int getColorId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return a.getResources().getIdentifier(str, "color", b);
        }
        return invokeL.intValue;
    }

    public static Drawable getDrawable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return a.getResources().getDrawable(getDrawableId(str));
        }
        return (Drawable) invokeL.objValue;
    }

    public static int getDrawableId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return a.getResources().getIdentifier(str, ResourceManager.DRAWABLE, b);
        }
        return invokeL.intValue;
    }

    public static int getIdId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return a.getResources().getIdentifier(str, "id", b);
        }
        return invokeL.intValue;
    }

    public static int getLayoutId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return a.getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, b);
        }
        return invokeL.intValue;
    }

    public static String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return a.getResources().getString(getStringId(str));
        }
        return (String) invokeL.objValue;
    }

    public static int getStringId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return a.getResources().getIdentifier(str, EMABTest.TYPE_STRING, b);
        }
        return invokeL.intValue;
    }

    public static int getStyleId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return a.getResources().getIdentifier(str, "style", b);
        }
        return invokeL.intValue;
    }

    public static void setmContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            a = context;
            b = context.getPackageName();
        }
    }

    public static String getString(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, objArr)) == null) {
            return a.getResources().getString(getStringId(str), objArr);
        }
        return (String) invokeLL.objValue;
    }
}
