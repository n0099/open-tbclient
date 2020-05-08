package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lSM;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lSM = list;
    }

    public static <T> e<T> eT(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dnB */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lSM.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lSM, ((e) obj).lSM);
    }

    public String toString() {
        return com.facebook.common.internal.f.aJ(this).C("list", this.lSM).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lSN = null;
        private b<T> lSO = null;

        public a() {
            if (!dnC()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dnE;
            dnE = dnE();
            return dnE != null ? dnE.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dnv() {
            boolean z;
            b<T> dnE = dnE();
            if (dnE != null) {
                z = dnE.dnv();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Wu() {
            synchronized (this) {
                if (!super.Wu()) {
                    return false;
                }
                b<T> bVar = this.lSN;
                this.lSN = null;
                b<T> bVar2 = this.lSO;
                this.lSO = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dnC() {
            j<b<T>> dnD = dnD();
            b<T> bVar = dnD != null ? dnD.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0719a(), com.facebook.common.b.a.dmO());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dnD() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lSM.size()) {
                jVar = null;
            } else {
                List list = e.this.lSM;
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
                this.lSN = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lSN) {
                z = false;
            } else {
                this.lSN = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dnE() {
            return this.lSO;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lSN && bVar != this.lSO) {
                    if (this.lSO == null || z) {
                        bVar2 = this.lSO;
                        this.lSO = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dnE()) {
                    l(bVar);
                }
                if (!dnC()) {
                    z(bVar.dnx());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dnE()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Wu();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0719a implements d<T> {
            private C0719a() {
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
                if (bVar.dnv()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.az(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
