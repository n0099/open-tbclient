package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class f<T> implements j<b<T>> {
    private final boolean pAB;
    private final List<j<b<T>>> pAw;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pAw = list;
        this.pAB = z;
    }

    public static <T> f<T> D(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pAw.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pAw, ((f) obj).pAw);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).H("list", this.pAw).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pAC;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int pAD;
        private int pAE;
        private AtomicInteger pAF;
        @Nullable
        private Throwable pAG;

        public a() {
            if (!f.this.pAB) {
                etp();
            }
        }

        private void etp() {
            if (this.pAF == null) {
                synchronized (this) {
                    if (this.pAF == null) {
                        this.pAF = new AtomicInteger(0);
                        int size = f.this.pAw.size();
                        this.pAE = size;
                        this.pAD = size;
                        this.pAC = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.pAw.get(i)).get();
                            this.pAC.add(bVar);
                            bVar.a(new C1045a(i), com.facebook.common.b.a.esz());
                            if (bVar.etf()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> OY(int i) {
            return (this.pAC == null || i >= this.pAC.size()) ? null : this.pAC.get(i);
        }

        @Nullable
        private synchronized b<T> OZ(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pAC != null && i < this.pAC.size()) {
                    bVar = this.pAC.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> eto() {
            return OY(this.pAD);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eto;
            if (f.this.pAB) {
                etp();
            }
            eto = eto();
            return eto != null ? eto.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean etf() {
            boolean z;
            if (f.this.pAB) {
                etp();
            }
            b<T> eto = eto();
            if (eto != null) {
                z = eto.etf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apL() {
            int i = 0;
            if (f.this.pAB) {
                etp();
            }
            synchronized (this) {
                if (super.apL()) {
                    ArrayList<b<T>> arrayList = this.pAC;
                    this.pAC = null;
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
            if (bVar == eto()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            etq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pAG = bVar.eth();
            }
            etq();
        }

        private void etq() {
            if (this.pAF.incrementAndGet() == this.pAE && this.pAG != null) {
                t(this.pAG);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.pAD;
                if (bVar == OY(i) && i != this.pAD) {
                    if (eto() == null || (z && i < this.pAD)) {
                        this.pAD = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.pAD; i3 > i; i3--) {
                        l(OZ(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == eto()) {
                bVar = null;
            } else if (bVar == OY(i)) {
                bVar = OZ(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apL();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1045a implements d<T> {
            private int mIndex;

            public C1045a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.etf()) {
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
                    a.this.bF(bVar.getProgress());
                }
            }
        }
    }
}
