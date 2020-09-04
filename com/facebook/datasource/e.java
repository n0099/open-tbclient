package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> nmi;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nmi = list;
    }

    public static <T> e<T> fH(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nmi.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nmi, ((e) obj).nmi);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).E("list", this.nmi).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes9.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> nmj = null;
        private b<T> nmk = null;

        public a() {
            if (!dPm()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dPo;
            dPo = dPo();
            return dPo != null ? dPo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dPf() {
            boolean z;
            b<T> dPo = dPo();
            if (dPo != null) {
                z = dPo.dPf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ahA() {
            synchronized (this) {
                if (!super.ahA()) {
                    return false;
                }
                b<T> bVar = this.nmj;
                this.nmj = null;
                b<T> bVar2 = this.nmk;
                this.nmk = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dPm() {
            j<b<T>> dPn = dPn();
            b<T> bVar = dPn != null ? dPn.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0862a(), com.facebook.common.b.a.dOz());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dPn() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.nmi.size()) {
                jVar = null;
            } else {
                List list = e.this.nmi;
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
                this.nmj = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.nmj) {
                z = false;
            } else {
                this.nmj = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dPo() {
            return this.nmk;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.nmj && bVar != this.nmk) {
                    if (this.nmk == null || z) {
                        bVar2 = this.nmk;
                        this.nmk = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dPo()) {
                    l(bVar);
                }
                if (!dPm()) {
                    x(bVar.dPh());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dPo()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ahA();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0862a implements d<T> {
            private C0862a() {
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
                if (bVar.dPf()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aJ(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
