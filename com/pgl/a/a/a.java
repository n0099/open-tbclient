package com.pgl.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f7469a = 255;

    public static String a() {
        switch (f7469a) {
            case 0:
                return "https://bds.snssdk.com";
            default:
                return "";
        }
    }

    public static synchronized void a(int i) {
        synchronized (a.class) {
            f7469a = i;
        }
    }

    public static String b() {
        switch (f7469a) {
            case 0:
                return "https://sdfp.snssdk.com";
            default:
                return "";
        }
    }
}
