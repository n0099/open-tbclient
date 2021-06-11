package d.a.n0.r0.u1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.e0.b;
import d.a.n0.e0.c;
import d.a.n0.e0.d;
import d.a.n0.e0.e;
import d.a.n0.e0.f;
import d.a.n0.e0.g;
import d.a.n0.e0.h;
import d.a.n0.r0.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f63378a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f63379b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object[] f63380c;

    public List<n> a() {
        return this.f63378a;
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f63379b.size(); i2++) {
            a2 a2Var = this.f63379b.get(i2);
            if (a2Var != null) {
                if (i2 % 4 == 0) {
                    d.a.n0.e0.a aVar = new d.a.n0.e0.a();
                    aVar.g(a2Var);
                    this.f63378a.add(aVar);
                } else {
                    b bVar = new b();
                    bVar.g(a2Var);
                    this.f63378a.add(bVar);
                }
            }
        }
    }

    public void c(int i2, d.a.n0.r0.u1.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f63378a.clear();
            this.f63379b.clear();
            this.f63380c = new Object[aVar.f63367b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f63368c)) {
            ArrayList arrayList = new ArrayList(aVar.f63368c.size());
            for (a2 a2Var : aVar.f63368c) {
                if (a2Var != null) {
                    arrayList.add(a2Var);
                }
            }
            this.f63379b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f63378a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Object[] objArr = this.f63380c;
        if (i2 >= objArr.length) {
            this.f63380c = Arrays.copyOf(objArr, i2 + 1);
        }
    }

    public final void e(d.a.n0.r0.u1.c.a aVar) {
        if (!ListUtils.isEmpty(aVar.f63370e)) {
            for (FeatureCardHot featureCardHot : aVar.f63370e) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    d(featureCardHot.floor.intValue());
                    this.f63380c[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63371f)) {
            for (FeatureCardTopic featureCardTopic : aVar.f63371f) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    d(featureCardTopic.floor.intValue());
                    this.f63380c[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63372g)) {
            for (d.a.n0.r0.u1.c.b bVar : aVar.f63372g) {
                if (bVar != null && bVar.a()) {
                    d(bVar.f63377c.intValue());
                    this.f63380c[bVar.f63377c.intValue()] = bVar;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63373h)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.f63373h) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    d(featureCardCompetition.floor.intValue());
                    this.f63380c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63374i)) {
            for (FeatureCardGod featureCardGod : aVar.f63374i) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    d(featureCardGod.floor.intValue());
                    this.f63380c[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (ListUtils.isEmpty(aVar.j)) {
            return;
        }
        for (FeatureCardGame featureCardGame : aVar.j) {
            if (featureCardGame != null && featureCardGame.isValid()) {
                d(featureCardGame.floor.intValue());
                this.f63380c[featureCardGame.floor.intValue()] = featureCardGame;
            }
        }
    }

    public final void f(d.a.n0.r0.u1.c.a aVar) {
        g gVar = new g();
        gVar.g(aVar.f63369d);
        this.f63378a.add(0, gVar);
    }

    public final void g() {
        Object[] objArr = this.f63380c;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f63380c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f63378a.size()) {
                    i3 = this.f63378a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.g((FeatureCardHot) obj);
                    this.f63378a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f63378a.add(i3, hVar);
                } else if (obj instanceof d.a.n0.r0.u1.c.b) {
                    d dVar = new d();
                    dVar.g((d.a.n0.r0.u1.c.b) obj);
                    this.f63378a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f63378a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    x xVar = new x();
                    xVar.h((FeatureCardGod) obj);
                    this.f63378a.add(i3, xVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f63378a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
