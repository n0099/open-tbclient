package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lFk;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lFk = list;
    }

    public static <T> e<T> eX(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: diT */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lFk.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lFk, ((e) obj).lFk);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("list", this.lFk).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes11.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lFl = null;
        private b<T> lFm = null;

        public a() {
            if (!diU()) {
                v(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> diW;
            diW = diW();
            return diW != null ? diW.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean diN() {
            boolean z;
            b<T> diW = diW();
            if (diW != null) {
                z = diW.diN();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean LR() {
            synchronized (this) {
                if (!super.LR()) {
                    return false;
                }
                b<T> bVar = this.lFl;
                this.lFl = null;
                b<T> bVar2 = this.lFm;
                this.lFm = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean diU() {
            j<b<T>> diV = diV();
            b<T> bVar = diV != null ? diV.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0641a(), com.facebook.common.b.a.dii());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> diV() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lFk.size()) {
                jVar = null;
            } else {
                List list = e.this.lFk;
                int i = this.mIndex;
                this.mIndex = i + 1;
                jVar = (j) list.get(i);
            }
            return jVar;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.lFl = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lFl) {
                z = false;
            } else {
                this.lFl = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> diW() {
            return this.lFm;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lFl && bVar != this.lFm) {
                    if (this.lFm == null || z) {
                        bVar2 = this.lFm;
                        this.lFm = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != diW()) {
                    f(bVar);
                }
                if (!diU()) {
                    v(bVar.diP());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == diW()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.LR();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0641a implements d<T> {
            private C0641a() {
            }

            @Override // com.facebook.datasource.d
            public void onFailure(b<T> bVar) {
                a.this.d(bVar);
            }

            @Override // com.facebook.datasource.d
            public void onCancellation(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.diN()) {
                    a.this.e(bVar);
                } else if (bVar.isFinished()) {
                    a.this.d(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.bl(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
