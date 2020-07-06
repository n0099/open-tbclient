package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> mJR;
    private final boolean mJW;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mJR = list;
        this.mJW = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dzP */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mJR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mJR, ((f) obj).mJR);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mJR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mJX;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mJY;
        private int mJZ;
        private AtomicInteger mKa;
        @Nullable
        private Throwable mKb;

        public a() {
            if (!f.this.mJW) {
                dzT();
            }
        }

        private void dzT() {
            if (this.mKa == null) {
                synchronized (this) {
                    if (this.mKa == null) {
                        this.mKa = new AtomicInteger(0);
                        int size = f.this.mJR.size();
                        this.mJZ = size;
                        this.mJY = size;
                        this.mJX = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mJR.get(i)).get();
                            this.mJX.add(bVar);
                            bVar.a(new C0796a(i), com.facebook.common.b.a.dzd());
                            if (bVar.dzJ()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> HY(int i) {
            return (this.mJX == null || i >= this.mJX.size()) ? null : this.mJX.get(i);
        }

        @Nullable
        private synchronized b<T> HZ(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mJX != null && i < this.mJX.size()) {
                    bVar = this.mJX.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dzS() {
            return HY(this.mJY);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dzS;
            if (f.this.mJW) {
                dzT();
            }
            dzS = dzS();
            return dzS != null ? dzS.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dzJ() {
            boolean z;
            if (f.this.mJW) {
                dzT();
            }
            b<T> dzS = dzS();
            if (dzS != null) {
                z = dzS.dzJ();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aam() {
            int i = 0;
            if (f.this.mJW) {
                dzT();
            }
            synchronized (this) {
                if (super.aam()) {
                    ArrayList<b<T>> arrayList = this.mJX;
                    this.mJX = null;
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
            if (bVar == dzS()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dzU();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mKb = bVar.dzL();
            }
            dzU();
        }

        private void dzU() {
            if (this.mKa.incrementAndGet() == this.mJZ && this.mKb != null) {
                z(this.mKb);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mJY;
                if (bVar == HY(i) && i != this.mJY) {
                    if (dzS() == null || (z && i < this.mJY)) {
                        this.mJY = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mJY; i3 > i; i3--) {
                        l(HZ(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dzS()) {
                bVar = null;
            } else if (bVar == HY(i)) {
                bVar = HZ(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aam();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0796a implements d<T> {
            private int mIndex;

            public C0796a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dzJ()) {
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
                    a.this.aE(bVar.getProgress());
                }
            }
        }
    }
}
