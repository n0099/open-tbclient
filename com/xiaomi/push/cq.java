package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes7.dex */
public final class cq {

    /* renamed from: a  reason: collision with root package name */
    public int f40334a;

    /* renamed from: a  reason: collision with other field name */
    public String f193a;

    public cq(String str, int i) {
        this.f193a = str;
        this.f40334a = i;
    }

    public static cq a(String str, int i) {
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
        return new cq(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m207a(String str, int i) {
        cq a2 = a(str, i);
        return new InetSocketAddress(a2.m208a(), a2.a());
    }

    public int a() {
        return this.f40334a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m208a() {
        return this.f193a;
    }

    public String toString() {
        if (this.f40334a > 0) {
            return this.f193a + ":" + this.f40334a;
        }
        return this.f193a;
    }
}
