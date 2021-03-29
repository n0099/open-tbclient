package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f31789a = "newversion";

    /* renamed from: b  reason: collision with root package name */
    public static String f31790b = "curversion";

    /* renamed from: c  reason: collision with root package name */
    public static String f31791c = "apiversion";

    /* renamed from: d  reason: collision with root package name */
    public static String f31792d = "_enable";

    public static String a(Context context) {
        return a(context, f31791c);
    }

    public static String a(Context context, String str) {
        return q.b(context, str, "");
    }

    public static void a(Context context, String str, String str2) {
        q.a(context, str, str2);
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
        a(context, f31791c, str);
    }
}
