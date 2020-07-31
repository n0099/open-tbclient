package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> mRU;
    private final boolean mRZ;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mRU = list;
        this.mRZ = z;
    }

    public static <T> f<T> v(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDb */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mRU.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mRU, ((f) obj).mRU);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mRU).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mSa;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mSb;
        private int mSc;
        private AtomicInteger mSd;
        @Nullable
        private Throwable mSe;

        public a() {
            if (!f.this.mRZ) {
                dDf();
            }
        }

        private void dDf() {
            if (this.mSd == null) {
                synchronized (this) {
                    if (this.mSd == null) {
                        this.mSd = new AtomicInteger(0);
                        int size = f.this.mRU.size();
                        this.mSc = size;
                        this.mSb = size;
                        this.mSa = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mRU.get(i)).get();
                            this.mSa.add(bVar);
                            bVar.a(new C0805a(i), com.facebook.common.b.a.dCp());
                            if (bVar.dCV()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> It(int i) {
            return (this.mSa == null || i >= this.mSa.size()) ? null : this.mSa.get(i);
        }

        @Nullable
        private synchronized b<T> Iu(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mSa != null && i < this.mSa.size()) {
                    bVar = this.mSa.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dDe() {
            return It(this.mSb);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dDe;
            if (f.this.mRZ) {
                dDf();
            }
            dDe = dDe();
            return dDe != null ? dDe.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dCV() {
            boolean z;
            if (f.this.mRZ) {
                dDf();
            }
            b<T> dDe = dDe();
            if (dDe != null) {
                z = dDe.dCV();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean abo() {
            int i = 0;
            if (f.this.mRZ) {
                dDf();
            }
            synchronized (this) {
                if (super.abo()) {
                    ArrayList<b<T>> arrayList = this.mSa;
                    this.mSa = null;
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
            if (bVar == dDe()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dDg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mSe = bVar.dCX();
            }
            dDg();
        }

        private void dDg() {
            if (this.mSd.incrementAndGet() == this.mSc && this.mSe != null) {
                y(this.mSe);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mSb;
                if (bVar == It(i) && i != this.mSb) {
                    if (dDe() == null || (z && i < this.mSb)) {
                        this.mSb = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mSb; i3 > i; i3--) {
                        l(Iu(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dDe()) {
                bVar = null;
            } else if (bVar == It(i)) {
                bVar = Iu(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.abo();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0805a implements d<T> {
            private int mIndex;

            public C0805a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dCV()) {
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
                    a.this.aD(bVar.getProgress());
                }
            }
        }
    }
}
