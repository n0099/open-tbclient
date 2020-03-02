package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lJw;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJw = list;
    }

    public static <T> e<T> eS(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dll */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJw.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJw, ((e) obj).lJw);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJw).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lJx = null;
        private b<T> lJy = null;

        public a() {
            if (!dlm()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlo;
            dlo = dlo();
            return dlo != null ? dlo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlf() {
            boolean z;
            b<T> dlo = dlo();
            if (dlo != null) {
                z = dlo.dlf();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OD() {
            synchronized (this) {
                if (!super.OD()) {
                    return false;
                }
                b<T> bVar = this.lJx;
                this.lJx = null;
                b<T> bVar2 = this.lJy;
                this.lJy = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean dlm() {
            j<b<T>> dln = dln();
            b<T> bVar = dln != null ? dln.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0654a(), com.facebook.common.b.a.dkA());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dln() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lJw.size()) {
                jVar = null;
            } else {
                List list = e.this.lJw;
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
                this.lJx = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lJx) {
                z = false;
            } else {
                this.lJx = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dlo() {
            return this.lJy;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lJx && bVar != this.lJy) {
                    if (this.lJy == null || z) {
                        bVar2 = this.lJy;
                        this.lJy = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != dlo()) {
                    f(bVar);
                }
                if (!dlm()) {
                    u(bVar.dlh());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dlo()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OD();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0654a implements d<T> {
            private C0654a() {
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
                if (bVar.dlf()) {
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
