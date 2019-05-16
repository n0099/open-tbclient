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
    private final List<i<b<T>>> jTs;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jTs = list;
    }

    public static <T> f<T> eC(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jTs.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jTs, ((f) obj).jTs);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.jTs).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> jTx;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int jTy;

        public a() {
            int size = f.this.jTs.size();
            this.jTy = size;
            this.jTx = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.jTs.get(i)).get();
                this.jTx.add(bVar);
                bVar.a(new C0448a(i), com.facebook.common.b.a.cBw());
                if (bVar.cCd()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> CS(int i) {
            return (this.jTx == null || i >= this.jTx.size()) ? null : this.jTx.get(i);
        }

        @Nullable
        private synchronized b<T> CT(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.jTx != null && i < this.jTx.size()) {
                    bVar = this.jTx.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cCm() {
            return CS(this.jTy);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cCm;
            cCm = cCm();
            return cCm != null ? cCm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cCd() {
            boolean z;
            b<T> cCm = cCm();
            if (cCm != null) {
                z = cCm.cCd();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Ab() {
            int i = 0;
            synchronized (this) {
                if (super.Ab()) {
                    ArrayList<b<T>> arrayList = this.jTx;
                    this.jTx = null;
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
            if (bVar == cCm()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                t(bVar.cCf());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.jTy;
                if (bVar == CS(i) && i != this.jTy) {
                    if (cCm() == null || (z && i < this.jTy)) {
                        this.jTy = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.jTy; i3 > i; i3--) {
                        l(CT(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cCm()) {
                bVar = null;
            } else if (bVar == CS(i)) {
                bVar = CT(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Ab();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0448a implements d<T> {
            private int mIndex;

            public C0448a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cCd()) {
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
                    a.this.aW(bVar.getProgress());
                }
            }
        }
    }
}
