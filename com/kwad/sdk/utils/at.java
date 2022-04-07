package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes5.dex */
public class at {
    public static final SimpleDateFormat a = new SimpleDateFormat("MM/dd", Locale.US);
    public static final SimpleDateFormat b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    public static final SimpleDateFormat c = new SimpleDateFormat("MM月dd日", Locale.US);
    public static final SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    public static final SimpleDateFormat e = new SimpleDateFormat("HH:mm", Locale.US);
    public static final SimpleDateFormat f = new SimpleDateFormat("MM-dd", Locale.US);
    public static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    @Deprecated
    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str);
    }

    public static boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }
}
