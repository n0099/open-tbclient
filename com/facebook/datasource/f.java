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
    private final boolean pAb;
    private final List<j<b<T>>> pzW;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pzW = list;
        this.pAb = z;
    }

    public static <T> f<T> D(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etd */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pzW.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pzW, ((f) obj).pzW);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).H("list", this.pzW).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pAc;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int pAd;
        private int pAe;
        private AtomicInteger pAf;
        @Nullable
        private Throwable pAg;

        public a() {
            if (!f.this.pAb) {
                eth();
            }
        }

        private void eth() {
            if (this.pAf == null) {
                synchronized (this) {
                    if (this.pAf == null) {
                        this.pAf = new AtomicInteger(0);
                        int size = f.this.pzW.size();
                        this.pAe = size;
                        this.pAd = size;
                        this.pAc = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.pzW.get(i)).get();
                            this.pAc.add(bVar);
                            bVar.a(new C1043a(i), com.facebook.common.b.a.esr());
                            if (bVar.esX()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> OX(int i) {
            return (this.pAc == null || i >= this.pAc.size()) ? null : this.pAc.get(i);
        }

        @Nullable
        private synchronized b<T> OY(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pAc != null && i < this.pAc.size()) {
                    bVar = this.pAc.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> etg() {
            return OX(this.pAd);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> etg;
            if (f.this.pAb) {
                eth();
            }
            etg = etg();
            return etg != null ? etg.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean esX() {
            boolean z;
            if (f.this.pAb) {
                eth();
            }
            b<T> etg = etg();
            if (etg != null) {
                z = etg.esX();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apL() {
            int i = 0;
            if (f.this.pAb) {
                eth();
            }
            synchronized (this) {
                if (super.apL()) {
                    ArrayList<b<T>> arrayList = this.pAc;
                    this.pAc = null;
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
            if (bVar == etg()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            eti();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pAg = bVar.esZ();
            }
            eti();
        }

        private void eti() {
            if (this.pAf.incrementAndGet() == this.pAe && this.pAg != null) {
                t(this.pAg);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.pAd;
                if (bVar == OX(i) && i != this.pAd) {
                    if (etg() == null || (z && i < this.pAd)) {
                        this.pAd = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.pAd; i3 > i; i3--) {
                        l(OY(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == etg()) {
                bVar = null;
            } else if (bVar == OX(i)) {
                bVar = OY(i);
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
        public class C1043a implements d<T> {
            private int mIndex;

            public C1043a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.esX()) {
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
