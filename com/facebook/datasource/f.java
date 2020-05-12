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
    private final List<j<b<T>>> lSM;
    private final boolean lSR;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lSM = list;
        this.lSR = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dnC */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lSM.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lSM, ((f) obj).lSM);
    }

    public String toString() {
        return com.facebook.common.internal.f.aJ(this).C("list", this.lSM).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lSS;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lST;
        private int lSU;
        private AtomicInteger lSV;
        @Nullable
        private Throwable lSW;

        public a() {
            if (!f.this.lSR) {
                dnG();
            }
        }

        private void dnG() {
            if (this.lSV == null) {
                synchronized (this) {
                    if (this.lSV == null) {
                        this.lSV = new AtomicInteger(0);
                        int size = f.this.lSM.size();
                        this.lSU = size;
                        this.lST = size;
                        this.lSS = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lSM.get(i)).get();
                            this.lSS.add(bVar);
                            bVar.a(new C0720a(i), com.facebook.common.b.a.dmP());
                            if (bVar.dnw()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Gd(int i) {
            return (this.lSS == null || i >= this.lSS.size()) ? null : this.lSS.get(i);
        }

        @Nullable
        private synchronized b<T> Ge(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lSS != null && i < this.lSS.size()) {
                    bVar = this.lSS.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dnF() {
            return Gd(this.lST);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dnF;
            if (f.this.lSR) {
                dnG();
            }
            dnF = dnF();
            return dnF != null ? dnF.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dnw() {
            boolean z;
            if (f.this.lSR) {
                dnG();
            }
            b<T> dnF = dnF();
            if (dnF != null) {
                z = dnF.dnw();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Wu() {
            int i = 0;
            if (f.this.lSR) {
                dnG();
            }
            synchronized (this) {
                if (super.Wu()) {
                    ArrayList<b<T>> arrayList = this.lSS;
                    this.lSS = null;
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
            if (bVar == dnF()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dnH();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.lSW = bVar.dny();
            }
            dnH();
        }

        private void dnH() {
            if (this.lSV.incrementAndGet() == this.lSU && this.lSW != null) {
                z(this.lSW);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lST;
                if (bVar == Gd(i) && i != this.lST) {
                    if (dnF() == null || (z && i < this.lST)) {
                        this.lST = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lST; i3 > i; i3--) {
                        l(Ge(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dnF()) {
                bVar = null;
            } else if (bVar == Gd(i)) {
                bVar = Ge(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Wu();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0720a implements d<T> {
            private int mIndex;

            public C0720a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dnw()) {
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
                    a.this.az(bVar.getProgress());
                }
            }
        }
    }
}
