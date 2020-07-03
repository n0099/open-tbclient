package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mJO;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mJO = list;
    }

    public static <T> e<T> fo(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dzL */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mJO.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mJO, ((e) obj).mJO);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mJO).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mJP = null;
        private b<T> mJQ = null;

        public a() {
            if (!dzM()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dzO;
            dzO = dzO();
            return dzO != null ? dzO.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dzF() {
            boolean z;
            b<T> dzO = dzO();
            if (dzO != null) {
                z = dzO.dzF();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aam() {
            synchronized (this) {
                if (!super.aam()) {
                    return false;
                }
                b<T> bVar = this.mJP;
                this.mJP = null;
                b<T> bVar2 = this.mJQ;
                this.mJQ = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dzM() {
            j<b<T>> dzN = dzN();
            b<T> bVar = dzN != null ? dzN.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0794a(), com.facebook.common.b.a.dyZ());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dzN() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mJO.size()) {
                jVar = null;
            } else {
                List list = e.this.mJO;
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
                this.mJP = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mJP) {
                z = false;
            } else {
                this.mJP = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dzO() {
            return this.mJQ;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mJP && bVar != this.mJQ) {
                    if (this.mJQ == null || z) {
                        bVar2 = this.mJQ;
                        this.mJQ = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dzO()) {
                    l(bVar);
                }
                if (!dzM()) {
                    z(bVar.dzH());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dzO()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aam();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0794a implements d<T> {
            private C0794a() {
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
                if (bVar.dzF()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aE(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
