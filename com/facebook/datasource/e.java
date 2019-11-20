package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> kbv;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kbv = list;
    }

    public static <T> e<T> eQ(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cDq */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kbv.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kbv, ((e) obj).kbv);
    }

    public String toString() {
        return com.facebook.common.internal.f.ax(this).q("list", this.kbv).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> kbw = null;
        private b<T> kbx = null;

        public a() {
            if (!cDr()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cDt;
            cDt = cDt();
            return cDt != null ? cDt.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cDk() {
            boolean z;
            b<T> cDt = cDt();
            if (cDt != null) {
                z = cDt.cDk();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean FI() {
            synchronized (this) {
                if (!super.FI()) {
                    return false;
                }
                b<T> bVar = this.kbw;
                this.kbw = null;
                b<T> bVar2 = this.kbx;
                this.kbx = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cDr() {
            i<b<T>> cDs = cDs();
            b<T> bVar = cDs != null ? cDs.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0558a(), com.facebook.common.b.a.cCD());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cDs() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.kbv.size()) {
                iVar = null;
            } else {
                List list = e.this.kbv;
                int i = this.mIndex;
                this.mIndex = i + 1;
                iVar = (i) list.get(i);
            }
            return iVar;
        }

        private synchronized boolean h(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.kbw = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.kbw) {
                z = false;
            } else {
                this.kbw = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cDt() {
            return this.kbx;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.kbw && bVar != this.kbx) {
                    if (this.kbx == null || z) {
                        bVar2 = this.kbx;
                        this.kbx = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cDt()) {
                    l(bVar);
                }
                if (!cDr()) {
                    t(bVar.cDm());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == cDt()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.FI();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0558a implements d<T> {
            private C0558a() {
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
                if (bVar.cDk()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aB(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
