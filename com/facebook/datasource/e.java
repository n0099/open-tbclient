package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> oMn;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oMn = list;
    }

    public static <T> e<T> gy(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ekH */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.oMn.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oMn, ((e) obj).oMn);
    }

    public String toString() {
        return com.facebook.common.internal.f.aZ(this).F("list", this.oMn).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes6.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> oMo = null;
        private b<T> oMp = null;

        public a() {
            if (!ekI()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> ekK;
            ekK = ekK();
            return ekK != null ? ekK.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean ekB() {
            boolean z;
            b<T> ekK = ekK();
            if (ekK != null) {
                z = ekK.ekB();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean apq() {
            synchronized (this) {
                if (!super.apq()) {
                    return false;
                }
                b<T> bVar = this.oMo;
                this.oMo = null;
                b<T> bVar2 = this.oMp;
                this.oMp = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean ekI() {
            j<b<T>> ekJ = ekJ();
            b<T> bVar = ekJ != null ? ekJ.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0968a(), com.facebook.common.b.a.ejV());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> ekJ() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.oMn.size()) {
                jVar = null;
            } else {
                List list = e.this.oMn;
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
                this.oMo = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.oMo) {
                z = false;
            } else {
                this.oMo = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> ekK() {
            return this.oMp;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.oMo && bVar != this.oMp) {
                    if (this.oMp == null || z) {
                        bVar2 = this.oMp;
                        this.oMp = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != ekK()) {
                    l(bVar);
                }
                if (!ekI()) {
                    x(bVar.ekD());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == ekK()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.apq();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0968a implements d<T> {
            private C0968a() {
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
                if (bVar.ekB()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bi(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
