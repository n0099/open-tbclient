package com.bytedance.sdk.openadsdk.l;

import java.util.UUID;
/* loaded from: classes5.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f30374a;

    /* renamed from: b  reason: collision with root package name */
    public String f30375b;

    /* renamed from: c  reason: collision with root package name */
    public String f30376c;

    public g(String str, int i2) {
        this.f30374a = 0;
        this.f30374a = i2 == 0 ? 5 : i2;
        this.f30375b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f30376c = str;
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
        return this.f30374a;
    }

    public String h() {
        return this.f30376c;
    }

    public g(String str) {
        this.f30374a = 0;
        this.f30374a = 5;
        this.f30375b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f30376c = str;
    }
}
