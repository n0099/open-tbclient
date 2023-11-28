package com.kwad.sdk.core.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kwad.sdk.core.f.a.b;
import com.kwad.sdk.core.f.a.c;
import com.kwad.sdk.core.f.a.d;
import com.kwad.sdk.core.f.a.e;
import com.kwad.sdk.core.f.a.f;
import com.kwad.sdk.core.f.a.g;
import com.kwad.sdk.core.f.a.i;
import com.kwad.sdk.core.f.a.j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.y;
/* loaded from: classes10.dex */
public final class a {
    public static String auP = "";
    public static boolean auQ;
    public static boolean sGetOaidFail;

    public static /* synthetic */ void zO() {
    }

    public static String bc(Context context) {
        if (au.KM() && !TextUtils.isEmpty(au.KN())) {
            return au.KN();
        }
        if (!TextUtils.isEmpty(auP)) {
            return auP;
        }
        if (!au.KM() && !((h) ServiceProvider.get(h.class)).T(2048L)) {
            initAsync(context);
            return auP;
        }
        return auP;
    }

    public static void bd(Context context) {
        if (!TextUtils.isEmpty(auP) || context == null || auQ) {
            return;
        }
        auQ = true;
        if (sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals(RomUtils.ROM_XIAOMI)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals(RomTypeUtil.ROM_ONEPLUS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals("VIVO")) {
                        c = 5;
                        break;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals(RomUtils.ROM_NUBIA)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c = 7;
                        break;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    auP = new b(applicationContext).getOAID();
                    break;
                case 1:
                case 2:
                    auP = new i(applicationContext).getOAID();
                    break;
                case 3:
                case 4:
                    auP = new f(applicationContext).getOAID();
                    break;
                case 5:
                    auP = new com.kwad.sdk.core.f.a.h(applicationContext).getOAID();
                    break;
                case 6:
                case 7:
                    auP = new c(applicationContext).getOAID();
                    break;
                case '\b':
                    auP = new d(applicationContext).getOAID();
                    break;
                case '\t':
                    auP = new e(applicationContext).getOAID();
                    break;
                case '\n':
                    auP = new g(applicationContext).getOAID();
                    break;
                case 11:
                    auP = new com.kwad.sdk.core.f.a.a(applicationContext).getOAID();
                    break;
                case '\f':
                case '\r':
                case 14:
                    auP = new j(applicationContext).getOAID();
                    break;
            }
            com.kwad.sdk.core.e.c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + auP);
            if (TextUtils.isEmpty(auP)) {
                sGetOaidFail = true;
            }
            dJ(auP);
            auQ = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public static void dJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            y.h("ksadsdk_pref", "kasd_oaid_key", str);
        }
    }

    public static void initAsync(final Context context) {
        if (TextUtils.isEmpty(auP) && context != null) {
            com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.core.f.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    String unused = a.auP = y.i("ksadsdk_pref", "kasd_oaid_key", "");
                    if (!TextUtils.isEmpty(a.auP)) {
                        return;
                    }
                    a.bd(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.f.a.1.1
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                            public final void dM(String str) {
                                String unused2 = a.auP = str;
                                a.dJ(str);
                                a.zO();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.f.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void dM(String str) {
                                String unused2 = a.auP = str;
                                a.dJ(str);
                                a.zO();
                            }
                        });
                    }
                }
            });
        }
    }
}
