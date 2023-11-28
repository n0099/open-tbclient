package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes10.dex */
public final class bg {
    public static final SimpleDateFormat aOw = new SimpleDateFormat("MM/dd", Locale.US);
    public static final SimpleDateFormat aOx = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    public static final SimpleDateFormat aOy = new SimpleDateFormat("MM月dd日", Locale.US);
    public static final SimpleDateFormat aOz = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    public static final SimpleDateFormat aOA = new SimpleDateFormat("HH:mm", Locale.US);
    public static final SimpleDateFormat aOB = new SimpleDateFormat("MM-dd", Locale.US);
    public static final SimpleDateFormat aOC = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean gh(String str) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public static boolean gi(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches(".*\\.kpg.*");
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }
}
