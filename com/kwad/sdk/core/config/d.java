package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class d {
    public static volatile boolean HK;
    public static volatile SdkConfigData Vy;

    @WorkerThread
    public static void aV(Context context) {
        com.kwad.sdk.core.e.b.d("SdkConfigManager", "load");
        c.init();
        rG();
        b.aU(context);
        rZ();
        HK = true;
    }

    public static boolean aW(Context context) {
        return ((j) b(context, c.Tr)).sB();
    }

    public static float aX(Context context) {
        return ((f) b(context, c.TH)).getValue().floatValue();
    }

    public static float aY(Context context) {
        return ((f) b(context, c.TI)).getValue().floatValue();
    }

    public static boolean aZ(Context context) {
        return ((j) b(context, c.TL)).getValue().intValue() > 0;
    }

    public static <T extends com.kwad.sdk.core.config.item.b> T b(Context context, T t) {
        if (!isLoaded()) {
            b.a(context, t);
        }
        return t;
    }

    public static float ba(Context context) {
        return ((f) b(context, c.TJ)).getValue().floatValue();
    }

    public static float bb(Context context) {
        return ((f) b(context, c.TT)).getValue().floatValue();
    }

    public static float bc(Context context) {
        return ((f) b(context, c.TQ)).getValue().floatValue();
    }

    public static float bd(Context context) {
        return ((f) b(context, c.TU)).getValue().floatValue();
    }

    public static float be(Context context) {
        return ((f) b(context, c.TV)).getValue().floatValue();
    }

    public static float bf(Context context) {
        return ((f) b(context, c.TW)).getValue().floatValue();
    }

    public static float bg(Context context) {
        return ((f) b(context, c.TM)).getValue().floatValue();
    }

    public static double bh(Context context) {
        return ((e) b(context, c.TN)).getValue().doubleValue();
    }

    public static double bi(Context context) {
        return ((e) b(context, c.TO)).getValue().doubleValue();
    }

    public static double bj(Context context) {
        return ((e) b(context, c.TP)).getValue().doubleValue();
    }

    public static float bk(Context context) {
        return ((f) b(context, c.TR)).getValue().floatValue();
    }

    public static float bl(Context context) {
        return ((f) b(context, c.TS)).getValue().floatValue();
    }

    public static void c(SdkConfigData sdkConfigData) {
        Vy = sdkConfigData;
    }

    public static boolean fY() {
        return c.Vc.getValue().booleanValue();
    }

    public static String getLogObiwanData() {
        return c.Vg.getValue();
    }

    public static long getLogObiwanStorageQuota() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return ((l) b(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), c.Vf)).getValue().longValue();
    }

    public static String getUserAgent() {
        return c.UR.getValue();
    }

    public static boolean i(long j) {
        return (j & c.TE.getValue().longValue()) != 0;
    }

    public static boolean isCanUseTk() {
        return c.UG.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return HK;
    }

    public static boolean isLogObiwanEnableNow() {
        return ((com.kwad.sdk.core.config.item.d) b(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), c.Vd)).getValue().booleanValue();
    }

    public static boolean isLogObiwanRecordAll() {
        return ((com.kwad.sdk.core.config.item.d) b(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), c.Ve)).getValue().booleanValue();
    }

    public static boolean lA() {
        return c.Us.getValue().intValue() == 1;
    }

    public static String lB() {
        return c.UF.getImei();
    }

    public static String lC() {
        return c.UF.getOaid();
    }

    public static List<String> lD() {
        return c.Ud.getValue();
    }

    public static boolean lE() {
        return c.UQ.getValue().intValue() == 1;
    }

    public static boolean lF() {
        return c.US.getValue().intValue() == 1;
    }

    public static boolean lG() {
        return c.Ux.getValue().intValue() == 1;
    }

    public static float lI() {
        return c.Vk.getValue().floatValue();
    }

    public static float lJ() {
        return c.Vl.getValue().floatValue();
    }

    public static boolean lK() {
        return c.Vm.getValue().booleanValue();
    }

    public static boolean lL() {
        return c.Vn.getValue().booleanValue();
    }

    public static int lM() {
        if (Vy != null) {
            return Vy.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int lN() {
        return c.Vp.getValue().intValue();
    }

    public static float lO() {
        return c.Vq.getValue().floatValue();
    }

    public static int lr() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.Tq.getValue().intValue();
    }

    public static boolean lt() {
        return false;
    }

    public static boolean lu() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.Tu.getValue().intValue() == 1;
    }

    public static boolean lx() {
        return c.Ut.getValue().intValue() == 1;
    }

    public static boolean ly() {
        return c.Uv.getValue().intValue() == 1;
    }

    public static boolean lz() {
        return c.Uu.getValue().intValue() == 1;
    }

    public static boolean rF() {
        return c.Ty.getValue().intValue() == 1;
    }

    @ForInvoker(methodId = "initConfigList")
    public static void rG() {
        com.kwad.components.ad.c.a.init();
        com.kwad.components.ad.feed.kwai.a.init();
        com.kwad.components.ad.fullscreen.kwai.a.init();
        com.kwad.components.ad.interstitial.kwai.a.init();
        com.kwad.components.ad.reward.kwai.a.init();
        com.kwad.components.ad.splashscreen.a.a.init();
    }

    public static String rH() {
        return c.Uc.getValue();
    }

    @NonNull
    public static List<String> rI() {
        return c.Ue.getValue();
    }

    public static boolean rJ() {
        return c.TG.getValue().booleanValue();
    }

    public static String rK() {
        return c.TZ.getValue();
    }

    public static String rL() {
        return c.Ua.getValue();
    }

    public static boolean rM() {
        return c.Tv.getValue().intValue() == 1;
    }

    public static int rN() {
        return c.Tw.getValue().intValue();
    }

    public static boolean rO() {
        return c.Tx.getValue().intValue() == 1;
    }

    public static int rP() {
        return c.Uk.getValue().intValue();
    }

    public static int rQ() {
        return c.Ul.getValue().intValue();
    }

    public static int rR() {
        return c.Um.getValue().intValue();
    }

    public static long rS() {
        return c.Un.getValue().intValue() * 60000;
    }

    public static boolean rT() {
        return c.Uw.getValue().intValue() == 1;
    }

    public static int rU() {
        return c.UD.getValue().intValue();
    }

    public static boolean rV() {
        return c.UE.getValue().booleanValue();
    }

    public static boolean rW() {
        return !c.UH.getValue().booleanValue();
    }

    public static boolean rX() {
        return c.UJ.getValue().intValue() == 1;
    }

    public static int rY() {
        return c.UK.getValue().intValue();
    }

    @Nullable
    public static SdkConfigData rZ() {
        if (Vy != null) {
            return Vy;
        }
        try {
            String cr = w.cr(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext());
            if (!TextUtils.isEmpty(cr)) {
                JSONObject jSONObject = new JSONObject(cr);
                SdkConfigData sdkConfigData = new SdkConfigData();
                Vy = sdkConfigData;
                sdkConfigData.parseJson(jSONObject);
            }
        } catch (Exception unused) {
        }
        return Vy;
    }

    public static boolean sa() {
        return c.Tz.getValue().intValue() == 1;
    }

    public static boolean sb() {
        return c.TA.getValue().intValue() == 1;
    }

    public static int sc() {
        return c.TC.getValue().intValue();
    }

    public static boolean sd() {
        return c.TD.getValue().booleanValue();
    }

    public static boolean se() {
        return c.Vj.getValue().intValue() == 1;
    }

    public static int sf() {
        return c.TB.getValue().intValue();
    }

    public static int sg() {
        return c.UU.getValue().intValue();
    }

    public static int sh() {
        return c.UT.getValue().intValue();
    }

    public static boolean si() {
        return c.UV.getValue().intValue() == 1;
    }

    public static boolean sj() {
        return c.UW.getValue().booleanValue();
    }

    public static float sk() {
        float floatValue = c.UX.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float sl() {
        return c.UY.getValue().floatValue();
    }

    public static boolean sm() {
        return c.UZ.getValue().booleanValue();
    }

    public static boolean sn() {
        return c.Vi.getValue().intValue() == 1;
    }

    public static long so() {
        return c.Vh.getValue().longValue();
    }

    public static boolean sp() {
        return c.Vo.sB();
    }

    public static com.kwad.sdk.core.network.idc.kwai.a sq() {
        return c.Vr.getValue();
    }

    public static long sr() {
        return c.Vs.getValue().longValue();
    }

    public static boolean ss() {
        return c.Vt.getValue().booleanValue() && st() > 0 && st() <= 100;
    }

    public static int st() {
        return c.Vu.getValue().intValue();
    }

    public static boolean su() {
        return c.Vv.getValue().floatValue() == 1.0f;
    }

    public static boolean sv() {
        return c.Vw.sB();
    }

    public static boolean sw() {
        return c.Vx.sB();
    }

    public static boolean useTkLite() {
        return !((com.kwad.sdk.core.config.item.d) b(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), c.Ub)).getValue().booleanValue();
    }
}
