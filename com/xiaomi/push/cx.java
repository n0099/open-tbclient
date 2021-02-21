package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes6.dex */
public final class cx {

    /* renamed from: a  reason: collision with root package name */
    private int f13928a;

    /* renamed from: a  reason: collision with other field name */
    private String f265a;

    public cx(String str, int i) {
        this.f265a = str;
        this.f13928a = i;
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
    public static InetSocketAddress m238a(String str, int i) {
        cx a2 = a(str, i);
        return new InetSocketAddress(a2.m239a(), a2.a());
    }

    public int a() {
        return this.f13928a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m239a() {
        return this.f265a;
    }

    public String toString() {
        return this.f13928a > 0 ? this.f265a + ":" + this.f13928a : this.f265a;
    }
}
