package d.a.p0.u0.t1.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.p0.g0.b;
import d.a.p0.g0.c;
import d.a.p0.g0.d;
import d.a.p0.g0.e;
import d.a.p0.g0.f;
import d.a.p0.g0.g;
import d.a.p0.g0.h;
import d.a.p0.u0.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f63831a;

    /* renamed from: b  reason: collision with root package name */
    public List<b2> f63832b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f63833c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63831a = new ArrayList();
        this.f63832b = new ArrayList();
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63831a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f63832b.size(); i2++) {
                b2 b2Var = this.f63832b.get(i2);
                if (b2Var != null) {
                    if (i2 % 4 == 0) {
                        d.a.p0.g0.a aVar = new d.a.p0.g0.a();
                        aVar.c(b2Var);
                        this.f63831a.add(aVar);
                    } else {
                        b bVar = new b();
                        bVar.c(b2Var);
                        this.f63831a.add(bVar);
                    }
                }
            }
        }
    }

    public void c(int i2, d.a.p0.u0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || aVar == null) {
            return;
        }
        if (1 == i2) {
            this.f63831a.clear();
            this.f63832b.clear();
            this.f63833c = new Object[aVar.f63820b + 10];
        }
        if (!ListUtils.isEmpty(aVar.f63821c)) {
            ArrayList arrayList = new ArrayList(aVar.f63821c.size());
            for (b2 b2Var : aVar.f63821c) {
                if (b2Var != null) {
                    arrayList.add(b2Var);
                }
            }
            this.f63832b.addAll(arrayList);
        }
        if (1 == i2) {
            e(aVar);
        }
        this.f63831a.clear();
        b();
        g();
        f(aVar);
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Object[] objArr = this.f63833c;
            if (i2 >= objArr.length) {
                this.f63833c = Arrays.copyOf(objArr, i2 + 1);
            }
        }
    }

    public final void e(d.a.p0.u0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (!ListUtils.isEmpty(aVar.f63823e)) {
                for (FeatureCardHot featureCardHot : aVar.f63823e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.f63833c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f63824f)) {
                for (FeatureCardTopic featureCardTopic : aVar.f63824f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.f63833c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f63825g)) {
                for (d.a.p0.u0.t1.c.b bVar : aVar.f63825g) {
                    if (bVar != null && bVar.a()) {
                        d(bVar.f63830c.intValue());
                        this.f63833c[bVar.f63830c.intValue()] = bVar;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f63826h)) {
                for (FeatureCardCompetition featureCardCompetition : aVar.f63826h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.f63833c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(aVar.f63827i)) {
                for (FeatureCardGod featureCardGod : aVar.f63827i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.f63833c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(aVar.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : aVar.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.f63833c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(d.a.p0.u0.t1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            g gVar = new g();
            gVar.d(aVar.f63822d);
            this.f63831a.add(0, gVar);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.f63833c) == null || objArr.length <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.f63833c;
            if (i2 >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i2];
            if (obj != null) {
                int i3 = i2 - 1;
                if (i3 < 0) {
                    i3 = 0;
                } else if (i3 >= this.f63831a.size()) {
                    i3 = this.f63831a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    e eVar = new e();
                    eVar.d((FeatureCardHot) obj);
                    this.f63831a.add(i3, eVar);
                } else if (obj instanceof FeatureCardTopic) {
                    h hVar = new h();
                    hVar.c((FeatureCardTopic) obj);
                    this.f63831a.add(i3, hVar);
                } else if (obj instanceof d.a.p0.u0.t1.c.b) {
                    d dVar = new d();
                    dVar.d((d.a.p0.u0.t1.c.b) obj);
                    this.f63831a.add(i3, dVar);
                } else if (obj instanceof FeatureCardCompetition) {
                    c cVar = new c();
                    cVar.c((FeatureCardCompetition) obj);
                    this.f63831a.add(i3, cVar);
                } else if (obj instanceof FeatureCardGod) {
                    w wVar = new w();
                    wVar.h((FeatureCardGod) obj);
                    this.f63831a.add(i3, wVar);
                } else if (obj instanceof FeatureCardGame) {
                    f fVar = new f();
                    fVar.c((FeatureCardGame) obj);
                    this.f63831a.add(i3, fVar);
                }
            }
            i2++;
        }
    }
}
