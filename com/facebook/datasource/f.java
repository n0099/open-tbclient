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
    private final List<i<b<T>>> hYg;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.hYg = list;
    }

    public static <T> f<T> ep(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bSl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.hYg.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.hYg, ((f) obj).hYg);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.hYg).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> hYl;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int hYm;

        public a() {
            int size = f.this.hYg.size();
            this.hYm = size;
            this.hYl = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.hYg.get(i)).get();
                this.hYl.add(bVar);
                bVar.a(new C0316a(i), com.facebook.common.b.a.bRw());
                if (bVar.bSe()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> xg(int i) {
            return (this.hYl == null || i >= this.hYl.size()) ? null : this.hYl.get(i);
        }

        @Nullable
        private synchronized b<T> xh(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.hYl != null && i < this.hYl.size()) {
                    bVar = this.hYl.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> bSo() {
            return xg(this.hYm);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bSo;
            bSo = bSo();
            return bSo != null ? bSo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bSe() {
            boolean z;
            b<T> bSo = bSo();
            if (bSo != null) {
                z = bSo.bSe();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bSh() {
            int i = 0;
            synchronized (this) {
                if (super.bSh()) {
                    ArrayList<b<T>> arrayList = this.hYl;
                    this.hYl = null;
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
            if (bVar == bSo()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            e(c(i, bVar));
            if (i == 0) {
                t(bVar.bSg());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.hYm;
                if (bVar == xg(i) && i != this.hYm) {
                    if (bSo() == null || (z && i < this.hYm)) {
                        this.hYm = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.hYm; i3 > i; i3--) {
                        e(xh(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == bSo()) {
                bVar = null;
            } else if (bVar == xg(i)) {
                bVar = xh(i);
            }
            return bVar;
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bSh();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0316a implements d<T> {
            private int mIndex;

            public C0316a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bSe()) {
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
                    a.this.aD(bVar.getProgress());
                }
            }
        }
    }
}
