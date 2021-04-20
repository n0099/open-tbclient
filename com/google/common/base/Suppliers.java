package com.google.common.base;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.g;
import d.g.c.a.k;
import d.g.c.a.m;
import d.g.c.a.n;
import d.g.c.a.r;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class Suppliers {

    /* loaded from: classes6.dex */
    public static class ExpiringMemoizingSupplier<T> implements r<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final r<T> delegate;
        public final long durationNanos;
        public volatile transient long expirationNanos;
        public volatile transient T value;

        public ExpiringMemoizingSupplier(r<T> rVar, long j, TimeUnit timeUnit) {
            n.p(rVar);
            this.delegate = rVar;
            this.durationNanos = timeUnit.toNanos(j);
            n.j(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // d.g.c.a.r
        public T get() {
            long j = this.expirationNanos;
            long f2 = m.f();
            if (j == 0 || f2 - j >= 0) {
                synchronized (this) {
                    if (j == this.expirationNanos) {
                        T t = this.delegate.get();
                        this.value = t;
                        long j2 = f2 + this.durationNanos;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.expirationNanos = j2;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.durationNanos + ", NANOS)";
        }
    }

    /* loaded from: classes6.dex */
    public static class MemoizingSupplier<T> implements r<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final r<T> delegate;
        public volatile transient boolean initialized;
        public transient T value;

        public MemoizingSupplier(r<T> rVar) {
            n.p(rVar);
            this.delegate = rVar;
        }

        @Override // d.g.c.a.r
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb.append(obj);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class SupplierComposition<F, T> implements r<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final g<? super F, T> function;
        public final r<F> supplier;

        public SupplierComposition(g<? super F, T> gVar, r<F> rVar) {
            n.p(gVar);
            this.function = gVar;
            n.p(rVar);
            this.supplier = rVar;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierComposition) {
                SupplierComposition supplierComposition = (SupplierComposition) obj;
                return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
            }
            return false;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: F, ? super F */
        @Override // d.g.c.a.r
        public T get() {
            return this.function.apply((F) this.supplier.get());
        }

        public int hashCode() {
            return k.b(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.supplier + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public enum SupplierFunctionImpl implements Object<Object> {
        INSTANCE;

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        public Object apply(r<Object> rVar) {
            return rVar.get();
        }
    }

    /* loaded from: classes6.dex */
    public static class SupplierOfInstance<T> implements r<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final T instance;

        public SupplierOfInstance(T t) {
            this.instance = t;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return k.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // d.g.c.a.r
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return k.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThreadSafeSupplier<T> implements r<T>, Serializable {
        public static final long serialVersionUID = 0;
        public final r<T> delegate;

        public ThreadSafeSupplier(r<T> rVar) {
            n.p(rVar);
            this.delegate = rVar;
        }

        @Override // d.g.c.a.r
        public T get() {
            T t;
            synchronized (this.delegate) {
                t = this.delegate.get();
            }
            return t;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    public static <T> r<T> a(T t) {
        return new SupplierOfInstance(t);
    }
}
