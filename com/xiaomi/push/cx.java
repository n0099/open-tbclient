package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes6.dex */
public final class cx {

    /* renamed from: a  reason: collision with root package name */
    private int f14226a;

    /* renamed from: a  reason: collision with other field name */
    private String f266a;

    public cx(String str, int i) {
        this.f266a = str;
        this.f14226a = i;
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
    public static InetSocketAddress m243a(String str, int i) {
        cx a2 = a(str, i);
        return new InetSocketAddress(a2.m244a(), a2.a());
    }

    public int a() {
        return this.f14226a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m244a() {
        return this.f266a;
    }

    public String toString() {
        return this.f14226a > 0 ? this.f266a + ":" + this.f14226a : this.f266a;
    }
}
