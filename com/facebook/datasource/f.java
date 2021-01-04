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
    private final List<j<b<T>>> puh;
    private final boolean pum;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.puh = list;
        this.pum = z;
    }

    public static <T> f<T> B(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: eux */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.puh.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.puh, ((f) obj).puh);
    }

    public String toString() {
        return com.facebook.common.internal.f.bb(this).I("list", this.puh).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> pun;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int puo;
        private int pup;
        private AtomicInteger puq;
        @Nullable
        private Throwable pur;

        public a() {
            if (!f.this.pum) {
                euB();
            }
        }

        private void euB() {
            if (this.puq == null) {
                synchronized (this) {
                    if (this.puq == null) {
                        this.puq = new AtomicInteger(0);
                        int size = f.this.puh.size();
                        this.pup = size;
                        this.puo = size;
                        this.pun = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.puh.get(i)).get();
                            this.pun.add(bVar);
                            bVar.a(new C1018a(i), com.facebook.common.b.a.etO());
                            if (bVar.eur()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Qe(int i) {
            return (this.pun == null || i >= this.pun.size()) ? null : this.pun.get(i);
        }

        @Nullable
        private synchronized b<T> Qf(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.pun != null && i < this.pun.size()) {
                    bVar = this.pun.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> euA() {
            return Qe(this.puo);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> euA;
            if (f.this.pum) {
                euB();
            }
            euA = euA();
            return euA != null ? euA.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean eur() {
            boolean z;
            if (f.this.pum) {
                euB();
            }
            b<T> euA = euA();
            if (euA != null) {
                z = euA.eur();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ath() {
            int i = 0;
            if (f.this.pum) {
                euB();
            }
            synchronized (this) {
                if (super.ath()) {
                    ArrayList<b<T>> arrayList = this.pun;
                    this.pun = null;
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
            if (bVar == euA()) {
                c((a) null, i == 0 && bVar.isFinished());
            }
            euC();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.pur = bVar.eut();
            }
            euC();
        }

        private void euC() {
            if (this.puq.incrementAndGet() == this.pup && this.pur != null) {
                u(this.pur);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.puo;
                if (bVar == Qe(i) && i != this.puo) {
                    if (euA() == null || (z && i < this.puo)) {
                        this.puo = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.puo; i3 > i; i3--) {
                        l(Qf(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == euA()) {
                bVar = null;
            } else if (bVar == Qe(i)) {
                bVar = Qf(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ath();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1018a implements d<T> {
            private int mIndex;

            public C1018a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.eur()) {
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
