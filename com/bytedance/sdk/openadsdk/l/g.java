package com.bytedance.sdk.openadsdk.l;

import java.util.UUID;
/* loaded from: classes5.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f29461a;

    /* renamed from: b  reason: collision with root package name */
    public String f29462b;

    /* renamed from: c  reason: collision with root package name */
    public String f29463c;

    public g(String str, int i) {
        this.f29461a = 0;
        this.f29461a = i == 0 ? 5 : i;
        this.f29462b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29463c = str;
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
        return this.f29461a;
    }

    public String h() {
        return this.f29463c;
    }

    public g(String str) {
        this.f29461a = 0;
        this.f29461a = 5;
        this.f29462b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29463c = str;
    }
}
