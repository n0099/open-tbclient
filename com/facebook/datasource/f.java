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
    private final List<i<b<T>>> ked;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ked = list;
    }

    public static <T> f<T> eE(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cGu */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ked.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ked, ((f) obj).ked);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.ked).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> kei;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int kej;

        public a() {
            int size = f.this.ked.size();
            this.kej = size;
            this.kei = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.ked.get(i)).get();
                this.kei.add(bVar);
                bVar.a(new C0464a(i), com.facebook.common.b.a.cFH());
                if (bVar.cGo()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> DF(int i) {
            return (this.kei == null || i >= this.kei.size()) ? null : this.kei.get(i);
        }

        @Nullable
        private synchronized b<T> DG(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.kei != null && i < this.kei.size()) {
                    bVar = this.kei.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cGx() {
            return DF(this.kej);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cGx;
            cGx = cGx();
            return cGx != null ? cGx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cGo() {
            boolean z;
            b<T> cGx = cGx();
            if (cGx != null) {
                z = cGx.cGo();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AM() {
            int i = 0;
            synchronized (this) {
                if (super.AM()) {
                    ArrayList<b<T>> arrayList = this.kei;
                    this.kei = null;
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
            if (bVar == cGx()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                t(bVar.cGq());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.kej;
                if (bVar == DF(i) && i != this.kej) {
                    if (cGx() == null || (z && i < this.kej)) {
                        this.kej = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.kej; i3 > i; i3--) {
                        l(DG(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cGx()) {
                bVar = null;
            } else if (bVar == DF(i)) {
                bVar = DG(i);
            }
            return bVar;
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.AM();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0464a implements d<T> {
            private int mIndex;

            public C0464a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.cGo()) {
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
                    a.this.aY(bVar.getProgress());
                }
            }
        }
    }
}
