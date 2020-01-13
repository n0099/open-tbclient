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
    private final List<j<b<T>>> lII;
    private final boolean lIN;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lII = list;
        this.lIN = z;
    }

    public static <T> f<T> y(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: djU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lII.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lII, ((f) obj).lII);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("list", this.lII).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> lIO;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int lIP;
        private int lIQ;
        private AtomicInteger lIR;
        @Nullable
        private Throwable lIS;

        public a() {
            if (!f.this.lIN) {
                djY();
            }
        }

        private void djY() {
            if (this.lIR == null) {
                synchronized (this) {
                    if (this.lIR == null) {
                        this.lIR = new AtomicInteger(0);
                        int size = f.this.lII.size();
                        this.lIQ = size;
                        this.lIP = size;
                        this.lIO = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.lII.get(i)).get();
                            this.lIO.add(bVar);
                            bVar.a(new C0647a(i), com.facebook.common.b.a.djj());
                            if (bVar.djO()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> Hr(int i) {
            return (this.lIO == null || i >= this.lIO.size()) ? null : this.lIO.get(i);
        }

        @Nullable
        private synchronized b<T> Hs(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.lIO != null && i < this.lIO.size()) {
                    bVar = this.lIO.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> djX() {
            return Hr(this.lIP);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> djX;
            if (f.this.lIN) {
                djY();
            }
            djX = djX();
            return djX != null ? djX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean djO() {
            boolean z;
            if (f.this.lIN) {
                djY();
            }
            b<T> djX = djX();
            if (djX != null) {
                z = djX.djO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Mn() {
            int i = 0;
            if (f.this.lIN) {
                djY();
            }
            synchronized (this) {
                if (super.Mn()) {
                    ArrayList<b<T>> arrayList = this.lIO;
                    this.lIO = null;
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
            if (bVar == djX()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            djZ();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            f(c(i, bVar));
            if (i == 0) {
                this.lIS = bVar.djQ();
            }
            djZ();
        }

        private void djZ() {
            if (this.lIR.incrementAndGet() == this.lIQ && this.lIS != null) {
                v(this.lIS);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.lIP;
                if (bVar == Hr(i) && i != this.lIP) {
                    if (djX() == null || (z && i < this.lIP)) {
                        this.lIP = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.lIP; i3 > i; i3--) {
                        f(Hs(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == djX()) {
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
                if (bVar.djO()) {
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
