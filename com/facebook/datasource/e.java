package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes19.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> pcZ;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pcZ = list;
    }

    public static <T> e<T> gN(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: equ */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pcZ.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pcZ, ((e) obj).pcZ);
    }

    public String toString() {
        return com.facebook.common.internal.f.ba(this).E("list", this.pcZ).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes19.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> pda = null;
        private b<T> pdb = null;

        public a() {
            if (!eqv()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eqx;
            eqx = eqx();
            return eqx != null ? eqx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eqo() {
            boolean z;
            b<T> eqx = eqx();
            if (eqx != null) {
                z = eqx.eqo();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean arP() {
            synchronized (this) {
                if (!super.arP()) {
                    return false;
                }
                b<T> bVar = this.pda;
                this.pda = null;
                b<T> bVar2 = this.pdb;
                this.pdb = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean eqv() {
            j<b<T>> eqw = eqw();
            b<T> bVar = eqw != null ? eqw.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0988a(), com.facebook.common.b.a.epI());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> eqw() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.pcZ.size()) {
                jVar = null;
            } else {
                List list = e.this.pcZ;
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
                this.pda = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.pda) {
                z = false;
            } else {
                this.pda = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> eqx() {
            return this.pdb;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.pda && bVar != this.pdb) {
                    if (this.pdb == null || z) {
                        bVar2 = this.pdb;
                        this.pdb = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != eqx()) {
                    l(bVar);
                }
                if (!eqv()) {
                    x(bVar.eqq());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == eqx()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.arP();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public class C0988a implements d<T> {
            private C0988a() {
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
                if (bVar.eqo()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bq(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
