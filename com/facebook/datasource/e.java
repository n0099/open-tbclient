package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lJH;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJH = list;
    }

    public static <T> e<T> eS(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlm */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJH.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJH, ((e) obj).lJH);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJH).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lJI = null;
        private b<T> lJJ = null;

        public a() {
            if (!dln()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlp;
            dlp = dlp();
            return dlp != null ? dlp.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dlg() {
            boolean z;
            b<T> dlp = dlp();
            if (dlp != null) {
                z = dlp.dlg();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OD() {
            synchronized (this) {
                if (!super.OD()) {
                    return false;
                }
                b<T> bVar = this.lJI;
                this.lJI = null;
                b<T> bVar2 = this.lJJ;
                this.lJJ = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean dln() {
            j<b<T>> dlo = dlo();
            b<T> bVar = dlo != null ? dlo.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0654a(), com.facebook.common.b.a.dkB());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dlo() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lJH.size()) {
                jVar = null;
            } else {
                List list = e.this.lJH;
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
                this.lJI = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lJI) {
                z = false;
            } else {
                this.lJI = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dlp() {
            return this.lJJ;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lJI && bVar != this.lJJ) {
                    if (this.lJJ == null || z) {
                        bVar2 = this.lJJ;
                        this.lJJ = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != dlp()) {
                    f(bVar);
                }
                if (!dln()) {
                    u(bVar.dli());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dlp()) {
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
                if (bVar.dlg()) {
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
