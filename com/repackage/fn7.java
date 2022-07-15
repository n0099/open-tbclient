package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
/* loaded from: classes6.dex */
public class fn7 extends tm7<dq4, ThreadCardViewHolder<dq4>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId k;
    public TbPageContext<?> l;
    public tn m;
    public String n;
    public String o;
    public View.OnClickListener p;
    public PullLeftRefreshLayout.f q;
    public jm4 r;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        public a(fn7 fn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        public b(fn7 fn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jm4<cq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn7 a;

        public c(fn7 fn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fn7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jm4
        /* renamed from: a */
        public void d(View view2, cq4 cq4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cq4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                qm7.a("c14399", cq4Var, i + 1, this.a.j.getOrignalPage().C1());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jm4
        /* renamed from: b */
        public void c(View view2, cq4 cq4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, cq4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (cq4Var == null) {
                    this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
                    return;
                }
                String k = cq4Var.k();
                if (oi.isForumName(k)) {
                    this.a.l.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.l.getPageActivity()).createNormalCfg(k, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    qm7.a("c13739", cq4Var, i + 1, this.a.j.getOrignalPage().C1());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.l = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.l.getPageActivity(), false);
            vx vxVar = new vx(this.l, this.k);
            vxVar.v(false);
            vxVar.q(false);
            vxVar.u(false);
            vxVar.t(this.q);
            vxVar.r(this.p);
            vxVar.s(this.r);
            bVar.n(vxVar);
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().h(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m));
            threadCardViewHolder.k(this.k);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public View S(int i, View view2, ViewGroup viewGroup, dq4 dq4Var, ThreadCardViewHolder<dq4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dq4Var, threadCardViewHolder})) == null) {
            if (dq4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            qm7.g("c14384", this.j.getOrignalPage().C1());
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.n);
            }
            threadCardViewHolder.g(dq4Var);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    public void g0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tnVar) == null) {
            this.m = tnVar;
        }
    }
}
