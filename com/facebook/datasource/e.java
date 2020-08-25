package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> nlQ;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nlQ = list;
    }

    public static <T> e<T> fH(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPc */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nlQ.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nlQ, ((e) obj).nlQ);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).E("list", this.nlQ).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes9.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> nlR = null;
        private b<T> nlS = null;

        public a() {
            if (!dPd()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dPf;
            dPf = dPf();
            return dPf != null ? dPf.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dOW() {
            boolean z;
            b<T> dPf = dPf();
            if (dPf != null) {
                z = dPf.dOW();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ahA() {
            synchronized (this) {
                if (!super.ahA()) {
                    return false;
                }
                b<T> bVar = this.nlR;
                this.nlR = null;
                b<T> bVar2 = this.nlS;
                this.nlS = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dPd() {
            j<b<T>> dPe = dPe();
            b<T> bVar = dPe != null ? dPe.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0862a(), com.facebook.common.b.a.dOq());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dPe() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.nlQ.size()) {
                jVar = null;
            } else {
                List list = e.this.nlQ;
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
                this.nlR = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.nlR) {
                z = false;
            } else {
                this.nlR = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dPf() {
            return this.nlS;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.nlR && bVar != this.nlS) {
                    if (this.nlS == null || z) {
                        bVar2 = this.nlS;
                        this.nlS = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dPf()) {
                    l(bVar);
                }
                if (!dPd()) {
                    x(bVar.dOY());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dPf()) {
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
                if (bVar.dOW()) {
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
