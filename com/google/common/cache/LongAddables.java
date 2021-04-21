package com.google.common.cache;

import d.h.c.a.r;
import d.h.c.b.g;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    public static final r<g> f30751a;

    /* loaded from: classes6.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements g {
        public PureJavaLongAddable() {
        }

        @Override // d.h.c.b.g
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // d.h.c.b.g
        public void increment() {
            getAndIncrement();
        }

        @Override // d.h.c.b.g
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
        @Override // d.h.c.a.r
        /* renamed from: a */
        public g get() {
            return new LongAdder();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.a.r
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
        f30751a = bVar;
    }

    public static g a() {
        return f30751a.get();
    }
}
