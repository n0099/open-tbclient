package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> oCU;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oCU = list;
    }

    public static <T> e<T> gp(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: egS */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.oCU.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oCU, ((e) obj).oCU);
    }

    public String toString() {
        return com.facebook.common.internal.f.aZ(this).F("list", this.oCU).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> oCV = null;
        private b<T> oCW = null;

        public a() {
            if (!egT()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> egV;
            egV = egV();
            return egV != null ? egV.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean egM() {
            boolean z;
            b<T> egV = egV();
            if (egV != null) {
                z = egV.egM();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean amP() {
            synchronized (this) {
                if (!super.amP()) {
                    return false;
                }
                b<T> bVar = this.oCV;
                this.oCV = null;
                b<T> bVar2 = this.oCW;
                this.oCW = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean egT() {
            j<b<T>> egU = egU();
            b<T> bVar = egU != null ? egU.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0949a(), com.facebook.common.b.a.egg());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> egU() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.oCU.size()) {
                jVar = null;
            } else {
                List list = e.this.oCU;
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
                this.oCV = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.oCV) {
                z = false;
            } else {
                this.oCV = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> egV() {
            return this.oCW;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.oCV && bVar != this.oCW) {
                    if (this.oCW == null || z) {
                        bVar2 = this.oCW;
                        this.oCW = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != egV()) {
                    l(bVar);
                }
                if (!egT()) {
                    x(bVar.egO());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == egV()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.amP();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0949a implements d<T> {
            private C0949a() {
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
                if (bVar.egM()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bg(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
