package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> pCB;
    private final boolean pCG;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.pCB = list;
        this.pCG = z;
    }

    public static <T> f<T> D(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: etu */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.pCB.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.pCB, ((f) obj).pCB);
    }

    public String toString() {
        return com.facebook.common.internal.f.bd(this).G("list", this.pCB).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes4.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pCH;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int pCI;
        private int pCJ;
        private AtomicInteger pCK;
        @Nullable
        private Throwable pCL;

        public a() {
            if (!f.this.pCG) {
                ety();
            }
        }

        private void ety() {
            if (this.pCK == null) {
                synchronized (this) {
                    if (this.pCK == null) {
                        this.pCK = new AtomicInteger(0);
                        int size = f.this.pCB.size();
                        this.pCJ = size;
                        this.pCI = size;
                        this.pCH = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.pCB.get(i)).get();
                            this.pCH.add(bVar);
                            bVar.a(new C1060a(i), com.facebook.common.b.a.esI());
                            if (bVar.eto()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Pc(int i) {
            return (this.pCH == null || i >= this.pCH.size()) ? null : this.pCH.get(i);
        }

        @Nullable
        private synchronized b<T> Pd(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pCH != null && i < this.pCH.size()) {
                    bVar = this.pCH.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> etx() {
            return Pc(this.pCI);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> etx;
            if (f.this.pCG) {
                ety();
            }
            etx = etx();
            return etx != null ? etx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eto() {
            boolean z;
            if (f.this.pCG) {
                ety();
            }
            b<T> etx = etx();
            if (etx != null) {
                z = etx.eto();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apO() {
            int i = 0;
            if (f.this.pCG) {
                ety();
            }
            synchronized (this) {
                if (super.apO()) {
                    ArrayList<b<T>> arrayList = this.pCH;
                    this.pCH = null;
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
            if (bVar == etx()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            etz();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pCL = bVar.etq();
            }
            etz();
        }

        private void etz() {
            if (this.pCK.incrementAndGet() == this.pCJ && this.pCL != null) {
                t(this.pCL);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.pCI;
                if (bVar == Pc(i) && i != this.pCI) {
                    if (etx() == null || (z && i < this.pCI)) {
                        this.pCI = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.pCI; i3 > i; i3--) {
                        l(Pd(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == etx()) {
                bVar = null;
            } else if (bVar == Pc(i)) {
                bVar = Pd(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apO();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1060a implements d<T> {
            private int mIndex;

            public C1060a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.eto()) {
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
                    a.this.bJ(bVar.getProgress());
                }
            }
        }
    }
}
