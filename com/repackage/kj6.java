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
public class kj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nn> a;
    public List<ThreadData> b;
    public Object[] c;

    public kj6() {
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
                        a26 a26Var = new a26();
                        a26Var.c(threadData);
                        this.a.add(a26Var);
                    } else {
                        b26 b26Var = new b26();
                        b26Var.c(threadData);
                        this.a.add(b26Var);
                    }
                }
            }
        }
    }

    public void c(int i, ij6 ij6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ij6Var) == null) || ij6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[ij6Var.b + 10];
        }
        if (!ListUtils.isEmpty(ij6Var.c)) {
            ArrayList arrayList = new ArrayList(ij6Var.c.size());
            for (ThreadData threadData : ij6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(ij6Var);
        }
        this.a.clear();
        b();
        g();
        f(ij6Var);
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

    public final void e(ij6 ij6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ij6Var) == null) {
            if (!ListUtils.isEmpty(ij6Var.e)) {
                for (FeatureCardHot featureCardHot : ij6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(ij6Var.f)) {
                for (FeatureCardTopic featureCardTopic : ij6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(ij6Var.g)) {
                for (jj6 jj6Var : ij6Var.g) {
                    if (jj6Var != null && jj6Var.a()) {
                        d(jj6Var.c.intValue());
                        this.c[jj6Var.c.intValue()] = jj6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(ij6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : ij6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(ij6Var.i)) {
                for (FeatureCardGod featureCardGod : ij6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(ij6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : ij6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(ij6 ij6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ij6Var) == null) {
            g26 g26Var = new g26();
            g26Var.f(ij6Var.d);
            this.a.add(0, g26Var);
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
                    e26 e26Var = new e26();
                    e26Var.f((FeatureCardHot) obj);
                    this.a.add(i2, e26Var);
                } else if (obj instanceof FeatureCardTopic) {
                    h26 h26Var = new h26();
                    h26Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, h26Var);
                } else if (obj instanceof jj6) {
                    d26 d26Var = new d26();
                    d26Var.f((jj6) obj);
                    this.a.add(i2, d26Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    c26 c26Var = new c26();
                    c26Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, c26Var);
                } else if (obj instanceof FeatureCardGod) {
                    rc6 rc6Var = new rc6();
                    rc6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, rc6Var);
                } else if (obj instanceof FeatureCardGame) {
                    f26 f26Var = new f26();
                    f26Var.b((FeatureCardGame) obj);
                    this.a.add(i2, f26Var);
                }
            }
            i++;
        }
    }
}
