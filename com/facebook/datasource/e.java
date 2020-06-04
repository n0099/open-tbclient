package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mnO;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mnO = list;
    }

    public static <T> e<T> fc(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: dvi */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mnO.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mnO, ((e) obj).mnO);
    }

    public String toString() {
        return com.facebook.common.internal.f.aN(this).F("list", this.mnO).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mnP = null;
        private b<T> mnQ = null;

        public a() {
            if (!dvj()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> dvl;
            dvl = dvl();
            return dvl != null ? dvl.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean dvc() {
            boolean z;
            b<T> dvl = dvl();
            if (dvl != null) {
                z = dvl.dvc();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Zg() {
            synchronized (this) {
                if (!super.Zg()) {
                    return false;
                }
                b<T> bVar = this.mnP;
                this.mnP = null;
                b<T> bVar2 = this.mnQ;
                this.mnQ = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean dvj() {
            j<b<T>> dvk = dvk();
            b<T> bVar = dvk != null ? dvk.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0775a(), com.facebook.common.b.a.duw());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> dvk() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mnO.size()) {
                jVar = null;
            } else {
                List list = e.this.mnO;
                int i = this.mIndex;
                this.mIndex = i + 1;
                jVar = (j) list.get(i);
            }
            return jVar;
        }

        private synchronized boolean h(b<T> bVar) {
            boolean z;
            if (isClosed()) {
                z = false;
            } else {
                this.mnP = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mnP) {
                z = false;
            } else {
                this.mnP = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> dvl() {
            return this.mnQ;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mnP && bVar != this.mnQ) {
                    if (this.mnQ == null || z) {
                        bVar2 = this.mnQ;
                        this.mnQ = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != dvl()) {
                    l(bVar);
                }
                if (!dvj()) {
                    z(bVar.dve());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == dvl()) {
                b((a) null, bVar.isFinished());
            }
        }

        private void l(b<T> bVar) {
            if (bVar != null) {
                bVar.Zg();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.facebook.datasource.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C0775a implements d<T> {
            private C0775a() {
            }

            @Override // com.facebook.datasource.d
            public void e(b<T> bVar) {
                a.this.j(bVar);
            }

            @Override // com.facebook.datasource.d
            public void b(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (bVar.dvc()) {
                    a.this.k(bVar);
                } else if (bVar.isFinished()) {
                    a.this.j(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void f(b<T> bVar) {
                a.this.ay(Math.max(a.this.getProgress(), bVar.getProgress()));
            }
        }
    }
}
