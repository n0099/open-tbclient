package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xx;
/* loaded from: classes5.dex */
public class fs6 extends wm<bx5, ThreadCardViewHolder<bx5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public pn l;

    /* loaded from: classes5.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs6 a;

        public a(fs6 fs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.tn
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            bx5 bx5Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            if (jnVar instanceof cn) {
                cn cnVar = (cn) jnVar;
                if (cnVar.e() instanceof bx5) {
                    bx5Var = (bx5) cnVar.e();
                    if (bx5Var == null) {
                        ((j45) ServiceManager.getService(j45.a.a())).a(this.a.j, bx5Var.b0());
                        return;
                    }
                    return;
                }
            }
            bx5Var = null;
            if (bx5Var == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public ThreadCardViewHolder<bx5> J(ViewGroup viewGroup, bx5 bx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, bx5Var)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            bVar.n(new gy(this.j, this.i));
            bVar.l().h(0);
            ThreadCardViewHolder<bx5> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l));
            threadCardViewHolder.k(this.i);
            V(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public View P(int i, View view2, ViewGroup viewGroup, bx5 bx5Var, ThreadCardViewHolder<bx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bx5Var, threadCardViewHolder})) == null) {
            if (threadCardViewHolder == null) {
                return null;
            }
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.k);
            bx5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
            threadCardViewHolder.g(bx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, bx5 bx5Var, ThreadCardViewHolder<bx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bx5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            this.l = pnVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.k = str;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? rw5.N : (BdUniqueId) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? rw5.D : (BdUniqueId) invokeV.objValue;
    }
}
