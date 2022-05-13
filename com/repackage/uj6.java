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
/* loaded from: classes7.dex */
public class uj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ro> a;
    public List<ThreadData> b;
    public Object[] c;

    public uj6() {
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

    public List<ro> a() {
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
                        p26 p26Var = new p26();
                        p26Var.e(threadData);
                        this.a.add(p26Var);
                    } else {
                        q26 q26Var = new q26();
                        q26Var.e(threadData);
                        this.a.add(q26Var);
                    }
                }
            }
        }
    }

    public void c(int i, sj6 sj6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, sj6Var) == null) || sj6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[sj6Var.b + 10];
        }
        if (!ListUtils.isEmpty(sj6Var.c)) {
            ArrayList arrayList = new ArrayList(sj6Var.c.size());
            for (ThreadData threadData : sj6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(sj6Var);
        }
        this.a.clear();
        b();
        g();
        f(sj6Var);
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

    public final void e(sj6 sj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sj6Var) == null) {
            if (!ListUtils.isEmpty(sj6Var.e)) {
                for (FeatureCardHot featureCardHot : sj6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(sj6Var.f)) {
                for (FeatureCardTopic featureCardTopic : sj6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(sj6Var.g)) {
                for (tj6 tj6Var : sj6Var.g) {
                    if (tj6Var != null && tj6Var.a()) {
                        d(tj6Var.c.intValue());
                        this.c[tj6Var.c.intValue()] = tj6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(sj6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : sj6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(sj6Var.i)) {
                for (FeatureCardGod featureCardGod : sj6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(sj6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : sj6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(sj6 sj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sj6Var) == null) {
            v26 v26Var = new v26();
            v26Var.g(sj6Var.d);
            this.a.add(0, v26Var);
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
                    t26 t26Var = new t26();
                    t26Var.g((FeatureCardHot) obj);
                    this.a.add(i2, t26Var);
                } else if (obj instanceof FeatureCardTopic) {
                    w26 w26Var = new w26();
                    w26Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, w26Var);
                } else if (obj instanceof tj6) {
                    s26 s26Var = new s26();
                    s26Var.g((tj6) obj);
                    this.a.add(i2, s26Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    r26 r26Var = new r26();
                    r26Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, r26Var);
                } else if (obj instanceof FeatureCardGod) {
                    bd6 bd6Var = new bd6();
                    bd6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, bd6Var);
                } else if (obj instanceof FeatureCardGame) {
                    u26 u26Var = new u26();
                    u26Var.b((FeatureCardGame) obj);
                    this.a.add(i2, u26Var);
                }
            }
            i++;
        }
    }
}
