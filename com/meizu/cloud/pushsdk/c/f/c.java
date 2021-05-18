package com.meizu.cloud.pushsdk.c.f;

import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f34982a;

    public static String a() {
        return Thread.currentThread().getName();
    }

    public static String a(String str) {
        return "PushTracker->" + str;
    }

    public static String a(String str, Object... objArr) {
        return a() + FieldBuilder.SE + String.format(str, objArr);
    }

    public static void a(b bVar) {
        f34982a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f34982a >= 1) {
            d.j.a.a.a.b(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f34982a >= 2) {
            d.j.a.a.a.a(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (f34982a >= 3) {
            d.j.a.a.a.d(a(str), a(str2, objArr));
        }
    }
}
