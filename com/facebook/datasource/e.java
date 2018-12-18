package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> ihe;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.ihe = list;
    }

    public static <T> e<T> eq(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bTL */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.ihe.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.ihe, ((e) obj).ihe);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.ihe).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> ihf = null;
        private b<T> ihg = null;

        public a() {
            if (!bTM()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bTO;
            bTO = bTO();
            return bTO != null ? bTO.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bTE() {
            boolean z;
            b<T> bTO = bTO();
            if (bTO != null) {
                z = bTO.bTE();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bTH() {
            synchronized (this) {
                if (!super.bTH()) {
                    return false;
                }
                b<T> bVar = this.ihf;
                this.ihf = null;
                b<T> bVar2 = this.ihg;
                this.ihg = null;
                e(bVar2);
                e(bVar);
                return true;
            }
        }

        private boolean bTM() {
            i<b<T>> bTN = bTN();
            b<T> bVar = bTN != null ? bTN.get() : null;
            if (a(bVar) && bVar != null) {
                bVar.a(new C0357a(), com.facebook.common.b.a.bSW());
                return true;
            }
            e(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> bTN() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.ihe.size()) {
                iVar = null;
            } else {
                List list = e.this.ihe;
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
                this.ihf = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.ihf) {
                z = false;
            } else {
                this.ihf = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> bTO() {
            return this.ihg;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.ihf && bVar != this.ihg) {
                    if (this.ihg == null || z) {
                        bVar2 = this.ihg;
                        this.ihg = bVar;
                    }
                    e(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(b<T> bVar) {
            if (b(bVar)) {
                if (bVar != bTO()) {
                    e(bVar);
                }
                if (!bTM()) {
                    t(bVar.bTG());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == bTO()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bTH();
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
                if (bVar.bTE()) {
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
