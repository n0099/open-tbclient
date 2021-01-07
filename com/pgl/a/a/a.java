package com.pgl.a.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f11681a = 255;

    public static String a() {
        switch (f11681a) {
            case 0:
                return "https://bds.snssdk.com";
            default:
                return "";
        }
    }

    public static synchronized void a(int i) {
        synchronized (a.class) {
            f11681a = i;
        }
    }

    public static String b() {
        switch (f11681a) {
            case 0:
                return "https://sdfp.snssdk.com";
            default:
                return "";
        }
    }
}
