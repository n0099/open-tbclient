package master.flame.danmaku.danmaku.model;

import java.util.Comparator;
/* loaded from: classes5.dex */
public interface l {

    /* loaded from: classes5.dex */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    l P(long j, long j2);

    l Q(long j, long j2);

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void b(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void clear();

    master.flame.danmaku.danmaku.model.d dNG();

    master.flame.danmaku.danmaku.model.d dNH();

    boolean isEmpty();

    boolean k(master.flame.danmaku.danmaku.model.d dVar);

    boolean l(master.flame.danmaku.danmaku.model.d dVar);

    boolean m(master.flame.danmaku.danmaku.model.d dVar);

    int size();

    /* loaded from: classes5.dex */
    public static abstract class b<Progress, Result> {
        public abstract int bL(Progress progress);

        public void dNI() {
        }

        public void dNJ() {
        }

        public Result dMI() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {
        protected boolean nxW;

        public a(boolean z) {
            wY(z);
        }

        public void wY(boolean z) {
            this.nxW = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nxW && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return master.flame.danmaku.danmaku.c.b.a(dVar, dVar2);
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class e extends a {
        public e(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nxW && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.dNu(), dVar2.dNu());
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends a {
        public f(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // master.flame.danmaku.danmaku.model.l.a, java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nxW && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.dNu(), dVar.dNu());
        }
    }
}
