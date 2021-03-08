package com.bytedance.sdk.openadsdk.j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f4869a;
    private int b;

    public f(Callable<V> callable, int i, int i2) {
        super(callable);
        this.f4869a = i == -1 ? 5 : i;
        this.b = i2;
    }

    public f(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.f4869a = i == -1 ? 5 : i;
        this.b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        if (a() < fVar.a()) {
            return 1;
        }
        if (a() > fVar.a()) {
            return -1;
        }
        return 0;
    }

    public int a() {
        return this.f4869a;
    }
}
