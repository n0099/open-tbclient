package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> nmi;
    private final boolean nmn;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nmi = list;
        this.nmn = z;
    }

    public static <T> f<T> v(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dPl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nmi.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nmi, ((f) obj).nmi);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).E("list", this.nmi).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes9.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> nmo;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int nmp;
        private int nmq;
        private AtomicInteger nmr;
        @Nullable
        private Throwable nms;

        public a() {
            if (!f.this.nmn) {
                dPp();
            }
        }

        private void dPp() {
            if (this.nmr == null) {
                synchronized (this) {
                    if (this.nmr == null) {
                        this.nmr = new AtomicInteger(0);
                        int size = f.this.nmi.size();
                        this.nmq = size;
                        this.nmp = size;
                        this.nmo = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.nmi.get(i)).get();
                            this.nmo.add(bVar);
                            bVar.a(new C0863a(i), com.facebook.common.b.a.dOz());
                            if (bVar.dPf()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> KX(int i) {
            return (this.nmo == null || i >= this.nmo.size()) ? null : this.nmo.get(i);
        }

        @Nullable
        private synchronized b<T> KY(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.nmo != null && i < this.nmo.size()) {
                    bVar = this.nmo.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dPo() {
            return KX(this.nmp);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dPo;
            if (f.this.nmn) {
                dPp();
            }
            dPo = dPo();
            return dPo != null ? dPo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dPf() {
            boolean z;
            if (f.this.nmn) {
                dPp();
            }
            b<T> dPo = dPo();
            if (dPo != null) {
                z = dPo.dPf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ahA() {
            int i = 0;
            if (f.this.nmn) {
                dPp();
            }
            synchronized (this) {
                if (super.ahA()) {
                    ArrayList<b<T>> arrayList = this.nmo;
                    this.nmo = null;
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
            if (bVar == dPo()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dPq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.nms = bVar.dPh();
            }
            dPq();
        }

        private void dPq() {
            if (this.nmr.incrementAndGet() == this.nmq && this.nms != null) {
                x(this.nms);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.nmp;
                if (bVar == KX(i) && i != this.nmp) {
                    if (dPo() == null || (z && i < this.nmp)) {
                        this.nmp = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.nmp; i3 > i; i3--) {
                        l(KY(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dPo()) {
                bVar = null;
            } else if (bVar == KX(i)) {
                bVar = KY(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ahA();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0863a implements d<T> {
            private int mIndex;

            public C0863a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dPf()) {
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
                    a.this.aJ(bVar.getProgress());
                }
            }
        }
    }
}
