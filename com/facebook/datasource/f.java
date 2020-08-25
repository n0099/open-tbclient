package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> nlQ;
    private final boolean nlV;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nlQ = list;
        this.nlV = z;
    }

    public static <T> f<T> v(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPc */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nlQ.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nlQ, ((f) obj).nlQ);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).E("list", this.nlQ).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes9.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> nlW;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int nlX;
        private int nlY;
        private AtomicInteger nlZ;
        @Nullable
        private Throwable nma;

        public a() {
            if (!f.this.nlV) {
                dPg();
            }
        }

        private void dPg() {
            if (this.nlZ == null) {
                synchronized (this) {
                    if (this.nlZ == null) {
                        this.nlZ = new AtomicInteger(0);
                        int size = f.this.nlQ.size();
                        this.nlY = size;
                        this.nlX = size;
                        this.nlW = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.nlQ.get(i)).get();
                            this.nlW.add(bVar);
                            bVar.a(new C0863a(i), com.facebook.common.b.a.dOq());
                            if (bVar.dOW()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> KX(int i) {
            return (this.nlW == null || i >= this.nlW.size()) ? null : this.nlW.get(i);
        }

        @Nullable
        private synchronized b<T> KY(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.nlW != null && i < this.nlW.size()) {
                    bVar = this.nlW.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dPf() {
            return KX(this.nlX);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dPf;
            if (f.this.nlV) {
                dPg();
            }
            dPf = dPf();
            return dPf != null ? dPf.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dOW() {
            boolean z;
            if (f.this.nlV) {
                dPg();
            }
            b<T> dPf = dPf();
            if (dPf != null) {
                z = dPf.dOW();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ahA() {
            int i = 0;
            if (f.this.nlV) {
                dPg();
            }
            synchronized (this) {
                if (super.ahA()) {
                    ArrayList<b<T>> arrayList = this.nlW;
                    this.nlW = null;
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
            if (bVar == dPf()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dPh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.nma = bVar.dOY();
            }
            dPh();
        }

        private void dPh() {
            if (this.nlZ.incrementAndGet() == this.nlY && this.nma != null) {
                x(this.nma);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.nlX;
                if (bVar == KX(i) && i != this.nlX) {
                    if (dPf() == null || (z && i < this.nlX)) {
                        this.nlX = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.nlX; i3 > i; i3--) {
                        l(KY(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dPf()) {
                bVar = null;
            } else if (bVar == KX(i)) {
                bVar = KY(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ahA();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0863a implements d<T> {
            private int mIndex;

            public C0863a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dOW()) {
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
                    a.this.aJ(bVar.getProgress());
                }
            }
        }
    }
}
