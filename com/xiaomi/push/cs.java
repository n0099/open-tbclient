package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes9.dex */
public final class cs {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f188a;

    public cs(String str, int i) {
        this.f188a = str;
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
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new cs(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m263a(String str, int i) {
        cs a = a(str, i);
        return new InetSocketAddress(a.m264a(), a.a());
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m264a() {
        return this.f188a;
    }

    public String toString() {
        if (this.a > 0) {
            return this.f188a + ":" + this.a;
        }
        return this.f188a;
    }
}
