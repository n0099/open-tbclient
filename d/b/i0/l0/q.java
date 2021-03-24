package d.b.i0.l0;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
/* loaded from: classes4.dex */
public class q extends d.b.h0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public final String f56595e;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56596a;

        public a(b bVar) {
            this.f56596a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar != null) {
                q.this.q(aVar);
                q.this.r(aVar);
                if (q.this.t()) {
                    this.f56596a.a(q.this);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(q qVar);
    }

    public q(d.b.i0.k0.c.b bVar) {
        this.f56595e = bVar.getGroupId();
        s(1);
        p(4);
    }

    @Override // d.b.h0.w.p.c
    public String b(int i) {
        return null;
    }

    @Override // d.b.h0.w.p.c
    public int c() {
        return 0;
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a e() {
        return super.d();
    }

    @Override // d.b.h0.w.p.c
    public String f() {
        return this.f56595e;
    }

    @Override // d.b.h0.w.p.c
    public String g() {
        return null;
    }

    @Override // d.b.h0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.SINGLE_FORUM;
    }

    @Override // d.b.h0.w.p.c
    public int i() {
        return 0;
    }

    @Override // d.b.h0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.b.h0.w.p.c
    public int l() {
        return 0;
    }

    @Override // d.b.h0.w.p.c
    public boolean m(String str) {
        return false;
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a n(String str) {
        return null;
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a o(String str) {
        return null;
    }

    public boolean t() {
        return d() != null;
    }

    public boolean u(d.b.i0.k0.c.b bVar, b bVar2) {
        if (bVar instanceof SingleBarEmotionRecommendData) {
            d.b.b.e.l.d.h().m(((SingleBarEmotionRecommendData) bVar).cover, 10, new a(bVar2), null);
            if (t()) {
                bVar2.a(this);
                return true;
            }
            return false;
        }
        return false;
    }
}
