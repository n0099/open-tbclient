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
    private final List<i<b<T>>> jAD;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jAD = list;
    }

    public static <T> f<T> eu(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cun */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jAD.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jAD, ((f) obj).jAD);
    }

    public String toString() {
        return com.facebook.common.internal.f.aA(this).q(IntentConfig.LIST, this.jAD).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> jAI;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int jAJ;

        public a() {
            int size = f.this.jAD.size();
            this.jAJ = size;
            this.jAI = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.jAD.get(i)).get();
                this.jAI.add(bVar);
                bVar.a(new C0429a(i), com.facebook.common.b.a.ctz());
                if (bVar.cuh()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> BO(int i) {
            return (this.jAI == null || i >= this.jAI.size()) ? null : this.jAI.get(i);
        }

        @Nullable
        private synchronized b<T> BP(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.jAI != null && i < this.jAI.size()) {
                    bVar = this.jAI.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cuq() {
            return BO(this.jAJ);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cuq;
            cuq = cuq();
            return cuq != null ? cuq.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cuh() {
            boolean z;
            b<T> cuq = cuq();
            if (cuq != null) {
                z = cuq.cuh();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean ze() {
            int i = 0;
            synchronized (this) {
                if (super.ze()) {
                    ArrayList<b<T>> arrayList = this.jAI;
                    this.jAI = null;
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
            if (bVar == cuq()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                u(bVar.cuj());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.jAJ;
                if (bVar == BO(i) && i != this.jAJ) {
                    if (cuq() == null || (z && i < this.jAJ)) {
                        this.jAJ = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.jAJ; i3 > i; i3--) {
                        l(BP(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cuq()) {
                bVar = null;
            } else if (bVar == BO(i)) {
                bVar = BP(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.ze();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0429a implements d<T> {
            private int mIndex;

            public C0429a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cuh()) {
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
                    a.this.aS(bVar.getProgress());
                }
            }
        }
    }
}
