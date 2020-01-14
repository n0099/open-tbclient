package master.flame.danmaku.danmaku.model;

import java.util.Comparator;
/* loaded from: classes4.dex */
public interface l {

    /* loaded from: classes4.dex */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    l ag(long j, long j2);

    l ah(long j, long j2);

    void b(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void clear();

    master.flame.danmaku.danmaku.model.d dKL();

    master.flame.danmaku.danmaku.model.d dKM();

    boolean isEmpty();

    boolean k(master.flame.danmaku.danmaku.model.d dVar);

    boolean l(master.flame.danmaku.danmaku.model.d dVar);

    boolean m(master.flame.danmaku.danmaku.model.d dVar);

    int size();

    /* loaded from: classes4.dex */
    public static abstract class b<Progress, Result> {
        public abstract int bU(Progress progress);

        public void dKN() {
        }

        public void dKO() {
        }

        public Result dJN() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {
        protected boolean nFm;

        public a(boolean z) {
            wI(z);
        }

        public void wI(boolean z) {
            this.nFm = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nFm && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return master.flame.danmaku.danmaku.c.b.a(dVar, dVar2);
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class e extends a {
        public e(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nFm && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.dKz(), dVar2.dKz());
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends a {
        public f(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nFm && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.dKz(), dVar.dKz());
        }
    }
}
