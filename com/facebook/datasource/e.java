package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> ilw;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ilw = list;
    }

    public static <T> e<T> es(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bVk */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ilw.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ilw, ((e) obj).ilw);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.ilw).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> ilx = null;
        private b<T> ily = null;

        public a() {
            if (!bVl()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
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
            synchronized (this) {
                if (!super.bVg()) {
                    return false;
                }
                b<T> bVar = this.ilx;
                this.ilx = null;
                b<T> bVar2 = this.ily;
                this.ily = null;
                e(bVar2);
                e(bVar);
                return true;
            }
        }

        private boolean bVl() {
            i<b<T>> bVm = bVm();
            b<T> bVar = bVm != null ? bVm.get() : null;
            if (a(bVar) && bVar != null) {
                bVar.a(new C0356a(), com.facebook.common.b.a.bUv());
                return true;
            }
            e(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> bVm() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.ilw.size()) {
                iVar = null;
            } else {
                List list = e.this.ilw;
                int i = this.mIndex;
                this.mIndex = i + 1;
                iVar = (i) list.get(i);
            }
            return iVar;
        }

        private synchronized boolean a(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.ilx = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.ilx) {
                z = false;
            } else {
                this.ilx = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> bVn() {
            return this.ily;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.ilx && bVar != this.ily) {
                    if (this.ily == null || z) {
                        bVar2 = this.ily;
                        this.ily = bVar;
                    }
                    e(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(b<T> bVar) {
            if (b(bVar)) {
                if (bVar != bVn()) {
                    e(bVar);
                }
                if (!bVl()) {
                    t(bVar.bVf());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == bVn()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bVg();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0356a implements d<T> {
            private C0356a() {
            }

            @Override // com.facebook.datasource.d
            public void onFailure(b<T> bVar) {
                a.this.c(bVar);
            }

            @Override // com.facebook.datasource.d
            public void onCancellation(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bVd()) {
                    a.this.d(bVar);
                } else if (bVar.isFinished()) {
                    a.this.c(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.aF(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
