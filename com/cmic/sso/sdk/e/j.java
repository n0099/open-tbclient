package com.cmic.sso.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;
/* loaded from: classes14.dex */
public class j {
    @SuppressLint({"StaticFieldLeak"})
    private static j pzJ;

    /* renamed from: a  reason: collision with root package name */
    private Context f5222a;

    public static void a(Context context) {
        pzJ = new j(context);
    }

    private j(Context context) {
        this.f5222a = context;
    }

    public static j erL() {
        return pzJ;
    }

    public String b() {
        try {
            b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
            return erD.OO(erD.f());
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
        b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
        String OQ = erD.OQ(erD.f());
        if (TextUtils.isEmpty(OQ) && n.a(this.f5222a) && (telephonyManager = (TelephonyManager) this.f5222a.getSystemService("phone")) != null) {
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator) && g.a(this.f5222a, "android.permission.READ_PHONE_STATE") && n.d()) {
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
            str = OQ;
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
    public String Bd(boolean z) {
        try {
            if (n.d()) {
                b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
                String OP = erD.OP(erD.f());
                if (TextUtils.isEmpty(OP) && z) {
                    OP = ((TelephonyManager) this.f5222a.getSystemService("phone")).getDeviceId();
                }
                c.b("SIMUtils", "imei is " + OP);
                if (TextUtils.isEmpty(OP)) {
                    return "none";
                }
                return OP;
            }
        } catch (Exception e) {
            c.a("SIMUtils", e.getMessage());
        }
        return "none";
    }

    public String c() {
        try {
            b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
            String OO = erD.OO((erD.f() + 1) % 2);
            if (OO == null) {
                return "";
            }
            return OO;
        } catch (Exception e) {
            return "";
        }
    }

    public String d() {
        try {
            b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
            String OP = erD.OP((erD.f() + 1) % 2);
            if (OP == null) {
                return "";
            }
            return OP;
        } catch (Exception e) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String e() {
        b.C1053b erD = com.cmic.sso.sdk.a.b.erC().erD();
        return erD.a(erD.f());
    }

    public String f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f5222a.getSystemService("phone");
        if (telephonyManager != null) {
            String simOperator = telephonyManager.getSimOperator();
            c.b("SIMUtils", "SysOperType = " + simOperator);
            return a(simOperator);
        }
        return "0";
    }
}
