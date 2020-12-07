package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes19.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> pcZ;
    private final boolean pde;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pcZ = list;
        this.pde = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
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
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pcZ, ((f) obj).pcZ);
    }

    public String toString() {
        return com.facebook.common.internal.f.ba(this).E("list", this.pcZ).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes19.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pdf;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int pdg;
        private int pdh;
        private AtomicInteger pdi;
        @Nullable
        private Throwable pdj;

        public a() {
            if (!f.this.pde) {
                eqy();
            }
        }

        private void eqy() {
            if (this.pdi == null) {
                synchronized (this) {
                    if (this.pdi == null) {
                        this.pdi = new AtomicInteger(0);
                        int size = f.this.pcZ.size();
                        this.pdh = size;
                        this.pdg = size;
                        this.pdf = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.pcZ.get(i)).get();
                            this.pdf.add(bVar);
                            bVar.a(new C0989a(i), com.facebook.common.b.a.epI());
                            if (bVar.eqo()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> PV(int i) {
            return (this.pdf == null || i >= this.pdf.size()) ? null : this.pdf.get(i);
        }

        @Nullable
        private synchronized b<T> PW(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pdf != null && i < this.pdf.size()) {
                    bVar = this.pdf.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> eqx() {
            return PV(this.pdg);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eqx;
            if (f.this.pde) {
                eqy();
            }
            eqx = eqx();
            return eqx != null ? eqx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eqo() {
            boolean z;
            if (f.this.pde) {
                eqy();
            }
            b<T> eqx = eqx();
            if (eqx != null) {
                z = eqx.eqo();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean arP() {
            int i = 0;
            if (f.this.pde) {
                eqy();
            }
            synchronized (this) {
                if (super.arP()) {
                    ArrayList<b<T>> arrayList = this.pdf;
                    this.pdf = null;
                    if (arrayList != null) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayList.size()) {
                                break;
                            }
                            l(arrayList.get(i2));
                            i = i2 + 1;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, b<T> bVar) {
            a(i, bVar, bVar.isFinished());
            if (bVar == eqx()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            eqz();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pdj = bVar.eqq();
            }
            eqz();
        }

        private void eqz() {
            if (this.pdi.incrementAndGet() == this.pdh && this.pdj != null) {
                x(this.pdj);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.pdg;
                if (bVar == PV(i) && i != this.pdg) {
                    if (eqx() == null || (z && i < this.pdg)) {
                        this.pdg = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.pdg; i3 > i; i3--) {
                        l(PW(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == eqx()) {
                bVar = null;
            } else if (bVar == PV(i)) {
                bVar = PW(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.arP();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public class C0989a implements d<T> {
            private int mIndex;

            public C0989a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.eqo()) {
                    a.this.a(this.mIndex, bVar);
                } else if (bVar.isFinished()) {
                    a.this.b(this.mIndex, bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void e(b<T> bVar) {
                a.this.b(this.mIndex, bVar);
            }

            @Override // com.facebook.datasource.d
            public void b(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                if (this.mIndex == 0) {
                    a.this.bq(bVar.getProgress());
                }
            }
        }
    }
}
