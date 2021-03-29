package d.b.i0.p0.u1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.d0.b;
import d.b.i0.d0.c;
import d.b.i0.d0.d;
import d.b.i0.d0.e;
import d.b.i0.d0.f;
import d.b.i0.d0.g;
import d.b.i0.d0.h;
import d.b.i0.p0.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f58607a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f58608b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object[] f58609c;

    public List<n> a() {
        return this.f58607a;
    }

    public final void b() {
        for (int i = 0; i < this.f58608b.size(); i++) {
            a2 a2Var = this.f58608b.get(i);
            if (a2Var != null) {
                if (i % 4 == 0) {
                    d.b.i0.d0.a aVar = new d.b.i0.d0.a();
                    aVar.j(a2Var);
                    this.f58607a.add(aVar);
                } else {
                    b bVar = new b();
                    bVar.j(a2Var);
                    this.f58607a.add(bVar);
                }
            }
        }
    }

    public void c(int i, d.b.i0.p0.u1.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (1 == i) {
            this.f58607a.clear();
            this.f58608b.clear();
            this.f58609c = new Object[aVar.f58597b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f58598c)) {
            ArrayList arrayList = new ArrayList(aVar.f58598c.size());
            for (a2 a2Var : aVar.f58598c) {
                if (a2Var != null) {
                    arrayList.add(a2Var);
                }
            }
            this.f58608b.addAll(arrayList);
        }
        if (1 == i) {
            e(aVar);
        }
        this.f58607a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i) {
        Object[] objArr = this.f58609c;
        if (i >= objArr.length) {
            this.f58609c = Arrays.copyOf(objArr, i + 1);
        }
    }

    public final void e(d.b.i0.p0.u1.c.a aVar) {
        if (!ListUtils.isEmpty(aVar.f58600e)) {
            for (FeatureCardHot featureCardHot : aVar.f58600e) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    d(featureCardHot.floor.intValue());
                    this.f58609c[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58601f)) {
            for (FeatureCardTopic featureCardTopic : aVar.f58601f) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    d(featureCardTopic.floor.intValue());
                    this.f58609c[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58602g)) {
            for (d.b.i0.p0.u1.c.b bVar : aVar.f58602g) {
                if (bVar != null && bVar.a()) {
                    d(bVar.f58606c.intValue());
                    this.f58609c[bVar.f58606c.intValue()] = bVar;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58603h)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.f58603h) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    d(featureCardCompetition.floor.intValue());
                    this.f58609c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.i)) {
            for (FeatureCardGod featureCardGod : aVar.i) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    d(featureCardGod.floor.intValue());
                    this.f58609c[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (ListUtils.isEmpty(aVar.j)) {
            return;
        }
        for (FeatureCardGame featureCardGame : aVar.j) {
            if (featureCardGame != null && featureCardGame.isValid()) {
                d(featureCardGame.floor.intValue());
                this.f58609c[featureCardGame.floor.intValue()] = featureCardGame;
            }
        }
    }

    public final void f(d.b.i0.p0.u1.c.a aVar) {
        g gVar = new g();
        gVar.j(aVar.f58599d);
        this.f58607a.add(0, gVar);
    }

    public final void g() {
        Object[] objArr = this.f58609c;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr2 = this.f58609c;
            if (i >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i];
            if (obj != null) {
                int i2 = i - 1;
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 >= this.f58607a.size()) {
                    i2 = this.f58607a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.j((FeatureCardHot) obj);
                    this.f58607a.add(i2, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.e((FeatureCardTopic) obj);
                    this.f58607a.add(i2, hVar);
                } else if (obj instanceof d.b.i0.p0.u1.c.b) {
                    d dVar = new d();
                    dVar.j((d.b.i0.p0.u1.c.b) obj);
                    this.f58607a.add(i2, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.e((FeatureCardCompetition) obj);
                    this.f58607a.add(i2, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    x xVar = new x();
                    xVar.j((FeatureCardGod) obj);
                    this.f58607a.add(i2, xVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.e((FeatureCardGame) obj);
                    this.f58607a.add(i2, fVar);
                }
            }
            i++;
        }
    }
}
