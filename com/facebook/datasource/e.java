package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lJu;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lJu = list;
    }

    public static <T> e<T> eS(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dlj */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lJu.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lJu, ((e) obj).lJu);
    }

    public String toString() {
        return com.facebook.common.internal.f.aS(this).x("list", this.lJu).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lJv = null;
        private b<T> lJw = null;

        public a() {
            if (!dlk()) {
                u(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dlm;
            dlm = dlm();
            return dlm != null ? dlm.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dld() {
            boolean z;
            b<T> dlm = dlm();
            if (dlm != null) {
                z = dlm.dld();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean OB() {
            synchronized (this) {
                if (!super.OB()) {
                    return false;
                }
                b<T> bVar = this.lJv;
                this.lJv = null;
                b<T> bVar2 = this.lJw;
                this.lJw = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean dlk() {
            j<b<T>> dll = dll();
            b<T> bVar = dll != null ? dll.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0654a(), com.facebook.common.b.a.dky());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dll() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lJu.size()) {
                jVar = null;
            } else {
                List list = e.this.lJu;
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
                this.lJv = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lJv) {
                z = false;
            } else {
                this.lJv = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dlm() {
            return this.lJw;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lJv && bVar != this.lJw) {
                    if (this.lJw == null || z) {
                        bVar2 = this.lJw;
                        this.lJw = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != dlm()) {
                    f(bVar);
                }
                if (!dlk()) {
                    u(bVar.dlf());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dlm()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.OB();
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
                if (bVar.dld()) {
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
