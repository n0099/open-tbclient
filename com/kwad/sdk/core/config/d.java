package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d {
    public static volatile boolean a;
    public static volatile SdkConfigData b;

    public static int A() {
        return c.ad.b().intValue();
    }

    public static boolean B() {
        return c.ae.b().booleanValue();
    }

    public static boolean C() {
        return c.ag.b().booleanValue();
    }

    public static boolean D() {
        return !c.ah.b().booleanValue();
    }

    public static boolean E() {
        return c.aj.b().intValue() == 1;
    }

    public static int F() {
        return c.ak.b().intValue();
    }

    @Nullable
    public static SdkConfigData G() {
        if (b != null) {
            return b;
        }
        try {
            String f = as.f(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a());
            if (!TextUtils.isEmpty(f)) {
                JSONObject jSONObject = new JSONObject(f);
                SdkConfigData sdkConfigData = new SdkConfigData();
                b = sdkConfigData;
                sdkConfigData.parseJson(jSONObject);
            }
        } catch (Exception unused) {
        }
        return b;
    }

    public static boolean H() {
        return c.j.b().intValue() == 1;
    }

    public static boolean I() {
        return c.k.b().intValue() == 1;
    }

    public static int J() {
        return c.m.b().intValue();
    }

    public static boolean K() {
        return c.n.b().booleanValue();
    }

    public static String L() {
        return c.ar.b();
    }

    public static boolean M() {
        return c.aq.b().intValue() == 1;
    }

    public static boolean N() {
        return c.aJ.b().intValue() == 1;
    }

    public static float O() {
        return c.aK.b().floatValue();
    }

    public static float P() {
        return c.aL.b().floatValue();
    }

    public static boolean Q() {
        return c.as.b().intValue() == 1;
    }

    public static int R() {
        return c.l.b().intValue();
    }

    public static int S() {
        return c.au.b().intValue();
    }

    public static int T() {
        return c.at.b().intValue();
    }

    public static boolean U() {
        return c.av.b().intValue() == 1;
    }

    public static boolean V() {
        return c.aw.b().booleanValue();
    }

    public static float W() {
        float floatValue = c.ax.b().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float X() {
        return c.ay.b().floatValue();
    }

    public static boolean Y() {
        return c.az.b().booleanValue();
    }

    public static boolean Z() {
        return c.aC.b().booleanValue();
    }

    public static <T extends com.kwad.sdk.core.config.item.b> T a(Context context, T t) {
        if (!an()) {
            b.a(context, t);
        }
        return t;
    }

    @WorkerThread
    public static void a(Context context) {
        com.kwad.sdk.core.d.b.a("SdkConfigManager", "load");
        c.a();
        ao();
        b.b(context);
        G();
        a = true;
    }

    public static void a(SdkConfigData sdkConfigData) {
        b = sdkConfigData;
    }

    public static boolean a() {
        return c.i.b().intValue() == 1;
    }

    public static boolean a(long j) {
        return (j & c.o.b().longValue()) != 0;
    }

    public static boolean aa() {
        return c.aI.b().intValue() == 1;
    }

    public static long ab() {
        return c.aH.b().longValue();
    }

    public static boolean ac() {
        return ((com.kwad.sdk.core.config.item.d) a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), c.aD)).b().booleanValue();
    }

    public static boolean ad() {
        return ((com.kwad.sdk.core.config.item.d) a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), c.aE)).b().booleanValue();
    }

    public static long ae() {
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return ((k) a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), c.aF)).b().longValue();
    }

    public static String af() {
        return c.aG.b();
    }

    public static boolean ag() {
        return c.aM.b().booleanValue();
    }

    public static boolean ah() {
        return c.aN.b().booleanValue();
    }

    public static boolean ai() {
        return c.aO.d();
    }

    public static com.kwad.sdk.core.network.idc.kwai.a aj() {
        return c.aP.b();
    }

    public static long ak() {
        return c.aQ.b().longValue();
    }

    public static boolean al() {
        return c.aR.b().booleanValue() && am() > 0 && am() <= 100;
    }

    public static int am() {
        return c.aS.b().intValue();
    }

    public static boolean an() {
        return a;
    }

    @ForInvoker(methodId = "initConfigList")
    public static void ao() {
        com.kwad.components.ad.c.a.a();
        com.kwad.components.ad.feed.kwai.a.a();
        com.kwad.components.ad.fullscreen.kwai.a.a();
        com.kwad.components.ad.interstitial.kwai.a.a();
        com.kwad.components.ad.reward.kwai.a.a();
        com.kwad.components.ad.splashscreen.a.a.a();
    }

    public static int b() {
        if (b != null) {
            return b.goodIdcThresholdMs;
        }
        return 200;
    }

    public static boolean b(Context context) {
        return ((i) a(context, c.b)).d();
    }

    public static float c(Context context) {
        return ((e) a(context, c.r)).b().floatValue();
    }

    public static List<String> c() {
        return c.F.b();
    }

    public static float d(Context context) {
        return ((e) a(context, c.s)).b().floatValue();
    }

    public static String d() {
        return c.E.b();
    }

    public static float e(Context context) {
        return ((e) a(context, c.v)).b().floatValue();
    }

    public static boolean e() {
        return false;
    }

    public static float f(Context context) {
        return ((e) a(context, c.w)).b().floatValue();
    }

    public static int f() {
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return c.a.b().intValue();
    }

    public static float g(Context context) {
        return ((e) a(context, c.x)).b().floatValue();
    }

    @NonNull
    public static List<String> g() {
        return c.G.b();
    }

    public static float h(Context context) {
        return ((e) a(context, c.y)).b().floatValue();
    }

    public static boolean h() {
        return c.c.b().intValue() == 0;
    }

    public static float i(Context context) {
        return ((e) a(context, c.t)).b().floatValue();
    }

    public static boolean i() {
        return c.q.b().booleanValue();
    }

    public static float j(Context context) {
        return ((e) a(context, c.u)).b().floatValue();
    }

    public static String j() {
        return c.B.b();
    }

    public static String k() {
        return c.C.b();
    }

    public static boolean l() {
        return !((com.kwad.sdk.core.config.item.d) a(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), c.D)).b().booleanValue();
    }

    public static boolean m() {
        return c.f.b().intValue() == 1;
    }

    public static int n() {
        return c.g.b().intValue();
    }

    public static boolean o() {
        return c.h.b().intValue() == 1;
    }

    public static boolean p() {
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return c.e.b().intValue() == 1;
    }

    public static int q() {
        return c.M.b().intValue();
    }

    public static int r() {
        return c.N.b().intValue();
    }

    public static boolean s() {
        return c.S.b().intValue() == 1;
    }

    public static boolean t() {
        return c.T.b().intValue() == 1;
    }

    public static boolean u() {
        return c.V.b().intValue() == 1;
    }

    public static boolean v() {
        return c.U.b().intValue() == 1;
    }

    public static boolean w() {
        return c.W.b().intValue() == 1;
    }

    public static boolean x() {
        return c.X.b().intValue() == 1;
    }

    public static String y() {
        return c.af.d();
    }

    public static String z() {
        return c.af.e();
    }
}
