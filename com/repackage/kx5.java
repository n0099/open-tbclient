package com.repackage;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import com.repackage.yr4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class kx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public wr4 c;
    public yr4 d;
    public nr4 e;
    public j f;
    public CardPersonDynamicThreadData g;
    public List<ur4> h;
    public ur4 i;
    public ur4 j;
    public ur4 k;
    public ur4 l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public sw5 p;
    public yr4.d q;
    public SetPrivacyModel.a r;
    public yr4.d s;
    public yr4.d t;
    public yr4.d u;
    public a9 v;

    /* loaded from: classes6.dex */
    public class a implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public a(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.yr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public b(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g == null) {
                return;
            }
            this.a.q();
            int i2 = 2;
            if (this.a.g.q == 1) {
                i = 2;
            } else {
                int i3 = this.a.g.q;
                i = 1;
            }
            if (this.a.g == null || !this.a.g.o) {
                if (this.a.g.getThreadData() != null) {
                    this.a.p.f(this.a.g.getThreadData().getTid());
                }
                i2 = (TbSingleton.getInstance().mCallFansTid == null || this.a.g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.g.getThreadData().getTid())) ? 1 : 1;
                this.a.p.b();
                if (this.a.g.getThreadData() != null) {
                    this.a.p.d(i, i2, this.a.g.getThreadData().getTid());
                    return;
                }
                return;
            }
            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0eea);
            if (this.a.g.getThreadData() != null) {
                this.a.p.d(i, 3, this.a.g.getThreadData().getTid());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public c(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                if (!ki.A()) {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                if (this.a.g.q != 1) {
                    if (this.a.g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.a.o) {
                    this.a.n.S(this.a.g.p);
                }
                this.a.n.U(this.a.g.a, this.a.g.h, this.a.g.b, this.a.g.e, 0, 0, true, this.a.g.p.getBaijiahaoData(), false);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public e(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                mi.N(this.a.b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g.o) {
                    this.a.g.o = false;
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f13c6);
                    if (this.a.i != null) {
                        this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f1111));
                    }
                    if (this.a.f != null) {
                        this.a.f.a(false);
                        return;
                    }
                    return;
                }
                this.a.g.o = true;
                if (this.a.i != null) {
                    this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f1112));
                }
                if (this.a.f != null) {
                    this.a.f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.g.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public f(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ki.A()) {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                if (this.a.g.o) {
                    if (this.a.g.q == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.g.q != 1) {
                    if (this.a.g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.g);
                }
                if (!this.a.m.E()) {
                    this.a.m.F(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public g(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ki.A()) {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                ThreadData threadData = this.a.g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(threadData.getTid())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{jumpUrlWithTid});
                TiebaPlusConfigData.addClickStatsForFireLink(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public h(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ki.A()) {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f0c2d);
                    return;
                }
                if (this.a.g != null && this.a.n != null) {
                    this.a.p();
                    this.a.e.show();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx5 a;

        public i(kx5 kx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kx5Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.c == 0) {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f04ab);
                    if (this.a.g != null) {
                        if (li.isEmpty(this.a.g.G)) {
                            if (li.isEmpty(this.a.g.b)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.g.b));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.g.G));
                    }
                } else if (!li.isEmpty(bVar.b)) {
                    mi.N(this.a.b, bVar.b);
                } else {
                    mi.M(this.a.b, R.string.obfuscated_res_0x7f0f04a2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(boolean z);
    }

    public kx5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.q = new b(this);
        this.r = new e(this);
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.v = new i(this);
        if (tbPageContext == null) {
            return;
        }
        this.a = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.h = new ArrayList();
        this.d = new yr4(this.b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new sw5(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        ur4 ur4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (ur4Var = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                ur4Var.n(this.b.getString(R.string.obfuscated_res_0x7f0f1112));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.h.contains(this.i)) {
                        this.h.remove(this.i);
                        this.d.j(this.h);
                    }
                } else {
                    this.i.n(this.b.getString(R.string.obfuscated_res_0x7f0f1111));
                }
            }
            this.i.r(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0367));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.g.getThreadData().getTid())) {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f081a));
                    } else {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0367));
                    }
                    this.j.q(R.color.cp_cont_b_alpha33);
                }
                this.j.r(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
                ur4 ur4Var = new ur4(this.b.getString(R.string.obfuscated_res_0x7f0f0824), this.d);
                this.l = ur4Var;
                ur4Var.m(this.t);
                this.h.add(this.l);
            }
            ur4 ur4Var2 = new ur4(this.d);
            this.i = ur4Var2;
            ur4Var2.m(this.s);
            if (!this.o) {
                this.h.add(this.i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                ur4 ur4Var3 = new ur4(this.b.getString(R.string.obfuscated_res_0x7f0f0367), this.d);
                this.j = ur4Var3;
                ur4Var3.m(this.q);
                this.h.add(this.j);
            }
            ur4 ur4Var4 = new ur4(this.b.getString(R.string.obfuscated_res_0x7f0f049d), this.d);
            this.k = ur4Var4;
            ur4Var4.m(this.u);
            this.h.add(this.k);
            this.d.m(new a(this));
            this.d.j(this.h);
            this.c = new wr4(this.a, this.d);
        }
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e == null) {
            nr4 nr4Var = new nr4(this.a.getPageActivity());
            this.e = nr4Var;
            if (this.o) {
                nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0494);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.g;
                if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f049c);
                } else {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f049b);
                }
            }
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new c(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a);
        }
    }

    public void q() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (wr4Var = this.c) != null && wr4Var.isShowing()) {
            this.c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yr4 yr4Var = this.d;
            if (yr4Var != null) {
                yr4Var.i();
            }
            nr4 nr4Var = this.e;
            if (nr4Var != null) {
                w95.a(this.a, nr4Var.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wr4Var = this.c) == null) {
            return;
        }
        wr4Var.m();
    }
}
