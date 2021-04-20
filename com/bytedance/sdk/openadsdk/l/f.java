package com.bytedance.sdk.openadsdk.l;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes5.dex */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {

    /* renamed from: a  reason: collision with root package name */
    public int f29459a;

    /* renamed from: b  reason: collision with root package name */
    public int f29460b;

    public f(Callable<V> callable, int i, int i2) {
        super(callable);
        this.f29459a = i == -1 ? 5 : i;
        this.f29460b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (a() < fVar.a()) {
            return 1;
        }
        return a() > fVar.a() ? -1 : 0;
    }

    public int a() {
        return this.f29459a;
    }

    public f(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.f29459a = i == -1 ? 5 : i;
        this.f29460b = i2;
    }
}
