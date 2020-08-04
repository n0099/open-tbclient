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
    private final List<j<b<T>>> mRW;
    private final boolean mSb;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mRW = list;
        this.mSb = z;
    }

    public static <T> f<T> v(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDc */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mRW.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mRW, ((f) obj).mRW);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mRW).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mSc;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mSd;
        private int mSe;
        private AtomicInteger mSf;
        @Nullable
        private Throwable mSg;

        public a() {
            if (!f.this.mSb) {
                dDg();
            }
        }

        private void dDg() {
            if (this.mSf == null) {
                synchronized (this) {
                    if (this.mSf == null) {
                        this.mSf = new AtomicInteger(0);
                        int size = f.this.mRW.size();
                        this.mSe = size;
                        this.mSd = size;
                        this.mSc = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mRW.get(i)).get();
                            this.mSc.add(bVar);
                            bVar.a(new C0805a(i), com.facebook.common.b.a.dCq());
                            if (bVar.dCW()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> It(int i) {
            return (this.mSc == null || i >= this.mSc.size()) ? null : this.mSc.get(i);
        }

        @Nullable
        private synchronized b<T> Iu(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mSc != null && i < this.mSc.size()) {
                    bVar = this.mSc.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dDf() {
            return It(this.mSd);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dDf;
            if (f.this.mSb) {
                dDg();
            }
            dDf = dDf();
            return dDf != null ? dDf.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dCW() {
            boolean z;
            if (f.this.mSb) {
                dDg();
            }
            b<T> dDf = dDf();
            if (dDf != null) {
                z = dDf.dCW();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean abo() {
            int i = 0;
            if (f.this.mSb) {
                dDg();
            }
            synchronized (this) {
                if (super.abo()) {
                    ArrayList<b<T>> arrayList = this.mSc;
                    this.mSc = null;
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
            if (bVar == dDf()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dDh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mSg = bVar.dCY();
            }
            dDh();
        }

        private void dDh() {
            if (this.mSf.incrementAndGet() == this.mSe && this.mSg != null) {
                y(this.mSg);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mSd;
                if (bVar == It(i) && i != this.mSd) {
                    if (dDf() == null || (z && i < this.mSd)) {
                        this.mSd = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mSd; i3 > i; i3--) {
                        l(Iu(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dDf()) {
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
                if (bVar.dCW()) {
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
