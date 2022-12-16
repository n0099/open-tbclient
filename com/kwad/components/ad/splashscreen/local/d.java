package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean W(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            a Q = b.Q(context);
            return !(Q == null || !Q.w(com.kwad.components.ad.splashscreen.a.b.jM()));
        }
        return invokeL.booleanValue;
    }

    public static boolean X(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            a S = b.S(context);
            return !(S == null || !S.w(com.kwad.components.ad.splashscreen.a.b.jN()));
        }
        return invokeL.booleanValue;
    }

    public static boolean Y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            a T = b.T(context);
            return !(T == null || !T.w(com.kwad.components.ad.splashscreen.a.b.jO()));
        }
        return invokeL.booleanValue;
    }

    public static int a(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, adInfo, sceneImpl)) == null) {
            if (a(adInfo, sceneImpl)) {
                return 1;
            }
            return b(context, adInfo) ? 2 : 0;
        }
        return invokeLLL.intValue;
    }

    public static boolean a(AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo, sceneImpl)) == null) {
            if (com.kwad.sdk.core.response.a.b.cb(adInfo) && a(sceneImpl)) {
                return true;
            }
            if (com.kwad.sdk.core.response.a.b.cc(adInfo) && b(sceneImpl)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.b.cd(adInfo) && c(sceneImpl);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sceneImpl)) == null) {
            if (jT()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.disableShake;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, adInfo)) == null) {
            if (com.kwad.sdk.core.response.a.b.cb(adInfo) && W(context)) {
                return true;
            }
            if (com.kwad.sdk.core.response.a.b.cc(adInfo) && X(context)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.b.cd(adInfo) && Y(context);
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, adInfo, sceneImpl)) == null) {
            return (W(context) ^ true) && com.kwad.sdk.core.response.a.b.cb(adInfo) && !a(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, sceneImpl)) == null) {
            if (jU()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.disableRotate;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, adInfo, sceneImpl)) == null) {
            return (X(context) ^ true) && com.kwad.sdk.core.response.a.b.cc(adInfo) && !b(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, sceneImpl)) == null) {
            if (jV()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.disableSlide;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, adInfo, sceneImpl)) == null) {
            return (Y(context) ^ true) && com.kwad.sdk.core.response.a.b.cd(adInfo) && !c(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean jT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean jU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean jV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean o(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.b.ce(adInfo) : invokeL.booleanValue;
    }
}
