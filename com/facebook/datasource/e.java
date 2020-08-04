package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mRW;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mRW = list;
    }

    public static <T> e<T> fx(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dDc */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mRW.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mRW, ((e) obj).mRW);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mRW).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mRX = null;
        private b<T> mRY = null;

        public a() {
            if (!dDd()) {
                y(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dDf;
            dDf = dDf();
            return dDf != null ? dDf.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dCW() {
            boolean z;
            b<T> dDf = dDf();
            if (dDf != null) {
                z = dDf.dCW();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean abo() {
            synchronized (this) {
                if (!super.abo()) {
                    return false;
                }
                b<T> bVar = this.mRX;
                this.mRX = null;
                b<T> bVar2 = this.mRY;
                this.mRY = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dDd() {
            j<b<T>> dDe = dDe();
            b<T> bVar = dDe != null ? dDe.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0804a(), com.facebook.common.b.a.dCq());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dDe() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mRW.size()) {
                jVar = null;
            } else {
                List list = e.this.mRW;
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
                this.mRX = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mRX) {
                z = false;
            } else {
                this.mRX = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dDf() {
            return this.mRY;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mRX && bVar != this.mRY) {
                    if (this.mRY == null || z) {
                        bVar2 = this.mRY;
                        this.mRY = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dDf()) {
                    l(bVar);
                }
                if (!dDd()) {
                    y(bVar.dCY());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dDf()) {
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
                if (bVar.dCW()) {
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
