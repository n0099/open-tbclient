package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> jBi;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jBi = list;
    }

    public static <T> e<T> ew(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuu */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jBi.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jBi, ((e) obj).jBi);
    }

    public String toString() {
        return com.facebook.common.internal.f.aE(this).q(IntentConfig.LIST, this.jBi).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> jBj = null;
        private b<T> jBk = null;

        public a() {
            if (!cuv()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cux;
            cux = cux();
            return cux != null ? cux.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cuo() {
            boolean z;
            b<T> cux = cux();
            if (cux != null) {
                z = cux.cuo();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean zf() {
            synchronized (this) {
                if (!super.zf()) {
                    return false;
                }
                b<T> bVar = this.jBj;
                this.jBj = null;
                b<T> bVar2 = this.jBk;
                this.jBk = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cuv() {
            i<b<T>> cuw = cuw();
            b<T> bVar = cuw != null ? cuw.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0428a(), com.facebook.common.b.a.ctG());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cuw() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.jBi.size()) {
                iVar = null;
            } else {
                List list = e.this.jBi;
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
                this.jBj = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.jBj) {
                z = false;
            } else {
                this.jBj = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cux() {
            return this.jBk;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.jBj && bVar != this.jBk) {
                    if (this.jBk == null || z) {
                        bVar2 = this.jBk;
                        this.jBk = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cux()) {
                    l(bVar);
                }
                if (!cuv()) {
                    u(bVar.cuq());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cux()) {
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
        public class C0428a implements d<T> {
            private C0428a() {
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
                if (bVar.cuo()) {
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
