package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class ax {
    public static final SimpleDateFormat aon = new SimpleDateFormat("MM/dd", Locale.US);
    public static final SimpleDateFormat aoo = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    public static final SimpleDateFormat aop = new SimpleDateFormat("MM月dd日", Locale.US);
    public static final SimpleDateFormat aoq = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    public static final SimpleDateFormat aor = new SimpleDateFormat("HH:mm", Locale.US);
    public static final SimpleDateFormat aos = new SimpleDateFormat("MM-dd", Locale.US);
    public static final SimpleDateFormat aot = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean V(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean dT(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str);
    }

    public static boolean dU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }
}
