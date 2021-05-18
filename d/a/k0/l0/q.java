package d.a.k0.l0;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
/* loaded from: classes4.dex */
public class q extends d.a.j0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public final String f57135e;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f57136a;

        public a(b bVar) {
            this.f57136a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                q.this.q(aVar);
                q.this.r(aVar);
                if (q.this.t()) {
                    this.f57136a.a(q.this);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(q qVar);
    }

    public q(d.a.k0.k0.c.b bVar) {
        this.f57135e = bVar.getGroupId();
        s(1);
        p(4);
    }

    @Override // d.a.j0.w.p.c
    public String b(int i2) {
        return null;
    }

    @Override // d.a.j0.w.p.c
    public int c() {
        return 0;
    }

    @Override // d.a.j0.w.p.c
    public d.a.c.j.d.a e() {
        return super.d();
    }

    @Override // d.a.j0.w.p.c
    public String f() {
        return this.f57135e;
    }

    @Override // d.a.j0.w.p.c
    public String g() {
        return null;
    }

    @Override // d.a.j0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.SINGLE_FORUM;
    }

    @Override // d.a.j0.w.p.c
    public int i() {
        return 0;
    }

    @Override // d.a.j0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.j0.w.p.c
    public int l() {
        return 0;
    }

    @Override // d.a.j0.w.p.c
    public boolean m(String str) {
        return false;
    }

    @Override // d.a.j0.w.p.c
    public d.a.c.j.d.a n(String str) {
        return null;
    }

    @Override // d.a.j0.w.p.c
    public d.a.c.j.d.a o(String str) {
        return null;
    }

    public boolean t() {
        return d() != null;
    }

    public boolean u(d.a.k0.k0.c.b bVar, b bVar2) {
        if (bVar instanceof SingleBarEmotionRecommendData) {
            d.a.c.e.l.d.h().m(((SingleBarEmotionRecommendData) bVar).cover, 10, new a(bVar2), null);
            if (t()) {
                bVar2.a(this);
                return true;
            }
            return false;
        }
        return false;
    }
}
