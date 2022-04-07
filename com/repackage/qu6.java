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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.qy;
import com.repackage.ty;
/* loaded from: classes7.dex */
public class qu6 extends ho<dy5, ThreadCardViewHolder<dy5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public zo l;
    public rx5<dy5> m;

    /* loaded from: classes7.dex */
    public class a extends rx5<dy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(qu6 qu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var};
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
        @Override // com.repackage.rx5
        /* renamed from: d */
        public void a(View view2, dy5 dy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dy5Var) == null) || view2 == null || dy5Var == null || dy5Var.getThreadData() == null || StringUtils.isNull(dy5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f86 || id == R.id.obfuscated_res_0x7f091f98) {
                yt6.b(view2, dy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f091f88) {
                yt6.b(view2, dy5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f09227a || id == R.id.obfuscated_res_0x7f09229c) {
                yt6.b(view2, dy5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090cda) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (dy5Var != null) {
                    statisticItem.param("tid", dy5Var.g);
                    ThreadData threadData = dy5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", dy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cd5) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (dy5Var != null) {
                    statisticItem2.param("tid", dy5Var.g);
                    ThreadData threadData2 = dy5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", dy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090cd8 || id == R.id.obfuscated_res_0x7f090cd9) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (dy5Var != null) {
                    statisticItem3.param("tid", dy5Var.g);
                    ThreadData threadData3 = dy5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", dy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (dy5Var != null) {
                    statisticItem4.param("tid", dy5Var.g);
                    ThreadData threadData4 = dy5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", dy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a6a) {
                yt6.b(view2, dy5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090cd6) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (dy5Var != null) {
                        statisticItem5.param("tid", dy5Var.g);
                        ThreadData threadData5 = dy5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", dy5Var.a.getTopAgreePost().I());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                yt6.b(view2, dy5Var, 6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(qu6 qu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ty.b
        public void a(qn4 qn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, qn4Var, view2) == null) || qn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229c) {
                qn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227a) {
                qn4Var.objType = 4;
            } else {
                qn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i00 a;
        public final /* synthetic */ wz b;
        public final /* synthetic */ qu6 c;

        public c(qu6 qu6Var, i00 i00Var, wz wzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var, i00Var, wzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qu6Var;
            this.a = i00Var;
            this.b = wzVar;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null || qn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            nc5.b(1, this.c.a, qn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            yt6.b(this.b.g(), qn4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements qy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i00 a;
        public final /* synthetic */ qu6 b;

        public d(qu6 qu6Var, i00 i00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var, i00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu6Var;
            this.a = i00Var;
        }

        @Override // com.repackage.qy.a
        public void a(qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null || qn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            nc5.b(1, this.b.a, qn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            yt6.b(this.a.g(), qn4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements n00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i00 a;
        public final /* synthetic */ qu6 b;

        public e(qu6 qu6Var, i00 i00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var, i00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu6Var;
            this.a = i00Var;
        }

        @Override // com.repackage.n00
        public void a(qn4 qn4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null || qn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (qn4Var.getThreadData().originalThreadData.r != null) {
                z = qn4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            nc5.a(1, z, this.b.a, qn4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            yt6.b(this.a.g(), qn4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu6 a;

        public f(qu6 qu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof dy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dy5 dy5Var = (dy5) uoVar;
                dy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), dy5Var);
                }
                ThreadCardUtils.jumpToPB((qn4) dy5Var, view2.getContext(), 1, false, uy.a((zo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new m00.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public g(qu6 qu6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu6Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uy.a((zo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity());
            i00 i00Var = new i00(this.j.getPageActivity());
            ty tyVar = new ty(this.j.getPageActivity());
            tyVar.t(this.i);
            tyVar.b(128);
            tyVar.c(1024);
            tyVar.s(new b(this));
            bVar.o(tyVar);
            wz wzVar = new wz(this.j);
            wzVar.n(Boolean.FALSE);
            wzVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(oi.f(this.a, R.dimen.tbds28));
            bVar.n(wzVar);
            wz wzVar2 = new wz(this.j);
            wzVar2.n(Boolean.TRUE);
            wzVar2.v(ImageViewerConfig.FROM_CONCERN);
            wzVar2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            wzVar2.w(new c(this, i00Var, wzVar2));
            bVar.h(wzVar2);
            i00Var.n(Boolean.TRUE);
            i00Var.w(ImageViewerConfig.FROM_CONCERN);
            i00Var.x(new d(this, i00Var));
            i00Var.y(new e(this, i00Var));
            bVar.h(i00Var);
            bVar.h(new f00(this.j.getPageActivity()));
            bVar.h(new az(this.j.getPageActivity()));
            d00 d00Var = new d00(this.j.getPageActivity());
            wn4 wn4Var = new wn4();
            wn4Var.b = 9;
            wn4Var.h = 9;
            d00Var.v(wn4Var);
            d00Var.w(9);
            d00Var.A(4);
            d00Var.x(1);
            d00Var.b(32);
            bVar.m(d00Var);
            b00 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, dy5 dy5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dy5Var, threadCardViewHolder})) == null) {
            if (dy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || dy5Var.a == null) {
                return null;
            }
            dy5Var.I(dy5Var.position + 1);
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c().f() instanceof d00) {
                ((d00) threadCardViewHolder.c().f()).z(new g(this, viewGroup, view2, i));
            }
            kx5.b().a(dy5Var.g("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(dy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zoVar) == null) {
            this.l = zoVar;
        }
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }
}
