package com.bytedance.sdk.openadsdk.l;

import java.util.UUID;
/* loaded from: classes6.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f29619a;

    /* renamed from: b  reason: collision with root package name */
    public String f29620b;

    /* renamed from: c  reason: collision with root package name */
    public String f29621c;

    public g(String str, int i2) {
        this.f29619a = 0;
        this.f29619a = i2 == 0 ? 5 : i2;
        this.f29620b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29621c = str;
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
        return this.f29619a;
    }

    public String h() {
        return this.f29621c;
    }

    public g(String str) {
        this.f29619a = 0;
        this.f29619a = 5;
        this.f29620b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29621c = str;
    }
}
