package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> lFk;
    private final boolean lFp;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lFk = list;
        this.lFp = z;
    }

    public static <T> f<T> w(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: diT */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lFk.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lFk, ((f) obj).lFk);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("list", this.lFk).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes11.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lFq;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lFr;
        private int lFs;
        private AtomicInteger lFt;
        @Nullable
        private Throwable lFu;

        public a() {
            if (!f.this.lFp) {
                diX();
            }
        }

        private void diX() {
            if (this.lFt == null) {
                synchronized (this) {
                    if (this.lFt == null) {
                        this.lFt = new AtomicInteger(0);
                        int size = f.this.lFk.size();
                        this.lFs = size;
                        this.lFr = size;
                        this.lFq = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lFk.get(i)).get();
                            this.lFq.add(bVar);
                            bVar.a(new C0642a(i), com.facebook.common.b.a.dii());
                            if (bVar.diN()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hm(int i) {
            return (this.lFq == null || i >= this.lFq.size()) ? null : this.lFq.get(i);
        }

        @Nullable
        private synchronized b<T> Hn(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lFq != null && i < this.lFq.size()) {
                    bVar = this.lFq.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> diW() {
            return Hm(this.lFr);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> diW;
            if (f.this.lFp) {
                diX();
            }
            diW = diW();
            return diW != null ? diW.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean diN() {
            boolean z;
            if (f.this.lFp) {
                diX();
            }
            b<T> diW = diW();
            if (diW != null) {
                z = diW.diN();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean LR() {
            int i = 0;
            if (f.this.lFp) {
                diX();
            }
            synchronized (this) {
                if (super.LR()) {
                    ArrayList<b<T>> arrayList = this.lFq;
                    this.lFq = null;
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
            if (bVar == diW()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            diY();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lFu = bVar.diP();
            }
            diY();
        }

        private void diY() {
            if (this.lFt.incrementAndGet() == this.lFs && this.lFu != null) {
                v(this.lFu);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lFr;
                if (bVar == Hm(i) && i != this.lFr) {
                    if (diW() == null || (z && i < this.lFr)) {
                        this.lFr = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lFr; i3 > i; i3--) {
                        f(Hn(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == diW()) {
                bVar = null;
            } else if (bVar == Hm(i)) {
                bVar = Hn(i);
            }
            return bVar;
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.LR();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0642a implements d<T> {
            private int mIndex;

            public C0642a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.diN()) {
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
                    a.this.bl(bVar.getProgress());
                }
            }
        }
    }
}
