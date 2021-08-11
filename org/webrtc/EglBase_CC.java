package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.Nullable;
import javax.microedition.khronos.egl.EGLContext;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;
/* loaded from: classes2.dex */
public final /* synthetic */ class EglBase_CC {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static EglBase create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? create(null, EglBase.CONFIG_PLAIN) : (EglBase) invokeV.objValue;
    }

    public static EglBase create(EglBase.Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? create(context, EglBase.CONFIG_PLAIN) : (EglBase) invokeL.objValue;
    }

    public static EglBase create(@Nullable EglBase.Context context, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, iArr)) == null) ? (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr) : (EglBase) invokeLL.objValue;
    }

    public static EglBase createEgl10(EGLContext eGLContext, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eGLContext, iArr)) == null) ? new EglBase10(new EglBase10.Context(eGLContext), iArr) : (EglBase) invokeLL.objValue;
    }

    public static EglBase createEgl10(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr)) == null) ? new EglBase10(null, iArr) : (EglBase) invokeL.objValue;
    }

    public static EglBase createEgl14(android.opengl.EGLContext eGLContext, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, eGLContext, iArr)) == null) ? new EglBase14(new EglBase14.Context(eGLContext), iArr) : (EglBase) invokeLL.objValue;
    }

    public static EglBase createEgl14(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iArr)) == null) ? new EglBase14(null, iArr) : (EglBase) invokeL.objValue;
    }
}
