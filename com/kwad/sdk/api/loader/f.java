package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes3.dex */
public class f {
    public static String a = "newversion";

    /* renamed from: b  reason: collision with root package name */
    public static String f55441b = "curversion";

    /* renamed from: c  reason: collision with root package name */
    public static String f55442c = "apiversion";

    /* renamed from: d  reason: collision with root package name */
    public static String f55443d = "_enable";

    public static String a(Context context) {
        return a(context, f55442c);
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
            for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
                try {
                    int parseInt = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
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
        a(context, f55442c, str);
    }
}
