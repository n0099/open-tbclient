package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class f<T> implements i<b<T>> {
    private final List<i<b<T>>> hZR;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.hZR = list;
    }

    public static <T> f<T> en(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bRG */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.hZR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.hZR, ((f) obj).hZR);
    }

    public String toString() {
        return com.facebook.common.internal.f.an(this).n("list", this.hZR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> hZW;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int hZX;

        public a() {
            int size = f.this.hZR.size();
            this.hZX = size;
            this.hZW = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.hZR.get(i)).get();
                this.hZW.add(bVar);
                bVar.a(new C0344a(i), com.facebook.common.b.a.bQR());
                if (bVar.bRz()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> xz(int i) {
            return (this.hZW == null || i >= this.hZW.size()) ? null : this.hZW.get(i);
        }

        @Nullable
        private synchronized b<T> xA(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.hZW != null && i < this.hZW.size()) {
                    bVar = this.hZW.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> bRJ() {
            return xz(this.hZX);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bRJ;
            bRJ = bRJ();
            return bRJ != null ? bRJ.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bRz() {
            boolean z;
            b<T> bRJ = bRJ();
            if (bRJ != null) {
                z = bRJ.bRz();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bRC() {
            int i = 0;
            synchronized (this) {
                if (super.bRC()) {
                    ArrayList<b<T>> arrayList = this.hZW;
                    this.hZW = null;
                    if (arrayList != null) {
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayList.size()) {
                                break;
                            }
                            e(arrayList.get(i2));
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
            if (bVar == bRJ()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            e(c(i, bVar));
            if (i == 0) {
                t(bVar.bRB());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.hZX;
                if (bVar == xz(i) && i != this.hZX) {
                    if (bRJ() == null || (z && i < this.hZX)) {
                        this.hZX = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.hZX; i3 > i; i3--) {
                        e(xA(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == bRJ()) {
                bVar = null;
            } else if (bVar == xz(i)) {
                bVar = xA(i);
            }
            return bVar;
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bRC();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0344a implements d<T> {
            private int mIndex;

            public C0344a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bRz()) {
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
                    a.this.aF(bVar.getProgress());
                }
            }
        }
    }
}
