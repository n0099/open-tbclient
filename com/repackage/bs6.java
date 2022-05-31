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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes5.dex */
public class bs6 extends wm<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public boolean l;
    public nw5<zw5> m;

    /* loaded from: classes5.dex */
    public class a extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bs6 bs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs6Var};
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

    /* loaded from: classes5.dex */
    public class b implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bs6 bs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs6Var};
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

    /* loaded from: classes5.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bs6 a;

        public c(bs6 bs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bs6Var;
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
                ThreadCardUtils.jumpToPB((om4) zw5Var, view2.getContext(), 1, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.l = true;
        this.m = new a(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public ThreadCardViewHolder<zw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.b(128);
            pwVar.c(1024);
            pwVar.s(new b(this));
            bVar.o(pwVar);
            cy cyVar = new cy(this.j.getPageActivity());
            bVar.n(cyVar);
            cyVar.u(2);
            bVar.h(new by(this.j.getPageActivity()));
            bVar.h(new ww(this.j.getPageActivity()));
            zw zwVar = new zw(this.j.getPageActivity());
            zwVar.x(this.l);
            zwVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(zwVar);
            zx zxVar = new zx(this.j.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 9;
            um4Var.h = 9;
            zxVar.v(um4Var);
            zxVar.x(9);
            zxVar.C(4);
            zxVar.y(1);
            zxVar.w(false);
            bVar.m(zxVar);
            xx i = bVar.i();
            i.r(1);
            ThreadCardViewHolder<zw5> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.i);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder<zw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
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

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.k = str;
        }
    }
}
