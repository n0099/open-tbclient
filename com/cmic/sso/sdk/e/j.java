package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;
/* loaded from: classes15.dex */
public class j {
    @SuppressLint({"StaticFieldLeak"})
    private static j pxe;

    /* renamed from: a  reason: collision with root package name */
    private Context f7731a;

    public static void a(Context context) {
        pxe = new j(context);
    }

    private j(Context context) {
        this.f7731a = context;
    }

    public static j eru() {
        return pxe;
    }

    public String b() {
        try {
            b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
            return erl.OJ(erl.f());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public String a(boolean z) {
        String str;
        TelephonyManager telephonyManager;
        String str2;
        b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
        String OL = erl.OL(erl.f());
        if (TextUtils.isEmpty(OL) && n.a(this.f7731a) && (telephonyManager = (TelephonyManager) this.f7731a.getSystemService("phone")) != null) {
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator) && g.a(this.f7731a, "android.permission.READ_PHONE_STATE") && n.d()) {
                try {
                    str2 = telephonyManager.getSubscriberId();
                } catch (Exception e) {
                    c.a("SIMUtils", "getOperator失败");
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2) && str2.length() >= 5) {
                    str = str2.substring(0, 5);
                }
            }
            str = simOperator;
        } else {
            str = OL;
        }
        c.b("SIMUtils", "operator: " + str);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                return "0";
            }
            return "";
        }
        return a(str);
    }

    private String a(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c = 4;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c = 1;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c = 7;
                    break;
                }
                break;
            case 49679474:
                if (str.equals("46004")) {
                    c = 3;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c = '\b';
                    break;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c = 2;
                    break;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    c = 6;
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                c.a("SIMUtils", "中国移动");
                return "1";
            case 4:
            case 5:
            case 6:
                c.a("SIMUtils", "中国联通");
                return "2";
            case 7:
            case '\b':
            case '\t':
                c.a("SIMUtils", "中国电信");
                return "3";
            default:
                return "0";
        }
    }

    @SuppressLint({"MissingPermission"})
    public String Bf(boolean z) {
        try {
            if (n.d()) {
                b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
                String OK = erl.OK(erl.f());
                if (TextUtils.isEmpty(OK) && z) {
                    OK = ((TelephonyManager) this.f7731a.getSystemService("phone")).getDeviceId();
                }
                c.b("SIMUtils", "imei is " + OK);
                if (TextUtils.isEmpty(OK)) {
                    return "none";
                }
                return OK;
            }
        } catch (Exception e) {
            c.a("SIMUtils", e.getMessage());
        }
        return "none";
    }

    public String c() {
        try {
            b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
            String OJ = erl.OJ((erl.f() + 1) % 2);
            if (OJ == null) {
                return "";
            }
            return OJ;
        } catch (Exception e) {
            return "";
        }
    }

    public String d() {
        try {
            b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
            String OK = erl.OK((erl.f() + 1) % 2);
            if (OK == null) {
                return "";
            }
            return OK;
        } catch (Exception e) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String e() {
        b.C1036b erl = com.cmic.sso.sdk.a.b.erk().erl();
        return erl.a(erl.f());
    }

    public String f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f7731a.getSystemService("phone");
        if (telephonyManager != null) {
            String simOperator = telephonyManager.getSimOperator();
            c.b("SIMUtils", "SysOperType = " + simOperator);
            return a(simOperator);
        }
        return "0";
    }
}
