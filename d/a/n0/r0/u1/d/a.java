package d.a.n0.r0.u1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.j.e.n;
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
    public List<n> f59687a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f59688b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object[] f59689c;

    public List<n> a() {
        return this.f59687a;
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f59688b.size(); i2++) {
            a2 a2Var = this.f59688b.get(i2);
            if (a2Var != null) {
                if (i2 % 4 == 0) {
                    d.a.n0.e0.a aVar = new d.a.n0.e0.a();
                    aVar.l(a2Var);
                    this.f59687a.add(aVar);
                } else {
                    b bVar = new b();
                    bVar.l(a2Var);
                    this.f59687a.add(bVar);
                }
            }
        }
    }

    public void c(int i2, d.a.n0.r0.u1.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f59687a.clear();
            this.f59688b.clear();
            this.f59689c = new Object[aVar.f59676b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f59677c)) {
            ArrayList arrayList = new ArrayList(aVar.f59677c.size());
            for (a2 a2Var : aVar.f59677c) {
                if (a2Var != null) {
                    arrayList.add(a2Var);
                }
            }
            this.f59688b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f59687a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Object[] objArr = this.f59689c;
        if (i2 >= objArr.length) {
            this.f59689c = Arrays.copyOf(objArr, i2 + 1);
        }
    }

    public final void e(d.a.n0.r0.u1.c.a aVar) {
        if (!ListUtils.isEmpty(aVar.f59679e)) {
            for (FeatureCardHot featureCardHot : aVar.f59679e) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    d(featureCardHot.floor.intValue());
                    this.f59689c[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f59680f)) {
            for (FeatureCardTopic featureCardTopic : aVar.f59680f) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    d(featureCardTopic.floor.intValue());
                    this.f59689c[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f59681g)) {
            for (d.a.n0.r0.u1.c.b bVar : aVar.f59681g) {
                if (bVar != null && bVar.a()) {
                    d(bVar.f59686c.intValue());
                    this.f59689c[bVar.f59686c.intValue()] = bVar;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f59682h)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.f59682h) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    d(featureCardCompetition.floor.intValue());
                    this.f59689c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f59683i)) {
            for (FeatureCardGod featureCardGod : aVar.f59683i) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    d(featureCardGod.floor.intValue());
                    this.f59689c[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (ListUtils.isEmpty(aVar.j)) {
            return;
        }
        for (FeatureCardGame featureCardGame : aVar.j) {
            if (featureCardGame != null && featureCardGame.isValid()) {
                d(featureCardGame.floor.intValue());
                this.f59689c[featureCardGame.floor.intValue()] = featureCardGame;
            }
        }
    }

    public final void f(d.a.n0.r0.u1.c.a aVar) {
        g gVar = new g();
        gVar.l(aVar.f59678d);
        this.f59687a.add(0, gVar);
    }

    public final void g() {
        Object[] objArr = this.f59689c;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f59689c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f59687a.size()) {
                    i3 = this.f59687a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.l((FeatureCardHot) obj);
                    this.f59687a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.e((FeatureCardTopic) obj);
                    this.f59687a.add(i3, hVar);
                } else if (obj instanceof d.a.n0.r0.u1.c.b) {
                    d dVar = new d();
                    dVar.l((d.a.n0.r0.u1.c.b) obj);
                    this.f59687a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.e((FeatureCardCompetition) obj);
                    this.f59687a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    x xVar = new x();
                    xVar.i((FeatureCardGod) obj);
                    this.f59687a.add(i3, xVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.e((FeatureCardGame) obj);
                    this.f59687a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
