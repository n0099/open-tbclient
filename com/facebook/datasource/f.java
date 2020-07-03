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
    private final List<j<b<T>>> mJO;
    private final boolean mJT;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mJO = list;
        this.mJT = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dzL */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mJO.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mJO, ((f) obj).mJO);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mJO).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mJU;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mJV;
        private int mJW;
        private AtomicInteger mJX;
        @Nullable
        private Throwable mJY;

        public a() {
            if (!f.this.mJT) {
                dzP();
            }
        }

        private void dzP() {
            if (this.mJX == null) {
                synchronized (this) {
                    if (this.mJX == null) {
                        this.mJX = new AtomicInteger(0);
                        int size = f.this.mJO.size();
                        this.mJW = size;
                        this.mJV = size;
                        this.mJU = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mJO.get(i)).get();
                            this.mJU.add(bVar);
                            bVar.a(new C0795a(i), com.facebook.common.b.a.dyZ());
                            if (bVar.dzF()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> HY(int i) {
            return (this.mJU == null || i >= this.mJU.size()) ? null : this.mJU.get(i);
        }

        @Nullable
        private synchronized b<T> HZ(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mJU != null && i < this.mJU.size()) {
                    bVar = this.mJU.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dzO() {
            return HY(this.mJV);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dzO;
            if (f.this.mJT) {
                dzP();
            }
            dzO = dzO();
            return dzO != null ? dzO.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dzF() {
            boolean z;
            if (f.this.mJT) {
                dzP();
            }
            b<T> dzO = dzO();
            if (dzO != null) {
                z = dzO.dzF();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aam() {
            int i = 0;
            if (f.this.mJT) {
                dzP();
            }
            synchronized (this) {
                if (super.aam()) {
                    ArrayList<b<T>> arrayList = this.mJU;
                    this.mJU = null;
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
            if (bVar == dzO()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dzQ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mJY = bVar.dzH();
            }
            dzQ();
        }

        private void dzQ() {
            if (this.mJX.incrementAndGet() == this.mJW && this.mJY != null) {
                z(this.mJY);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mJV;
                if (bVar == HY(i) && i != this.mJV) {
                    if (dzO() == null || (z && i < this.mJV)) {
                        this.mJV = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mJV; i3 > i; i3--) {
                        l(HZ(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dzO()) {
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
        public class C0795a implements d<T> {
            private int mIndex;

            public C0795a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dzF()) {
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
