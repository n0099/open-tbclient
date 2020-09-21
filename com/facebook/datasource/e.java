package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes17.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> nwi;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nwi = list;
    }

    public static <T> e<T> fQ(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dTj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nwi.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nwi, ((e) obj).nwi);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).E("list", this.nwi).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes17.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> nwj = null;
        private b<T> nwk = null;

        public a() {
            if (!dTk()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dTm;
            dTm = dTm();
            return dTm != null ? dTm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dTd() {
            boolean z;
            b<T> dTm = dTm();
            if (dTm != null) {
                z = dTm.dTd();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aik() {
            synchronized (this) {
                if (!super.aik()) {
                    return false;
                }
                b<T> bVar = this.nwj;
                this.nwj = null;
                b<T> bVar2 = this.nwk;
                this.nwk = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dTk() {
            j<b<T>> dTl = dTl();
            b<T> bVar = dTl != null ? dTl.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0859a(), com.facebook.common.b.a.dSx());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dTl() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.nwi.size()) {
                jVar = null;
            } else {
                List list = e.this.nwi;
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
                this.nwj = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.nwj) {
                z = false;
            } else {
                this.nwj = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dTm() {
            return this.nwk;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.nwj && bVar != this.nwk) {
                    if (this.nwk == null || z) {
                        bVar2 = this.nwk;
                        this.nwk = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dTm()) {
                    l(bVar);
                }
                if (!dTk()) {
                    x(bVar.dTf());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dTm()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aik();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public class C0859a implements d<T> {
            private C0859a() {
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
                if (bVar.dTd()) {
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
