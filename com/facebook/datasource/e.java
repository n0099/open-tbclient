package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> oNR;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.oNR = list;
    }

    public static <T> e<T> gy(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: ekF */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.oNR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.oNR, ((e) obj).oNR);
    }

    public String toString() {
        return com.facebook.common.internal.f.ba(this).F("list", this.oNR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> oNS = null;
        private b<T> oNT = null;

        public a() {
            if (!ekG()) {
                x(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> ekI;
            ekI = ekI();
            return ekI != null ? ekI.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean ekz() {
            boolean z;
            b<T> ekI = ekI();
            if (ekI != null) {
                z = ekI.ekz();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean aoH() {
            synchronized (this) {
                if (!super.aoH()) {
                    return false;
                }
                b<T> bVar = this.oNS;
                this.oNS = null;
                b<T> bVar2 = this.oNT;
                this.oNT = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean ekG() {
            j<b<T>> ekH = ekH();
            b<T> bVar = ekH != null ? ekH.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0971a(), com.facebook.common.b.a.ejT());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> ekH() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.oNR.size()) {
                jVar = null;
            } else {
                List list = e.this.oNR;
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
                this.oNS = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.oNS) {
                z = false;
            } else {
                this.oNS = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> ekI() {
            return this.oNT;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.oNS && bVar != this.oNT) {
                    if (this.oNT == null || z) {
                        bVar2 = this.oNT;
                        this.oNT = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != ekI()) {
                    l(bVar);
                }
                if (!ekG()) {
                    x(bVar.ekB());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == ekI()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.aoH();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0971a implements d<T> {
            private C0971a() {
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
                if (bVar.ekz()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.bp(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
