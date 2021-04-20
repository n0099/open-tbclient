package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;
/* loaded from: classes5.dex */
public class j {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    public static j f30382b;

    /* renamed from: a  reason: collision with root package name */
    public Context f30383a;

    public j(Context context) {
        this.f30383a = context;
    }

    public static void a(Context context) {
        f30382b = new j(context);
    }

    @SuppressLint({"MissingPermission"})
    public static String d() {
        b.C0343b b2 = com.cmic.sso.sdk.a.b.a().b();
        return b2.a(b2.d());
    }

    public String b() {
        try {
            b.C0343b b2 = com.cmic.sso.sdk.a.b.a().b();
            return b2.e(b2.d());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String c() {
        try {
            b.C0343b b2 = com.cmic.sso.sdk.a.b.a().b();
            String e2 = b2.e((b2.d() + 1) % 2);
            return e2 == null ? "" : e2;
        } catch (Exception unused) {
            return "";
        }
    }

    public String e() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f30383a.getSystemService("phone");
        if (telephonyManager != null) {
            String simOperator = telephonyManager.getSimOperator();
            c.b("SIMUtils", "SysOperType = " + simOperator);
            return a(simOperator);
        }
        return "0";
    }

    public static j a() {
        return f30382b;
    }

    @SuppressLint({"MissingPermission"})
    public String a(boolean z) {
        TelephonyManager telephonyManager;
        b.C0343b b2 = com.cmic.sso.sdk.a.b.a().b();
        String f2 = b2.f(b2.d());
        if (TextUtils.isEmpty(f2) && n.a(this.f30383a) && (telephonyManager = (TelephonyManager) this.f30383a.getSystemService("phone")) != null) {
            f2 = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(f2) && g.a(this.f30383a, "android.permission.READ_PHONE_STATE") && n.d()) {
                String str = null;
                try {
                    str = telephonyManager.getSubscriberId();
                } catch (Exception unused) {
                    c.a("SIMUtils", "getOperator失败");
                }
                if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                    f2 = str.substring(0, 5);
                }
            }
        }
        c.b("SIMUtils", "operator: " + f2);
        if (TextUtils.isEmpty(f2)) {
            return z ? "0" : "";
        }
        return a(f2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String a(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == 49679479) {
            if (str.equals("46009")) {
                c2 = 6;
            }
            c2 = 65535;
        } else if (hashCode != 49679502) {
            switch (hashCode) {
                case 49679470:
                    if (str.equals("46000")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679471:
                    if (str.equals("46001")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679472:
                    if (str.equals("46002")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679473:
                    if (str.equals("46003")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679474:
                    if (str.equals("46004")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679475:
                    if (str.equals("46005")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679476:
                    if (str.equals("46006")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49679477:
                    if (str.equals("46007")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
        } else {
            if (str.equals("46011")) {
                c2 = '\t';
            }
            c2 = 65535;
        }
        switch (c2) {
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
}
