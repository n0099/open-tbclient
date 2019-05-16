package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> jTs;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jTs = list;
    }

    public static <T> e<T> eB(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jTs.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jTs, ((e) obj).jTs);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.jTs).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> jTt = null;
        private b<T> jTu = null;

        public a() {
            if (!cCk()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cCm;
            cCm = cCm();
            return cCm != null ? cCm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cCd() {
            boolean z;
            b<T> cCm = cCm();
            if (cCm != null) {
                z = cCm.cCd();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Ab() {
            synchronized (this) {
                if (!super.Ab()) {
                    return false;
                }
                b<T> bVar = this.jTt;
                this.jTt = null;
                b<T> bVar2 = this.jTu;
                this.jTu = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cCk() {
            i<b<T>> cCl = cCl();
            b<T> bVar = cCl != null ? cCl.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0447a(), com.facebook.common.b.a.cBw());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cCl() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.jTs.size()) {
                iVar = null;
            } else {
                List list = e.this.jTs;
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
                this.jTt = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.jTt) {
                z = false;
            } else {
                this.jTt = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cCm() {
            return this.jTu;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.jTt && bVar != this.jTu) {
                    if (this.jTu == null || z) {
                        bVar2 = this.jTu;
                        this.jTu = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cCm()) {
                    l(bVar);
                }
                if (!cCk()) {
                    t(bVar.cCf());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cCm()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Ab();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0447a implements d<T> {
            private C0447a() {
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
                if (bVar.cCd()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aW(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
