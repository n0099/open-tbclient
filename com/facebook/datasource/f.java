package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes14.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> ppM;
    private final boolean ppR;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ppM = list;
        this.ppR = z;
    }

    public static <T> f<T> B(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eqK */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ppM.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ppM, ((f) obj).ppM);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("list", this.ppM).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes14.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> ppS;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int ppT;
        private int ppU;
        private AtomicInteger ppV;
        @Nullable
        private Throwable ppW;

        public a() {
            if (!f.this.ppR) {
                eqO();
            }
        }

        private void eqO() {
            if (this.ppV == null) {
                synchronized (this) {
                    if (this.ppV == null) {
                        this.ppV = new AtomicInteger(0);
                        int size = f.this.ppM.size();
                        this.ppU = size;
                        this.ppT = size;
                        this.ppS = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.ppM.get(i)).get();
                            this.ppS.add(bVar);
                            bVar.a(new C1039a(i), com.facebook.common.b.a.epY());
                            if (bVar.eqE()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> OC(int i) {
            return (this.ppS == null || i >= this.ppS.size()) ? null : this.ppS.get(i);
        }

        @Nullable
        private synchronized b<T> OD(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.ppS != null && i < this.ppS.size()) {
                    bVar = this.ppS.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> eqN() {
            return OC(this.ppT);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> eqN;
            if (f.this.ppR) {
                eqO();
            }
            eqN = eqN();
            return eqN != null ? eqN.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eqE() {
            boolean z;
            if (f.this.ppR) {
                eqO();
            }
            b<T> eqN = eqN();
            if (eqN != null) {
                z = eqN.eqE();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apn() {
            int i = 0;
            if (f.this.ppR) {
                eqO();
            }
            synchronized (this) {
                if (super.apn()) {
                    ArrayList<b<T>> arrayList = this.ppS;
                    this.ppS = null;
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
            if (bVar == eqN()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            eqP();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.ppW = bVar.eqG();
            }
            eqP();
        }

        private void eqP() {
            if (this.ppV.incrementAndGet() == this.ppU && this.ppW != null) {
                u(this.ppW);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.ppT;
                if (bVar == OC(i) && i != this.ppT) {
                    if (eqN() == null || (z && i < this.ppT)) {
                        this.ppT = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.ppT; i3 > i; i3--) {
                        l(OD(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == eqN()) {
                bVar = null;
            } else if (bVar == OC(i)) {
                bVar = OD(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apn();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public class C1039a implements d<T> {
            private int mIndex;

            public C1039a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.eqE()) {
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
                    a.this.bC(bVar.getProgress());
                }
            }
        }
    }
}
