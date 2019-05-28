package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> jTt;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jTt = list;
    }

    public static <T> e<T> eB(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cCl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jTt.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jTt, ((e) obj).jTt);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.jTt).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> jTu = null;
        private b<T> jTv = null;

        public a() {
            if (!cCm()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cCo;
            cCo = cCo();
            return cCo != null ? cCo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cCf() {
            boolean z;
            b<T> cCo = cCo();
            if (cCo != null) {
                z = cCo.cCf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Ab() {
            synchronized (this) {
                if (!super.Ab()) {
                    return false;
                }
                b<T> bVar = this.jTu;
                this.jTu = null;
                b<T> bVar2 = this.jTv;
                this.jTv = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cCm() {
            i<b<T>> cCn = cCn();
            b<T> bVar = cCn != null ? cCn.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0447a(), com.facebook.common.b.a.cBy());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cCn() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.jTt.size()) {
                iVar = null;
            } else {
                List list = e.this.jTt;
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
                this.jTu = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.jTu) {
                z = false;
            } else {
                this.jTu = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cCo() {
            return this.jTv;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.jTu && bVar != this.jTv) {
                    if (this.jTv == null || z) {
                        bVar2 = this.jTv;
                        this.jTv = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cCo()) {
                    l(bVar);
                }
                if (!cCm()) {
                    t(bVar.cCh());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cCo()) {
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
                if (bVar.cCf()) {
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
