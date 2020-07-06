package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mJR;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mJR = list;
    }

    public static <T> e<T> fo(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dzP */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mJR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mJR, ((e) obj).mJR);
    }

    public String toString() {
        return com.facebook.common.internal.f.aO(this).F("list", this.mJR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mJS = null;
        private b<T> mJT = null;

        public a() {
            if (!dzQ()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dzS;
            dzS = dzS();
            return dzS != null ? dzS.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dzJ() {
            boolean z;
            b<T> dzS = dzS();
            if (dzS != null) {
                z = dzS.dzJ();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aam() {
            synchronized (this) {
                if (!super.aam()) {
                    return false;
                }
                b<T> bVar = this.mJS;
                this.mJS = null;
                b<T> bVar2 = this.mJT;
                this.mJT = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dzQ() {
            j<b<T>> dzR = dzR();
            b<T> bVar = dzR != null ? dzR.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0795a(), com.facebook.common.b.a.dzd());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dzR() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mJR.size()) {
                jVar = null;
            } else {
                List list = e.this.mJR;
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
                this.mJS = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mJS) {
                z = false;
            } else {
                this.mJS = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dzS() {
            return this.mJT;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mJS && bVar != this.mJT) {
                    if (this.mJT == null || z) {
                        bVar2 = this.mJT;
                        this.mJT = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dzS()) {
                    l(bVar);
                }
                if (!dzQ()) {
                    z(bVar.dzL());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dzS()) {
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
        public class C0795a implements d<T> {
            private C0795a() {
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
                if (bVar.dzJ()) {
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
