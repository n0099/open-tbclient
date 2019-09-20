package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> ked;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ked = list;
    }

    public static <T> e<T> eD(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cGu */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ked.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ked, ((e) obj).ked);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.ked).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> kee = null;
        private b<T> kef = null;

        public a() {
            if (!cGv()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cGx;
            cGx = cGx();
            return cGx != null ? cGx.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cGo() {
            boolean z;
            b<T> cGx = cGx();
            if (cGx != null) {
                z = cGx.cGo();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AM() {
            synchronized (this) {
                if (!super.AM()) {
                    return false;
                }
                b<T> bVar = this.kee;
                this.kee = null;
                b<T> bVar2 = this.kef;
                this.kef = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cGv() {
            i<b<T>> cGw = cGw();
            b<T> bVar = cGw != null ? cGw.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0463a(), com.facebook.common.b.a.cFH());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cGw() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.ked.size()) {
                iVar = null;
            } else {
                List list = e.this.ked;
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
                this.kee = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.kee) {
                z = false;
            } else {
                this.kee = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cGx() {
            return this.kef;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.kee && bVar != this.kef) {
                    if (this.kef == null || z) {
                        bVar2 = this.kef;
                        this.kef = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cGx()) {
                    l(bVar);
                }
                if (!cGv()) {
                    t(bVar.cGq());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cGx()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.AM();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0463a implements d<T> {
            private C0463a() {
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
                if (bVar.cGo()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.aY(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
