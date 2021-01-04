package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
class x {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(@Nullable Throwable th) {
        return "{\"code\":" + (th instanceof r ? ((r) th).f7435a : 0) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String str2 = "";
        if (f7452a) {
            str2 = str.substring(1, str.length() - 1);
        }
        String str3 = "{\"code\":1,\"__data\":" + str;
        if (!str2.isEmpty()) {
            return str3 + "," + str2 + "}";
        }
        return str3 + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        f7452a = z;
    }
}
