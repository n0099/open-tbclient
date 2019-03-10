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
    private final List<i<b<T>>> jBq;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jBq = list;
    }

    public static <T> f<T> ex(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cur */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jBq.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jBq, ((f) obj).jBq);
    }

    public String toString() {
        return com.facebook.common.internal.f.aE(this).q(IntentConfig.LIST, this.jBq).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> jBv;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int jBw;

        public a() {
            int size = f.this.jBq.size();
            this.jBw = size;
            this.jBv = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.jBq.get(i)).get();
                this.jBv.add(bVar);
                bVar.a(new C0336a(i), com.facebook.common.b.a.ctD());
                if (bVar.cul()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> BY(int i) {
            return (this.jBv == null || i >= this.jBv.size()) ? null : this.jBv.get(i);
        }

        @Nullable
        private synchronized b<T> BZ(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.jBv != null && i < this.jBv.size()) {
                    bVar = this.jBv.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cuu() {
            return BY(this.jBw);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cuu;
            cuu = cuu();
            return cuu != null ? cuu.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cul() {
            boolean z;
            b<T> cuu = cuu();
            if (cuu != null) {
                z = cuu.cul();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean zf() {
            int i = 0;
            synchronized (this) {
                if (super.zf()) {
                    ArrayList<b<T>> arrayList = this.jBv;
                    this.jBv = null;
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
            if (bVar == cuu()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                u(bVar.cun());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.jBw;
                if (bVar == BY(i) && i != this.jBw) {
                    if (cuu() == null || (z && i < this.jBw)) {
                        this.jBw = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.jBw; i3 > i; i3--) {
                        l(BZ(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cuu()) {
                bVar = null;
            } else if (bVar == BY(i)) {
                bVar = BZ(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.zf();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0336a implements d<T> {
            private int mIndex;

            public C0336a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cul()) {
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
