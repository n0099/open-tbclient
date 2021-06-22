package d.a.o0.r0.u1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.e0.b;
import d.a.o0.e0.c;
import d.a.o0.e0.d;
import d.a.o0.e0.e;
import d.a.o0.e0.f;
import d.a.o0.e0.g;
import d.a.o0.e0.h;
import d.a.o0.r0.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<n> f63503a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<a2> f63504b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Object[] f63505c;

    public List<n> a() {
        return this.f63503a;
    }

    public final void b() {
        for (int i2 = 0; i2 < this.f63504b.size(); i2++) {
            a2 a2Var = this.f63504b.get(i2);
            if (a2Var != null) {
                if (i2 % 4 == 0) {
                    d.a.o0.e0.a aVar = new d.a.o0.e0.a();
                    aVar.g(a2Var);
                    this.f63503a.add(aVar);
                } else {
                    b bVar = new b();
                    bVar.g(a2Var);
                    this.f63503a.add(bVar);
                }
            }
        }
    }

    public void c(int i2, d.a.o0.r0.u1.c.a aVar) {
        if (aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f63503a.clear();
            this.f63504b.clear();
            this.f63505c = new Object[aVar.f63492b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f63493c)) {
            ArrayList arrayList = new ArrayList(aVar.f63493c.size());
            for (a2 a2Var : aVar.f63493c) {
                if (a2Var != null) {
                    arrayList.add(a2Var);
                }
            }
            this.f63504b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f63503a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Object[] objArr = this.f63505c;
        if (i2 >= objArr.length) {
            this.f63505c = Arrays.copyOf(objArr, i2 + 1);
        }
    }

    public final void e(d.a.o0.r0.u1.c.a aVar) {
        if (!ListUtils.isEmpty(aVar.f63495e)) {
            for (FeatureCardHot featureCardHot : aVar.f63495e) {
                if (featureCardHot != null && featureCardHot.isValid()) {
                    d(featureCardHot.floor.intValue());
                    this.f63505c[featureCardHot.floor.intValue()] = featureCardHot;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63496f)) {
            for (FeatureCardTopic featureCardTopic : aVar.f63496f) {
                if (featureCardTopic != null && featureCardTopic.isValid()) {
                    d(featureCardTopic.floor.intValue());
                    this.f63505c[featureCardTopic.floor.intValue()] = featureCardTopic;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63497g)) {
            for (d.a.o0.r0.u1.c.b bVar : aVar.f63497g) {
                if (bVar != null && bVar.a()) {
                    d(bVar.f63502c.intValue());
                    this.f63505c[bVar.f63502c.intValue()] = bVar;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63498h)) {
            for (FeatureCardCompetition featureCardCompetition : aVar.f63498h) {
                if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                    d(featureCardCompetition.floor.intValue());
                    this.f63505c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                }
            }
        }
        if (!ListUtils.isEmpty(aVar.f63499i)) {
            for (FeatureCardGod featureCardGod : aVar.f63499i) {
                if (featureCardGod != null && featureCardGod.isValid()) {
                    d(featureCardGod.floor.intValue());
                    this.f63505c[featureCardGod.floor.intValue()] = featureCardGod;
                }
            }
        }
        if (ListUtils.isEmpty(aVar.j)) {
            return;
        }
        for (FeatureCardGame featureCardGame : aVar.j) {
            if (featureCardGame != null && featureCardGame.isValid()) {
                d(featureCardGame.floor.intValue());
                this.f63505c[featureCardGame.floor.intValue()] = featureCardGame;
            }
        }
    }

    public final void f(d.a.o0.r0.u1.c.a aVar) {
        g gVar = new g();
        gVar.g(aVar.f63494d);
        this.f63503a.add(0, gVar);
    }

    public final void g() {
        Object[] objArr = this.f63505c;
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f63505c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f63503a.size()) {
                    i3 = this.f63503a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.g((FeatureCardHot) obj);
                    this.f63503a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f63503a.add(i3, hVar);
                } else if (obj instanceof d.a.o0.r0.u1.c.b) {
                    d dVar = new d();
                    dVar.g((d.a.o0.r0.u1.c.b) obj);
                    this.f63503a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f63503a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    x xVar = new x();
                    xVar.h((FeatureCardGod) obj);
                    this.f63503a.add(i3, xVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f63503a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
