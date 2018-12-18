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
    private final List<i<b<T>>> ihe;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ihe = list;
    }

    public static <T> f<T> er(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bTL */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ihe.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ihe, ((f) obj).ihe);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.ihe).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> ihj;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int ihk;

        public a() {
            int size = f.this.ihe.size();
            this.ihk = size;
            this.ihj = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.ihe.get(i)).get();
                this.ihj.add(bVar);
                bVar.a(new C0358a(i), com.facebook.common.b.a.bSW());
                if (bVar.bTE()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> xW(int i) {
            return (this.ihj == null || i >= this.ihj.size()) ? null : this.ihj.get(i);
        }

        @Nullable
        private synchronized b<T> xX(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.ihj != null && i < this.ihj.size()) {
                    bVar = this.ihj.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> bTO() {
            return xW(this.ihk);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bTO;
            bTO = bTO();
            return bTO != null ? bTO.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bTE() {
            boolean z;
            b<T> bTO = bTO();
            if (bTO != null) {
                z = bTO.bTE();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bTH() {
            int i = 0;
            synchronized (this) {
                if (super.bTH()) {
                    ArrayList<b<T>> arrayList = this.ihj;
                    this.ihj = null;
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
            if (bVar == bTO()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            e(c(i, bVar));
            if (i == 0) {
                t(bVar.bTG());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.ihk;
                if (bVar == xW(i) && i != this.ihk) {
                    if (bTO() == null || (z && i < this.ihk)) {
                        this.ihk = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.ihk; i3 > i; i3--) {
                        e(xX(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == bTO()) {
                bVar = null;
            } else if (bVar == xW(i)) {
                bVar = xX(i);
            }
            return bVar;
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bTH();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0358a implements d<T> {
            private int mIndex;

            public C0358a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bTE()) {
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
