package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mRU;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mRU = list;
    }

    public static <T> e<T> fx(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDb */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mRU.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mRU, ((e) obj).mRU);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mRU).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mRV = null;
        private b<T> mRW = null;

        public a() {
            if (!dDc()) {
                y(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dDe;
            dDe = dDe();
            return dDe != null ? dDe.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dCV() {
            boolean z;
            b<T> dDe = dDe();
            if (dDe != null) {
                z = dDe.dCV();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean abo() {
            synchronized (this) {
                if (!super.abo()) {
                    return false;
                }
                b<T> bVar = this.mRV;
                this.mRV = null;
                b<T> bVar2 = this.mRW;
                this.mRW = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dDc() {
            j<b<T>> dDd = dDd();
            b<T> bVar = dDd != null ? dDd.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0804a(), com.facebook.common.b.a.dCp());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dDd() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mRU.size()) {
                jVar = null;
            } else {
                List list = e.this.mRU;
                int i = this.mIndex;
                this.mIndex = i + 1;
                jVar = (j) list.get(i);
            }
            return jVar;
        }

        private synchronized boolean h(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.mRV = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mRV) {
                z = false;
            } else {
                this.mRV = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dDe() {
            return this.mRW;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mRV && bVar != this.mRW) {
                    if (this.mRW == null || z) {
                        bVar2 = this.mRW;
                        this.mRW = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dDe()) {
                    l(bVar);
                }
                if (!dDc()) {
                    y(bVar.dCX());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dDe()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.abo();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0804a implements d<T> {
            private C0804a() {
            }

            @Override // com.facebook.datasource.d
            public void e(b<T> bVar) {
                a.this.j(bVar);
            }

            @Override // com.facebook.datasource.d
            public void b(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dCV()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aD(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
