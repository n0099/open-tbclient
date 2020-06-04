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
    private final List<j<b<T>>> mnO;
    private final boolean mnT;

    private f(List<j<b<T>>> list, boolean z) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mnO = list;
        this.mnT = z;
    }

    public static <T> f<T> x(List<j<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dvi */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mnO.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mnO, ((f) obj).mnO);
    }

    public String toString() {
        return com.facebook.common.internal.f.aN(this).F("list", this.mnO).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> mnU;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int mnV;
        private int mnW;
        private AtomicInteger mnX;
        @Nullable
        private Throwable mnY;

        public a() {
            if (!f.this.mnT) {
                dvm();
            }
        }

        private void dvm() {
            if (this.mnX == null) {
                synchronized (this) {
                    if (this.mnX == null) {
                        this.mnX = new AtomicInteger(0);
                        int size = f.this.mnO.size();
                        this.mnW = size;
                        this.mnV = size;
                        this.mnU = new ArrayList<>(size);
                        for (int i = 0; i < size; i++) {
                            b<T> bVar = (b) ((j) f.this.mnO.get(i)).get();
                            this.mnU.add(bVar);
                            bVar.a(new C0776a(i), com.facebook.common.b.a.duw());
                            if (bVar.dvc()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> GR(int i) {
            return (this.mnU == null || i >= this.mnU.size()) ? null : this.mnU.get(i);
        }

        @Nullable
        private synchronized b<T> GS(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.mnU != null && i < this.mnU.size()) {
                    bVar = this.mnU.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> dvl() {
            return GR(this.mnV);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dvl;
            if (f.this.mnT) {
                dvm();
            }
            dvl = dvl();
            return dvl != null ? dvl.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dvc() {
            boolean z;
            if (f.this.mnT) {
                dvm();
            }
            b<T> dvl = dvl();
            if (dvl != null) {
                z = dvl.dvc();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Zg() {
            int i = 0;
            if (f.this.mnT) {
                dvm();
            }
            synchronized (this) {
                if (super.Zg()) {
                    ArrayList<b<T>> arrayList = this.mnU;
                    this.mnU = null;
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
            if (bVar == dvl()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
            dvn();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                this.mnY = bVar.dve();
            }
            dvn();
        }

        private void dvn() {
            if (this.mnX.incrementAndGet() == this.mnW && this.mnY != null) {
                z(this.mnY);
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.mnV;
                if (bVar == GR(i) && i != this.mnV) {
                    if (dvl() == null || (z && i < this.mnV)) {
                        this.mnV = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.mnV; i3 > i; i3--) {
                        l(GS(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == dvl()) {
                bVar = null;
            } else if (bVar == GR(i)) {
                bVar = GS(i);
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
        public class C0776a implements d<T> {
            private int mIndex;

            public C0776a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dvc()) {
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
