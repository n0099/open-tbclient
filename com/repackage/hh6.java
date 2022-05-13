package com.repackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kz;
import com.repackage.vz;
import com.repackage.zx;
/* loaded from: classes6.dex */
public class hh6 extends pc6<br4, AutoVideoCardViewHolder<ThreadData>> implements sx5, jo6, ij5, tx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public String v;
    public int w;
    public ho6 x;
    public ux5<ThreadData> y;

    /* loaded from: classes6.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh6 b;

        public a(hh6 hh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hh6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.q != null) {
                this.b.q.b(view2, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.b.v)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091fe0 && threadData.isVideoThreadType()) {
                io6.k().h(this.b.x, threadData, 1);
                this.b.J0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090545) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922f3 || view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                io6.k().h(this.b.x, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090d2d) {
                sp6.a(this.b.x, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09161e) {
                io6.k().h(this.b.x, threadData, 4);
                this.b.J0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.J0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09161e) {
                go6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                sp6.g(threadData, this.b.j, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092390) {
                go6.e(threadData, 4, this.b.e, this.b.x, this.b.a0());
                sp6.g(threadData, this.b.j, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0922f3 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091ff4) {
                    go6.e(threadData, 5, this.b.e, this.b.x, this.b.a0());
                    sp6.g(threadData, this.b.j, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    go6.e(threadData, 15, this.b.e, this.b.x, this.b.a0());
                    sp6.g(threadData, this.b.j, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091d0b) {
                    sp6.g(threadData, this.b.j, 1);
                    go6.e(threadData, 1, this.b.e, this.b.x, this.b.a0());
                } else {
                    go6.e(threadData, 14, this.b.e, this.b.x, this.b.a0());
                }
            } else {
                go6.e(threadData, 2, this.b.e, this.b.x, this.b.a0());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ hh6 b;

        public b(hh6 hh6Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh6Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hh6Var;
            this.a = szVar;
        }

        @Override // com.repackage.zx.a
        public void a(zn4 zn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, zn4Var) == null) || zn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(zn4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(zn4Var, this.b.a, this.b.w, false, computeViewArea);
                return;
            }
            zn4Var.objType = 5;
            ThreadCardUtils.jumpToPB(zn4Var, this.b.a, this.b.w, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh6 a;

        public c(hh6 hh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof br4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((br4) roVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((zn4) threadData, view2.getContext(), this.a.w, false, dy.a((xo) viewGroup, view2, i));
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 3;
        this.x = new ho6();
        this.y = new a(this);
        this.t = tbPageContext;
    }

    public final m78 G0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            m78 m78Var = new m78();
            if (100 == a0().tabType) {
                m78Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                m78Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.x.e == 501) {
                m78Var.a = "frs_tab";
            }
            m78Var.d = this.x.c;
            m78Var.c = threadData.getTid();
            m78Var.f = threadData.mRecomSource;
            m78Var.g = threadData.mRecomReason;
            m78Var.h = threadData.mRecomWeight;
            m78Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                m78Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return m78Var;
        }
        return (m78) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: H0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.t.getPageActivity(), false);
            fy fyVar = new fy(this.t.getPageActivity(), true);
            fyVar.t("frs");
            fyVar.x("2003");
            fyVar.u(new b(this, fyVar));
            if (this.w == 502) {
                fyVar.v(false);
            } else {
                fyVar.v(true);
            }
            bVar.n(fyVar);
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.k(this.e);
            k.p(this.y);
            k.r(this.w);
            V(new c(this));
            autoVideoCardViewHolder.q(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: I0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (br4Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder.c() instanceof hj5) {
                autoVideoCardViewHolder.c().b(this.u);
            }
            super.S(i, view2, viewGroup, br4Var, autoVideoCardViewHolder);
            oc6.i(autoVideoCardViewHolder.c().f(), this.j);
            autoVideoCardViewHolder.x(G0(br4Var.s));
            autoVideoCardViewHolder.c().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                br4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.g(br4Var.s);
            autoVideoCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.y);
            if (this.x != null) {
                FrsViewData frsViewData2 = this.j;
                br4Var.s.statFloor = (br4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            io6.k().c(this.x, br4Var.s);
            io6.k().b(br4Var.s);
            io6.k().e(br4Var.s, b0());
            go6.n(br4Var.s, this.e, this.x, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                go6.l(br4Var.s, a0());
                go6.m(br4Var.s, this.j.getForum().getId());
            }
            if (100 == a0().tabType) {
                io6.k().f(br4Var.s);
            }
            br4Var.s.updateShowStatus();
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void J0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.jo6
    public ho6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : (ho6) invokeV.objValue;
    }

    @Override // com.repackage.tx5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = i;
        }
    }

    @Override // com.repackage.pc6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.v = str;
        }
    }
}
