package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dt5 extends pc6<br4, FrsPageAlaVideoHolder> implements sx5, ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nt5 t;
    public String u;
    public String v;
    public ux5<ThreadData> w;

    /* loaded from: classes5.dex */
    public class a extends ux5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt5 b;

        public a(dt5 dt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dt5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0911f9) {
                    customMessage = new CustomMessage(2921018);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f090548 && view2.getId() != R.id.obfuscated_res_0x7f090544 && view2.getId() != R.id.obfuscated_res_0x7f0922d3) {
                    customMessage = view2.getId() == R.id.obfuscated_res_0x7f092351 ? new CustomMessage(2921019) : null;
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage == null || this.b.k == null) {
                    return;
                }
                customMessage.setData(threadData);
                this.b.k.sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.w = new a(this);
    }

    @Override // com.repackage.sx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.u = str;
        }
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.v = str;
        }
    }

    @Override // com.repackage.pc6
    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bdUniqueId) == null) {
            super.n(tbPageContext, bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: n0 */
    public FrsPageAlaVideoHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                return null;
            }
            nt5 nt5Var = new nt5(tbPageContext, this.e);
            this.t = nt5Var;
            nt5Var.V(this.e);
            this.t.a(this.u);
            this.t.n(this.w);
            return new FrsPageAlaVideoHolder(this.t);
        }
        return (FrsPageAlaVideoHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pc6, com.repackage.eo
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, br4 br4Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br4Var, frsPageAlaVideoHolder})) == null) {
            TiebaStatic.log("c11842");
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.j;
            int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
            ThreadData threadData = br4Var.s;
            threadData.statFloor = (i + 1) - topThreadSize;
            customMessage.setData(threadData);
            this.k.sendMessage(customMessage);
            if (br4Var != null) {
                nt5 nt5Var = frsPageAlaVideoHolder.b;
                if (nt5Var instanceof hj5) {
                    nt5Var.b(this.v);
                }
                frsPageAlaVideoHolder.b.a(this.u);
                frsPageAlaVideoHolder.b.W(b0());
                frsPageAlaVideoHolder.b.l(br4Var.s);
                br4Var.s.updateShowStatus();
            }
            this.m = (xo) viewGroup;
            return frsPageAlaVideoHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sx5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }
}
