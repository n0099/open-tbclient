package com.bytedance.sdk.openadsdk.l;

import java.util.UUID;
/* loaded from: classes6.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f29733a;

    /* renamed from: b  reason: collision with root package name */
    public String f29734b;

    /* renamed from: c  reason: collision with root package name */
    public String f29735c;

    public g(String str, int i2) {
        this.f29733a = 0;
        this.f29733a = i2 == 0 ? 5 : i2;
        this.f29734b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29735c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        if (g() < gVar.g()) {
            return 1;
        }
        return g() > gVar.g() ? -1 : 0;
    }

    public int g() {
        return this.f29733a;
    }

    public String h() {
        return this.f29735c;
    }

    public g(String str) {
        this.f29733a = 0;
        this.f29733a = 5;
        this.f29734b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29735c = str;
    }
}
