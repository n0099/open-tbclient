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
    private final List<j<b<T>>> lIN;
    private final boolean lIS;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lIN = list;
        this.lIS = z;
    }

    public static <T> f<T> y(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: djW */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lIN.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lIN, ((f) obj).lIN);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("list", this.lIN).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lIT;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lIU;
        private int lIV;
        private AtomicInteger lIW;
        @Nullable
        private Throwable lIX;

        public a() {
            if (!f.this.lIS) {
                dka();
            }
        }

        private void dka() {
            if (this.lIW == null) {
                synchronized (this) {
                    if (this.lIW == null) {
                        this.lIW = new AtomicInteger(0);
                        int size = f.this.lIN.size();
                        this.lIV = size;
                        this.lIU = size;
                        this.lIT = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lIN.get(i)).get();
                            this.lIT.add(bVar);
                            bVar.a(new C0647a(i), com.facebook.common.b.a.djl());
                            if (bVar.djQ()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hr(int i) {
            return (this.lIT == null || i >= this.lIT.size()) ? null : this.lIT.get(i);
        }

        @Nullable
        private synchronized b<T> Hs(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lIT != null && i < this.lIT.size()) {
                    bVar = this.lIT.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> djZ() {
            return Hr(this.lIU);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> djZ;
            if (f.this.lIS) {
                dka();
            }
            djZ = djZ();
            return djZ != null ? djZ.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean djQ() {
            boolean z;
            if (f.this.lIS) {
                dka();
            }
            b<T> djZ = djZ();
            if (djZ != null) {
                z = djZ.djQ();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Mn() {
            int i = 0;
            if (f.this.lIS) {
                dka();
            }
            synchronized (this) {
                if (super.Mn()) {
                    ArrayList<b<T>> arrayList = this.lIT;
                    this.lIT = null;
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
            if (bVar == djZ()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dkb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lIX = bVar.djS();
            }
            dkb();
        }

        private void dkb() {
            if (this.lIW.incrementAndGet() == this.lIV && this.lIX != null) {
                v(this.lIX);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lIU;
                if (bVar == Hr(i) && i != this.lIU) {
                    if (djZ() == null || (z && i < this.lIU)) {
                        this.lIU = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lIU; i3 > i; i3--) {
                        f(Hs(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == djZ()) {
                bVar = null;
            } else if (bVar == Hr(i)) {
                bVar = Hs(i);
            }
            return bVar;
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.Mn();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0647a implements d<T> {
            private int mIndex;

            public C0647a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.djQ()) {
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
                    a.this.bk(bVar.getProgress());
                }
            }
        }
    }
}
