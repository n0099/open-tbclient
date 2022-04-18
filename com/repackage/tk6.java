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
public class tk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<uo> a;
    public List<ThreadData> b;
    public Object[] c;

    public tk6() {
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

    public List<uo> a() {
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
                        o26 o26Var = new o26();
                        o26Var.e(threadData);
                        this.a.add(o26Var);
                    } else {
                        p26 p26Var = new p26();
                        p26Var.e(threadData);
                        this.a.add(p26Var);
                    }
                }
            }
        }
    }

    public void c(int i, rk6 rk6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, rk6Var) == null) || rk6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[rk6Var.b + 10];
        }
        if (!ListUtils.isEmpty(rk6Var.c)) {
            ArrayList arrayList = new ArrayList(rk6Var.c.size());
            for (ThreadData threadData : rk6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(rk6Var);
        }
        this.a.clear();
        b();
        g();
        f(rk6Var);
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

    public final void e(rk6 rk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rk6Var) == null) {
            if (!ListUtils.isEmpty(rk6Var.e)) {
                for (FeatureCardHot featureCardHot : rk6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(rk6Var.f)) {
                for (FeatureCardTopic featureCardTopic : rk6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(rk6Var.g)) {
                for (sk6 sk6Var : rk6Var.g) {
                    if (sk6Var != null && sk6Var.a()) {
                        d(sk6Var.c.intValue());
                        this.c[sk6Var.c.intValue()] = sk6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(rk6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : rk6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(rk6Var.i)) {
                for (FeatureCardGod featureCardGod : rk6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(rk6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : rk6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(rk6 rk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rk6Var) == null) {
            u26 u26Var = new u26();
            u26Var.g(rk6Var.d);
            this.a.add(0, u26Var);
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
                    s26 s26Var = new s26();
                    s26Var.g((FeatureCardHot) obj);
                    this.a.add(i2, s26Var);
                } else if (obj instanceof FeatureCardTopic) {
                    v26 v26Var = new v26();
                    v26Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, v26Var);
                } else if (obj instanceof sk6) {
                    r26 r26Var = new r26();
                    r26Var.g((sk6) obj);
                    this.a.add(i2, r26Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    q26 q26Var = new q26();
                    q26Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, q26Var);
                } else if (obj instanceof FeatureCardGod) {
                    wd6 wd6Var = new wd6();
                    wd6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, wd6Var);
                } else if (obj instanceof FeatureCardGame) {
                    t26 t26Var = new t26();
                    t26Var.b((FeatureCardGame) obj);
                    this.a.add(i2, t26Var);
                }
            }
            i++;
        }
    }
}
