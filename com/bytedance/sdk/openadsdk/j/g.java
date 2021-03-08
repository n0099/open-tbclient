package com.bytedance.sdk.openadsdk.j;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* loaded from: classes6.dex */
public abstract class g implements Comparable<g>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f4870a;
    private String b;

    public g(int i) {
        this.f4870a = 0;
        this.f4870a = i == 0 ? 5 : i;
        this.b = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());
    }

    public g() {
        this.f4870a = 0;
        this.f4870a = 5;
        this.b = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());
    }

    public int c() {
        return this.f4870a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        if (c() < gVar.c()) {
            return 1;
        }
        if (c() > gVar.c()) {
            return -1;
        }
        return 0;
    }
}
