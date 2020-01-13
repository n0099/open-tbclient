package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> lII;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.lII = list;
    }

    public static <T> e<T> eX(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: djU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.lII.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.lII, ((e) obj).lII);
    }

    public String toString() {
        return com.facebook.common.internal.f.aQ(this).x("list", this.lII).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes12.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> lIJ = null;
        private b<T> lIK = null;

        public a() {
            if (!djV()) {
                v(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> djX;
            djX = djX();
            return djX != null ? djX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean djO() {
            boolean z;
            b<T> djX = djX();
            if (djX != null) {
                z = djX.djO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Mn() {
            synchronized (this) {
                if (!super.Mn()) {
                    return false;
                }
                b<T> bVar = this.lIJ;
                this.lIJ = null;
                b<T> bVar2 = this.lIK;
                this.lIK = null;
                f(bVar2);
                f(bVar);
                return true;
            }
        }

        private boolean djV() {
            j<b<T>> djW = djW();
            b<T> bVar = djW != null ? djW.get() : null;
            if (b(bVar) && bVar != null) {
                bVar.a(new C0646a(), com.facebook.common.b.a.djj());
                return true;
            }
            f(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> djW() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.lII.size()) {
                jVar = null;
            } else {
                List list = e.this.lII;
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
                this.lIJ = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean c(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.lIJ) {
                z = false;
            } else {
                this.lIJ = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> djX() {
            return this.lIK;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.lIJ && bVar != this.lIK) {
                    if (this.lIK == null || z) {
                        bVar2 = this.lIK;
                        this.lIK = bVar;
                    }
                    f(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            if (c(bVar)) {
                if (bVar != djX()) {
                    f(bVar);
                }
                if (!djV()) {
                    v(bVar.djQ());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == djX()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void f(b<T> bVar) {
            if (bVar != null) {
                bVar.Mn();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C0646a implements d<T> {
            private C0646a() {
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
                if (bVar.djO()) {
                    a.this.e(bVar);
                } else if (bVar.isFinished()) {
                    a.this.d(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.bk(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
