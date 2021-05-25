package com.bytedance.sdk.openadsdk.l;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class f<V> extends FutureTask<V> implements Comparable<f<V>> {

    /* renamed from: a  reason: collision with root package name */
    public int f29546a;

    /* renamed from: b  reason: collision with root package name */
    public int f29547b;

    public f(Callable<V> callable, int i2, int i3) {
        super(callable);
        this.f29546a = i2 == -1 ? 5 : i2;
        this.f29547b = i3;
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
        return this.f29546a;
    }

    public f(Runnable runnable, V v, int i2, int i3) {
        super(runnable, v);
        this.f29546a = i2 == -1 ? 5 : i2;
        this.f29547b = i3;
    }
}
