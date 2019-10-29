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
    private final List<i<b<T>>> kcm;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kcm = list;
    }

    public static <T> f<T> eR(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cDs */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kcm.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kcm, ((f) obj).kcm);
    }

    public String toString() {
        return com.facebook.common.internal.f.ax(this).q("list", this.kcm).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> kcr;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int kcs;

        public a() {
            int size = f.this.kcm.size();
            this.kcs = size;
            this.kcr = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.kcm.get(i)).get();
                this.kcr.add(bVar);
                bVar.a(new C0559a(i), com.facebook.common.b.a.cCF());
                if (bVar.cDm()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> Cb(int i) {
            return (this.kcr == null || i >= this.kcr.size()) ? null : this.kcr.get(i);
        }

        @Nullable
        private synchronized b<T> Cc(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.kcr != null && i < this.kcr.size()) {
                    bVar = this.kcr.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cDv() {
            return Cb(this.kcs);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cDv;
            cDv = cDv();
            return cDv != null ? cDv.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cDm() {
            boolean z;
            b<T> cDv = cDv();
            if (cDv != null) {
                z = cDv.cDm();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean FH() {
            int i = 0;
            synchronized (this) {
                if (super.FH()) {
                    ArrayList<b<T>> arrayList = this.kcr;
                    this.kcr = null;
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
            if (bVar == cDv()) {
                b((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                s(bVar.cDo());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.kcs;
                if (bVar == Cb(i) && i != this.kcs) {
                    if (cDv() == null || (z && i < this.kcs)) {
                        this.kcs = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.kcs; i3 > i; i3--) {
                        l(Cc(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cDv()) {
                bVar = null;
            } else if (bVar == Cb(i)) {
                bVar = Cc(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.FH();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0559a implements d<T> {
            private int mIndex;

            public C0559a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cDm()) {
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
