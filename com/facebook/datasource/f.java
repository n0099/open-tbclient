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
    private final boolean lJB;
    private final List<j<b<T>>> lJw;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJw = list;
        this.lJB = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dll */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJw.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJw, ((f) obj).lJw);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJw).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lJC;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lJD;
        private int lJE;
        private AtomicInteger lJF;
        @Nullable
        private Throwable lJG;

        public a() {
            if (!f.this.lJB) {
                dlp();
            }
        }

        private void dlp() {
            if (this.lJF == null) {
                synchronized (this) {
                    if (this.lJF == null) {
                        this.lJF = new AtomicInteger(0);
                        int size = f.this.lJw.size();
                        this.lJE = size;
                        this.lJD = size;
                        this.lJC = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lJw.get(i)).get();
                            this.lJC.add(bVar);
                            bVar.a(new C0655a(i), com.facebook.common.b.a.dkA());
                            if (bVar.dlf()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hw(int i) {
            return (this.lJC == null || i >= this.lJC.size()) ? null : this.lJC.get(i);
        }

        @Nullable
        private synchronized b<T> Hx(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lJC != null && i < this.lJC.size()) {
                    bVar = this.lJC.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dlo() {
            return Hw(this.lJD);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlo;
            if (f.this.lJB) {
                dlp();
            }
            dlo = dlo();
            return dlo != null ? dlo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlf() {
            boolean z;
            if (f.this.lJB) {
                dlp();
            }
            b<T> dlo = dlo();
            if (dlo != null) {
                z = dlo.dlf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OD() {
            int i = 0;
            if (f.this.lJB) {
                dlp();
            }
            synchronized (this) {
                if (super.OD()) {
                    ArrayList<b<T>> arrayList = this.lJC;
                    this.lJC = null;
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
            if (bVar == dlo()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dlq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lJG = bVar.dlh();
            }
            dlq();
        }

        private void dlq() {
            if (this.lJF.incrementAndGet() == this.lJE && this.lJG != null) {
                u(this.lJG);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lJD;
                if (bVar == Hw(i) && i != this.lJD) {
                    if (dlo() == null || (z && i < this.lJD)) {
                        this.lJD = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lJD; i3 > i; i3--) {
                        f(Hx(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dlo()) {
                bVar = null;
            } else if (bVar == Hw(i)) {
                bVar = Hx(i);
            }
            return bVar;
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OD();
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
                if (bVar.dlf()) {
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
