package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> pAw;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pAw = list;
    }

    public static <T> e<T> gI(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pAw.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pAw, ((e) obj).pAw);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).H("list", this.pAw).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> pAx = null;
        private b<T> pAy = null;

        public a() {
            if (!etm()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eto;
            eto = eto();
            return eto != null ? eto.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean etf() {
            boolean z;
            b<T> eto = eto();
            if (eto != null) {
                z = eto.etf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apL() {
            synchronized (this) {
                if (!super.apL()) {
                    return false;
                }
                b<T> bVar = this.pAx;
                this.pAx = null;
                b<T> bVar2 = this.pAy;
                this.pAy = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean etm() {
            j<b<T>> etn = etn();
            b<T> bVar = etn != null ? etn.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C1044a(), com.facebook.common.b.a.esz());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> etn() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.pAw.size()) {
                jVar = null;
            } else {
                List list = e.this.pAw;
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
                this.pAx = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.pAx) {
                z = false;
            } else {
                this.pAx = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> eto() {
            return this.pAy;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.pAx && bVar != this.pAy) {
                    if (this.pAy == null || z) {
                        bVar2 = this.pAy;
                        this.pAy = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != eto()) {
                    l(bVar);
                }
                if (!etm()) {
                    t(bVar.eth());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == eto()) {
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
        public class C1044a implements d<T> {
            private C1044a() {
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
                if (bVar.etf()) {
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
