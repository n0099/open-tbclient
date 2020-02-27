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
    private final List<j<b<T>>> lJu;
    private final boolean lJz;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJu = list;
        this.lJz = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJu.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJu, ((f) obj).lJu);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJu).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lJA;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lJB;
        private int lJC;
        private AtomicInteger lJD;
        @Nullable
        private Throwable lJE;

        public a() {
            if (!f.this.lJz) {
                dln();
            }
        }

        private void dln() {
            if (this.lJD == null) {
                synchronized (this) {
                    if (this.lJD == null) {
                        this.lJD = new AtomicInteger(0);
                        int size = f.this.lJu.size();
                        this.lJC = size;
                        this.lJB = size;
                        this.lJA = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lJu.get(i)).get();
                            this.lJA.add(bVar);
                            bVar.a(new C0655a(i), com.facebook.common.b.a.dky());
                            if (bVar.dld()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hw(int i) {
            return (this.lJA == null || i >= this.lJA.size()) ? null : this.lJA.get(i);
        }

        @Nullable
        private synchronized b<T> Hx(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lJA != null && i < this.lJA.size()) {
                    bVar = this.lJA.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dlm() {
            return Hw(this.lJB);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlm;
            if (f.this.lJz) {
                dln();
            }
            dlm = dlm();
            return dlm != null ? dlm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dld() {
            boolean z;
            if (f.this.lJz) {
                dln();
            }
            b<T> dlm = dlm();
            if (dlm != null) {
                z = dlm.dld();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OB() {
            int i = 0;
            if (f.this.lJz) {
                dln();
            }
            synchronized (this) {
                if (super.OB()) {
                    ArrayList<b<T>> arrayList = this.lJA;
                    this.lJA = null;
                    if (arrayList != null) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayList.size()) {
                                break;
                            }
                            f(arrayList.get(i2));
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
            if (bVar == dlm()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dlo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lJE = bVar.dlf();
            }
            dlo();
        }

        private void dlo() {
            if (this.lJD.incrementAndGet() == this.lJC && this.lJE != null) {
                u(this.lJE);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lJB;
                if (bVar == Hw(i) && i != this.lJB) {
                    if (dlm() == null || (z && i < this.lJB)) {
                        this.lJB = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lJB; i3 > i; i3--) {
                        f(Hx(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dlm()) {
                bVar = null;
            } else if (bVar == Hw(i)) {
                bVar = Hx(i);
            }
            return bVar;
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OB();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0655a implements d<T> {
            private int mIndex;

            public C0655a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.dld()) {
                    a.this.a(this.mIndex, bVar);
                } else if (bVar.isFinished()) {
                    a.this.b(this.mIndex, bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onFailure(b<T> bVar) {
                a.this.b(this.mIndex, bVar);
            }

            @Override // com.facebook.datasource.d
            public void onCancellation(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                if (this.mIndex == 0) {
                    a.this.bj(bVar.getProgress());
                }
            }
        }
    }
}
