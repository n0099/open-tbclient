package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes6.dex */
public final class cs {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f204a;

    public cs(String str, int i) {
        this.f204a = str;
        this.a = i;
    }

    public static cs a(String str, int i) {
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
        return new cs(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m199a(String str, int i) {
        cs a = a(str, i);
        return new InetSocketAddress(a.m200a(), a.a());
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m200a() {
        return this.f204a;
    }

    public String toString() {
        return this.a > 0 ? this.f204a + ":" + this.a : this.f204a;
    }
}
