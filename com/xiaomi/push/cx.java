package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes18.dex */
public final class cx {

    /* renamed from: a  reason: collision with root package name */
    private int f4617a;

    /* renamed from: a  reason: collision with other field name */
    private String f187a;

    public cx(String str, int i) {
        this.f187a = str;
        this.f4617a = i;
    }

    public static cx a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
                str = substring;
            } catch (NumberFormatException e) {
                str = substring;
            }
        }
        return new cx(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m206a(String str, int i) {
        cx a2 = a(str, i);
        return new InetSocketAddress(a2.m207a(), a2.a());
    }

    public int a() {
        return this.f4617a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m207a() {
        return this.f187a;
    }

    public String toString() {
        return this.f4617a > 0 ? this.f187a + ":" + this.f4617a : this.f187a;
    }
}
