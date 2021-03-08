package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> pCB;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pCB = list;
    }

    public static <T> e<T> gI(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etu */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pCB.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pCB, ((e) obj).pCB);
    }

    public String toString() {
        return com.facebook.common.internal.f.bd(this).G("list", this.pCB).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes4.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> pCC = null;
        private b<T> pCD = null;

        public a() {
            if (!etv()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> etx;
            etx = etx();
            return etx != null ? etx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eto() {
            boolean z;
            b<T> etx = etx();
            if (etx != null) {
                z = etx.eto();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apO() {
            synchronized (this) {
                if (!super.apO()) {
                    return false;
                }
                b<T> bVar = this.pCC;
                this.pCC = null;
                b<T> bVar2 = this.pCD;
                this.pCD = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean etv() {
            j<b<T>> etw = etw();
            b<T> bVar = etw != null ? etw.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C1059a(), com.facebook.common.b.a.esI());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> etw() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.pCB.size()) {
                jVar = null;
            } else {
                List list = e.this.pCB;
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
                this.pCC = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.pCC) {
                z = false;
            } else {
                this.pCC = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> etx() {
            return this.pCD;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.pCC && bVar != this.pCD) {
                    if (this.pCD == null || z) {
                        bVar2 = this.pCD;
                        this.pCD = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != etx()) {
                    l(bVar);
                }
                if (!etv()) {
                    t(bVar.etq());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == etx()) {
                c(null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apO();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1059a implements d<T> {
            private C1059a() {
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
                if (bVar.eto()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bJ(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
