package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> jAX;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.jAX = list;
    }

    public static <T> e<T> ew(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cuh */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.jAX.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.jAX, ((e) obj).jAX);
    }

    public String toString() {
        return com.facebook.common.internal.f.aD(this).q(IntentConfig.LIST, this.jAX).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> jAY = null;
        private b<T> jAZ = null;

        public a() {
            if (!cui()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cuk;
            cuk = cuk();
            return cuk != null ? cuk.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cub() {
            boolean z;
            b<T> cuk = cuk();
            if (cuk != null) {
                z = cuk.cub();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean zf() {
            synchronized (this) {
                if (!super.zf()) {
                    return false;
                }
                b<T> bVar = this.jAY;
                this.jAY = null;
                b<T> bVar2 = this.jAZ;
                this.jAZ = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cui() {
            i<b<T>> cuj = cuj();
            b<T> bVar = cuj != null ? cuj.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0332a(), com.facebook.common.b.a.ctt());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cuj() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.jAX.size()) {
                iVar = null;
            } else {
                List list = e.this.jAX;
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
                this.jAY = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.jAY) {
                z = false;
            } else {
                this.jAY = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cuk() {
            return this.jAZ;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.jAY && bVar != this.jAZ) {
                    if (this.jAZ == null || z) {
                        bVar2 = this.jAZ;
                        this.jAZ = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cuk()) {
                    l(bVar);
                }
                if (!cui()) {
                    u(bVar.cud());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cuk()) {
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
        public class C0332a implements d<T> {
            private C0332a() {
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
                if (bVar.cub()) {
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
