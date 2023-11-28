package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public static final AtomicBoolean ard = new AtomicBoolean(false);
    public static volatile SdkConfigData are;

    public static boolean yf() {
        return false;
    }

    public static String AA() {
        return c.aoU.getValue();
    }

    public static boolean AB() {
        if (c.aoz.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int AC() {
        return c.aoA.getValue().intValue();
    }

    public static boolean AD() {
        if (c.aoB.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int AE() {
        return c.apg.getValue().intValue();
    }

    public static int AF() {
        return c.aph.getValue().intValue();
    }

    public static int AG() {
        return c.api.getValue().intValue();
    }

    public static long AH() {
        return c.apj.getValue().intValue() * 60000;
    }

    public static boolean AI() {
        if (c.aps.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean AJ() {
        if (c.apt.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int AK() {
        return c.apA.getValue().intValue();
    }

    public static boolean AL() {
        return c.apB.getValue().booleanValue();
    }

    public static boolean AM() {
        return a(c.apE);
    }

    public static boolean AN() {
        if (!c.apG.getValue().booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean AO() {
        return a(c.apF);
    }

    public static boolean AP() {
        if (c.apI.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int AQ() {
        return c.apJ.getValue().intValue();
    }

    public static boolean AS() {
        if (c.aoJ.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean AT() {
        if (c.aoK.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean AU() {
        return c.aoN.getValue().booleanValue();
    }

    public static boolean AV() {
        if (c.aqi.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int AW() {
        return c.aoL.getValue().intValue();
    }

    public static int AX() {
        return c.apQ.getValue().intValue();
    }

    public static int AY() {
        return c.apP.getValue().intValue();
    }

    public static boolean AZ() {
        if (c.apR.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean Al() {
        if (c.aoC.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int Am() {
        return c.aoD.getValue().intValue();
    }

    public static int An() {
        return c.aoE.getValue().intValue();
    }

    public static boolean Ao() {
        if (c.aoG.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean Ap() {
        if (c.aoE.getValue().intValue() == 2) {
            return true;
        }
        return false;
    }

    public static int Aq() {
        return c.aoF.getValue().intValue();
    }

    public static boolean Ar() {
        if (c.aoH.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean As() {
        if (c.aoI.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int At() {
        return c.aoH.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    public static void Au() {
        com.kwad.components.ad.d.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> Av() {
        return c.aoZ.getValue();
    }

    public static String Aw() {
        return c.aoW.getValue();
    }

    @NonNull
    public static List<String> Ax() {
        return c.aoY.getValue();
    }

    public static int Ay() {
        return c.aqt.getValue().intValue();
    }

    public static String Az() {
        return c.aoT.getValue();
    }

    public static boolean Ba() {
        return c.apS.getValue().booleanValue();
    }

    public static float Bb() {
        float floatValue = c.apT.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float Bc() {
        return c.apU.getValue().floatValue();
    }

    public static boolean Bd() {
        return c.apW.getValue().booleanValue();
    }

    public static boolean Be() {
        if (c.aqa.getValue().intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean Bf() {
        if (c.aqh.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static long Bg() {
        return c.aqf.getValue().longValue();
    }

    public static boolean Bh() {
        return c.aql.BC();
    }

    public static com.kwad.sdk.core.network.idc.a.b Bi() {
        return c.aqn.getValue();
    }

    public static int Bj() {
        return c.aqo.getValue().intValue();
    }

    public static long Bk() {
        return c.aqp.getValue().longValue();
    }

    public static int Bl() {
        return c.aqq.getValue().intValue();
    }

    public static boolean Bm() {
        if (c.aqr.getValue().floatValue() == 1.0f) {
            return true;
        }
        return false;
    }

    public static boolean Bn() {
        return c.aqs.BC();
    }

    public static boolean Bo() {
        return c.aqu.BC();
    }

    public static String Bp() {
        return c.aqv.getValue();
    }

    public static String Bq() {
        return c.aqw.getValue();
    }

    public static String Br() {
        return c.aqx.getValue();
    }

    public static int Bs() {
        return c.aqA.getValue().intValue();
    }

    public static boolean Bt() {
        return c.aqD.getValue().booleanValue();
    }

    public static int Bu() {
        return c.aqE.getValue().intValue();
    }

    public static boolean Bv() {
        return c.ara.BC();
    }

    public static boolean Bw() {
        return c.arc.BC();
    }

    public static String getLogObiwanData() {
        return c.aqe.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.arb.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.aqX.getValue();
    }

    public static String getUserAgent() {
        return c.apN.getValue();
    }

    public static boolean gq() {
        return c.apZ.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return ard.get();
    }

    public static boolean wz() {
        return c.aqy.getValue().booleanValue();
    }

    public static boolean yD() {
        return c.aqP.getValue().booleanValue();
    }

    @Deprecated
    public static int yE() {
        return c.aoM.getValue().intValue();
    }

    public static boolean yF() {
        return c.aqT.BC();
    }

    public static int ye() {
        return c.aou.getValue().intValue();
    }

    public static boolean yg() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (c.aoy.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean yk() {
        if (c.app.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean ym() {
        if (c.apq.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean yn() {
        if (c.apo.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static String yo() {
        return c.apC.getImei();
    }

    public static String yp() {
        return c.apC.getOaid();
    }

    public static List<String> yq() {
        return c.aoX.getValue();
    }

    public static boolean yr() {
        if (c.apM.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean ys() {
        if (c.apO.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean yu() {
        return c.aqj.getValue().booleanValue();
    }

    public static boolean yv() {
        return c.aqk.getValue().booleanValue();
    }

    public static int yw() {
        if (are != null) {
            return are.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int yx() {
        return c.aqm.getValue().intValue();
    }

    public static double yy() {
        return c.apV.getValue().floatValue();
    }

    public static boolean yz() {
        return c.aqC.getValue().booleanValue();
    }

    @NonNull
    public static SdkConfigData AR() {
        if (are == null) {
            synchronized (d.class) {
                if (are == null) {
                    are = new SdkConfigData();
                    String ch = y.ch(ServiceProvider.Jn());
                    if (!TextUtils.isEmpty(ch)) {
                        try {
                            are.parseJson(new JSONObject(ch));
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    } else {
                        com.kwad.sdk.core.e.c.d("SdkConfigManager", "configCache is empty");
                    }
                }
            }
        }
        return are;
    }

    public static boolean T(long j) {
        if ((j & c.aoO.getValue().longValue()) != 0) {
            return true;
        }
        return false;
    }

    public static double a(f fVar) {
        Double d = (Double) b(fVar);
        if (d == null) {
            d = fVar.Bx();
        }
        return d.doubleValue();
    }

    @WorkerThread
    public static synchronized void aR(Context context) {
        synchronized (d.class) {
            if (ard.get()) {
                return;
            }
            com.kwad.sdk.core.e.c.d("SdkConfigManager", "loadCache");
            c.init();
            Au();
            b.aQ(context);
            AR();
            ard.set(true);
        }
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context Jn = ServiceProvider.Jn();
            b.a(Jn, bVar);
            g.execute(new ay() { // from class: com.kwad.sdk.core.config.d.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    d.aR(Jn);
                }
            });
        }
        T value = bVar.getValue();
        if (value != null) {
            return value;
        }
        return bVar.Bx();
    }

    public static void c(@NonNull SdkConfigData sdkConfigData) {
        synchronized (d.class) {
            are = sdkConfigData;
        }
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        if (num == null) {
            num = kVar.Bx();
        }
        return num.intValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b<Object>) kVar);
        if (num != null) {
            if (num.intValue() > 0) {
                return true;
            }
            return false;
        } else if (kVar.Bx().intValue() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static long a(m mVar) {
        Long l = (Long) b(mVar);
        if (l == null) {
            l = mVar.Bx();
        }
        return l.longValue();
    }

    public static String a(p pVar) {
        String str = (String) b(pVar);
        if (str != null) {
            return str;
        }
        return pVar.Bx();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        if (jSONObject != null) {
            return jSONObject;
        }
        return eVar.Bx();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.Bx();
        }
        return bool.booleanValue();
    }
}
