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
    private final List<i<b<T>>> kbv;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kbv = list;
    }

    public static <T> f<T> eR(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cDq */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kbv.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kbv, ((f) obj).kbv);
    }

    public String toString() {
        return com.facebook.common.internal.f.ax(this).q("list", this.kbv).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> kbA;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int kbB;

        public a() {
            int size = f.this.kbv.size();
            this.kbB = size;
            this.kbA = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.kbv.get(i)).get();
                this.kbA.add(bVar);
                bVar.a(new C0554a(i), com.facebook.common.b.a.cCD());
                if (bVar.cDk()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> Ca(int i) {
            return (this.kbA == null || i >= this.kbA.size()) ? null : this.kbA.get(i);
        }

        @Nullable
        private synchronized b<T> Cb(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.kbA != null && i < this.kbA.size()) {
                    bVar = this.kbA.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cDt() {
            return Ca(this.kbB);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cDt;
            cDt = cDt();
            return cDt != null ? cDt.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cDk() {
            boolean z;
            b<T> cDt = cDt();
            if (cDt != null) {
                z = cDt.cDk();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean FI() {
            int i = 0;
            synchronized (this) {
                if (super.FI()) {
                    ArrayList<b<T>> arrayList = this.kbA;
                    this.kbA = null;
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
            if (bVar == cDt()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                t(bVar.cDm());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.kbB;
                if (bVar == Ca(i) && i != this.kbB) {
                    if (cDt() == null || (z && i < this.kbB)) {
                        this.kbB = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.kbB; i3 > i; i3--) {
                        l(Cb(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cDt()) {
                bVar = null;
            } else if (bVar == Ca(i)) {
                bVar = Cb(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.FI();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0554a implements d<T> {
            private int mIndex;

            public C0554a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cDk()) {
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
                    a.this.aB(bVar.getProgress());
                }
            }
        }
    }
}
