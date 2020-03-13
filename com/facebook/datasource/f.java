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
    private final List<j<b<T>>> lJH;
    private final boolean lJM;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJH = list;
        this.lJM = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlm */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJH.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJH, ((f) obj).lJH);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJH).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lJN;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lJO;
        private int lJP;
        private AtomicInteger lJQ;
        @Nullable
        private Throwable lJR;

        public a() {
            if (!f.this.lJM) {
                dlq();
            }
        }

        private void dlq() {
            if (this.lJQ == null) {
                synchronized (this) {
                    if (this.lJQ == null) {
                        this.lJQ = new AtomicInteger(0);
                        int size = f.this.lJH.size();
                        this.lJP = size;
                        this.lJO = size;
                        this.lJN = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lJH.get(i)).get();
                            this.lJN.add(bVar);
                            bVar.a(new C0655a(i), com.facebook.common.b.a.dkB());
                            if (bVar.dlg()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hw(int i) {
            return (this.lJN == null || i >= this.lJN.size()) ? null : this.lJN.get(i);
        }

        @Nullable
        private synchronized b<T> Hx(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lJN != null && i < this.lJN.size()) {
                    bVar = this.lJN.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dlp() {
            return Hw(this.lJO);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlp;
            if (f.this.lJM) {
                dlq();
            }
            dlp = dlp();
            return dlp != null ? dlp.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlg() {
            boolean z;
            if (f.this.lJM) {
                dlq();
            }
            b<T> dlp = dlp();
            if (dlp != null) {
                z = dlp.dlg();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OD() {
            int i = 0;
            if (f.this.lJM) {
                dlq();
            }
            synchronized (this) {
                if (super.OD()) {
                    ArrayList<b<T>> arrayList = this.lJN;
                    this.lJN = null;
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
            if (bVar == dlp()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dlr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lJR = bVar.dli();
            }
            dlr();
        }

        private void dlr() {
            if (this.lJQ.incrementAndGet() == this.lJP && this.lJR != null) {
                u(this.lJR);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lJO;
                if (bVar == Hw(i) && i != this.lJO) {
                    if (dlp() == null || (z && i < this.lJO)) {
                        this.lJO = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lJO; i3 > i; i3--) {
                        f(Hx(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dlp()) {
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
                if (bVar.dlg()) {
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
