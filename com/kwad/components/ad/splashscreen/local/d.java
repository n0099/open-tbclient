package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes9.dex */
public final class d {
    public static boolean W(Context context) {
        a Q = b.Q(context);
        return !(Q == null || !Q.w(com.kwad.components.ad.splashscreen.a.b.jM()));
    }

    public static boolean X(Context context) {
        a S = b.S(context);
        return !(S == null || !S.w(com.kwad.components.ad.splashscreen.a.b.jN()));
    }

    public static boolean Y(Context context) {
        a T = b.T(context);
        return !(T == null || !T.w(com.kwad.components.ad.splashscreen.a.b.jO()));
    }

    public static int a(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        if (a(adInfo, sceneImpl)) {
            return 1;
        }
        return b(context, adInfo) ? 2 : 0;
    }

    public static boolean a(AdInfo adInfo, SceneImpl sceneImpl) {
        if (com.kwad.sdk.core.response.a.b.cb(adInfo) && a(sceneImpl)) {
            return true;
        }
        if (com.kwad.sdk.core.response.a.b.cc(adInfo) && b(sceneImpl)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.b.cd(adInfo) && c(sceneImpl);
    }

    public static boolean a(SceneImpl sceneImpl) {
        com.kwad.sdk.internal.api.b bVar;
        if (jT()) {
            return true;
        }
        if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
            return false;
        }
        return bVar.disableShake;
    }

    public static boolean b(Context context, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.b.cb(adInfo) && W(context)) {
            return true;
        }
        if (com.kwad.sdk.core.response.a.b.cc(adInfo) && X(context)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.b.cd(adInfo) && Y(context);
    }

    public static boolean b(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        return (W(context) ^ true) && com.kwad.sdk.core.response.a.b.cb(adInfo) && !a(sceneImpl);
    }

    public static boolean b(SceneImpl sceneImpl) {
        com.kwad.sdk.internal.api.b bVar;
        if (jU()) {
            return true;
        }
        if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
            return false;
        }
        return bVar.disableRotate;
    }

    public static boolean c(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        return (X(context) ^ true) && com.kwad.sdk.core.response.a.b.cc(adInfo) && !b(sceneImpl);
    }

    public static boolean c(SceneImpl sceneImpl) {
        com.kwad.sdk.internal.api.b bVar;
        if (jV()) {
            return true;
        }
        if (sceneImpl == null || (bVar = sceneImpl.splashExtraData) == null) {
            return false;
        }
        return bVar.disableSlide;
    }

    public static boolean d(Context context, AdInfo adInfo, SceneImpl sceneImpl) {
        return (Y(context) ^ true) && com.kwad.sdk.core.response.a.b.cd(adInfo) && !c(sceneImpl);
    }

    public static boolean jT() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean jU() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean jV() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean o(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.ce(adInfo);
    }
}
