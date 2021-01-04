package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> puh;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.puh = list;
    }

    public static <T> e<T> gK(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eux */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.puh.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.puh, ((e) obj).puh);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("list", this.puh).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> pui = null;
        private b<T> puj = null;

        public a() {
            if (!euy()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> euA;
            euA = euA();
            return euA != null ? euA.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eur() {
            boolean z;
            b<T> euA = euA();
            if (euA != null) {
                z = euA.eur();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ath() {
            synchronized (this) {
                if (!super.ath()) {
                    return false;
                }
                b<T> bVar = this.pui;
                this.pui = null;
                b<T> bVar2 = this.puj;
                this.puj = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean euy() {
            j<b<T>> euz = euz();
            b<T> bVar = euz != null ? euz.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C1017a(), com.facebook.common.b.a.etO());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> euz() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.puh.size()) {
                jVar = null;
            } else {
                List list = e.this.puh;
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
                this.pui = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.pui) {
                z = false;
            } else {
                this.pui = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> euA() {
            return this.puj;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.pui && bVar != this.puj) {
                    if (this.puj == null || z) {
                        bVar2 = this.puj;
                        this.puj = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != euA()) {
                    l(bVar);
                }
                if (!euy()) {
                    u(bVar.eut());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == euA()) {
                c(null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ath();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1017a implements d<T> {
            private C1017a() {
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
                if (bVar.eur()) {
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
