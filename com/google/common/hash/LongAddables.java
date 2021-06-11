package com.google.common.hash;

import d.g.c.a.r;
import d.g.c.d.i;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    public static final r<i> f31436a;

    /* loaded from: classes6.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements i {
        public PureJavaLongAddable() {
        }

        @Override // d.g.c.d.i
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // d.g.c.d.i
        public void increment() {
            getAndIncrement();
        }

        @Override // d.g.c.d.i
        public long sum() {
            return get();
        }

        public /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements r<i> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        /* renamed from: a */
        public i get() {
            return new LongAdder();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r<i> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        /* renamed from: a */
        public i get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        r<i> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f31436a = bVar;
    }

    public static i a() {
        return f31436a.get();
    }
}
