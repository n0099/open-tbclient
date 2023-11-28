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
import com.kwad.sdk.utils.bu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class av {
    public static String aOb = "";

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static com.kwad.sdk.k.a.b IV() {
        return com.kwad.sdk.k.a.b.IV();
    }

    public static com.kwad.sdk.k.a.f IW() {
        return com.kwad.sdk.k.a.f.IW();
    }

    public static String KT() {
        com.kwad.sdk.k.a.b IV = com.kwad.sdk.k.a.b.IV();
        if (IV != null) {
            return com.kwad.sdk.f.b.a(false, IV.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ym()) {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
        return com.kwad.sdk.f.b.a(false, "", 2);
    }

    public static String KU() {
        return com.kwad.sdk.f.b.a(false, "1", 0);
    }

    public static String KV() {
        return com.kwad.sdk.f.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    public static String KW() {
        return com.kwad.sdk.f.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return bQ(false);
    }

    public static String getOaid() {
        return bP(false);
    }

    public static String KS() {
        int i;
        com.kwad.sdk.k.a.f IW = com.kwad.sdk.k.a.f.IW();
        if (IW != null) {
            i = IW.aLu;
        } else {
            i = -1;
        }
        if (i >= 0) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(i), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yk()) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(i), 1);
        }
        return com.kwad.sdk.f.b.a(false, String.valueOf(i), 2);
    }

    public static String bP(boolean z) {
        String ca = bi.ca(z);
        if (!z) {
            if (TextUtils.isEmpty(ca)) {
                return "";
            }
            return ca;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(ca)) {
            return com.kwad.sdk.f.b.a((!au.KM() || TextUtils.isEmpty(au.KN())) ? false : false, ca, 0);
        } else if (!au.KM() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(2048L)) {
            return com.kwad.sdk.f.b.a(false, ca, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, ca, 1);
        }
    }

    public static String bQ(boolean z) {
        if (com.kwad.framework.a.a.mc.booleanValue() && !TextUtils.isEmpty(bj.getDeviceId())) {
            return bj.getDeviceId();
        }
        String deviceId = bi.getDeviceId();
        if (!z) {
            if (TextUtils.isEmpty(deviceId)) {
                return "";
            }
            return deviceId;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(deviceId)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.KJ())) ? false : false, deviceId, 0);
        } else if (!au.usePhoneStateDisable() && o.JH()) {
            return com.kwad.sdk.f.b.a(false, deviceId, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, deviceId, 1);
        }
    }

    public static String cF(Context context) {
        List<bu.a> n = n(context, 15);
        if (n != null && n.size() > 0) {
            return com.kwad.sdk.f.b.a(au.KO(), t.K(n), 0);
        }
        int i = 1;
        if (!au.KO() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(32L)) {
            if (!bu.dj(context)) {
                i = 3;
            }
            return com.kwad.sdk.f.b.a(false, "", i);
        }
        return com.kwad.sdk.f.b.a(false, "", 1);
    }

    public static String cG(Context context) {
        com.kwad.sdk.core.c.b.Ct();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.f.b.a(false, "", 5);
        }
        Map<String, InstalledAppInfoManager.AppPackageInfo> bW = InstalledAppInfoManager.bW(context);
        int i = 1;
        boolean z = true;
        if (bW.size() > 0) {
            return com.kwad.sdk.f.b.a((!au.KQ() || au.KR() == null) ? false : false, InstalledAppInfoManager.f(bW), 0);
        } else if (!au.KQ() && o.JK()) {
            if (bi.di(context)) {
                i = 3;
            }
            return com.kwad.sdk.f.b.a(false, "", i);
        } else {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
    }

    public static String bR(boolean z) {
        String LH = bi.LH();
        if (!z) {
            if (TextUtils.isEmpty(LH)) {
                return "";
            }
            return LH;
        } else if (!TextUtils.isEmpty(LH)) {
            return com.kwad.sdk.f.b.a(au.KO(), LH, 0);
        } else {
            if (!au.KO() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(8L)) {
                return com.kwad.sdk.f.b.a(false, LH, 2);
            }
            return com.kwad.sdk.f.b.a(false, LH, 1);
        }
    }

    public static /* synthetic */ String bS(boolean z) {
        return bP(true);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.sdk.utils.av.1.He():java.lang.String] */
    public static /* synthetic */ String bT(boolean z) {
        return KS();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.sdk.utils.av.1.Hf():java.lang.String] */
    public static /* synthetic */ String bU(boolean z) {
        return KT();
    }

    public static Location bV(Context context) {
        return r.bV(context);
    }

    public static /* synthetic */ String bW(boolean z) {
        return bR(true);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.sdk.utils.av.1.Hi():java.lang.String] */
    public static /* synthetic */ String bX(boolean z) {
        return KU();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.sdk.utils.av.1.getSdkVersion():java.lang.String] */
    public static /* synthetic */ String bY(boolean z) {
        return KV();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.sdk.utils.av.1.getAppId():java.lang.String] */
    public static /* synthetic */ String bZ(boolean z) {
        return KW();
    }

    public static String cA(Context context) {
        return h(context, false);
    }

    public static String cB(Context context) {
        return i(context, false);
    }

    public static int cC(Context context) {
        return bi.db(context);
    }

    public static String cD(Context context) {
        int db = bi.db(context);
        if (db > 0) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(db), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(db), 1);
        }
        return com.kwad.sdk.f.b.a(false, String.valueOf(db), 3);
    }

    public static int cE(Context context) {
        return bi.dc(context);
    }

    @NonNull
    public static com.kwad.sdk.f.c cI(final Context context) {
        return new com.kwad.sdk.f.c() { // from class: com.kwad.sdk.utils.av.1
            @Override // com.kwad.sdk.f.a
            public final String GX() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + av.c(context, true));
                return av.c(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String GY() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + av.d(context, true));
                return av.d(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String GZ() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getMac:" + av.e(context, true));
                return av.e(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Ha() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + av.f(context, true));
                return av.f(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Hb() {
                String g = av.g(context, true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + g);
                return g;
            }

            @Override // com.kwad.sdk.f.a
            public final String Hc() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + av.h(context, true));
                return av.h(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Hd() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + av.cD(context));
                return av.cD(context);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bT(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.f.a
            public final java.lang.String He() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bT(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSimCardActivePhoneCount:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.He():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bU(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.f.a
            public final java.lang.String Hf() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bU(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getBaseStationInfo:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.Hf():java.lang.String");
            }

            @Override // com.kwad.sdk.f.a
            public final String Hg() {
                String cF = av.cF(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + cF);
                return cF;
            }

            @Override // com.kwad.sdk.f.a
            public final String Hh() {
                String cG = av.cG(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + cG);
                return cG;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bX(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.f.a
            public final java.lang.String Hi() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bX(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkType:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.Hi():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bZ(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.f.a
            public final java.lang.String getAppId() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bZ(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getAppId:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.getAppId():java.lang.String");
            }

            @Override // com.kwad.sdk.f.a
            public final String getDeviceId() {
                String bV = av.bV(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bV);
                return bV;
            }

            @Override // com.kwad.sdk.f.a
            public final String getIccId() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + av.i(context, true));
                return av.i(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String getIp() {
                String bW = av.bW(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIp:" + bW);
                return bW;
            }

            @Override // com.kwad.sdk.f.a
            public final String getLocation() {
                String cH = av.cH(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + cH);
                return cH;
            }

            @Override // com.kwad.sdk.f.a
            public final String getOaid() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + av.bS(true));
                return av.bS(true);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bY(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.f.a
            public final java.lang.String getSdkVersion() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bY(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkVersion:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.getSdkVersion():java.lang.String");
            }
        };
    }

    public static String cv(Context context) {
        return c(context, false);
    }

    public static String cw(Context context) {
        return d(context, false);
    }

    public static String cx(Context context) {
        return e(context, false);
    }

    public static String cy(Context context) {
        return f(context, false);
    }

    public static String cz(Context context) {
        return g(context, false);
    }

    public static void init(Context context) {
        com.kwad.sdk.f.b.a(cI(context));
    }

    public static /* synthetic */ String bV(boolean z) {
        return bQ(true);
    }

    public static String c(Context context, boolean z) {
        String u = bi.u(context, z);
        if (!z) {
            if (TextUtils.isEmpty(u)) {
                return "";
            }
            return u;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(u)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.KH())) ? false : false, u, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, u, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.JM()) {
                if (SystemUtil.cU(context)) {
                    i = 3;
                }
                return com.kwad.sdk.f.b.a(false, u, i);
            }
            return com.kwad.sdk.f.b.a(false, u, 1);
        }
    }

    public static String e(Context context, boolean z) {
        String dg = bi.dg(context);
        if (!z) {
            if (TextUtils.isEmpty(dg)) {
                return "";
            }
            return dg;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(dg)) {
            return com.kwad.sdk.f.b.a((!au.KK() || TextUtils.isEmpty(au.KL())) ? false : false, dg.toLowerCase(), 0);
        } else if (!au.KK() && o.JI()) {
            if (am.aq(context, com.kuaishou.weapon.p0.g.d) == 0) {
                i = 3;
            }
            return com.kwad.sdk.f.b.a(false, dg, i);
        } else {
            return com.kwad.sdk.f.b.a(false, dg, 0);
        }
    }

    public static String f(Context context, boolean z) {
        String str;
        String[] da = bi.da(context);
        if (da != null && da.length > 0) {
            str = da[0];
        } else {
            str = null;
        }
        if (!z) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        int i = 1;
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.KH())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, str, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.JM()) {
                if (SystemUtil.cU(context)) {
                    i = 3;
                }
                return com.kwad.sdk.f.b.a(false, str, i);
            }
            return com.kwad.sdk.f.b.a(false, str, 1);
        }
    }

    public static String g(Context context, boolean z) {
        String str;
        String[] da = bi.da(context);
        int i = 1;
        boolean z2 = true;
        if (da != null && da.length > 1) {
            str = da[1];
        } else {
            str = null;
        }
        if (!z) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        } else if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.KH())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, str, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.JM()) {
                if (SystemUtil.cU(context)) {
                    i = 3;
                }
                return com.kwad.sdk.f.b.a(false, str, i);
            }
            return com.kwad.sdk.f.b.a(false, str, 1);
        }
    }

    public static String h(Context context, boolean z) {
        String cA = bi.cA(context);
        if (!z) {
            if (TextUtils.isEmpty(cA)) {
                return "";
            }
            return cA;
        } else if (!TextUtils.isEmpty(cA)) {
            return com.kwad.sdk.f.b.a(au.usePhoneStateDisable(), cA, 0);
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                return com.kwad.sdk.f.b.a(false, cA, 4);
            }
            int i = 1;
            if (!au.usePhoneStateDisable() && o.JN()) {
                if (SystemUtil.cU(context)) {
                    i = 3;
                }
                return com.kwad.sdk.f.b.a(false, cA, i);
            }
            return com.kwad.sdk.f.b.a(false, cA, 1);
        }
    }

    public static String cH(Context context) {
        boolean z;
        Location bV = r.bV(context);
        int i = 1;
        boolean z2 = true;
        if (bV != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(bV.getLatitude()));
            hashMap.put("longitude", String.valueOf(bV.getLongitude()));
            return com.kwad.sdk.f.b.a((!au.KF() || au.KG() == null) ? false : false, t.parseMap2JSON(hashMap), 0);
        } else if (!au.KF() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(64L)) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = 3;
            }
            return com.kwad.sdk.f.b.a(false, "", i);
        } else {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
    }

    public static String d(Context context, boolean z) {
        String cw = bi.cw(context);
        if (!z) {
            if (TextUtils.isEmpty(cw)) {
                return "";
            }
            return cw;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(cw)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.KJ())) ? false : false, cw, 0);
        } else if (!au.usePhoneStateDisable() && o.JH()) {
            return com.kwad.sdk.f.b.a(false, cw, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, cw, 1);
        }
    }

    public static String i(Context context, boolean z) {
        String dd = bi.dd(context);
        if (!z) {
            if (TextUtils.isEmpty(dd)) {
                return "";
            }
            return dd;
        } else if (!TextUtils.isEmpty(dd)) {
            return com.kwad.sdk.f.b.a(au.usePhoneStateDisable(), dd, 0);
        } else {
            int i = 1;
            if (!au.usePhoneStateDisable() && o.JO()) {
                if (SystemUtil.cU(context)) {
                    i = 3;
                }
                return com.kwad.sdk.f.b.a(false, dd, i);
            }
            return com.kwad.sdk.f.b.a(false, dd, 1);
        }
    }

    public static List<bu.a> n(Context context, int i) {
        return bu.n(context, 15);
    }
}
