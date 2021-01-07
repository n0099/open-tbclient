package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> puo;
    private final boolean put;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.puo = list;
        this.put = z;
    }

    public static <T> f<T> B(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: euE */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.puo.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.puo, ((f) obj).puo);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("list", this.puo).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> puu;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int puv;
        private int puw;
        private AtomicInteger pux;
        @Nullable
        private Throwable puy;

        public a() {
            if (!f.this.put) {
                euI();
            }
        }

        private void euI() {
            if (this.pux == null) {
                synchronized (this) {
                    if (this.pux == null) {
                        this.pux = new AtomicInteger(0);
                        int size = f.this.puo.size();
                        this.puw = size;
                        this.puv = size;
                        this.puu = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.puo.get(i)).get();
                            this.puu.add(bVar);
                            bVar.a(new C1056a(i), com.facebook.common.b.a.etS());
                            if (bVar.euy()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Qj(int i) {
            return (this.puu == null || i >= this.puu.size()) ? null : this.puu.get(i);
        }

        @Nullable
        private synchronized b<T> Qk(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.puu != null && i < this.puu.size()) {
                    bVar = this.puu.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> euH() {
            return Qj(this.puv);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> euH;
            if (f.this.put) {
                euI();
            }
            euH = euH();
            return euH != null ? euH.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean euy() {
            boolean z;
            if (f.this.put) {
                euI();
            }
            b<T> euH = euH();
            if (euH != null) {
                z = euH.euy();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ati() {
            int i = 0;
            if (f.this.put) {
                euI();
            }
            synchronized (this) {
                if (super.ati()) {
                    ArrayList<b<T>> arrayList = this.puu;
                    this.puu = null;
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
            if (bVar == euH()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            euJ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.puy = bVar.euA();
            }
            euJ();
        }

        private void euJ() {
            if (this.pux.incrementAndGet() == this.puw && this.puy != null) {
                u(this.puy);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.puv;
                if (bVar == Qj(i) && i != this.puv) {
                    if (euH() == null || (z && i < this.puv)) {
                        this.puv = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.puv; i3 > i; i3--) {
                        l(Qk(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == euH()) {
                bVar = null;
            } else if (bVar == Qj(i)) {
                bVar = Qk(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ati();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1056a implements d<T> {
            private int mIndex;

            public C1056a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.euy()) {
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
                    a.this.bC(bVar.getProgress());
                }
            }
        }
    }
}
