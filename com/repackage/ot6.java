package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
import com.repackage.tw;
/* loaded from: classes6.dex */
public class ot6 extends an<vy5, ThreadCardViewHolder<vy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public tn l;
    public jy5<vy5> m;

    /* loaded from: classes6.dex */
    public class a extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ot6 ot6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) || view2 == null || vy5Var == null || vy5Var.getThreadData() == null || StringUtils.isNull(vy5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f09203e) {
                vs6.b(view2, vy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09202c) {
                vs6.b(view2, vy5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f09230c || id == R.id.obfuscated_res_0x7f09232d) {
                vs6.b(view2, vy5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090c84) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (vy5Var != null) {
                    statisticItem.param("tid", vy5Var.g);
                    ThreadData threadData = vy5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090c7f) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (vy5Var != null) {
                    statisticItem2.param("tid", vy5Var.g);
                    ThreadData threadData2 = vy5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090c82 || id == R.id.obfuscated_res_0x7f090c83) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (vy5Var != null) {
                    statisticItem3.param("tid", vy5Var.g);
                    ThreadData threadData3 = vy5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090c7e) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (vy5Var != null) {
                    statisticItem4.param("tid", vy5Var.g);
                    ThreadData threadData4 = vy5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a40) {
                vs6.b(view2, vy5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090c80) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (vy5Var != null) {
                        statisticItem5.param("tid", vy5Var.g);
                        ThreadData threadData5 = vy5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", vy5Var.a.getTopAgreePost().J());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                vs6.b(view2, vy5Var, 6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ot6 ot6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tw.b
        public void a(nn4 nn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) || nn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d) {
                nn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                nn4Var.objType = 4;
            } else {
                nn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ xx b;
        public final /* synthetic */ ot6 c;

        public c(ot6 ot6Var, jy jyVar, xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, jyVar, xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ot6Var;
            this.a = jyVar;
            this.b = xxVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            pd5.b(1, this.c.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "concern_page", null, "concern_tab", "");
            vs6.b(this.b.h(), nn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ ot6 b;

        public d(ot6 ot6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            pd5.b(1, this.b.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "concern_page", null, "concern_tab", "");
            vs6.b(this.a.h(), nn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements oy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;
        public final /* synthetic */ ot6 b;

        public e(ot6 ot6Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot6Var;
            this.a = jyVar;
        }

        @Override // com.repackage.oy
        public void a(nn4 nn4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (nn4Var.getThreadData().originalThreadData.r != null) {
                z = nn4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            pd5.a(1, z, this.b.a, nn4Var.getThreadData(), 0, this.a.v(), "from_nani_video", "concern_page", null, "concern_tab", "");
            vs6.b(this.a.h(), nn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot6 a;

        public f(ot6 ot6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ot6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof vy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                vy5 vy5Var = (vy5) nnVar;
                vy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), vy5Var);
                }
                ThreadCardUtils.jumpToPB((nn4) vy5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public g(ot6 ot6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity());
            jy jyVar = new jy(this.j.getPageActivity());
            tw twVar = new tw(this.j.getPageActivity());
            twVar.u(this.i);
            twVar.c(128);
            twVar.d(1024);
            twVar.t(new b(this));
            bVar.o(twVar);
            xx xxVar = new xx(this.j);
            xxVar.o(Boolean.FALSE);
            xxVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(pi.f(this.a, R.dimen.tbds28));
            bVar.n(xxVar);
            xx xxVar2 = new xx(this.j);
            xxVar2.o(Boolean.TRUE);
            xxVar2.w(ImageViewerConfig.FROM_CONCERN);
            xxVar2.z(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            xxVar2.x(new c(this, jyVar, xxVar2));
            bVar.h(xxVar2);
            jyVar.o(Boolean.TRUE);
            jyVar.x(ImageViewerConfig.FROM_CONCERN);
            jyVar.y(new d(this, jyVar));
            jyVar.z(new e(this, jyVar));
            bVar.h(jyVar);
            bVar.h(new gy(this.j.getPageActivity()));
            bVar.h(new ax(this.j.getPageActivity()));
            ey eyVar = new ey(this.j.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 9;
            tn4Var.h = 9;
            eyVar.w(tn4Var);
            eyVar.y(9);
            eyVar.D(4);
            eyVar.z(1);
            eyVar.c(32);
            eyVar.x(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || vy5Var.a == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c().f() instanceof ey) {
                ((ey) threadCardViewHolder.c().f()).C(new g(this, viewGroup, view2, i));
            }
            cy5.b().a(vy5Var.d("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tnVar) == null) {
            this.l = tnVar;
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }
}
