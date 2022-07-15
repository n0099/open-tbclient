package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, adInfo, sceneImpl)) == null) {
            if (a(adInfo, sceneImpl)) {
                return 1;
            }
            return a(context, adInfo) ? 2 : 0;
        }
        return invokeLLL.intValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            a b = b.b(context);
            return !(b == null || !b.a(com.kwad.components.ad.splashscreen.a.b.d()));
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, adInfo)) == null) {
            if (com.kwad.sdk.core.response.a.b.i(adInfo) && a(context)) {
                return true;
            }
            if (com.kwad.sdk.core.response.a.b.j(adInfo) && b(context)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.b.k(adInfo) && c(context);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adInfo)) == null) ? com.kwad.sdk.core.response.a.b.l(adInfo) : invokeL.booleanValue;
    }

    public static boolean a(AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, adInfo, sceneImpl)) == null) {
            if (com.kwad.sdk.core.response.a.b.i(adInfo) && a(sceneImpl)) {
                return true;
            }
            if (com.kwad.sdk.core.response.a.b.j(adInfo) && b(sceneImpl)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.b.k(adInfo) && c(sceneImpl);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sceneImpl)) == null) {
            if (a()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.a;
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            a d = b.d(context);
            return !(d == null || !d.a(com.kwad.components.ad.splashscreen.a.b.e()));
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, adInfo, sceneImpl)) == null) {
            return (a(context) ^ true) && com.kwad.sdk.core.response.a.b.i(adInfo) && !a(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, sceneImpl)) == null) {
            if (b()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.b;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            a e = b.e(context);
            return !(e == null || !e.a(com.kwad.components.ad.splashscreen.a.b.f()));
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, adInfo, sceneImpl)) == null) {
            return (b(context) ^ true) && com.kwad.sdk.core.response.a.b.j(adInfo) && !b(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        com.kwad.sdk.internal.api.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, sceneImpl)) == null) {
            if (c()) {
                return true;
            }
            if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
                return false;
            }
            return bVar.c;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, context, adInfo, sceneImpl)) == null) {
            return (c(context) ^ true) && com.kwad.sdk.core.response.a.b.k(adInfo) && !c(sceneImpl);
        }
        return invokeLLL.booleanValue;
    }
}
