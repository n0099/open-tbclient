package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class f<T> implements i<b<T>> {
    private final List<i<b<T>>> kaA;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kaA = list;
    }

    public static <T> f<T> eF(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kaA.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kaA, ((f) obj).kaA);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.kaA).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> kaF;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int kaG;

        public a() {
            int size = f.this.kaA.size();
            this.kaG = size;
            this.kaF = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.kaA.get(i)).get();
                this.kaF.add(bVar);
                bVar.a(new C0453a(i), com.facebook.common.b.a.cEy());
                if (bVar.cFf()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> Dz(int i) {
            return (this.kaF == null || i >= this.kaF.size()) ? null : this.kaF.get(i);
        }

        @Nullable
        private synchronized b<T> DA(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.kaF != null && i < this.kaF.size()) {
                    bVar = this.kaF.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cFo() {
            return Dz(this.kaG);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cFo;
            cFo = cFo();
            return cFo != null ? cFo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cFf() {
            boolean z;
            b<T> cFo = cFo();
            if (cFo != null) {
                z = cFo.cFf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AI() {
            int i = 0;
            synchronized (this) {
                if (super.AI()) {
                    ArrayList<b<T>> arrayList = this.kaF;
                    this.kaF = null;
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
            if (bVar == cFo()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                t(bVar.cFh());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.kaG;
                if (bVar == Dz(i) && i != this.kaG) {
                    if (cFo() == null || (z && i < this.kaG)) {
                        this.kaG = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.kaG; i3 > i; i3--) {
                        l(DA(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cFo()) {
                bVar = null;
            } else if (bVar == Dz(i)) {
                bVar = DA(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.AI();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0453a implements d<T> {
            private int mIndex;

            public C0453a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cFf()) {
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
                    a.this.aX(bVar.getProgress());
                }
            }
        }
    }
}
