package master.flame.danmaku.danmaku.model;

import java.util.Comparator;
/* loaded from: classes6.dex */
public interface l {

    /* loaded from: classes6.dex */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    l R(long j, long j2);

    l S(long j, long j2);

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void b(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void clear();

    master.flame.danmaku.danmaku.model.d eDw();

    master.flame.danmaku.danmaku.model.d eDx();

    boolean isEmpty();

    boolean k(master.flame.danmaku.danmaku.model.d dVar);

    boolean l(master.flame.danmaku.danmaku.model.d dVar);

    boolean m(master.flame.danmaku.danmaku.model.d dVar);

    int size();

    /* loaded from: classes6.dex */
    public static abstract class b<Progress, Result> {
        public abstract int bX(Progress progress);

        public void eDy() {
        }

        public void eDz() {
        }

        public Result eCx() {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {
        protected boolean pWw;

        public a(boolean z) {
            Ba(z);
        }

        public void Ba(boolean z) {
            this.pWw = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.pWw && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return master.flame.danmaku.danmaku.c.b.a(dVar, dVar2);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a {
        public d(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            return super.compare(dVar, dVar2);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a {
        public e(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.pWw && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.eDk(), dVar2.eDk());
        }
    }

    /* loaded from: classes6.dex */
    public static class f extends a {
        public f(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.pWw && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.eDk(), dVar.eDk());
        }
    }
}
