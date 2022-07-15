package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes5.dex */
public final class g {
    public static String a = "newversion";
    public static String b = "curversion";
    public static String c = "apiversion";
    public static String d = "autoRevert";
    public static String e = "_enable";

    public static String a(Context context) {
        return r.b(context, c, "");
    }

    public static String a(Context context, String str) {
        return r.b(context, str, "");
    }

    public static void a(Context context, String str, String str2) {
        r.a(context, str, str2);
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            for (int i = 0; i < split.length && i < split2.length; i++) {
                try {
                    int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            return split.length > split2.length;
        }
        return true;
    }

    public static void b(Context context, String str) {
        r.a(context, c, str);
    }
}
