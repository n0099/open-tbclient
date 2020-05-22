package com.facebook.datasource;

import com.facebook.common.internal.j;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class e<T> implements j<b<T>> {
    private final List<j<b<T>>> mmE;

    private e(List<j<b<T>>> list) {
        com.facebook.common.internal.g.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mmE = list;
    }

    public static <T> e<T> fa(List<j<b<T>>> list) {
        return new e<>(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.j
    /* renamed from: duU */
    public b<T> get() {
        return new a();
    }

    public int hashCode() {
        return this.mmE.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return com.facebook.common.internal.f.equal(this.mmE, ((e) obj).mmE);
    }

    public String toString() {
        return com.facebook.common.internal.f.aN(this).F("list", this.mmE).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes13.dex */
    public class a extends AbstractDataSource<T> {
        private int mIndex = 0;
        private b<T> mmF = null;
        private b<T> mmG = null;

        public a() {
            if (!duV()) {
                z(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> duX;
            duX = duX();
            return duX != null ? duX.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean duO() {
            boolean z;
            b<T> duX = duX();
            if (duX != null) {
                z = duX.duO();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean Zg() {
            synchronized (this) {
                if (!super.Zg()) {
                    return false;
                }
                b<T> bVar = this.mmF;
                this.mmF = null;
                b<T> bVar2 = this.mmG;
                this.mmG = null;
                l(bVar2);
                l(bVar);
                return true;
            }
        }

        private boolean duV() {
            j<b<T>> duW = duW();
            b<T> bVar = duW != null ? duW.get() : null;
            if (h(bVar) && bVar != null) {
                bVar.a(new C0774a(), com.facebook.common.b.a.dui());
                return true;
            }
            l(bVar);
            return false;
        }

        @Nullable
        private synchronized j<b<T>> duW() {
            j<b<T>> jVar;
            if (isClosed() || this.mIndex >= e.this.mmE.size()) {
                jVar = null;
            } else {
                List list = e.this.mmE;
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
                this.mmF = bVar;
                z = true;
            }
            return z;
        }

        private synchronized boolean i(b<T> bVar) {
            boolean z;
            if (isClosed() || bVar != this.mmF) {
                z = false;
            } else {
                this.mmF = null;
                z = true;
            }
            return z;
        }

        @Nullable
        private synchronized b<T> duX() {
            return this.mmG;
        }

        private void a(b<T> bVar, boolean z) {
            b<T> bVar2 = null;
            synchronized (this) {
                if (bVar == this.mmF && bVar != this.mmG) {
                    if (this.mmG == null || z) {
                        bVar2 = this.mmG;
                        this.mmG = bVar;
                    }
                    l(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(b<T> bVar) {
            if (i(bVar)) {
                if (bVar != duX()) {
                    l(bVar);
                }
                if (!duV()) {
                    z(bVar.duQ());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(b<T> bVar) {
            a(bVar, bVar.isFinished());
            if (bVar == duX()) {
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
        public class C0774a implements d<T> {
            private C0774a() {
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
                if (bVar.duO()) {
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
