package com.bytedance.sdk.openadsdk.l;

import java.util.UUID;
/* loaded from: classes5.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f29469a;

    /* renamed from: b  reason: collision with root package name */
    public String f29470b;

    /* renamed from: c  reason: collision with root package name */
    public String f29471c;

    public g(String str, int i) {
        this.f29469a = 0;
        this.f29469a = i == 0 ? 5 : i;
        this.f29470b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29471c = str;
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
        return this.f29469a;
    }

    public String h() {
        return this.f29471c;
    }

    public g(String str) {
        this.f29469a = 0;
        this.f29469a = 5;
        this.f29470b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
        this.f29471c = str;
    }
}
