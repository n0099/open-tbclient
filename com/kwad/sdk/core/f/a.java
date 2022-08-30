package com.kwad.sdk.core.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kwad.sdk.core.f.kwai.b;
import com.kwad.sdk.core.f.kwai.c;
import com.kwad.sdk.core.f.kwai.d;
import com.kwad.sdk.core.f.kwai.e;
import com.kwad.sdk.core.f.kwai.h;
import com.kwad.sdk.core.f.kwai.i;
import com.kwad.sdk.core.f.kwai.j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
/* loaded from: classes7.dex */
public final class a {
    public static String Zn = "";
    public static boolean Zo;
    public static boolean sGetOaidFail;

    public static String bv(Context context) {
        if (!aq.Ab() || TextUtils.isEmpty(aq.Ac())) {
            if (TextUtils.isEmpty(Zn)) {
                if (aq.Ab() || ((f) ServiceProvider.get(f.class)).i(2048L)) {
                    return Zn;
                }
                init(context);
                return Zn;
            }
            return Zn;
        }
        return aq.Ac();
    }

    public static void bw(Context context) {
        if (!TextUtils.isEmpty(Zn) || context == null || Zo) {
            return;
        }
        Zo = true;
        if (sGetOaidFail) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.sdk.core.f.a.3
            @Override // java.lang.Runnable
            public final void run() {
                String oaid;
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
                            if (upperCase.equals("XIAOMI")) {
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
                            oaid = new b(applicationContext).getOAID();
                            String unused = a.Zn = oaid;
                            break;
                        case 1:
                        case 2:
                            oaid = new i(applicationContext).getOAID();
                            String unused2 = a.Zn = oaid;
                            break;
                        case 3:
                        case 4:
                            oaid = new com.kwad.sdk.core.f.kwai.f(applicationContext).getOAID();
                            String unused22 = a.Zn = oaid;
                            break;
                        case 5:
                            oaid = new h(applicationContext).getOAID();
                            String unused222 = a.Zn = oaid;
                            break;
                        case 6:
                        case 7:
                            oaid = new c(applicationContext).getOAID();
                            String unused2222 = a.Zn = oaid;
                            break;
                        case '\b':
                            oaid = new d(applicationContext).getOAID();
                            String unused22222 = a.Zn = oaid;
                            break;
                        case '\t':
                            oaid = new e(applicationContext).getOAID();
                            String unused222222 = a.Zn = oaid;
                            break;
                        case '\n':
                            oaid = new com.kwad.sdk.core.f.kwai.g(applicationContext).getOAID();
                            String unused2222222 = a.Zn = oaid;
                            break;
                        case 11:
                            oaid = new com.kwad.sdk.core.f.kwai.a(applicationContext).getOAID();
                            String unused22222222 = a.Zn = oaid;
                            break;
                        case '\f':
                        case '\r':
                        case 14:
                            oaid = new j(applicationContext).getOAID();
                            String unused222222222 = a.Zn = oaid;
                            break;
                        default:
                            if (a.ue() || a.uf()) {
                                oaid = new j(applicationContext).getOAID();
                                String unused2222222222 = a.Zn = oaid;
                                break;
                            }
                            break;
                    }
                    com.kwad.sdk.core.e.b.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + a.Zn);
                    if (TextUtils.isEmpty(a.Zn)) {
                        boolean unused3 = a.sGetOaidFail = true;
                    }
                    a.ug();
                    boolean unused4 = a.Zo = false;
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
        });
    }

    public static void init(Context context) {
        if (!TextUtils.isEmpty(Zn) || context == null) {
            return;
        }
        bw(context);
        if (OADIDSDKHelper.isSupport()) {
            OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.f.a.1
                @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                public final void cp(String str) {
                    String unused = a.Zn = str;
                    a.ug();
                }
            });
        } else if (OADIDSDKHelper25.isSupport()) {
            OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.f.a.2
                @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                public final void cp(String str) {
                    String unused = a.Zn = str;
                    a.ug();
                }
            });
        }
    }

    public static boolean ue() {
        String str = ay.get("ro.build.freeme.label");
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean uf() {
        String str = ay.get("ro.ssui.product");
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown")) ? false : true;
    }

    public static /* synthetic */ void ug() {
    }
}
