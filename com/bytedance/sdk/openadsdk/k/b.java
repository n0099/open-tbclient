package com.bytedance.sdk.openadsdk.k;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes4.dex */
public class b<V> extends FutureTask<V> implements Comparable<b<V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f7321a;

    /* renamed from: b  reason: collision with root package name */
    private int f7322b;

    public b(Callable<V> callable, int i, int i2) {
        super(callable);
        this.f7321a = i == -1 ? 5 : i;
        this.f7322b = i2;
    }

    public b(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.f7321a = i == -1 ? 5 : i;
        this.f7322b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (a() < bVar.a()) {
            return 1;
        }
        if (a() > bVar.a()) {
            return -1;
        }
        return 0;
    }

    public int a() {
        return this.f7321a;
    }
}
