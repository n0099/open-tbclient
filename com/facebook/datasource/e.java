package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> kaA;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kaA = list;
    }

    public static <T> e<T> eE(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kaA.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kaA, ((e) obj).kaA);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.kaA).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> kaB = null;
        private b<T> kaC = null;

        public a() {
            if (!cFm()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cFo;
            cFo = cFo();
            return cFo != null ? cFo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cFf() {
            boolean z;
            b<T> cFo = cFo();
            if (cFo != null) {
                z = cFo.cFf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AI() {
            synchronized (this) {
                if (!super.AI()) {
                    return false;
                }
                b<T> bVar = this.kaB;
                this.kaB = null;
                b<T> bVar2 = this.kaC;
                this.kaC = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cFm() {
            i<b<T>> cFn = cFn();
            b<T> bVar = cFn != null ? cFn.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0446a(), com.facebook.common.b.a.cEy());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cFn() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.kaA.size()) {
                iVar = null;
            } else {
                List list = e.this.kaA;
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
                this.kaB = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.kaB) {
                z = false;
            } else {
                this.kaB = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cFo() {
            return this.kaC;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.kaB && bVar != this.kaC) {
                    if (this.kaC == null || z) {
                        bVar2 = this.kaC;
                        this.kaC = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cFo()) {
                    l(bVar);
                }
                if (!cFm()) {
                    t(bVar.cFh());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cFo()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.AI();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0446a implements d<T> {
            private C0446a() {
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
                if (bVar.cFf()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aX(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
