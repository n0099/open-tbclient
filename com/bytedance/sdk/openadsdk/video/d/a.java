package com.bytedance.sdk.openadsdk.video.d;

import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30272a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f30273b = 4;

    public static void a(int i2) {
        f30273b = i2;
    }

    public static boolean b() {
        return f30272a;
    }

    public static void a() {
        f30272a = true;
        a(3);
    }

    public static void b(String str, Object... objArr) {
        if (f30272a && objArr != null && f30273b <= 4) {
            Log.v(str, a(objArr));
        }
    }

    public static void a(String str, Object... objArr) {
        if (f30272a && objArr != null && f30273b <= 3) {
            Log.v(str, a(objArr));
        }
    }

    public static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            sb.append(obj == null ? StringUtil.NULL_STRING : obj.toString());
            sb.append(" ");
        }
        return sb.toString();
    }
}
