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
import com.repackage.xx;
/* loaded from: classes5.dex */
public class cl7 extends qk7<ep4, ThreadCardViewHolder<ep4>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId k;
    public TbPageContext<?> l;
    public pn m;
    public String n;
    public String o;
    public View.OnClickListener p;
    public PullLeftRefreshLayout.f q;
    public kl4 r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl7 a;

        public a(cl7 cl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cl7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl7 a;

        public b(cl7 cl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cl7Var;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements kl4<dp4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl7 a;

        public c(cl7 cl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cl7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: b */
        public void c(View view2, dp4 dp4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, dp4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                nk7.a("c14399", dp4Var, i + 1, this.a.j.getOrignalPage().getTopicId());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.kl4
        /* renamed from: d */
        public void a(View view2, dp4 dp4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, dp4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (dp4Var == null) {
                    this.a.l.sendMessage(new CustomMessage(2002001, new ForumSquareActivityConfig(this.a.l.getPageActivity(), this.a.o)));
                    return;
                }
                String m = dp4Var.m();
                if (ki.isForumName(m)) {
                    this.a.l.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.l.getPageActivity()).createNormalCfg(m, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    nk7.a("c13739", dp4Var, i + 1, this.a.j.getOrignalPage().getTopicId());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.l.getPageActivity(), false);
            qx qxVar = new qx(this.l, this.k);
            qxVar.u(false);
            qxVar.p(false);
            qxVar.t(false);
            qxVar.s(this.q);
            qxVar.q(this.p);
            qxVar.r(this.r);
            bVar.n(qxVar);
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
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public View S(int i, View view2, ViewGroup viewGroup, ep4 ep4Var, ThreadCardViewHolder<ep4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ep4Var, threadCardViewHolder})) == null) {
            if (ep4Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            nk7.g("c14384", this.j.getOrignalPage().getTopicId());
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.n);
            }
            threadCardViewHolder.g(ep4Var);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    public void g0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pnVar) == null) {
            this.m = pnVar;
        }
    }
}
