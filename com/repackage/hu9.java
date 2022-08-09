package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;
/* compiled from: EglBase.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class hu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static EglBase a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c(null, EglBase.CONFIG_PLAIN) : (EglBase) invokeV.objValue;
    }

    public static EglBase b(EglBase.Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? c(context, EglBase.CONFIG_PLAIN) : (EglBase) invokeL.objValue;
    }

    public static EglBase c(@Nullable EglBase.Context context, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, iArr)) == null) ? (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr) : (EglBase) invokeLL.objValue;
    }

    public static EglBase d(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iArr)) == null) ? new EglBase10(null, iArr) : (EglBase) invokeL.objValue;
    }
}
