package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> hYh;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.hYh = list;
    }

    public static <T> e<T> eo(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bSl */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.hYh.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.hYh, ((e) obj).hYh);
    }

    public String toString() {
        return com.facebook.common.internal.f.ao(this).n("list", this.hYh).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> hYi = null;
        private b<T> hYj = null;

        public a() {
            if (!bSm()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bSo;
            bSo = bSo();
            return bSo != null ? bSo.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bSe() {
            boolean z;
            b<T> bSo = bSo();
            if (bSo != null) {
                z = bSo.bSe();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bSh() {
            synchronized (this) {
                if (!super.bSh()) {
                    return false;
                }
                b<T> bVar = this.hYi;
                this.hYi = null;
                b<T> bVar2 = this.hYj;
                this.hYj = null;
                e(bVar2);
                e(bVar);
                return true;
            }
        }

        private boolean bSm() {
            i<b<T>> bSn = bSn();
            b<T> bVar = bSn != null ? bSn.get() : null;
            if (a(bVar) && bVar != null) {
                bVar.a(new C0315a(), com.facebook.common.b.a.bRw());
                return true;
            }
            e(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> bSn() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.hYh.size()) {
                iVar = null;
            } else {
                List list = e.this.hYh;
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
                this.hYi = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.hYi) {
                z = false;
            } else {
                this.hYi = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> bSo() {
            return this.hYj;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.hYi && bVar != this.hYj) {
                    if (this.hYj == null || z) {
                        bVar2 = this.hYj;
                        this.hYj = bVar;
                    }
                    e(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(b<T> bVar) {
            if (b(bVar)) {
                if (bVar != bSo()) {
                    e(bVar);
                }
                if (!bSm()) {
                    t(bVar.bSg());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == bSo()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bSh();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0315a implements d<T> {
            private C0315a() {
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
                if (bVar.bSe()) {
                    a.this.d(bVar);
                } else if (bVar.isFinished()) {
                    a.this.c(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void onProgressUpdate(b<T> bVar) {
                a.this.aD(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
