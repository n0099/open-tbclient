package d.a.j0.q0.u1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.d0.b;
import d.a.j0.d0.c;
import d.a.j0.d0.d;
import d.a.j0.d0.e;
import d.a.j0.d0.f;
import d.a.j0.d0.g;
import d.a.j0.d0.h;
import d.a.j0.q0.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f58804a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f58805b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object[] f58806c;

    public List<n> a() {
        return this.f58804a;
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f58805b.size(); i2++) {
            a2 a2Var = this.f58805b.get(i2);
            if (a2Var != null) {
                if (i2 % 4 == 0) {
                    d.a.j0.d0.a aVar = new d.a.j0.d0.a();
                    aVar.l(a2Var);
                    this.f58804a.add(aVar);
                } else {
                    b bVar = new b();
                    bVar.l(a2Var);
                    this.f58804a.add(bVar);
                }
            }
        }
    }

    public void c(int i2, d.a.j0.q0.u1.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f58804a.clear();
            this.f58805b.clear();
            this.f58806c = new Object[aVar.f58793b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f58794c)) {
            ArrayList arrayList = new ArrayList(aVar.f58794c.size());
            for (a2 a2Var : aVar.f58794c) {
                if (a2Var != null) {
                    arrayList.add(a2Var);
                }
            }
            this.f58805b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f58804a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Object[] objArr = this.f58806c;
        if (i2 >= objArr.length) {
            this.f58806c = Arrays.copyOf(objArr, i2 + 1);
        }
    }

    public final void e(d.a.j0.q0.u1.c.a aVar) {
        if (!ListUtils.isEmpty(aVar.f58796e)) {
            for (FeatureCardHot featureCardHot : aVar.f58796e) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    d(featureCardHot.floor.intValue());
                    this.f58806c[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58797f)) {
            for (FeatureCardTopic featureCardTopic : aVar.f58797f) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    d(featureCardTopic.floor.intValue());
                    this.f58806c[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58798g)) {
            for (d.a.j0.q0.u1.c.b bVar : aVar.f58798g) {
                if (bVar != null && bVar.a()) {
                    d(bVar.f58803c.intValue());
                    this.f58806c[bVar.f58803c.intValue()] = bVar;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58799h)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.f58799h) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    d(featureCardCompetition.floor.intValue());
                    this.f58806c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f58800i)) {
            for (FeatureCardGod featureCardGod : aVar.f58800i) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    d(featureCardGod.floor.intValue());
                    this.f58806c[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (ListUtils.isEmpty(aVar.j)) {
            return;
        }
        for (FeatureCardGame featureCardGame : aVar.j) {
            if (featureCardGame != null && featureCardGame.isValid()) {
                d(featureCardGame.floor.intValue());
                this.f58806c[featureCardGame.floor.intValue()] = featureCardGame;
            }
        }
    }

    public final void f(d.a.j0.q0.u1.c.a aVar) {
        g gVar = new g();
        gVar.l(aVar.f58795d);
        this.f58804a.add(0, gVar);
    }

    public final void g() {
        Object[] objArr = this.f58806c;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f58806c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f58804a.size()) {
                    i3 = this.f58804a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.l((FeatureCardHot) obj);
                    this.f58804a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.e((FeatureCardTopic) obj);
                    this.f58804a.add(i3, hVar);
                } else if (obj instanceof d.a.j0.q0.u1.c.b) {
                    d dVar = new d();
                    dVar.l((d.a.j0.q0.u1.c.b) obj);
                    this.f58804a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.e((FeatureCardCompetition) obj);
                    this.f58804a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    x xVar = new x();
                    xVar.i((FeatureCardGod) obj);
                    this.f58804a.add(i3, xVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.e((FeatureCardGame) obj);
                    this.f58804a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
