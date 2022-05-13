package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class ot6 extends eo<gy5, ThreadCardViewHolder<gy5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public boolean l;
    public xo m;
    public ux5<gy5> n;

    /* loaded from: classes6.dex */
    public class a extends ux5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot6 b;

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
                    return;
                }
            }
            this.b = ot6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) || view2 == null || gy5Var == null || gy5Var.getThreadData() == null || StringUtils.isNull(gy5Var.getThreadData().getTid())) {
                return;
            }
            this.b.d0(view2, gy5Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ot6 a;

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
                    return;
                }
            }
            this.a = ot6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof gy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gy5 gy5Var = (gy5) roVar;
                gy5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), gy5Var);
                }
                ThreadCardUtils.jumpToPB((zn4) gy5Var, view2.getContext(), 1, false);
                threadCardViewHolder.c().o(new vz.a(1));
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
        this.l = true;
        this.n = new a(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            my myVar = new my(this.j.getPageActivity());
            myVar.x(this.l);
            myVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(myVar);
            kz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, ThreadCardViewHolder<gy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, threadCardViewHolder})) == null) {
            if (gy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || gy5Var.a == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            nx5.b().a(new StatisticItem("c13424"));
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.g(gy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.n);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(View view2, gy5 gy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, gy5Var) == null) {
            int id = view2.getId();
            if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
                at6.b(view2, gy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f090cc7) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (gy5Var != null) {
                    statisticItem.param("tid", gy5Var.g);
                    ThreadData threadData = gy5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", gy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cc2) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (gy5Var != null) {
                    statisticItem2.param("tid", gy5Var.g);
                    ThreadData threadData2 = gy5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", gy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090cc5 || id == R.id.obfuscated_res_0x7f090cc6) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (gy5Var != null) {
                    statisticItem3.param("tid", gy5Var.g);
                    ThreadData threadData3 = gy5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", gy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090cc1) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (gy5Var != null) {
                    statisticItem4.param("tid", gy5Var.g);
                    ThreadData threadData4 = gy5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", gy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cc3) instanceof Integer)) {
                StatisticItem statisticItem5 = new StatisticItem("c13423");
                statisticItem5.param("obj_locate", 3);
                if (gy5Var != null) {
                    statisticItem5.param("tid", gy5Var.g);
                    ThreadData threadData5 = gy5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", gy5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem5);
            }
        }
    }

    public void e0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xoVar) == null) {
            this.m = xoVar;
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }
}
