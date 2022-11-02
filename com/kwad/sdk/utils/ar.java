package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.bi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ar {
    public static String aob = "";

    public static String Ah() {
        com.kwad.sdk.f.kwai.f yT = com.kwad.sdk.f.kwai.f.yT();
        int i = yT != null ? yT.amF : -1;
        if (i >= 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(i), 0);
        }
        boolean lx = ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lx();
        String valueOf = String.valueOf(i);
        return !lx ? com.kwad.sdk.c.b.a(false, valueOf, 1) : com.kwad.sdk.c.b.a(false, valueOf, 2);
    }

    public static String Ai() {
        com.kwad.sdk.f.kwai.b yS = com.kwad.sdk.f.kwai.b.yS();
        return yS != null ? com.kwad.sdk.c.b.a(false, yS.toJson(), 0) : !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).lz() ? com.kwad.sdk.c.b.a(false, "", 1) : com.kwad.sdk.c.b.a(false, "", 2);
    }

    public static List<com.kwad.sdk.f.kwai.e> Aj() {
        return at.Aj();
    }

    public static String Ak() {
        return com.kwad.sdk.c.b.a(false, "1", 0);
    }

    public static String Al() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    public static String Am() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static String bg(boolean z) {
        String br = az.br(z);
        if (!z) {
            return TextUtils.isEmpty(br) ? "" : br;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(br)) {
            return (aq.Ab() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(2048L)) ? com.kwad.sdk.c.b.a(false, br, 1) : com.kwad.sdk.c.b.a(false, br, 5);
        }
        return com.kwad.sdk.c.b.a((!aq.Ab() || TextUtils.isEmpty(aq.Ac())) ? false : false, br, 0);
    }

    public static String bh(boolean z) {
        String deviceId = az.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(deviceId)) {
            return (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(2L)) ? com.kwad.sdk.c.b.a(false, deviceId, 1) : com.kwad.sdk.c.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.c.b.a((!aq.zV() || TextUtils.isEmpty(aq.zY())) ? false : false, deviceId, 0);
    }

    public static String bi(boolean z) {
        String AR = az.AR();
        return !z ? TextUtils.isEmpty(AR) ? "" : AR : !TextUtils.isEmpty(AR) ? com.kwad.sdk.c.b.a(aq.Ad(), AR, 0) : (aq.Ad() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(8L)) ? com.kwad.sdk.c.b.a(false, AR, 1) : com.kwad.sdk.c.b.a(false, AR, 2);
    }

    public static String c(Context context, boolean z) {
        String u = az.u(context, z);
        if (!z) {
            return TextUtils.isEmpty(u) ? "" : u;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(u)) {
            return com.kwad.sdk.c.b.a((!aq.zV() || TextUtils.isEmpty(aq.zW())) ? false : false, u, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, u, 4);
        } else {
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1L)) {
                return com.kwad.sdk.c.b.a(false, u, 1);
            }
            return com.kwad.sdk.c.b.a(false, u, SystemUtil.dk(context) ? 3 : 1);
        }
    }

    public static String cI(Context context) {
        return c(context, false);
    }

    public static String cJ(Context context) {
        return d(context, false);
    }

    public static String cK(Context context) {
        return e(context, false);
    }

    public static String cL(Context context) {
        return f(context, false);
    }

    public static String cM(Context context) {
        return g(context, false);
    }

    public static String cN(Context context) {
        return h(context, false);
    }

    public static String cO(Context context) {
        return i(context, false);
    }

    public static int cP(Context context) {
        return az.dr(context);
    }

    public static String cQ(Context context) {
        int dr = az.dr(context);
        if (dr > 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(dr), 0);
        }
        int i = Build.VERSION.SDK_INT;
        String valueOf = String.valueOf(dr);
        return i < 23 ? com.kwad.sdk.c.b.a(false, valueOf, 1) : com.kwad.sdk.c.b.a(false, valueOf, 3);
    }

    public static int cR(Context context) {
        return az.ds(context);
    }

    public static String cS(Context context) {
        List<bi.a> h = h(context, 15);
        if (h == null || h.size() <= 0) {
            if (aq.Ad() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(32L)) {
                return com.kwad.sdk.c.b.a(false, "", 1);
            }
            return com.kwad.sdk.c.b.a(false, "", bi.dA(context) ? 1 : 3);
        }
        return com.kwad.sdk.c.b.a(aq.Ad(), r.B(h), 0);
    }

    public static Map<String, InstalledAppInfoManager.AppPackageInfo> cT(Context context) {
        return InstalledAppInfoManager.ci(context);
    }

    public static String cU(Context context) {
        Map<String, InstalledAppInfoManager.AppPackageInfo> ci = InstalledAppInfoManager.ci(context);
        boolean z = true;
        if (ci.size() > 0) {
            return com.kwad.sdk.c.b.a((!aq.Af() || aq.Ag() == null) ? false : false, InstalledAppInfoManager.d(ci), 0);
        } else if (aq.Af() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(16L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        } else {
            return com.kwad.sdk.c.b.a(false, "", az.dy(context) ? 3 : 1);
        }
    }

    public static String cV(Context context) {
        Location cg = p.cg(context);
        boolean z = true;
        if (cg != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(cg.getLatitude()));
            hashMap.put("longitude", String.valueOf(cg.getLongitude()));
            return com.kwad.sdk.c.b.a((!aq.zT() || aq.zU() == null) ? false : false, r.parseMap2JSON(hashMap), 0);
        } else if (aq.zT() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(64L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        } else {
            return com.kwad.sdk.c.b.a(false, "", ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == 0 ? 3 : 1);
        }
    }

    @NonNull
    public static com.kwad.sdk.c.c cW(final Context context) {
        return new com.kwad.sdk.c.c() { // from class: com.kwad.sdk.utils.ar.1
            @Override // com.kwad.sdk.c.a
            public final String getAppId() {
                String Am = ar.Am();
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getAppId:" + Am);
                return Am;
            }

            @Override // com.kwad.sdk.c.a
            public final String getDeviceId() {
                String bh = ar.bh(true);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bh);
                return bh;
            }

            @Override // com.kwad.sdk.c.a
            public final String getIccId() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIccId:" + ar.i(context, true));
                return ar.i(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String getIp() {
                String bi = ar.bi(true);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIp:" + bi);
                return bi;
            }

            @Override // com.kwad.sdk.c.a
            public final String getLocation() {
                String cV = ar.cV(context);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getLocation:" + cV);
                return cV;
            }

            @Override // com.kwad.sdk.c.a
            public final String getOaid() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getOaid:" + ar.bg(true));
                return ar.bg(true);
            }

            @Override // com.kwad.sdk.c.a
            public final String getSdkVersion() {
                String Al = ar.Al();
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + Al);
                return Al;
            }

            @Override // com.kwad.sdk.c.a
            public final String xa() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIMEI:" + ar.c(context, true));
                return ar.c(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String xb() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + ar.d(context, true));
                return ar.d(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String xc() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getMac:" + ar.e(context, true));
                return ar.e(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String xd() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + ar.f(context, true));
                return ar.f(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String xe() {
                String g = ar.g(context, true);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + g);
                return g;
            }

            @Override // com.kwad.sdk.c.a
            public final String xf() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getIMSI:" + ar.h(context, true));
                return ar.h(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String xg() {
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + ar.cQ(context));
                return ar.cQ(context);
            }

            @Override // com.kwad.sdk.c.a
            public final String xh() {
                String Ah = ar.Ah();
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + Ah);
                return Ah;
            }

            @Override // com.kwad.sdk.c.a
            public final String xi() {
                String Ai = ar.Ai();
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + Ai);
                return Ai;
            }

            @Override // com.kwad.sdk.c.a
            public final String xj() {
                String cS = ar.cS(context);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getWifiList:" + cS);
                return cS;
            }

            @Override // com.kwad.sdk.c.a
            public final String xk() {
                String cU = ar.cU(context);
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getAppList:" + cU);
                return cU;
            }

            @Override // com.kwad.sdk.c.a
            public final String xl() {
                String Ak = ar.Ak();
                com.kwad.sdk.core.e.b.d("SDKPrivateSafetyDataUtil", "getSdkType:" + Ak);
                return Ak;
            }
        };
    }

    public static Location cg(Context context) {
        return p.cg(context);
    }

    public static String d(Context context, boolean z) {
        String cJ = az.cJ(context);
        if (!z) {
            return TextUtils.isEmpty(cJ) ? "" : cJ;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(cJ)) {
            return (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(2L)) ? com.kwad.sdk.c.b.a(false, cJ, 1) : com.kwad.sdk.c.b.a(false, cJ, 5);
        }
        return com.kwad.sdk.c.b.a((!aq.zV() || TextUtils.isEmpty(aq.zY())) ? false : false, cJ, 0);
    }

    public static String e(Context context, boolean z) {
        String dw = az.dw(context);
        if (!z) {
            return TextUtils.isEmpty(dw) ? "" : dw;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(dw)) {
            return com.kwad.sdk.c.b.a((!aq.zZ() || TextUtils.isEmpty(aq.Aa())) ? false : false, dw.toLowerCase(), 0);
        } else if (aq.zZ() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(4L)) {
            return com.kwad.sdk.c.b.a(false, dw, 0);
        } else {
            return com.kwad.sdk.c.b.a(false, dw, aj.Y(context, com.kuaishou.weapon.p0.h.d) == 0 ? 3 : 1);
        }
    }

    public static String f(Context context, boolean z) {
        String[] dq = az.dq(context);
        String str = (dq == null || dq.length <= 0) ? null : dq[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a((!aq.zV() || TextUtils.isEmpty(aq.zW())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        } else {
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1L)) {
                return com.kwad.sdk.c.b.a(false, str, 1);
            }
            return com.kwad.sdk.c.b.a(false, str, SystemUtil.dk(context) ? 3 : 1);
        }
    }

    public static String g(Context context, boolean z) {
        String[] dq = az.dq(context);
        boolean z2 = true;
        String str = (dq == null || dq.length <= 1) ? null : dq[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        } else if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a((!aq.zV() || TextUtils.isEmpty(aq.zW())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        } else {
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(1L)) {
                return com.kwad.sdk.c.b.a(false, str, 1);
            }
            return com.kwad.sdk.c.b.a(false, str, SystemUtil.dk(context) ? 3 : 1);
        }
    }

    public static String getAppId() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getAppId();
    }

    public static String getDeviceId() {
        return bh(false);
    }

    public static String getOaid() {
        return bg(false);
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static String h(Context context, boolean z) {
        String cN = az.cN(context);
        if (!z) {
            return TextUtils.isEmpty(cN) ? "" : cN;
        } else if (TextUtils.isEmpty(cN)) {
            if (Build.VERSION.SDK_INT >= 29) {
                return com.kwad.sdk.c.b.a(false, cN, 4);
            }
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(128L)) {
                return com.kwad.sdk.c.b.a(false, cN, 1);
            }
            return com.kwad.sdk.c.b.a(false, cN, SystemUtil.dk(context) ? 3 : 1);
        } else {
            return com.kwad.sdk.c.b.a(aq.zV(), cN, 0);
        }
    }

    public static List<bi.a> h(Context context, int i) {
        return bi.h(context, 15);
    }

    public static String i(Context context, boolean z) {
        String dt = az.dt(context);
        if (!z) {
            return TextUtils.isEmpty(dt) ? "" : dt;
        } else if (TextUtils.isEmpty(dt)) {
            if (aq.zV() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(128L)) {
                return com.kwad.sdk.c.b.a(false, dt, 1);
            }
            return com.kwad.sdk.c.b.a(false, dt, SystemUtil.dk(context) ? 3 : 1);
        } else {
            return com.kwad.sdk.c.b.a(aq.zV(), dt, 0);
        }
    }

    public static void init(Context context) {
        com.kwad.sdk.c.b.a(cW(context));
    }

    public static com.kwad.sdk.f.kwai.b yS() {
        return com.kwad.sdk.f.kwai.b.yS();
    }

    public static com.kwad.sdk.f.kwai.f yT() {
        return com.kwad.sdk.f.kwai.f.yT();
    }
}
