package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> oMn;
    private final boolean oMs;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oMn = list;
        this.oMs = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ekH */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.oMn.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oMn, ((f) obj).oMn);
    }

    public String toString() {
        return com.facebook.common.internal.f.aZ(this).F("list", this.oMn).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> oMt;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int oMu;
        private int oMv;
        private AtomicInteger oMw;
        @Nullable
        private Throwable oMx;

        public a() {
            if (!f.this.oMs) {
                ekL();
            }
        }

        private void ekL() {
            if (this.oMw == null) {
                synchronized (this) {
                    if (this.oMw == null) {
                        this.oMw = new AtomicInteger(0);
                        int size = f.this.oMn.size();
                        this.oMv = size;
                        this.oMu = size;
                        this.oMt = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.oMn.get(i)).get();
                            this.oMt.add(bVar);
                            bVar.a(new C0969a(i), com.facebook.common.b.a.ejV());
                            if (bVar.ekB()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Ou(int i) {
            return (this.oMt == null || i >= this.oMt.size()) ? null : this.oMt.get(i);
        }

        @Nullable
        private synchronized b<T> Ov(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.oMt != null && i < this.oMt.size()) {
                    bVar = this.oMt.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> ekK() {
            return Ou(this.oMu);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> ekK;
            if (f.this.oMs) {
                ekL();
            }
            ekK = ekK();
            return ekK != null ? ekK.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean ekB() {
            boolean z;
            if (f.this.oMs) {
                ekL();
            }
            b<T> ekK = ekK();
            if (ekK != null) {
                z = ekK.ekB();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apq() {
            int i = 0;
            if (f.this.oMs) {
                ekL();
            }
            synchronized (this) {
                if (super.apq()) {
                    ArrayList<b<T>> arrayList = this.oMt;
                    this.oMt = null;
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
            if (bVar == ekK()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            ekM();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.oMx = bVar.ekD();
            }
            ekM();
        }

        private void ekM() {
            if (this.oMw.incrementAndGet() == this.oMv && this.oMx != null) {
                x(this.oMx);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.oMu;
                if (bVar == Ou(i) && i != this.oMu) {
                    if (ekK() == null || (z && i < this.oMu)) {
                        this.oMu = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.oMu; i3 > i; i3--) {
                        l(Ov(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == ekK()) {
                bVar = null;
            } else if (bVar == Ou(i)) {
                bVar = Ov(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apq();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0969a implements d<T> {
            private int mIndex;

            public C0969a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.ekB()) {
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
                    a.this.bi(bVar.getProgress());
                }
            }
        }
    }
}
