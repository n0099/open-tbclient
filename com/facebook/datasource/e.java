package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> nLB;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.nLB = list;
    }

    public static <T> e<T> fT(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dWU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.nLB.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.nLB, ((e) obj).nLB);
    }

    public String toString() {
        return com.facebook.common.internal.f.aV(this).F("list", this.nLB).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> nLC = null;
        private b<T> nLD = null;

        public a() {
            if (!dWV()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dWX;
            dWX = dWX();
            return dWX != null ? dWX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dWO() {
            boolean z;
            b<T> dWX = dWX();
            if (dWX != null) {
                z = dWX.dWO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean akV() {
            synchronized (this) {
                if (!super.akV()) {
                    return false;
                }
                b<T> bVar = this.nLC;
                this.nLC = null;
                b<T> bVar2 = this.nLD;
                this.nLD = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dWV() {
            j<b<T>> dWW = dWW();
            b<T> bVar = dWW != null ? dWW.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0877a(), com.facebook.common.b.a.dWi());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dWW() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.nLB.size()) {
                jVar = null;
            } else {
                List list = e.this.nLB;
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
                this.nLC = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.nLC) {
                z = false;
            } else {
                this.nLC = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dWX() {
            return this.nLD;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.nLC && bVar != this.nLD) {
                    if (this.nLD == null || z) {
                        bVar2 = this.nLD;
                        this.nLD = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dWX()) {
                    l(bVar);
                }
                if (!dWV()) {
                    x(bVar.dWQ());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dWX()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.akV();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0877a implements d<T> {
            private C0877a() {
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
                if (bVar.dWO()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aP(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
