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
    private final List<j<b<T>>> oCU;
    private final boolean oCZ;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oCU = list;
        this.oCZ = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
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
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oCU, ((f) obj).oCU);
    }

    public String toString() {
        return com.facebook.common.internal.f.aZ(this).F("list", this.oCU).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> oDa;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int oDb;
        private int oDc;
        private AtomicInteger oDd;
        @Nullable
        private Throwable oDe;

        public a() {
            if (!f.this.oCZ) {
                egW();
            }
        }

        private void egW() {
            if (this.oDd == null) {
                synchronized (this) {
                    if (this.oDd == null) {
                        this.oDd = new AtomicInteger(0);
                        int size = f.this.oCU.size();
                        this.oDc = size;
                        this.oDb = size;
                        this.oDa = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.oCU.get(i)).get();
                            this.oDa.add(bVar);
                            bVar.a(new C0950a(i), com.facebook.common.b.a.egg());
                            if (bVar.egM()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> NZ(int i) {
            return (this.oDa == null || i >= this.oDa.size()) ? null : this.oDa.get(i);
        }

        @Nullable
        private synchronized b<T> Oa(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.oDa != null && i < this.oDa.size()) {
                    bVar = this.oDa.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> egV() {
            return NZ(this.oDb);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> egV;
            if (f.this.oCZ) {
                egW();
            }
            egV = egV();
            return egV != null ? egV.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean egM() {
            boolean z;
            if (f.this.oCZ) {
                egW();
            }
            b<T> egV = egV();
            if (egV != null) {
                z = egV.egM();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean amP() {
            int i = 0;
            if (f.this.oCZ) {
                egW();
            }
            synchronized (this) {
                if (super.amP()) {
                    ArrayList<b<T>> arrayList = this.oDa;
                    this.oDa = null;
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
            if (bVar == egV()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            egX();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.oDe = bVar.egO();
            }
            egX();
        }

        private void egX() {
            if (this.oDd.incrementAndGet() == this.oDc && this.oDe != null) {
                x(this.oDe);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.oDb;
                if (bVar == NZ(i) && i != this.oDb) {
                    if (egV() == null || (z && i < this.oDb)) {
                        this.oDb = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.oDb; i3 > i; i3--) {
                        l(Oa(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == egV()) {
                bVar = null;
            } else if (bVar == NZ(i)) {
                bVar = Oa(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.amP();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0950a implements d<T> {
            private int mIndex;

            public C0950a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.egM()) {
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
                    a.this.bg(bVar.getProgress());
                }
            }
        }
    }
}
