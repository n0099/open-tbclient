package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lLn;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lLn = list;
    }

    public static <T> e<T> eS(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlJ */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lLn.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lLn, ((e) obj).lLn);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lLn).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lLo = null;
        private b<T> lLp = null;

        public a() {
            if (!dlK()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlM;
            dlM = dlM();
            return dlM != null ? dlM.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlD() {
            boolean z;
            b<T> dlM = dlM();
            if (dlM != null) {
                z = dlM.dlD();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OG() {
            synchronized (this) {
                if (!super.OG()) {
                    return false;
                }
                b<T> bVar = this.lLo;
                this.lLo = null;
                b<T> bVar2 = this.lLp;
                this.lLp = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean dlK() {
            j<b<T>> dlL = dlL();
            b<T> bVar = dlL != null ? dlL.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0655a(), com.facebook.common.b.a.dkY());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dlL() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lLn.size()) {
                jVar = null;
            } else {
                List list = e.this.lLn;
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
                this.lLo = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lLo) {
                z = false;
            } else {
                this.lLo = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dlM() {
            return this.lLp;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lLo && bVar != this.lLp) {
                    if (this.lLp == null || z) {
                        bVar2 = this.lLp;
                        this.lLp = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != dlM()) {
                    f(bVar);
                }
                if (!dlK()) {
                    u(bVar.dlF());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dlM()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OG();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0655a implements d<T> {
            private C0655a() {
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
                if (bVar.dlD()) {
                    a.this.e(bVar);
                } else if (bVar.isFinished()) {
                    a.this.d(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.bj(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
