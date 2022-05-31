package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class pr6 extends wm<ax5, ThreadCardViewHolder<ax5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public pn m;
    public uw n;
    public nw5<ax5> o;

    /* loaded from: classes6.dex */
    public class a extends nw5<ax5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr6 b;

        public a(pr6 pr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ax5 ax5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ax5Var) == null) {
                BdToast.i(this.b.k.getContext(), this.b.k.getString(R.string.obfuscated_res_0x7f0f1519), R.drawable.obfuscated_res_0x7f0809ca, true).n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr6 a;

        public b(pr6 pr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BdToast.i(this.a.k.getContext(), this.a.k.getString(R.string.obfuscated_res_0x7f0f1519), R.drawable.obfuscated_res_0x7f0809ca, true).n();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pr6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.k = tbPageContext;
        this.j = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public ThreadCardViewHolder<ax5> J(ViewGroup viewGroup, ax5 ax5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, ax5Var)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity(), false);
            uw uwVar = new uw(this.k.getPageActivity());
            this.n = uwVar;
            uwVar.q(this.i);
            bVar.n(this.n);
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            ThreadCardViewHolder<ax5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(1);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public AutoVideoCardViewHolder<ax5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public View P(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, ThreadCardViewHolder<ax5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, threadCardViewHolder})) == null) {
            if (ax5Var == null) {
                return threadCardViewHolder.b();
            }
            if (threadCardViewHolder == null) {
                return null;
            }
            ax5Var.I(ax5Var.position + 1);
            gw5.b().a(ax5Var.g("c12351"));
            threadCardViewHolder.c().q(i);
            ax5Var.T = 0;
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.l);
            }
            threadCardViewHolder.g(ax5Var);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, ThreadCardViewHolder<ax5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            this.m = pnVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.repackage.wm
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? rw5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? rw5.K : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? rw5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdUniqueId bdUniqueId = this.j;
            return bdUniqueId != null ? bdUniqueId : rw5.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
