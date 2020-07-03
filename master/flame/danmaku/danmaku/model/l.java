package master.flame.danmaku.danmaku.model;

import java.util.Comparator;
/* loaded from: classes5.dex */
public interface l {

    /* loaded from: classes5.dex */
    public static abstract class c<Progress> extends b<Progress, Void> {
    }

    l Q(long j, long j2);

    l R(long j, long j2);

    void a(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void b(b<? super master.flame.danmaku.danmaku.model.d, ?> bVar);

    void clear();

    master.flame.danmaku.danmaku.model.d dSm();

    master.flame.danmaku.danmaku.model.d dSn();

    boolean isEmpty();

    boolean k(master.flame.danmaku.danmaku.model.d dVar);

    boolean l(master.flame.danmaku.danmaku.model.d dVar);

    boolean m(master.flame.danmaku.danmaku.model.d dVar);

    int size();

    /* loaded from: classes5.dex */
    public static abstract class b<Progress, Result> {
        public abstract int bM(Progress progress);

        public void dSo() {
        }

        public void dSp() {
        }

        public Result dRo() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Comparator<master.flame.danmaku.danmaku.model.d> {
        protected boolean nTH;

        public a(boolean z) {
            xt(z);
        }

        public void xt(boolean z) {
            this.nTH = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(master.flame.danmaku.danmaku.model.d dVar, master.flame.danmaku.danmaku.model.d dVar2) {
            if (this.nTH && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
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
            if (this.nTH && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar.dSa(), dVar2.dSa());
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
            if (this.nTH && master.flame.danmaku.danmaku.c.b.b(dVar, dVar2)) {
                return 0;
            }
            return Float.compare(dVar2.dSa(), dVar.dSa());
        }
    }
}
