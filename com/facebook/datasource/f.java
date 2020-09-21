package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes17.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> nwi;
    private final boolean nwn;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nwi = list;
        this.nwn = z;
    }

    public static <T> f<T> v(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dTj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nwi.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nwi, ((f) obj).nwi);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).E("list", this.nwi).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes17.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> nwo;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int nwp;
        private int nwq;
        private AtomicInteger nwr;
        @Nullable
        private Throwable nws;

        public a() {
            if (!f.this.nwn) {
                dTn();
            }
        }

        private void dTn() {
            if (this.nwr == null) {
                synchronized (this) {
                    if (this.nwr == null) {
                        this.nwr = new AtomicInteger(0);
                        int size = f.this.nwi.size();
                        this.nwq = size;
                        this.nwp = size;
                        this.nwo = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.nwi.get(i)).get();
                            this.nwo.add(bVar);
                            bVar.a(new C0860a(i), com.facebook.common.b.a.dSx());
                            if (bVar.dTd()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> LC(int i) {
            return (this.nwo == null || i >= this.nwo.size()) ? null : this.nwo.get(i);
        }

        @Nullable
        private synchronized b<T> LD(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.nwo != null && i < this.nwo.size()) {
                    bVar = this.nwo.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dTm() {
            return LC(this.nwp);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dTm;
            if (f.this.nwn) {
                dTn();
            }
            dTm = dTm();
            return dTm != null ? dTm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dTd() {
            boolean z;
            if (f.this.nwn) {
                dTn();
            }
            b<T> dTm = dTm();
            if (dTm != null) {
                z = dTm.dTd();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aik() {
            int i = 0;
            if (f.this.nwn) {
                dTn();
            }
            synchronized (this) {
                if (super.aik()) {
                    ArrayList<b<T>> arrayList = this.nwo;
                    this.nwo = null;
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
            if (bVar == dTm()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dTo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.nws = bVar.dTf();
            }
            dTo();
        }

        private void dTo() {
            if (this.nwr.incrementAndGet() == this.nwq && this.nws != null) {
                x(this.nws);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.nwp;
                if (bVar == LC(i) && i != this.nwp) {
                    if (dTm() == null || (z && i < this.nwp)) {
                        this.nwp = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.nwp; i3 > i; i3--) {
                        l(LD(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dTm()) {
                bVar = null;
            } else if (bVar == LC(i)) {
                bVar = LD(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aik();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public class C0860a implements d<T> {
            private int mIndex;

            public C0860a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dTd()) {
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
