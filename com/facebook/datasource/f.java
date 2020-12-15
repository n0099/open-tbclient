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
    private final List<j<b<T>>> pdb;
    private final boolean pdg;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pdb = list;
        this.pdg = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eqv */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pdb.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pdb, ((f) obj).pdb);
    }

    public String toString() {
        return com.facebook.common.internal.f.ba(this).E("list", this.pdb).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes19.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pdh;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int pdi;
        private int pdj;
        private AtomicInteger pdk;
        @Nullable
        private Throwable pdl;

        public a() {
            if (!f.this.pdg) {
                eqz();
            }
        }

        private void eqz() {
            if (this.pdk == null) {
                synchronized (this) {
                    if (this.pdk == null) {
                        this.pdk = new AtomicInteger(0);
                        int size = f.this.pdb.size();
                        this.pdj = size;
                        this.pdi = size;
                        this.pdh = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.pdb.get(i)).get();
                            this.pdh.add(bVar);
                            bVar.a(new C0989a(i), com.facebook.common.b.a.epJ());
                            if (bVar.eqp()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> PV(int i) {
            return (this.pdh == null || i >= this.pdh.size()) ? null : this.pdh.get(i);
        }

        @Nullable
        private synchronized b<T> PW(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pdh != null && i < this.pdh.size()) {
                    bVar = this.pdh.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> eqy() {
            return PV(this.pdi);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eqy;
            if (f.this.pdg) {
                eqz();
            }
            eqy = eqy();
            return eqy != null ? eqy.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eqp() {
            boolean z;
            if (f.this.pdg) {
                eqz();
            }
            b<T> eqy = eqy();
            if (eqy != null) {
                z = eqy.eqp();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean arP() {
            int i = 0;
            if (f.this.pdg) {
                eqz();
            }
            synchronized (this) {
                if (super.arP()) {
                    ArrayList<b<T>> arrayList = this.pdh;
                    this.pdh = null;
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
            if (bVar == eqy()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            eqA();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pdl = bVar.eqr();
            }
            eqA();
        }

        private void eqA() {
            if (this.pdk.incrementAndGet() == this.pdj && this.pdl != null) {
                x(this.pdl);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.pdi;
                if (bVar == PV(i) && i != this.pdi) {
                    if (eqy() == null || (z && i < this.pdi)) {
                        this.pdi = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.pdi; i3 > i; i3--) {
                        l(PW(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == eqy()) {
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
                if (bVar.eqp()) {
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
