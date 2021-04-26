package com.google.common.cache;

import d.g.c.a.r;
import d.g.c.b.g;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    public static final r<g> f31698a;

    /* loaded from: classes6.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements g {
        public PureJavaLongAddable() {
        }

        @Override // d.g.c.b.g
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // d.g.c.b.g
        public void increment() {
            getAndIncrement();
        }

        @Override // d.g.c.b.g
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements r<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        /* renamed from: a */
        public g get() {
            return new LongAdder();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        /* renamed from: a */
        public g get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        r<g> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f31698a = bVar;
    }

    public static g a() {
        return f31698a.get();
    }
}
