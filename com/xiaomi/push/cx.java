package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes8.dex */
public final class cx {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f192a;

    public cx(String str, int i) {
        this.f192a = str;
        this.a = i;
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
    public static InetSocketAddress m207a(String str, int i) {
        cx a = a(str, i);
        return new InetSocketAddress(a.m208a(), a.a());
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m208a() {
        return this.f192a;
    }

    public String toString() {
        return this.a > 0 ? this.f192a + ":" + this.a : this.f192a;
    }
}
