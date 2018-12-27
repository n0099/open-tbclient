package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> iko;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.iko = list;
    }

    public static <T> e<T> er(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bUC */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.iko.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.iko, ((e) obj).iko);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.iko).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> ikp = null;
        private b<T> ikq = null;

        public a() {
            if (!bUD()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bUF;
            bUF = bUF();
            return bUF != null ? bUF.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bUv() {
            boolean z;
            b<T> bUF = bUF();
            if (bUF != null) {
                z = bUF.bUv();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bUy() {
            synchronized (this) {
                if (!super.bUy()) {
                    return false;
                }
                b<T> bVar = this.ikp;
                this.ikp = null;
                b<T> bVar2 = this.ikq;
                this.ikq = null;
                e(bVar2);
                e(bVar);
                return true;
            }
        }

        private boolean bUD() {
            i<b<T>> bUE = bUE();
            b<T> bVar = bUE != null ? bUE.get() : null;
            if (a(bVar) && bVar != null) {
                bVar.a(new C0357a(), com.facebook.common.b.a.bTN());
                return true;
            }
            e(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> bUE() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.iko.size()) {
                iVar = null;
            } else {
                List list = e.this.iko;
                int i = this.mIndex;
                this.mIndex = i + 1;
                iVar = (i) list.get(i);
            }
            return iVar;
        }

        private synchronized boolean a(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.ikp = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.ikp) {
                z = false;
            } else {
                this.ikp = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> bUF() {
            return this.ikq;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.ikp && bVar != this.ikq) {
                    if (this.ikq == null || z) {
                        bVar2 = this.ikq;
                        this.ikq = bVar;
                    }
                    e(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(b<T> bVar) {
            if (b(bVar)) {
                if (bVar != bUF()) {
                    e(bVar);
                }
                if (!bUD()) {
                    t(bVar.bUx());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == bUF()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bUy();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0357a implements d<T> {
            private C0357a() {
            }

            @Override // com.facebook.datasource.d
            public void onFailure(b<T> bVar) {
                a.this.c(bVar);
            }

            @Override // com.facebook.datasource.d
            public void onCancellation(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void onNewResult(b<T> bVar) {
                if (bVar.bUv()) {
                    a.this.d(bVar);
                } else if (bVar.isFinished()) {
                    a.this.c(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.aF(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
