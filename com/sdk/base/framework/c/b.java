package com.sdk.base.framework.c;
/* loaded from: classes5.dex */
public final class b {
    private int c;
    private long a = System.currentTimeMillis();
    private c b = new c();
    private String d = "";

    public final String a() {
        return this.d;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final int b() {
        return this.c;
    }

    public final c c() {
        return this.b;
    }

    public final String toString() {
        return "MobileLog{time=" + this.a + ", status=" + this.b + '}';
    }
}
