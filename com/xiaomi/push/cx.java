package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes5.dex */
public final class cx {

    /* renamed from: a  reason: collision with root package name */
    private int f8310a;

    /* renamed from: a  reason: collision with other field name */
    private String f186a;

    public cx(String str, int i) {
        this.f186a = str;
        this.f8310a = i;
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
    public static InetSocketAddress m217a(String str, int i) {
        cx a2 = a(str, i);
        return new InetSocketAddress(a2.m218a(), a2.a());
    }

    public int a() {
        return this.f8310a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m218a() {
        return this.f186a;
    }

    public String toString() {
        return this.f8310a > 0 ? this.f186a + ":" + this.f8310a : this.f186a;
    }
}
