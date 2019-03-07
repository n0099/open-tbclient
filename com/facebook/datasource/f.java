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
    private final List<i<b<T>>> jAX;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jAX = list;
    }

    public static <T> f<T> ex(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuh */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jAX.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jAX, ((f) obj).jAX);
    }

    public String toString() {
        return com.facebook.common.internal.f.aD(this).q(IntentConfig.LIST, this.jAX).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> jBc;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int jBd;

        public a() {
            int size = f.this.jAX.size();
            this.jBd = size;
            this.jBc = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.jAX.get(i)).get();
                this.jBc.add(bVar);
                bVar.a(new C0333a(i), com.facebook.common.b.a.ctt());
                if (bVar.cub()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> BX(int i) {
            return (this.jBc == null || i >= this.jBc.size()) ? null : this.jBc.get(i);
        }

        @Nullable
        private synchronized b<T> BY(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.jBc != null && i < this.jBc.size()) {
                    bVar = this.jBc.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cuk() {
            return BX(this.jBd);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cuk;
            cuk = cuk();
            return cuk != null ? cuk.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cub() {
            boolean z;
            b<T> cuk = cuk();
            if (cuk != null) {
                z = cuk.cub();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean zf() {
            int i = 0;
            synchronized (this) {
                if (super.zf()) {
                    ArrayList<b<T>> arrayList = this.jBc;
                    this.jBc = null;
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
            if (bVar == cuk()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                u(bVar.cud());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.jBd;
                if (bVar == BX(i) && i != this.jBd) {
                    if (cuk() == null || (z && i < this.jBd)) {
                        this.jBd = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.jBd; i3 > i; i3--) {
                        l(BY(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cuk()) {
                bVar = null;
            } else if (bVar == BX(i)) {
                bVar = BY(i);
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
        private class C0333a implements d<T> {
            private int mIndex;

            public C0333a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cub()) {
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
