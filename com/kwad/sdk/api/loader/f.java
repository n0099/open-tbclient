package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes5.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    static String f8499a = "newversion";

    /* renamed from: b  reason: collision with root package name */
    static String f8500b = "curversion";
    static String c = "apiversion";
    static String d = "_enable";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        return a(context, c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        return q.b(context, str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2) {
        q.a(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length && i < split2.length; i++) {
                try {
                    int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                    if (parseInt > 0) {
                        return true;
                    }
                    if (parseInt < 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return split.length > split2.length;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        a(context, c, str);
    }
}
