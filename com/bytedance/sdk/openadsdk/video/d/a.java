package com.bytedance.sdk.openadsdk.video.d;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30181a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f30182b = 4;

    public static void a(int i) {
        f30182b = i;
    }

    public static boolean b() {
        return f30181a;
    }

    public static void a() {
        f30181a = true;
        a(3);
    }

    public static void b(String str, Object... objArr) {
        if (f30181a && objArr != null && f30182b <= 4) {
            Log.v(str, a(objArr));
        }
    }

    public static void a(String str, Object... objArr) {
        if (f30181a && objArr != null && f30182b <= 3) {
            Log.v(str, a(objArr));
        }
    }

    public static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            sb.append(obj == null ? StringUtil.NULL_STRING : obj.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
