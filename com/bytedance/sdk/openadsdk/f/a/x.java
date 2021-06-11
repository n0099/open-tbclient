package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29244a;

    public static String a() {
        return "";
    }

    public static String a(@Nullable Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":");
        sb.append(th instanceof r ? ((r) th).f29212a : 0);
        sb.append("}");
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = f29244a ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!substring.isEmpty()) {
            return str2 + "," + substring + "}";
        }
        return str2 + "}";
    }

    public static void a(boolean z) {
        f29244a = z;
    }
}
