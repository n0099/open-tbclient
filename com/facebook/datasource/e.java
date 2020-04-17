package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lSI;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lSI = list;
    }

    public static <T> e<T> eT(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dnE */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lSI.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lSI, ((e) obj).lSI);
    }

    public String toString() {
        return com.facebook.common.internal.f.aI(this).C("list", this.lSI).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lSJ = null;
        private b<T> lSK = null;

        public a() {
            if (!dnF()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dnH;
            dnH = dnH();
            return dnH != null ? dnH.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dny() {
            boolean z;
            b<T> dnH = dnH();
            if (dnH != null) {
                z = dnH.dny();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Wv() {
            synchronized (this) {
                if (!super.Wv()) {
                    return false;
                }
                b<T> bVar = this.lSJ;
                this.lSJ = null;
                b<T> bVar2 = this.lSK;
                this.lSK = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dnF() {
            j<b<T>> dnG = dnG();
            b<T> bVar = dnG != null ? dnG.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0698a(), com.facebook.common.b.a.dmR());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dnG() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lSI.size()) {
                jVar = null;
            } else {
                List list = e.this.lSI;
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
                this.lSJ = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lSJ) {
                z = false;
            } else {
                this.lSJ = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dnH() {
            return this.lSK;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lSJ && bVar != this.lSK) {
                    if (this.lSK == null || z) {
                        bVar2 = this.lSK;
                        this.lSK = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dnH()) {
                    l(bVar);
                }
                if (!dnF()) {
                    z(bVar.dnA());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dnH()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Wv();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0698a implements d<T> {
            private C0698a() {
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
                if (bVar.dny()) {
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
