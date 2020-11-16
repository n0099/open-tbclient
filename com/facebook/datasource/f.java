package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class f<T> implements j<b<T>> {
    private final List<j<b<T>>> oNR;
    private final boolean oNW;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oNR = list;
        this.oNW = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ekF */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.oNR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oNR, ((f) obj).oNR);
    }

    public String toString() {
        return com.facebook.common.internal.f.ba(this).F("list", this.oNR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> oNX;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int oNY;
        private int oNZ;
        private AtomicInteger oOa;
        @Nullable
        private Throwable oOb;

        public a() {
            if (!f.this.oNW) {
                ekJ();
            }
        }

        private void ekJ() {
            if (this.oOa == null) {
                synchronized (this) {
                    if (this.oOa == null) {
                        this.oOa = new AtomicInteger(0);
                        int size = f.this.oNR.size();
                        this.oNZ = size;
                        this.oNY = size;
                        this.oNX = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.oNR.get(i)).get();
                            this.oNX.add(bVar);
                            bVar.a(new C0972a(i), com.facebook.common.b.a.ejT());
                            if (bVar.ekz()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> OX(int i) {
            return (this.oNX == null || i >= this.oNX.size()) ? null : this.oNX.get(i);
        }

        @Nullable
        private synchronized b<T> OY(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.oNX != null && i < this.oNX.size()) {
                    bVar = this.oNX.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> ekI() {
            return OX(this.oNY);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> ekI;
            if (f.this.oNW) {
                ekJ();
            }
            ekI = ekI();
            return ekI != null ? ekI.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean ekz() {
            boolean z;
            if (f.this.oNW) {
                ekJ();
            }
            b<T> ekI = ekI();
            if (ekI != null) {
                z = ekI.ekz();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aoH() {
            int i = 0;
            if (f.this.oNW) {
                ekJ();
            }
            synchronized (this) {
                if (super.aoH()) {
                    ArrayList<b<T>> arrayList = this.oNX;
                    this.oNX = null;
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
            if (bVar == ekI()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            ekK();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.oOb = bVar.ekB();
            }
            ekK();
        }

        private void ekK() {
            if (this.oOa.incrementAndGet() == this.oNZ && this.oOb != null) {
                x(this.oOb);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.oNY;
                if (bVar == OX(i) && i != this.oNY) {
                    if (ekI() == null || (z && i < this.oNY)) {
                        this.oNY = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.oNY; i3 > i; i3--) {
                        l(OY(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == ekI()) {
                bVar = null;
            } else if (bVar == OX(i)) {
                bVar = OY(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aoH();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0972a implements d<T> {
            private int mIndex;

            public C0972a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.ekz()) {
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
                    a.this.bp(bVar.getProgress());
                }
            }
        }
    }
}
