package com.xiaomi.push;

import java.net.InetSocketAddress;
/* loaded from: classes6.dex */
public final class cs {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f203a;

    public cs(String str, int i) {
        this.f203a = str;
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
        return this.f203a;
    }

    public String toString() {
        return this.a > 0 ? this.f203a + ":" + this.a : this.f203a;
    }
}
