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
import com.repackage.dr4;
import com.repackage.or4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public mr4 c;
    public or4 d;
    public dr4 e;
    public j f;
    public CardPersonDynamicThreadData g;
    public List<kr4> h;
    public kr4 i;
    public kr4 j;
    public kr4 k;
    public kr4 l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public hx5 p;
    public or4.d q;
    public SetPrivacyModel.a r;
    public or4.d s;
    public or4.d t;
    public or4.d u;
    public c9 v;

    /* loaded from: classes7.dex */
    public class a implements or4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public a(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.or4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements or4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public b(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.or4.d
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
            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0edd);
            if (this.a.g.getThreadData() != null) {
                this.a.p.d(i, 3, this.a.g.getThreadData().getTid());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public c(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (!ni.A()) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0c17);
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
                    this.a.n.U(this.a.g.p);
                }
                this.a.n.W(this.a.g.a, this.a.g.h, this.a.g.b, this.a.g.e, 0, 0, true, this.a.g.p.getBaijiahaoData(), false);
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public e(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pi.O(this.a.b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g.o) {
                    this.a.g.o = false;
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f138d);
                    if (this.a.i != null) {
                        this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f10e0));
                    }
                    if (this.a.f != null) {
                        this.a.f.a(false);
                        return;
                    }
                    return;
                }
                this.a.g.o = true;
                if (this.a.i != null) {
                    this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f10e1));
                }
                if (this.a.f != null) {
                    this.a.f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.g.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements or4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public f(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.or4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ni.A()) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0c17);
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
                if (!this.a.m.G()) {
                    this.a.m.H(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements or4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public g(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.or4.d
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ni.A()) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0c17);
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

    /* loaded from: classes7.dex */
    public class h implements or4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public h(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.or4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ni.A()) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0c17);
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

    /* loaded from: classes7.dex */
    public class i extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx5 a;

        public i(zx5 zx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zx5Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.c == 0) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f04ac);
                    if (this.a.g != null) {
                        if (oi.isEmpty(this.a.g.G)) {
                            if (oi.isEmpty(this.a.g.b)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.g.b));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.g.G));
                    }
                } else if (!oi.isEmpty(bVar.b)) {
                    pi.O(this.a.b, bVar.b);
                } else {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f04a3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z);
    }

    public zx5(TbPageContext tbPageContext) {
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
        this.d = new or4(this.b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new hx5(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        kr4 kr4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (kr4Var = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                kr4Var.n(this.b.getString(R.string.obfuscated_res_0x7f0f10e1));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.h.contains(this.i)) {
                        this.h.remove(this.i);
                        this.d.j(this.h);
                    }
                } else {
                    this.i.n(this.b.getString(R.string.obfuscated_res_0x7f0f10e0));
                }
            }
            this.i.r(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f035d));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.g.getThreadData().getTid())) {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0824));
                    } else {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f035d));
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
                kr4 kr4Var = new kr4(this.b.getString(R.string.obfuscated_res_0x7f0f082e), this.d);
                this.l = kr4Var;
                kr4Var.m(this.t);
                this.h.add(this.l);
            }
            kr4 kr4Var2 = new kr4(this.d);
            this.i = kr4Var2;
            kr4Var2.m(this.s);
            if (!this.o) {
                this.h.add(this.i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                kr4 kr4Var3 = new kr4(this.b.getString(R.string.obfuscated_res_0x7f0f035d), this.d);
                this.j = kr4Var3;
                kr4Var3.m(this.q);
                this.h.add(this.j);
            }
            kr4 kr4Var4 = new kr4(this.b.getString(R.string.obfuscated_res_0x7f0f049e), this.d);
            this.k = kr4Var4;
            kr4Var4.m(this.u);
            this.h.add(this.k);
            this.d.m(new a(this));
            this.d.j(this.h);
            this.c = new mr4(this.a, this.d);
        }
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e == null) {
            dr4 dr4Var = new dr4(this.a.getPageActivity());
            this.e = dr4Var;
            if (this.o) {
                dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0495);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.g;
                if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f049d);
                } else {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f049c);
                }
            }
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new c(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04dc, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a);
        }
    }

    public void q() {
        mr4 mr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (mr4Var = this.c) != null && mr4Var.isShowing()) {
            this.c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            or4 or4Var = this.d;
            if (or4Var != null) {
                or4Var.i();
            }
            dr4 dr4Var = this.e;
            if (dr4Var != null) {
                ha5.a(this.a, dr4Var.getRealView());
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
        mr4 mr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (mr4Var = this.c) == null) {
            return;
        }
        mr4Var.m();
    }
}
