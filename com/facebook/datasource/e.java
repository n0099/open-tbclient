package com.facebook.datasource;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> kbG;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.kbG = list;
    }

    public static <T> e<T> eD(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: cFG */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.kbG.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.kbG, ((e) obj).kbG);
    }

    public String toString() {
        return com.facebook.common.internal.f.aC(this).t(IntentConfig.LIST, this.kbG).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> kbH = null;
        private b<T> kbI = null;

        public a() {
            if (!cFH()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> cFJ;
            cFJ = cFJ();
            return cFJ != null ? cFJ.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean cFA() {
            boolean z;
            b<T> cFJ = cFJ();
            if (cFJ != null) {
                z = cFJ.cFA();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean AI() {
            synchronized (this) {
                if (!super.AI()) {
                    return false;
                }
                b<T> bVar = this.kbH;
                this.kbH = null;
                b<T> bVar2 = this.kbI;
                this.kbI = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean cFH() {
            i<b<T>> cFI = cFI();
            b<T> bVar = cFI != null ? cFI.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0452a(), com.facebook.common.b.a.cET());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> cFI() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.kbG.size()) {
                iVar = null;
            } else {
                List list = e.this.kbG;
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
                this.kbH = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.kbH) {
                z = false;
            } else {
                this.kbH = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> cFJ() {
            return this.kbI;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.kbH && bVar != this.kbI) {
                    if (this.kbI == null || z) {
                        bVar2 = this.kbI;
                        this.kbI = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != cFJ()) {
                    l(bVar);
                }
                if (!cFH()) {
                    t(bVar.cFC());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == cFJ()) {
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
        public class C0452a implements d<T> {
            private C0452a() {
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
                if (bVar.cFA()) {
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
