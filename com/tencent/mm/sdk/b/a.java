package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
/* loaded from: classes6.dex */
public final class a {
    public static int level = 6;
    public static InterfaceC0531a n;
    public static InterfaceC0531a o;
    public static final String p;

    /* renamed from: com.tencent.mm.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0531a {
        int b();

        void d(String str, String str2);

        void e(String str, String str2);

        void f(String str, String str2);
    }

    static {
        b bVar = new b();
        n = bVar;
        o = bVar;
        StringBuilder sb = new StringBuilder();
        sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb.append("] BOARD:[" + Build.BOARD);
        sb.append("] DEVICE:[" + Build.DEVICE);
        sb.append("] DISPLAY:[" + Build.DISPLAY);
        sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb.append("] HOST:[" + Build.HOST);
        sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb.append("] MODEL:[" + Build.MODEL);
        sb.append("] PRODUCT:[" + Build.PRODUCT);
        sb.append("] TAGS:[" + Build.TAGS);
        sb.append("] TYPE:[" + Build.TYPE);
        sb.append("] USER:[" + Build.USER + "]");
        p = sb.toString();
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Object... objArr) {
        InterfaceC0531a interfaceC0531a = o;
        if (interfaceC0531a == null || interfaceC0531a.b() > 4) {
            return;
        }
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        InterfaceC0531a interfaceC0531a2 = o;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        interfaceC0531a2.f(str, str2);
    }

    public static void b(String str, String str2) {
        InterfaceC0531a interfaceC0531a = o;
        if (interfaceC0531a == null || interfaceC0531a.b() > 2) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        InterfaceC0531a interfaceC0531a2 = o;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        interfaceC0531a2.d(str, str2);
    }

    public static void c(String str, String str2) {
        InterfaceC0531a interfaceC0531a = o;
        if (interfaceC0531a == null || interfaceC0531a.b() > 1) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        InterfaceC0531a interfaceC0531a2 = o;
        Process.myPid();
        Thread.currentThread().getId();
        Looper.getMainLooper().getThread().getId();
        interfaceC0531a2.e(str, str2);
    }
}
