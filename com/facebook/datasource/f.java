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
    private final List<i<b<T>>> kbG;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kbG = list;
    }

    public static <T> f<T> eE(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFG */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kbG.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kbG, ((f) obj).kbG);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.kbG).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> kbL;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int kbM;

        public a() {
            int size = f.this.kbG.size();
            this.kbM = size;
            this.kbL = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.kbG.get(i)).get();
                this.kbL.add(bVar);
                bVar.a(new C0453a(i), com.facebook.common.b.a.cET());
                if (bVar.cFA()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> DB(int i) {
            return (this.kbL == null || i >= this.kbL.size()) ? null : this.kbL.get(i);
        }

        @Nullable
        private synchronized b<T> DC(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.kbL != null && i < this.kbL.size()) {
                    bVar = this.kbL.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> cFJ() {
            return DB(this.kbM);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cFJ;
            cFJ = cFJ();
            return cFJ != null ? cFJ.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cFA() {
            boolean z;
            b<T> cFJ = cFJ();
            if (cFJ != null) {
                z = cFJ.cFA();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AI() {
            int i = 0;
            synchronized (this) {
                if (super.AI()) {
                    ArrayList<b<T>> arrayList = this.kbL;
                    this.kbL = null;
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
            if (bVar == cFJ()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            l(c(i, bVar));
            if (i == 0) {
                t(bVar.cFC());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.kbM;
                if (bVar == DB(i) && i != this.kbM) {
                    if (cFJ() == null || (z && i < this.kbM)) {
                        this.kbM = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.kbM; i3 > i; i3--) {
                        l(DC(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == cFJ()) {
                bVar = null;
            } else if (bVar == DB(i)) {
                bVar = DC(i);
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
                if (bVar.cFA()) {
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
