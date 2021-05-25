package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes7.dex */
public final class cq {

    /* renamed from: a  reason: collision with root package name */
    public int f37409a;

    /* renamed from: a  reason: collision with other field name */
    public String f193a;

    public cq(String str, int i2) {
        this.f193a = str;
        this.f37409a = i2;
    }

    public static cq a(String str, int i2) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i2 = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new cq(str, i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m213a(String str, int i2) {
        cq a2 = a(str, i2);
        return new InetSocketAddress(a2.m214a(), a2.a());
    }

    public int a() {
        return this.f37409a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m214a() {
        return this.f193a;
    }

    public String toString() {
        if (this.f37409a > 0) {
            return this.f193a + ":" + this.f37409a;
        }
        return this.f193a;
    }
}
