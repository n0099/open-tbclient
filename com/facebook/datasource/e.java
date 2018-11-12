package com.facebook.datasource;

import com.facebook.common.internal.i;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class e<T> implements i<b<T>> {
    private final List<i<b<T>>> hZR;

    private e(List<i<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.hZR = list;
    }

    public static <T> e<T> em(List<i<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.i
    /* renamed from: bRG */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.hZR.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.hZR, ((e) obj).hZR);
    }

    public String toString() {
        return com.facebook.common.internal.f.an(this).n("list", this.hZR).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> hZS = null;
        private b<T> hZT = null;

        public a() {
            if (!bRH()) {
                t(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> bRJ;
            bRJ = bRJ();
            return bRJ != null ? bRJ.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean bRz() {
            boolean z;
            b<T> bRJ = bRJ();
            if (bRJ != null) {
                z = bRJ.bRz();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean bRC() {
            synchronized (this) {
                if (!super.bRC()) {
                    return false;
                }
                b<T> bVar = this.hZS;
                this.hZS = null;
                b<T> bVar2 = this.hZT;
                this.hZT = null;
                e(bVar2);
                e(bVar);
                return true;
            }
        }

        private boolean bRH() {
            i<b<T>> bRI = bRI();
            b<T> bVar = bRI != null ? bRI.get() : null;
            if (a(bVar) && bVar != null) {
                bVar.a(new C0343a(), com.facebook.common.b.a.bQR());
                return true;
            }
            e(bVar);
            return false;
        }

        @Nullable
        private synchronized i<b<T>> bRI() {
            i<b<T>> iVar;
            if (isClosed() || this.mIndex >= e.this.hZR.size()) {
                iVar = null;
            } else {
                List list = e.this.hZR;
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
                this.hZS = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean b(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.hZS) {
                z = false;
            } else {
                this.hZS = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> bRJ() {
            return this.hZT;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.hZS && bVar != this.hZT) {
                    if (this.hZT == null || z) {
                        bVar2 = this.hZT;
                        this.hZT = bVar;
                    }
                    e(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(b<T> bVar) {
            if (b(bVar)) {
                if (bVar != bRJ()) {
                    e(bVar);
                }
                if (!bRH()) {
                    t(bVar.bRB());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(b<T> bVar) {
            a((b) bVar, bVar.isFinished());
            if (bVar == bRJ()) {
                a((a) null, bVar.isFinished());
            }
        }

        private void e(b<T> bVar) {
            if (bVar != null) {
                bVar.bRC();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0343a implements d<T> {
            private C0343a() {
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
                if (bVar.bRz()) {
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
