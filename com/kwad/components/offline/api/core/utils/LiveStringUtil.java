package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes10.dex */
public class LiveStringUtil {
    @NonNull
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isEquals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNullString(String str) {
        if (!TextUtils.isEmpty(str) && !StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
