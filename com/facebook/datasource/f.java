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
    private final List<j<b<T>>> nLB;
    private final boolean nLG;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nLB = list;
        this.nLG = z;
    }

    public static <T> f<T> w(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dWU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nLB.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nLB, ((f) obj).nLB);
    }

    public String toString() {
        return com.facebook.common.internal.f.aV(this).F("list", this.nLB).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> nLH;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int nLI;
        private int nLJ;
        private AtomicInteger nLK;
        @Nullable
        private Throwable nLL;

        public a() {
            if (!f.this.nLG) {
                dWY();
            }
        }

        private void dWY() {
            if (this.nLK == null) {
                synchronized (this) {
                    if (this.nLK == null) {
                        this.nLK = new AtomicInteger(0);
                        int size = f.this.nLB.size();
                        this.nLJ = size;
                        this.nLI = size;
                        this.nLH = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.nLB.get(i)).get();
                            this.nLH.add(bVar);
                            bVar.a(new C0878a(i), com.facebook.common.b.a.dWi());
                            if (bVar.dWO()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Mi(int i) {
            return (this.nLH == null || i >= this.nLH.size()) ? null : this.nLH.get(i);
        }

        @Nullable
        private synchronized b<T> Mj(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.nLH != null && i < this.nLH.size()) {
                    bVar = this.nLH.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dWX() {
            return Mi(this.nLI);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dWX;
            if (f.this.nLG) {
                dWY();
            }
            dWX = dWX();
            return dWX != null ? dWX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dWO() {
            boolean z;
            if (f.this.nLG) {
                dWY();
            }
            b<T> dWX = dWX();
            if (dWX != null) {
                z = dWX.dWO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean akV() {
            int i = 0;
            if (f.this.nLG) {
                dWY();
            }
            synchronized (this) {
                if (super.akV()) {
                    ArrayList<b<T>> arrayList = this.nLH;
                    this.nLH = null;
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
            if (bVar == dWX()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dWZ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.nLL = bVar.dWQ();
            }
            dWZ();
        }

        private void dWZ() {
            if (this.nLK.incrementAndGet() == this.nLJ && this.nLL != null) {
                x(this.nLL);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.nLI;
                if (bVar == Mi(i) && i != this.nLI) {
                    if (dWX() == null || (z && i < this.nLI)) {
                        this.nLI = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.nLI; i3 > i; i3--) {
                        l(Mj(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dWX()) {
                bVar = null;
            } else if (bVar == Mi(i)) {
                bVar = Mj(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.akV();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0878a implements d<T> {
            private int mIndex;

            public C0878a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dWO()) {
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
                    a.this.aP(bVar.getProgress());
                }
            }
        }
    }
}
