package com.google.common.hash;

import d.h.c.a.r;
import d.h.c.d.i;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    public static final r<i> f31193a;

    /* loaded from: classes6.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements i {
        public PureJavaLongAddable() {
        }

        @Override // d.h.c.d.i
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // d.h.c.d.i
        public void increment() {
            getAndIncrement();
        }

        @Override // d.h.c.d.i
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
        @Override // d.h.c.a.r
        /* renamed from: a */
        public i get() {
            return new LongAdder();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r<i> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.a.r
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
        f31193a = bVar;
    }

    public static i a() {
        return f31193a.get();
    }
}
