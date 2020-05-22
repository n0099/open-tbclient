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
    private final List<j<b<T>>> mmE;
    private final boolean mmJ;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mmE = list;
        this.mmJ = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: duU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mmE.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mmE, ((f) obj).mmE);
    }

    public String toString() {
        return com.facebook.common.internal.f.aN(this).F("list", this.mmE).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mmK;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mmL;
        private int mmM;
        private AtomicInteger mmN;
        @Nullable
        private Throwable mmO;

        public a() {
            if (!f.this.mmJ) {
                duY();
            }
        }

        private void duY() {
            if (this.mmN == null) {
                synchronized (this) {
                    if (this.mmN == null) {
                        this.mmN = new AtomicInteger(0);
                        int size = f.this.mmE.size();
                        this.mmM = size;
                        this.mmL = size;
                        this.mmK = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mmE.get(i)).get();
                            this.mmK.add(bVar);
                            bVar.a(new C0775a(i), com.facebook.common.b.a.dui());
                            if (bVar.duO()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> GP(int i) {
            return (this.mmK == null || i >= this.mmK.size()) ? null : this.mmK.get(i);
        }

        @Nullable
        private synchronized b<T> GQ(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mmK != null && i < this.mmK.size()) {
                    bVar = this.mmK.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> duX() {
            return GP(this.mmL);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> duX;
            if (f.this.mmJ) {
                duY();
            }
            duX = duX();
            return duX != null ? duX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean duO() {
            boolean z;
            if (f.this.mmJ) {
                duY();
            }
            b<T> duX = duX();
            if (duX != null) {
                z = duX.duO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Zg() {
            int i = 0;
            if (f.this.mmJ) {
                duY();
            }
            synchronized (this) {
                if (super.Zg()) {
                    ArrayList<b<T>> arrayList = this.mmK;
                    this.mmK = null;
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
            if (bVar == duX()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            duZ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mmO = bVar.duQ();
            }
            duZ();
        }

        private void duZ() {
            if (this.mmN.incrementAndGet() == this.mmM && this.mmO != null) {
                z(this.mmO);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mmL;
                if (bVar == GP(i) && i != this.mmL) {
                    if (duX() == null || (z && i < this.mmL)) {
                        this.mmL = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mmL; i3 > i; i3--) {
                        l(GQ(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == duX()) {
                bVar = null;
            } else if (bVar == GP(i)) {
                bVar = GQ(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Zg();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0775a implements d<T> {
            private int mIndex;

            public C0775a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.duO()) {
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
                    a.this.ay(bVar.getProgress());
                }
            }
        }
    }
}
