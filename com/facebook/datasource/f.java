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
    private final List<j<b<T>>> lLn;
    private final boolean lLs;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lLn = list;
        this.lLs = z;
    }

    public static <T> f<T> z(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlJ */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lLn.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lLn, ((f) obj).lLn);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lLn).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lLt;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lLu;
        private int lLv;
        private AtomicInteger lLw;
        @Nullable
        private Throwable lLx;

        public a() {
            if (!f.this.lLs) {
                dlN();
            }
        }

        private void dlN() {
            if (this.lLw == null) {
                synchronized (this) {
                    if (this.lLw == null) {
                        this.lLw = new AtomicInteger(0);
                        int size = f.this.lLn.size();
                        this.lLv = size;
                        this.lLu = size;
                        this.lLt = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lLn.get(i)).get();
                            this.lLt.add(bVar);
                            bVar.a(new C0656a(i), com.facebook.common.b.a.dkY());
                            if (bVar.dlD()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> HC(int i) {
            return (this.lLt == null || i >= this.lLt.size()) ? null : this.lLt.get(i);
        }

        @Nullable
        private synchronized b<T> HD(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lLt != null && i < this.lLt.size()) {
                    bVar = this.lLt.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dlM() {
            return HC(this.lLu);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlM;
            if (f.this.lLs) {
                dlN();
            }
            dlM = dlM();
            return dlM != null ? dlM.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlD() {
            boolean z;
            if (f.this.lLs) {
                dlN();
            }
            b<T> dlM = dlM();
            if (dlM != null) {
                z = dlM.dlD();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OG() {
            int i = 0;
            if (f.this.lLs) {
                dlN();
            }
            synchronized (this) {
                if (super.OG()) {
                    ArrayList<b<T>> arrayList = this.lLt;
                    this.lLt = null;
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
            if (bVar == dlM()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dlO();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lLx = bVar.dlF();
            }
            dlO();
        }

        private void dlO() {
            if (this.lLw.incrementAndGet() == this.lLv && this.lLx != null) {
                u(this.lLx);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lLu;
                if (bVar == HC(i) && i != this.lLu) {
                    if (dlM() == null || (z && i < this.lLu)) {
                        this.lLu = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lLu; i3 > i; i3--) {
                        f(HD(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dlM()) {
                bVar = null;
            } else if (bVar == HC(i)) {
                bVar = HD(i);
            }
            return bVar;
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OG();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0656a implements d<T> {
            private int mIndex;

            public C0656a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.dlD()) {
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
