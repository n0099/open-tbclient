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
public class ki6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jn> a;
    public List<ThreadData> b;
    public Object[] c;

    public ki6() {
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

    public List<jn> a() {
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
                        a16 a16Var = new a16();
                        a16Var.e(threadData);
                        this.a.add(a16Var);
                    } else {
                        b16 b16Var = new b16();
                        b16Var.e(threadData);
                        this.a.add(b16Var);
                    }
                }
            }
        }
    }

    public void c(int i, ii6 ii6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ii6Var) == null) || ii6Var == null) {
            return;
        }
        if (1 == i) {
            this.a.clear();
            this.b.clear();
            this.c = new Object[ii6Var.b + 10];
        }
        if (!ListUtils.isEmpty(ii6Var.c)) {
            ArrayList arrayList = new ArrayList(ii6Var.c.size());
            for (ThreadData threadData : ii6Var.c) {
                if (threadData != null) {
                    arrayList.add(threadData);
                }
            }
            this.b.addAll(arrayList);
        }
        if (1 == i) {
            e(ii6Var);
        }
        this.a.clear();
        b();
        g();
        f(ii6Var);
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

    public final void e(ii6 ii6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ii6Var) == null) {
            if (!ListUtils.isEmpty(ii6Var.e)) {
                for (FeatureCardHot featureCardHot : ii6Var.e) {
                    if (featureCardHot != null && featureCardHot.isValid()) {
                        d(featureCardHot.floor.intValue());
                        this.c[featureCardHot.floor.intValue()] = featureCardHot;
                    }
                }
            }
            if (!ListUtils.isEmpty(ii6Var.f)) {
                for (FeatureCardTopic featureCardTopic : ii6Var.f) {
                    if (featureCardTopic != null && featureCardTopic.isValid()) {
                        d(featureCardTopic.floor.intValue());
                        this.c[featureCardTopic.floor.intValue()] = featureCardTopic;
                    }
                }
            }
            if (!ListUtils.isEmpty(ii6Var.g)) {
                for (ji6 ji6Var : ii6Var.g) {
                    if (ji6Var != null && ji6Var.a()) {
                        d(ji6Var.c.intValue());
                        this.c[ji6Var.c.intValue()] = ji6Var;
                    }
                }
            }
            if (!ListUtils.isEmpty(ii6Var.h)) {
                for (FeatureCardCompetition featureCardCompetition : ii6Var.h) {
                    if (featureCardCompetition != null && featureCardCompetition.isValid()) {
                        d(featureCardCompetition.floor.intValue());
                        this.c[featureCardCompetition.floor.intValue()] = featureCardCompetition;
                    }
                }
            }
            if (!ListUtils.isEmpty(ii6Var.i)) {
                for (FeatureCardGod featureCardGod : ii6Var.i) {
                    if (featureCardGod != null && featureCardGod.isValid()) {
                        d(featureCardGod.floor.intValue());
                        this.c[featureCardGod.floor.intValue()] = featureCardGod;
                    }
                }
            }
            if (ListUtils.isEmpty(ii6Var.j)) {
                return;
            }
            for (FeatureCardGame featureCardGame : ii6Var.j) {
                if (featureCardGame != null && featureCardGame.isValid()) {
                    d(featureCardGame.floor.intValue());
                    this.c[featureCardGame.floor.intValue()] = featureCardGame;
                }
            }
        }
    }

    public final void f(ii6 ii6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ii6Var) == null) {
            g16 g16Var = new g16();
            g16Var.g(ii6Var.d);
            this.a.add(0, g16Var);
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
                    e16 e16Var = new e16();
                    e16Var.g((FeatureCardHot) obj);
                    this.a.add(i2, e16Var);
                } else if (obj instanceof FeatureCardTopic) {
                    h16 h16Var = new h16();
                    h16Var.b((FeatureCardTopic) obj);
                    this.a.add(i2, h16Var);
                } else if (obj instanceof ji6) {
                    d16 d16Var = new d16();
                    d16Var.g((ji6) obj);
                    this.a.add(i2, d16Var);
                } else if (obj instanceof FeatureCardCompetition) {
                    c16 c16Var = new c16();
                    c16Var.b((FeatureCardCompetition) obj);
                    this.a.add(i2, c16Var);
                } else if (obj instanceof FeatureCardGod) {
                    rb6 rb6Var = new rb6();
                    rb6Var.g((FeatureCardGod) obj);
                    this.a.add(i2, rb6Var);
                } else if (obj instanceof FeatureCardGame) {
                    f16 f16Var = new f16();
                    f16Var.b((FeatureCardGame) obj);
                    this.a.add(i2, f16Var);
                }
            }
            i++;
        }
    }
}
