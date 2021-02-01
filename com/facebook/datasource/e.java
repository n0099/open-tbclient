package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> pzW;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pzW = list;
    }

    public static <T> e<T> gI(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etd */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pzW.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pzW, ((e) obj).pzW);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).H("list", this.pzW).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> pzX = null;
        private b<T> pzY = null;

        public a() {
            if (!ete()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> etg;
            etg = etg();
            return etg != null ? etg.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean esX() {
            boolean z;
            b<T> etg = etg();
            if (etg != null) {
                z = etg.esX();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apL() {
            synchronized (this) {
                if (!super.apL()) {
                    return false;
                }
                b<T> bVar = this.pzX;
                this.pzX = null;
                b<T> bVar2 = this.pzY;
                this.pzY = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean ete() {
            j<b<T>> etf = etf();
            b<T> bVar = etf != null ? etf.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C1042a(), com.facebook.common.b.a.esr());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> etf() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.pzW.size()) {
                jVar = null;
            } else {
                List list = e.this.pzW;
                int i = this.mIndex;
                this.mIndex = i + 1;
                jVar = (j) list.get(i);
            }
            return jVar;
        }

        private synchronized boolean h(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.pzX = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.pzX) {
                z = false;
            } else {
                this.pzX = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> etg() {
            return this.pzY;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.pzX && bVar != this.pzY) {
                    if (this.pzY == null || z) {
                        bVar2 = this.pzY;
                        this.pzY = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != etg()) {
                    l(bVar);
                }
                if (!ete()) {
                    t(bVar.esZ());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == etg()) {
                c(null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apL();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1042a implements d<T> {
            private C1042a() {
            }

            @Override // com.facebook.datasource.d
            public void e(b<T> bVar) {
                a.this.j(bVar);
            }

            @Override // com.facebook.datasource.d
            public void b(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.esX()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bF(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
