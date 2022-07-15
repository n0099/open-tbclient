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
/* loaded from: classes6.dex */
public class hk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nn> a;
    public List<ThreadData> b;
    public Object[] c;

    public hk6() {
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

    public List<nn> a() {
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
                        y26 y26Var = new y26();
                        y26Var.c(threadData);
                        this.a.add(y26Var);
                    } else {
                        z26 z26Var = new z26();
                        z26Var.c(threadData);
                        this.a.add(z26Var);
                    }
                }
            }
        }
    }

    public void c(int i, fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, fk6Var) == null) || fk6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[fk6Var.b + 10];
        }
        if (!ListUtils.isEmpty(fk6Var.c)) {
            ArrayList arrayList = new ArrayList(fk6Var.c.size());
            for (ThreadData threadData : fk6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(fk6Var);
        }
        this.a.clear();
        b();
        g();
        f(fk6Var);
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

    public final void e(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fk6Var) == null) {
            if (!ListUtils.isEmpty(fk6Var.e)) {
                for (FeatureCardHot featureCardHot : fk6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk6Var.f)) {
                for (FeatureCardTopic featureCardTopic : fk6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk6Var.g)) {
                for (gk6 gk6Var : fk6Var.g) {
                    if (gk6Var != null && gk6Var.a()) {
                        d(gk6Var.c.intValue());
                        this.c[gk6Var.c.intValue()] = gk6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : fk6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(fk6Var.i)) {
                for (FeatureCardGod featureCardGod : fk6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(fk6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : fk6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(fk6 fk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fk6Var) == null) {
            e36 e36Var = new e36();
            e36Var.d(fk6Var.d);
            this.a.add(0, e36Var);
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
                    c36 c36Var = new c36();
                    c36Var.d((FeatureCardHot) obj);
                    this.a.add(i2, c36Var);
                } else if (obj instanceof FeatureCardTopic) {
                    f36 f36Var = new f36();
                    f36Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, f36Var);
                } else if (obj instanceof gk6) {
                    b36 b36Var = new b36();
                    b36Var.d((gk6) obj);
                    this.a.add(i2, b36Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    a36 a36Var = new a36();
                    a36Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, a36Var);
                } else if (obj instanceof FeatureCardGod) {
                    od6 od6Var = new od6();
                    od6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, od6Var);
                } else if (obj instanceof FeatureCardGame) {
                    d36 d36Var = new d36();
                    d36Var.b((FeatureCardGame) obj);
                    this.a.add(i2, d36Var);
                }
            }
            i++;
        }
    }
}
