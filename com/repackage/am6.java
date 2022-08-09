package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class am6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<on> a;
    public List<ThreadData> b;
    public Object[] c;

    public am6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.b.size(); i++) {
                ThreadData threadData = this.b.get(i);
                if (threadData != null) {
                    if (i % 4 == 0) {
                        q46 q46Var = new q46();
                        q46Var.c(threadData);
                        this.a.add(q46Var);
                    } else {
                        r46 r46Var = new r46();
                        r46Var.c(threadData);
                        this.a.add(r46Var);
                    }
                }
            }
        }
    }

    public void c(int i, yl6 yl6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, yl6Var) == null) || yl6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[yl6Var.b + 10];
        }
        if (!ListUtils.isEmpty(yl6Var.c)) {
            ArrayList arrayList = new ArrayList(yl6Var.c.size());
            for (ThreadData threadData : yl6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(yl6Var);
        }
        this.a.clear();
        b();
        g();
        f(yl6Var);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Object[] objArr = this.c;
            if (i >= objArr.length) {
                this.c = Arrays.copyOf(objArr, i + 1);
            }
        }
    }

    public final void e(yl6 yl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yl6Var) == null) {
            if (!ListUtils.isEmpty(yl6Var.e)) {
                for (FeatureCardHot featureCardHot : yl6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(yl6Var.f)) {
                for (FeatureCardTopic featureCardTopic : yl6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(yl6Var.g)) {
                for (zl6 zl6Var : yl6Var.g) {
                    if (zl6Var != null && zl6Var.a()) {
                        d(zl6Var.c.intValue());
                        this.c[zl6Var.c.intValue()] = zl6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(yl6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : yl6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(yl6Var.i)) {
                for (FeatureCardGod featureCardGod : yl6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(yl6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : yl6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(yl6 yl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yl6Var) == null) {
            w46 w46Var = new w46();
            w46Var.f(yl6Var.d);
            this.a.add(0, w46Var);
        }
    }

    public final void g() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (objArr = this.c) == null || objArr.length <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr2 = this.c;
            if (i >= objArr2.length) {
                return;
            }
            Object obj = objArr2[i];
            if (obj != null) {
                int i2 = i - 1;
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 >= this.a.size()) {
                    i2 = this.a.size();
                }
                if (obj instanceof FeatureCardHot) {
                    u46 u46Var = new u46();
                    u46Var.f((FeatureCardHot) obj);
                    this.a.add(i2, u46Var);
                } else if (obj instanceof FeatureCardTopic) {
                    x46 x46Var = new x46();
                    x46Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, x46Var);
                } else if (obj instanceof zl6) {
                    t46 t46Var = new t46();
                    t46Var.f((zl6) obj);
                    this.a.add(i2, t46Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    s46 s46Var = new s46();
                    s46Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, s46Var);
                } else if (obj instanceof FeatureCardGod) {
                    gf6 gf6Var = new gf6();
                    gf6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, gf6Var);
                } else if (obj instanceof FeatureCardGame) {
                    v46 v46Var = new v46();
                    v46Var.b((FeatureCardGame) obj);
                    this.a.add(i2, v46Var);
                }
            }
            i++;
        }
    }
}
