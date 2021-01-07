package com.bytedance.sdk.openadsdk.k;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;
/* loaded from: classes4.dex */
public abstract class c implements Comparable<c>, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f7623a;

    /* renamed from: b  reason: collision with root package name */
    private String f7624b;

    public c(int i) {
        this.f7623a = -1;
        this.f7623a = i == -1 ? 5 : i;
        this.f7624b = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());
    }

    public c() {
        this.f7623a = -1;
        this.f7623a = 5;
        this.f7624b = UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.nanoTime());
    }

    public int a() {
        return this.f7623a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        if (a() < cVar.a()) {
            return 1;
        }
        if (a() > cVar.a()) {
            return -1;
        }
        return 0;
    }
}
