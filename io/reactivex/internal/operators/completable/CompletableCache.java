package io.reactivex.internal.operators.completable;

import f.a.a;
import f.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class CompletableCache extends a implements b {

    /* loaded from: classes7.dex */
    public final class InnerCompletableCache extends AtomicBoolean implements f.a.t.b {
        public static final long serialVersionUID = 8943152917179642732L;
        public final b actual;

        public InnerCompletableCache(b bVar) {
            this.actual = bVar;
        }

        @Override // f.a.t.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.d(this);
                throw null;
            }
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return get();
        }
    }

    public void d(InnerCompletableCache innerCompletableCache) {
        throw null;
    }
}
