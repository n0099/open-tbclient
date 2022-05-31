package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class kf6 extends fb6<rp4, ThreadCardViewHolder<ThreadData>> implements lw5, pm6, ci5, mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public int v;
    public nm6 w;

    /* loaded from: classes6.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kf6 a;

        public a(kf6 kf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kf6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BdToast.i(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f1519), R.drawable.obfuscated_res_0x7f0809ca, true).n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kf6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.v = 3;
        this.w = new nm6();
        this.t = tbPageContext;
    }

    @Override // com.repackage.lw5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.w : (nm6) invokeV.objValue;
    }

    @Override // com.repackage.mw5
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: n0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.t.getPageActivity(), false);
            uw uwVar = new uw(this.t.getPageActivity());
            if (this.v == 502) {
                uwVar.p(false);
            } else {
                uwVar.p(true);
            }
            bVar.n(uwVar);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m));
            threadCardViewHolder.k(this.e);
            V(new a(this));
            threadCardViewHolder.q(false);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fb6, com.repackage.wm
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, rp4 rp4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rp4Var, threadCardViewHolder})) == null) {
            if (threadCardViewHolder == null) {
                return null;
            }
            if (rp4Var == null) {
                return threadCardViewHolder.b();
            }
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.u);
            }
            super.S(i, view2, viewGroup, rp4Var, threadCardViewHolder);
            eb6.i(threadCardViewHolder.c().f(), this.j);
            threadCardViewHolder.c().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                rp4Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.g(rp4Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            rp4Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.lw5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.v = i;
        }
    }

    @Override // com.repackage.fb6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }
}
