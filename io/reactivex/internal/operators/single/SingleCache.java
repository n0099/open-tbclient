package io.reactivex.internal.operators.single;

import f.b.q;
import f.b.r;
import f.b.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class SingleCache<T> extends q<T> implements r<T> {

    /* loaded from: classes7.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements b {
        public static final long serialVersionUID = 7514387411091976596L;
        public final r<? super T> actual;
        public final SingleCache<T> parent;

        public CacheDisposable(r<? super T> rVar, SingleCache<T> singleCache) {
            this.actual = rVar;
            this.parent = singleCache;
        }

        @Override // f.b.t.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.c(this);
            }
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return get();
        }
    }

    public abstract void c(CacheDisposable<T> cacheDisposable);
}
