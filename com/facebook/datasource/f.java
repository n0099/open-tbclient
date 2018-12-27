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
    private final List<i<b<T>>> iko;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.iko = list;
    }

    public static <T> f<T> es(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bUC */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.iko.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.iko, ((f) obj).iko);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.iko).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> ikt;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int iku;

        public a() {
            int size = f.this.iko.size();
            this.iku = size;
            this.ikt = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.iko.get(i)).get();
                this.ikt.add(bVar);
                bVar.a(new C0358a(i), com.facebook.common.b.a.bTN());
                if (bVar.bUv()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> yj(int i) {
            return (this.ikt == null || i >= this.ikt.size()) ? null : this.ikt.get(i);
        }

        @Nullable
        private synchronized b<T> yk(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.ikt != null && i < this.ikt.size()) {
                    bVar = this.ikt.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> bUF() {
            return yj(this.iku);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bUF;
            bUF = bUF();
            return bUF != null ? bUF.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bUv() {
            boolean z;
            b<T> bUF = bUF();
            if (bUF != null) {
                z = bUF.bUv();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bUy() {
            int i = 0;
            synchronized (this) {
                if (super.bUy()) {
                    ArrayList<b<T>> arrayList = this.ikt;
                    this.ikt = null;
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
            if (bVar == bUF()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            e(c(i, bVar));
            if (i == 0) {
                t(bVar.bUx());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.iku;
                if (bVar == yj(i) && i != this.iku) {
                    if (bUF() == null || (z && i < this.iku)) {
                        this.iku = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.iku; i3 > i; i3--) {
                        e(yk(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == bUF()) {
                bVar = null;
            } else if (bVar == yj(i)) {
                bVar = yk(i);
            }
            return bVar;
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bUy();
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
                if (bVar.bUv()) {
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
