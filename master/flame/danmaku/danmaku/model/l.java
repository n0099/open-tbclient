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

    master.flame.danmaku.danmaku.model.d dNs();

    master.flame.danmaku.danmaku.model.d dNt();

    boolean isEmpty();

    boolean k(master.flame.danmaku.danmaku.model.d dVar);

    boolean l(master.flame.danmaku.danmaku.model.d dVar);

    boolean m(master.flame.danmaku.danmaku.model.d dVar);

    int size();

    /* loaded from: classes5.dex */
    public static abstract class b<Progress, Result> {
        public abstract int bL(Progress progress);

        public void dNu() {
        }

        public void dNv() {
        }

        public Result dMu() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {
        protected boolean nwM;

        public a(boolean z) {
            wW(z);
        }

        public void wW(boolean z) {
            this.nwM = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nwM && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
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
            if (this.nwM && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.dNg(), dVar2.dNg());
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
            if (this.nwM && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.dNg(), dVar.dNg());
        }
    }
}
