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
    private final List<i<b<T>>> ilv;

    private f(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ilv = list;
    }

    public static <T> f<T> et(List<i<b<T>>> list) {
        return new f<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bVk */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ilv.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ilv, ((f) obj).ilv);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.ilv).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable
        private ArrayList<b<T>> ilA;
        @GuardedBy("IncreasingQualityDataSource.this")
        private int ilB;

        public a() {
            int size = f.this.ilv.size();
            this.ilB = size;
            this.ilA = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                b<T> bVar = (b) ((i) f.this.ilv.get(i)).get();
                this.ilA.add(bVar);
                bVar.a(new C0357a(i), com.facebook.common.b.a.bUv());
                if (bVar.bVd()) {
                    return;
                }
            }
        }

        @Nullable
        private synchronized b<T> yl(int i) {
            return (this.ilA == null || i >= this.ilA.size()) ? null : this.ilA.get(i);
        }

        @Nullable
        private synchronized b<T> ym(int i) {
            b<T> bVar = null;
            synchronized (this) {
                if (this.ilA != null && i < this.ilA.size()) {
                    bVar = this.ilA.set(i, null);
                }
            }
            return bVar;
        }

        @Nullable
        private synchronized b<T> bVn() {
            return yl(this.ilB);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bVn;
            bVn = bVn();
            return bVn != null ? bVn.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bVd() {
            boolean z;
            b<T> bVn = bVn();
            if (bVn != null) {
                z = bVn.bVd();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bVg() {
            int i = 0;
            synchronized (this) {
                if (super.bVg()) {
                    ArrayList<b<T>> arrayList = this.ilA;
                    this.ilA = null;
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
            if (bVar == bVn()) {
                a((a) null, i == 0 && bVar.isFinished());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, b<T> bVar) {
            e(c(i, bVar));
            if (i == 0) {
                t(bVar.bVf());
            }
        }

        private void a(int i, b<T> bVar, boolean z) {
            synchronized (this) {
                int i2 = this.ilB;
                if (bVar == yl(i) && i != this.ilB) {
                    if (bVn() == null || (z && i < this.ilB)) {
                        this.ilB = i;
                    } else {
                        i = i2;
                    }
                    for (int i3 = this.ilB; i3 > i; i3--) {
                        e(ym(i3));
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> c(int i, b<T> bVar) {
            if (bVar == bVn()) {
                bVar = null;
            } else if (bVar == yl(i)) {
                bVar = ym(i);
            }
            return bVar;
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bVg();
            }
        }

        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0357a implements d<T> {
            private int mIndex;

            public C0357a(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bVd()) {
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
