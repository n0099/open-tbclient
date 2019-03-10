package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> jBq;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jBq = list;
    }

    public static <T> e<T> ew(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cur */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jBq.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jBq, ((e) obj).jBq);
    }

    public String toString() {
        return com.facebook.common.internal.f.aE(this).q(IntentConfig.LIST, this.jBq).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> jBr = null;
        private b<T> jBs = null;

        public a() {
            if (!cus()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cuu;
            cuu = cuu();
            return cuu != null ? cuu.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cul() {
            boolean z;
            b<T> cuu = cuu();
            if (cuu != null) {
                z = cuu.cul();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean zf() {
            synchronized (this) {
                if (!super.zf()) {
                    return false;
                }
                b<T> bVar = this.jBr;
                this.jBr = null;
                b<T> bVar2 = this.jBs;
                this.jBs = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cus() {
            i<b<T>> cut = cut();
            b<T> bVar = cut != null ? cut.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0335a(), com.facebook.common.b.a.ctD());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cut() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.jBq.size()) {
                iVar = null;
            } else {
                List list = e.this.jBq;
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
                this.jBr = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.jBr) {
                z = false;
            } else {
                this.jBr = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cuu() {
            return this.jBs;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.jBr && bVar != this.jBs) {
                    if (this.jBs == null || z) {
                        bVar2 = this.jBs;
                        this.jBs = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cuu()) {
                    l(bVar);
                }
                if (!cus()) {
                    u(bVar.cun());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cuu()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.zf();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0335a implements d<T> {
            private C0335a() {
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
                if (bVar.cul()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aS(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
