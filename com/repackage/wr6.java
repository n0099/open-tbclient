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
import com.repackage.iy;
import com.repackage.mw;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes7.dex */
public class wr6 extends wm<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public pn l;
    public nw5<zw5> m;

    /* loaded from: classes7.dex */
    public class a extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
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
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zw5Var) == null) || view2 == null || zw5Var == null || zw5Var.getThreadData() == null || StringUtils.isNull(zw5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
                er6.b(view2, zw5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f091f87) {
                er6.b(view2, zw5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f092278 || id == R.id.obfuscated_res_0x7f092298) {
                er6.b(view2, zw5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090c8b) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (zw5Var != null) {
                    statisticItem.param("tid", zw5Var.g);
                    ThreadData threadData = zw5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090c86) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (zw5Var != null) {
                    statisticItem2.param("tid", zw5Var.g);
                    ThreadData threadData2 = zw5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090c89 || id == R.id.obfuscated_res_0x7f090c8a) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (zw5Var != null) {
                    statisticItem3.param("tid", zw5Var.g);
                    ThreadData threadData3 = zw5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090c85) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (zw5Var != null) {
                    statisticItem4.param("tid", zw5Var.g);
                    ThreadData threadData4 = zw5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a49) {
                er6.b(view2, zw5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090c87) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (zw5Var != null) {
                        statisticItem5.param("tid", zw5Var.g);
                        ThreadData threadData5 = zw5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", zw5Var.a.getTopAgreePost().I());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                er6.b(view2, zw5Var, 6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || om4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298) {
                om4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om4Var.objType = 4;
            } else {
                om4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;
        public final /* synthetic */ sx b;
        public final /* synthetic */ wr6 c;

        public c(wr6 wr6Var, ey eyVar, sx sxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, eyVar, sxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wr6Var;
            this.a = eyVar;
            this.b = sxVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null || om4Var.getThreadData() == null || om4Var.getThreadData().originalThreadData == null) {
                return;
            }
            zb5.b(1, this.c.a, om4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            er6.b(this.b.g(), om4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;
        public final /* synthetic */ wr6 b;

        public d(wr6 wr6Var, ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr6Var;
            this.a = eyVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null || om4Var.getThreadData() == null || om4Var.getThreadData().originalThreadData == null) {
                return;
            }
            zb5.b(1, this.b.a, om4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            er6.b(this.a.g(), om4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements jy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;
        public final /* synthetic */ wr6 b;

        public e(wr6 wr6Var, ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wr6Var;
            this.a = eyVar;
        }

        @Override // com.repackage.jy
        public void a(om4 om4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null || om4Var.getThreadData() == null || om4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (om4Var.getThreadData().originalThreadData.r != null) {
                z = om4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            zb5.a(1, z, this.b.a, om4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            er6.b(this.a.g(), om4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public f(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof zw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zw5 zw5Var = (zw5) jnVar;
                zw5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), zw5Var);
                }
                ThreadCardUtils.jumpToPB((om4) zw5Var, view2.getContext(), 1, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
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

        public g(wr6 wr6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(qw.a((pn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            ey eyVar = new ey(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.b(128);
            pwVar.c(1024);
            pwVar.s(new b(this));
            bVar.o(pwVar);
            sx sxVar = new sx(this.j);
            sxVar.n(Boolean.FALSE);
            sxVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(li.f(this.a, R.dimen.tbds28));
            bVar.n(sxVar);
            sx sxVar2 = new sx(this.j);
            sxVar2.n(Boolean.TRUE);
            sxVar2.v(ImageViewerConfig.FROM_CONCERN);
            sxVar2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            sxVar2.w(new c(this, eyVar, sxVar2));
            bVar.h(sxVar2);
            eyVar.n(Boolean.TRUE);
            eyVar.w(ImageViewerConfig.FROM_CONCERN);
            eyVar.x(new d(this, eyVar));
            eyVar.y(new e(this, eyVar));
            bVar.h(eyVar);
            bVar.h(new by(this.j.getPageActivity()));
            bVar.h(new ww(this.j.getPageActivity()));
            zx zxVar = new zx(this.j.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 9;
            um4Var.h = 9;
            zxVar.v(um4Var);
            zxVar.x(9);
            zxVar.C(4);
            zxVar.y(1);
            zxVar.b(32);
            zxVar.w(false);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c().f() instanceof zx) {
                ((zx) threadCardViewHolder.c().f()).B(new g(this, viewGroup, view2, i));
            }
            gw5.b().a(zw5Var.g("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(zw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pnVar) == null) {
            this.l = pnVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }
}
