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
import com.repackage.by;
import com.repackage.my;
import com.repackage.qw;
import com.repackage.tw;
/* loaded from: classes5.dex */
public class at6 extends an<yx5, ThreadCardViewHolder<yx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public tn l;
    public mx5<yx5> m;

    /* loaded from: classes5.dex */
    public class a extends mx5<yx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
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
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, yx5 yx5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yx5Var) == null) || view2 == null || yx5Var == null || yx5Var.getThreadData() == null || StringUtils.isNull(yx5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
                hs6.b(view2, yx5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f091f87) {
                hs6.b(view2, yx5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f092266 || id == R.id.obfuscated_res_0x7f092285) {
                hs6.b(view2, yx5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090c7b) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (yx5Var != null) {
                    statisticItem.param("tid", yx5Var.g);
                    ThreadData threadData = yx5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", yx5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090c76) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (yx5Var != null) {
                    statisticItem2.param("tid", yx5Var.g);
                    ThreadData threadData2 = yx5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", yx5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090c79 || id == R.id.obfuscated_res_0x7f090c7a) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (yx5Var != null) {
                    statisticItem3.param("tid", yx5Var.g);
                    ThreadData threadData3 = yx5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", yx5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090c75) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (yx5Var != null) {
                    statisticItem4.param("tid", yx5Var.g);
                    ThreadData threadData4 = yx5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", yx5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a38) {
                hs6.b(view2, yx5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090c77) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (yx5Var != null) {
                        statisticItem5.param("tid", yx5Var.g);
                        ThreadData threadData5 = yx5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", yx5Var.a.getTopAgreePost().J());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                hs6.b(view2, yx5Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
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
        public void a(ym4 ym4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ym4Var, view2) == null) || ym4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092285) {
                ym4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092266) {
                ym4Var.objType = 4;
            } else {
                ym4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy a;
        public final /* synthetic */ wx b;
        public final /* synthetic */ at6 c;

        public c(at6 at6Var, iy iyVar, wx wxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, iyVar, wxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = at6Var;
            this.a = iyVar;
            this.b = wxVar;
        }

        @Override // com.repackage.qw.a
        public void a(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null || ym4Var.getThreadData() == null || ym4Var.getThreadData().originalThreadData == null) {
                return;
            }
            mc5.b(1, this.c.a, ym4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            hs6.b(this.b.g(), ym4Var, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy a;
        public final /* synthetic */ at6 b;

        public d(at6 at6Var, iy iyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, iyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at6Var;
            this.a = iyVar;
        }

        @Override // com.repackage.qw.a
        public void a(ym4 ym4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null || ym4Var.getThreadData() == null || ym4Var.getThreadData().originalThreadData == null) {
                return;
            }
            mc5.b(1, this.b.a, ym4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            hs6.b(this.a.g(), ym4Var, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ny {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy a;
        public final /* synthetic */ at6 b;

        public e(at6 at6Var, iy iyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, iyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at6Var;
            this.a = iyVar;
        }

        @Override // com.repackage.ny
        public void a(ym4 ym4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ym4Var) == null) || ym4Var == null || ym4Var.getThreadData() == null || ym4Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (ym4Var.getThreadData().originalThreadData.r != null) {
                z = ym4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            mc5.a(1, z, this.b.a, ym4Var.getThreadData(), 0, this.a.u(), "from_nani_video", "concern_page", null, "concern_tab", "");
            hs6.b(this.a.g(), ym4Var, 6);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public f(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof yx5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yx5 yx5Var = (yx5) nnVar;
                yx5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), yx5Var);
                }
                ThreadCardUtils.jumpToPB((ym4) yx5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public g(at6 at6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            by.b bVar = new by.b(this.j.getPageActivity());
            iy iyVar = new iy(this.j.getPageActivity());
            tw twVar = new tw(this.j.getPageActivity());
            twVar.t(this.i);
            twVar.b(128);
            twVar.c(1024);
            twVar.s(new b(this));
            bVar.o(twVar);
            wx wxVar = new wx(this.j);
            wxVar.n(Boolean.FALSE);
            wxVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(pi.f(this.a, R.dimen.tbds28));
            bVar.n(wxVar);
            wx wxVar2 = new wx(this.j);
            wxVar2.n(Boolean.TRUE);
            wxVar2.v(ImageViewerConfig.FROM_CONCERN);
            wxVar2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            wxVar2.w(new c(this, iyVar, wxVar2));
            bVar.h(wxVar2);
            iyVar.n(Boolean.TRUE);
            iyVar.w(ImageViewerConfig.FROM_CONCERN);
            iyVar.x(new d(this, iyVar));
            iyVar.y(new e(this, iyVar));
            bVar.h(iyVar);
            bVar.h(new fy(this.j.getPageActivity()));
            bVar.h(new ax(this.j.getPageActivity()));
            dy dyVar = new dy(this.j.getPageActivity());
            en4 en4Var = new en4();
            en4Var.b = 9;
            en4Var.h = 9;
            dyVar.v(en4Var);
            dyVar.x(9);
            dyVar.C(4);
            dyVar.y(1);
            dyVar.b(32);
            dyVar.w(false);
            bVar.m(dyVar);
            by k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.l);
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
    public View S(int i, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c().f() instanceof dy) {
                ((dy) threadCardViewHolder.c().f()).B(new g(this, viewGroup, view2, i));
            }
            fx5.b().a(yx5Var.f("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(yx5Var);
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

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }
}
