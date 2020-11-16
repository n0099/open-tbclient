package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes18.dex */
public final class cx {

    /* renamed from: a  reason: collision with root package name */
    private int f4847a;

    /* renamed from: a  reason: collision with other field name */
    private String f189a;

    public cx(String str, int i) {
        this.f189a = str;
        this.f4847a = i;
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
    public static InetSocketAddress m216a(String str, int i) {
        cx a2 = a(str, i);
        return new InetSocketAddress(a2.m217a(), a2.a());
    }

    public int a() {
        return this.f4847a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m217a() {
        return this.f189a;
    }

    public String toString() {
        return this.f4847a > 0 ? this.f189a + ":" + this.f4847a : this.f189a;
    }
}
