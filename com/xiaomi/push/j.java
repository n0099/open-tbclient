package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class j {
    public static volatile int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, n> f811a = null;
    public static int b = -1;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        int i;
        boolean z;
        if (a == 0) {
            try {
                i = 1;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                a = 0;
            }
            if (TextUtils.isEmpty(m711a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m711a("ro.miui.ui.version.name"))) {
                z = false;
                if (z) {
                    i = 2;
                }
                a = i;
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
            z = true;
            if (z) {
            }
            a = i;
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    public static int a(Context context) {
        String m711a = m711a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m711a) || !TextUtils.isDigitsOnly(m711a)) {
            return 0;
        }
        return Integer.parseInt(m711a);
    }

    public static n a(String str) {
        n b2 = b(str);
        return b2 == null ? n.Global : b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m710a() {
        int a2 = s.a();
        return (!m713a() || a2 <= 0) ? "" : a2 < 2 ? Key.ALPHA : a2 < 3 ? "development" : "stable";
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(StringUtil.NULL_STRING);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m711a(String str) {
        try {
            try {
                return (String) bj.a(CountryCodeBean.ANDRIOD_SYSTEMPROP, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m712a() {
        if (f811a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f811a = hashMap;
        hashMap.put("CN", n.China);
        f811a.put("FI", n.Europe);
        f811a.put("SE", n.Europe);
        f811a.put(HlsPlaylistParser.BOOLEAN_FALSE, n.Europe);
        f811a.put("FO", n.Europe);
        f811a.put("EE", n.Europe);
        f811a.put("LV", n.Europe);
        f811a.put("LT", n.Europe);
        f811a.put("BY", n.Europe);
        f811a.put("MD", n.Europe);
        f811a.put("UA", n.Europe);
        f811a.put("PL", n.Europe);
        f811a.put("CZ", n.Europe);
        f811a.put("SK", n.Europe);
        f811a.put("HU", n.Europe);
        f811a.put("DE", n.Europe);
        f811a.put("AT", n.Europe);
        f811a.put("CH", n.Europe);
        f811a.put("LI", n.Europe);
        f811a.put("GB", n.Europe);
        f811a.put("IE", n.Europe);
        f811a.put("NL", n.Europe);
        f811a.put("BE", n.Europe);
        f811a.put("LU", n.Europe);
        f811a.put("FR", n.Europe);
        f811a.put("RO", n.Europe);
        f811a.put("BG", n.Europe);
        f811a.put("RS", n.Europe);
        f811a.put("MK", n.Europe);
        f811a.put("AL", n.Europe);
        f811a.put("GR", n.Europe);
        f811a.put("SI", n.Europe);
        f811a.put("HR", n.Europe);
        f811a.put("IT", n.Europe);
        f811a.put("SM", n.Europe);
        f811a.put("MT", n.Europe);
        f811a.put("ES", n.Europe);
        f811a.put("PT", n.Europe);
        f811a.put("AD", n.Europe);
        f811a.put("CY", n.Europe);
        f811a.put("DK", n.Europe);
        f811a.put("IS", n.Europe);
        f811a.put("UK", n.Europe);
        f811a.put("EL", n.Europe);
        f811a.put("RU", n.Russia);
        f811a.put("IN", n.India);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m713a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m714a(Context context) {
        return context != null && m715a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m715a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static n b(String str) {
        m712a();
        return f811a.get(str.toUpperCase());
    }

    public static String b() {
        String a2 = r.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m716b(r.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = r.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m183a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m183a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m716b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split("-");
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m717b() {
        return a() == 2;
    }

    public static String c() {
        return m711a("ro.miui.ui.version.name");
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m718c() {
        if (b < 0) {
            b = !m720e() ? 1 : 0;
        }
        return b > 0;
    }

    public static String d() {
        return m711a("ro.build.characteristics");
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m719d() {
        return !n.China.name().equalsIgnoreCase(a(b()).name());
    }

    public static String e() {
        return m711a("ro.product.manufacturer");
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m720e() {
        String str = "";
        try {
            str = r.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }
}
