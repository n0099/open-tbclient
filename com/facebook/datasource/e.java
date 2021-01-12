package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes14.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> ppM;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ppM = list;
    }

    public static <T> e<T> gK(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eqK */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ppM.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ppM, ((e) obj).ppM);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("list", this.ppM).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes14.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> ppN = null;
        private b<T> ppO = null;

        public a() {
            if (!eqL()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eqN;
            eqN = eqN();
            return eqN != null ? eqN.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eqE() {
            boolean z;
            b<T> eqN = eqN();
            if (eqN != null) {
                z = eqN.eqE();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apn() {
            synchronized (this) {
                if (!super.apn()) {
                    return false;
                }
                b<T> bVar = this.ppN;
                this.ppN = null;
                b<T> bVar2 = this.ppO;
                this.ppO = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean eqL() {
            j<b<T>> eqM = eqM();
            b<T> bVar = eqM != null ? eqM.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C1038a(), com.facebook.common.b.a.epY());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> eqM() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.ppM.size()) {
                jVar = null;
            } else {
                List list = e.this.ppM;
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
                this.ppN = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.ppN) {
                z = false;
            } else {
                this.ppN = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> eqN() {
            return this.ppO;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.ppN && bVar != this.ppO) {
                    if (this.ppO == null || z) {
                        bVar2 = this.ppO;
                        this.ppO = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != eqN()) {
                    l(bVar);
                }
                if (!eqL()) {
                    u(bVar.eqG());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == eqN()) {
                c(null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apn();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public class C1038a implements d<T> {
            private C1038a() {
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
                if (bVar.eqE()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bC(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
